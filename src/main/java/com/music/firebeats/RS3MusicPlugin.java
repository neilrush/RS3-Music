/*
 * Copyright (c) 2021, neilrush
 * Copyright (c) 2020, RKGman
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.music.firebeats;

import com.google.inject.Provides;
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.RuneLite;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.music.MusicConfig;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Slf4j
@PluginDescriptor(
	name = "RS3 Music",
	description = "Plays the RS3 version of songs that exist in both games.", 
	tags = {"music, audio"}
	)
public class RS3MusicPlugin extends Plugin
{
	/**
	 *	The varbit for the loop button in the music controls 
	 *	!May change if jagex changes the music widget
	 */
	private static final int LOOP_MUSIC_CONTROL_VARBIT = 4147;
	/**
	 *The maximum value that the client music volume can be set to. 
	 */
	private static final double CLIENT_MAX_VOLUME = 255;
	/**
	 * Represents the maximum value that the player volume can be set to. 
	 */
	private static final double AUDIO_PLAYER_MAX_VOLUME = 100;
	public static final int CURRENTLY_PLAYING_WIDGET_ID = 6;

	/**
	 *!use enum or single flag instead
	 */
	private final int FADING_TRACK_STATE = 0;
	/**
	 *!use enum or single flag instead
	 */
	private final int PLAYING_TRACK_STATE = 1;

	@Inject
	private Client client;
	@Inject
	private PluginManager pluginManager;
	@Inject
	private ClientThread clientThread;
	@Inject
	private MusicConfig musicConfig;


	Plugin musicPlugin;
	/**
	 *!remove there is a simpler way to do this
	 */
	private int currentPlayerState = PLAYING_TRACK_STATE;

	private String previousTrack = "";

	private String nextTrack = "";

	private final MP3Player trackPlayer = new MP3Player();

	private Thread handlePlayThread = null;

	private final ArrayList<String> availableTrackNameArray = new ArrayList<String>();

	private final Random rng = new Random();

	private Collection<Widget> tracks = null;

	private boolean remixAvailable = false;

	private boolean changingTracks = false;

	private boolean initializeTrack = true;

	private boolean comingFromLogin = true;

	

	private void fadeCurrentTrack()
	{
		if (trackPlayer.getVolume() == 0)
		{
			client.setMusicVolume(0);
			previousTrack = nextTrack;
			currentPlayerState = PLAYING_TRACK_STATE;
		}
		else
		{
			trackPlayer.setVolume(trackPlayer.getVolume() - 7);
			if (trackPlayer.getVolume() < 7)
			{
				trackPlayer.setVolume(0);
				trackPlayer.stop();
				previousTrack = nextTrack;
				currentPlayerState = PLAYING_TRACK_STATE;
				comingFromLogin = false;
			}
		}

	}

	private boolean isOnMusicTab()
	{
		return client.getVar(VarClientInt.INVENTORY_TAB) == 13;
	}
	/**
	 * Highlight tracks that have a replacement 
	 * 
	 */
	private void tagRemixedTracks()
	{
		final Widget musicList = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST);

		if (tracks == null)
		{
			tracks = Arrays.stream(musicList.getDynamicChildren()).sorted(Comparator.comparing(Widget::getRelativeY))
				.collect(Collectors.toList());
		}

		for (Widget track : tracks)
		{
			Track mappedTrack = mp3Map.get(track.getText());
			if (mappedTrack != null && mappedTrack.link != null)
			{
				// The track can be played, mark cyan.
				track.setTextColor(Color.CYAN.getRGB());
				// TODO: Figure out how to mark tracks not unlocked. getColor doesn't match with
				// Color.red / green
			}
		}
	}

	private void playTrack(boolean repeat, boolean shuffle)
	{
		trackPlayer.getPlayList().clear();

		Track track = mp3Map.get(nextTrack);

		if (repeat == true)
		{
			track = mp3Map.get(previousTrack);
		}

		if (shuffle == true)
		{
			track = mp3Map.get(availableTrackNameArray.get(rng.nextInt(availableTrackNameArray.size())));
		}

		if (track != null && track.link != null)
		{
			remixAvailable = true;
			client.setMusicVolume(0);
			trackPlayer.setVolume(getVolume());
			Track finalTrack = track;
			handlePlayThread = new Thread(() -> {
				try
				{
					// Get actual track link
					String directLink = getTrackLink(finalTrack.link);
					trackPlayer.addToPlayList(new URL(directLink));
					trackPlayer.play();
				}
				catch (Exception e)
				{
					// log.error(e.getMessage()); 
					//TODO: Still log but prevent spamming the file
				}
			});

			handlePlayThread.start();

			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "",
				"Fire Beats Notice: " + track.name + " remix produced by " + track.credit, null);

			initializeTrack = false;
		}
		else
		{
			remixAvailable = false;
			if (config.playOriginalIfNoRemix() == true)
			{
				client.setMusicVolume(getVolume());
				initializeTrack = false;
			}
		}
	}

	/**
	 * gets the volume from the in game music slider and converts it to a value that the Audio Player can use.
	 * <p>
	 * Using the max in game volume: {@value #CLIENT_MAX_VOLUME} and the max audio player volume: {@value #AUDIO_PLAYER_MAX_VOLUME}
	 * <p>
	 * This avoids using {@code client.getMusicVolume()} as it would always return zero in this context.
	 * @return The volume converted to a value that can be used by the Audio Player.
	 */
	private double getVolume() {
		if(pluginManager.isPluginEnabled(musicPlugin))
		{
			return ((musicConfig.getMusicVolume() - 1) / CLIENT_MAX_VOLUME) * AUDIO_PLAYER_MAX_VOLUME;
		}
		else
		{
		 	return client.getVar(VarPlayer.MUSIC_VOLUME);
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		// Build map of mp3 track links
		buildMp3TrackMap();

		log.info("RS3 Music Started");
	}

	@Override
	protected void shutDown() throws Exception
	{
		trackPlayer.stop();

		log.info("Fire Beats stopped!");
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged)
	{
		if (isOnMusicTab() == true)
		{
			tagRemixedTracks();
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			config.setMusicVolume(0);
		}
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			try
			{
				client.setMusicVolume(0); // Attempt to force mute.
				comingFromLogin = true;

				if (config.mute() == true)
				{
					trackPlayer.setVolume(0);
				}

				// Stop current track
				// trackPlayer.stop();
				trackPlayer.getPlayList().clear();
				// Start playing new track
				Track track = mp3Map.get("Scape Main");
				if (track.link != null)
				{
					remixAvailable = true;
					trackPlayer.setVolume(getVolume());
					handlePlayThread = new Thread(() -> {
						try
						{
							// Get actual track link
							String directLink = getTrackLink(track.link);
							trackPlayer.addToPlayList(new URL(directLink));
							trackPlayer.play();
						}
						catch (Exception e)
						{
							// log.error(e.getMessage()); 
							//TODO: Still log but prevent spamming the file
						}
					});

					handlePlayThread.start();
				}
				else
				{
					remixAvailable = false;
					// TODO: Handle playing normal song, or not
				}
			}
			catch (Exception e)
			{
				log.error(e.getMessage());
			}
		}
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick)
	{
		if (client.getGameState() == GameState.LOGIN_SCREEN)
		{
			trackPlayer.setVolume(0);
			trackPlayer.stop();
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		final Widget currentTrack = client.getWidget(WidgetID.MUSIC_GROUP_ID, CURRENTLY_PLAYING_WIDGET_ID);

		// If loop flag set, the player is loaded with music, and it is no longer
		// playing, start again.
		if (config.loop() == true && trackPlayer.getPlayList().size() > 0 && trackPlayer.isPlaying() == false)
		{
			playTrack(true, false);
		}

		if (client.getVarbitValue(LOOP_MUSIC_CONTROL_VARBIT) == 1 && trackPlayer.getPlayList().size() > 0 && trackPlayer.isPlaying() == false)
		{
			shuffleNextTrack();
		}

		if (isOnMusicTab() == true)
		{
			tagRemixedTracks();
		}

		if (previousTrack != currentTrack.getText())
		{
			changingTracks = true;
			nextTrack = currentTrack.getText();
			currentPlayerState = FADING_TRACK_STATE;
			initializeTrack = true;
		}
		else
		{
			changingTracks = false;
		}

		try
		{
			if (changingTracks == true && currentPlayerState == FADING_TRACK_STATE)
			{
				if (config.shuffleMode() == false || comingFromLogin == true)
				{
					fadeCurrentTrack();
				}
			}
			else
			{
				if (initializeTrack == true)
				{
					playTrack(false, false);
				}
			}
		}
		catch (Exception e)
		{
			// log.error(e.getMessage()); 
			//TODO: Still log but prevent spamming the file
		}

		if (config.mute() == true)
		{
			trackPlayer.setVolume(0);
			client.setMusicVolume(0);
		}
		else
		{
			if (remixAvailable == true)
			{ // If in a fading state...
				if (currentPlayerState == PLAYING_TRACK_STATE)
				{
					//? this seems to be the track fader but it fades when not necessary
					// TODO: Make this not trash.
					if (trackPlayer.getVolume() < (getVolume() - config.remixVolumeOffset()))
					{
						trackPlayer.setVolume(trackPlayer.getVolume() + 7);
					}
					else if (trackPlayer.getVolume() > (getVolume() - config.remixVolumeOffset()))
					{
						trackPlayer.setVolume(getVolume() - config.remixVolumeOffset());
					}

					client.setMusicVolume(0);
				}
			}
			else
			{
				if (config.playOriginalIfNoRemix() == true)
				{
					trackPlayer.setVolume(0);
					client.setMusicVolume(getVolume());
				}
				else
				{
					trackPlayer.setVolume(0);
					client.setMusicVolume(0);
				}
			}
		}

		if (currentTrackBox != null)
		{
			currentTrackBox.setText(currentTrack.getText());

			if (mp3Map.get(currentTrack.getText()) != null && mp3Map.get(currentTrack.getText()).link != null)
			{
				currentTrack.setTextColor(Color.CYAN.getRGB());
			}
			else
			{
				currentTrack.setTextColor(Color.GREEN.getRGB());
			}
		}
	}


	public void updateListFromRepo(boolean updateMap)
	{
		try
		{
			// Check if track listing CSV exists.
			File trackFile = new File(RuneLite.RUNELITE_DIR, "Osrs-Track-Remix-List.csv");
			if (trackFile.exists() == false)
			{
				// Copy default track list from resources.
				String updatedCsv = getUpdatedListFromRepo();
				FileWriter writer = new FileWriter(trackFile.getPath());
				writer.write(updatedCsv);
				writer.close();
			}
			else
			{
				// Overwrite contents with new
				trackFile.delete();
				String updatedCsv = getUpdatedListFromRepo();
				FileWriter writer = new FileWriter(trackFile.getPath());
				writer.write(updatedCsv);
				writer.close();
			}

			// Reload map if necessary
			if (updateMap == true)
			{
				buildMp3TrackMap();
			}
		}
		catch (Exception e)
		{
			log.error(e.getMessage());
		}

	}

	public void shuffleNextTrack()
	{
		playTrack(false, true);
	}

	public Widget getCurrentTrackBox()
	{
		return currentTrackBox;
	}

}

