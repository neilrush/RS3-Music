/*
 * Copyright (c) 2021, neilrush
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

package com.RS3Music;

import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.VarClientInt;
import net.runelite.api.VarPlayer;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.music.MusicConfig;
import net.runelite.client.plugins.music.MusicPlugin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Slf4j
@PluginDescriptor(
	name = "RS3 Music",
	description = "Plays the RS3 version of songs that exist in both games.",
	tags = {"music, audio"}
)
@PluginDependency(MusicPlugin.class)
public class RS3MusicPlugin extends Plugin
{
	/**
	 * The id of the currently playing track in the music widget
	 * <p>
	 * !may change if jagex update the music player
	 */
	public static final int CURRENTLY_PLAYING_WIDGET_ID = 6;
	/**
	 * The decimal value of the green color used by unlocked music tracks
	 */
	private static final int RUNESCAPE_GREEN = 901389;
	/**
	 * The Integer that represents the music tab number
	 */
	private static final int MUSIC_TAB_VAR_CLIENT_INT = 13;
	/**
	 * The maximum value that the client music volume can be set to.
	 */
	private static final double CLIENT_MAX_VOLUME = 255;
	/**
	 * Represents the maximum value that the player volume can be set to.
	 */
	private static final double AUDIO_PLAYER_MAX_VOLUME = 100;
	private final MP3Player trackPlayer = new MP3Player();
	@Inject
	private Client client;
	@Inject
	private PluginManager pluginManager;
	@Inject
	private ClientThread clientThread;
	@Inject
	private MusicConfig musicConfig;
	private Thread handlePlayThread = null;
	private Plugin musicPlugin = null;
	/**
	 * Represents the track being played in game
	 */
	private String currentlyPlayingTrackClient = "";
	/**
	 * Represents the track being played by the audio player
	 */
	private String currentlyPlayingTrackAudioPlayer = "";
	/**
	 * Used to fade the currently playing track
	 */
	private final Double fader = 1.00;

	/**
	 * Checks the client vars to see if the user is on the music tab
	 *
	 * @return true if the user is on the music tab else false
	 */
	private boolean isOnMusicTab()
	{
		return client.getVar(VarClientInt.INVENTORY_TAB) == MUSIC_TAB_VAR_CLIENT_INT;
	}

	/**
	 * Highlights the tracks in the music tab that have available replacements
	 * in {@code MusicTracks.trackList}
	 */
	private void tagReplaceableTracks()
	{
		if (isOnMusicTab())
		{
			final Widget musicListWidget = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST); //get list of tracks form music tab

			Collection<Widget> widgetTracks = Arrays.stream(musicListWidget.getDynamicChildren()).sorted(Comparator.comparing(Widget::getRelativeY)) //get individual tracks from the client music tab
				.collect(Collectors.toList());

			Widget currentTrack = client.getWidget(WidgetID.MUSIC_GROUP_ID, CURRENTLY_PLAYING_WIDGET_ID);

			//highlight the current playing track
			if (currentTrack != null && MusicTracks.containsTrack(currentTrack.getText()))
			{
				currentTrack.setTextColor(Color.CYAN.getRGB());
			}

			//highlight all tracks in the list
			for (Widget track : widgetTracks)
			{
				if (MusicTracks.containsTrack(track.getText()) && track.getTextColor() == RUNESCAPE_GREEN)
				{
					track.setTextColor(Color.CYAN.getRGB());
				}
			}
		}
	}

	/**
	 * Plays the given track from the tracklist.
	 *
	 * @param track The track name of the track to play
	 * @throws IllegalArgumentException Invalid link or invalid track name
	 */
	private void playTrack(String track) throws IllegalArgumentException
	{
		trackPlayer.getPlayList().clear();
		if (MusicTracks.containsTrack(track))
		{
			try
			{
				// Get actual track link
				String directLink = getTrackLink(MusicTracks.getTrackLink(track));
				if (!directLink.equals(""))
				{
					System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
					trackPlayer.addToPlayList(new URL(directLink));
					trackPlayer.setVolume(getVolume());
					System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
					trackPlayer.play();
					currentlyPlayingTrackAudioPlayer = track;
					log.debug("Played Track: " + track);
				}
			}
			catch (Exception e)
			{
				currentlyPlayingTrackAudioPlayer = "";
				throw new IllegalArgumentException("The track to play does not have a valid link: " + track);
			}
		}
		else
		{
			throw new IllegalArgumentException("The track to play does not exist: " + track);
		}
	}

	/**
	 * gets the volume from the in game music slider and converts it to a value that the Audio Player can use.
	 * <p>
	 * Using the max in game volume: {@value #CLIENT_MAX_VOLUME} and the max audio player volume: {@value #AUDIO_PLAYER_MAX_VOLUME}
	 * <p>
	 * This avoids using {@code client.getMusicVolume()} as it would always return zero in this context.
	 *
	 * @return The volume converted to a value that can be used by the Audio Player.
	 */
	private int getVolume()
	{
		int volume = 0;
		if (pluginManager.isPluginEnabled(musicPlugin))
		{
			volume = (int) (((musicConfig.getMusicVolume() - 1) / CLIENT_MAX_VOLUME) * AUDIO_PLAYER_MAX_VOLUME);
		}
		else
		{
			volume = client.getVar(VarPlayer.MUSIC_VOLUME);
		}

		return volume < 0 ? 0 : volume > 100 ? 100 : volume;
	}

	@Override
	protected void startUp()
	{
		musicPlugin = getMusicPlugin();
	}

	@Override
	protected void shutDown()
	{
		trackPlayer.stop();
		trackPlayer.getPlayList().clear();
		clientThread.invokeLater(() -> client.setMusicVolume((int) ((getVolume() / AUDIO_PLAYER_MAX_VOLUME) * CLIENT_MAX_VOLUME))); //restore volume
		final Widget musicListWidget = client.getWidget(WidgetInfo.MUSIC_TRACK_LIST); //get list of tracks form music tab

		Collection<Widget> widgetTracks = Arrays.stream(musicListWidget.getDynamicChildren()).sorted(Comparator.comparing(Widget::getRelativeY)) //get individual tracks from the client music tab
			.collect(Collectors.toList());

		Widget currentTrack = client.getWidget(WidgetID.MUSIC_GROUP_ID, CURRENTLY_PLAYING_WIDGET_ID);
		//TODO:Undo track recolors
	}

	/**
	 * Finds the music plugin from the pluginmanager list
	 *
	 * @return The music plugin or null if not found
	 */
	private Plugin getMusicPlugin()
	{
		for (Plugin plugin : pluginManager.getPlugins())
		{
			if (plugin.getName().equals("Music"))
			{
				return plugin;
			}
		}
		return null;
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged)
	{
		tagReplaceableTracks(); //highlight replaceable tracks in blue if on music tab
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGIN_SCREEN)
		{
			trackPlayer.stop();
			trackPlayer.getPlayList().clear();
		}
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick)
	{
		if (trackPlayer.isPlaying())
		{
			clientThread.invokeLater(() -> client.setMusicVolume(0));
			trackPlayer.setVolume(getVolume()); //mute client music
		}
		else
		{
			clientThread.invokeLater(() -> client.setMusicVolume((int) ((getVolume() / AUDIO_PLAYER_MAX_VOLUME) * CLIENT_MAX_VOLUME))); //unmute client music
		}

		tagReplaceableTracks();
		if (currentlyPlayingTrackClient != null && (!currentlyPlayingTrackAudioPlayer.equals(currentlyPlayingTrackClient) || !trackPlayer.isPlaying()))
		{
			if (MusicTracks.containsTrack(currentlyPlayingTrackClient))
			{
				handlePlayThread = new Thread(() ->
				{
					playTrack(currentlyPlayingTrackClient);
				});

				handlePlayThread.start();
				//TODO: setup fader

				//TODO: create method of catching errors that stops trying to play song after number of retries

			}
		}
	}

	@Subscribe
	public void onGameTick(GameTick gameTick)
	{
		if (client.getGameState() == GameState.LOGGED_IN)
		{
			Widget currentTrack = client.getWidget(WidgetID.MUSIC_GROUP_ID, CURRENTLY_PLAYING_WIDGET_ID);
			if (currentTrack != null)
			{
				currentlyPlayingTrackClient = currentTrack.getText();
			}
			else
			{
				currentlyPlayingTrackClient = null;
			}
		}
	}

	/**
	 * Webscraper for the rs wiki files page that gets the mp3 link from the download button
	 *
	 * @param trackLink the link to the rs wiki file page
	 * @return The direct link to the mp3 or {@code ""} if unable to get the link
	 */
	private String getTrackLink(String trackLink)
	{
		String link = "";

		try
		{
			System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
			Document doc = Jsoup.connect(trackLink).get();
			Element downloadUrl = doc.selectFirst(".wikitable.mw-filepage-transcodestatus a");//get the mp3 download button on the wiki
			link = downloadUrl.absUrl("href");
			log.debug("Link scraped from the wiki: " + link);
			log.debug(System.getProperty("http.agent"));
			return link;
		}
		catch (Exception e)
		{
			log.error("Unable to get direct link for: " + link);
			return "";
		}
	}


}

