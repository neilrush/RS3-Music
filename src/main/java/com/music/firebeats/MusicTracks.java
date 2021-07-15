package com.music.firebeats;

import com.google.common.collect.ImmutableMap;

/**
 * Provides access to the music tracks map see {@link #trackList} 
 */
public class MusicTracks
{
    /**
     * Map of all the tracks that are shared between osrs and rs3
     * {@link https://runescape.wiki/w/Music/track_list}
     */
	private static final ImmutableMap<String, String> trackList = new ImmutableMap
		.Builder<String, String>()
		.put("7th Realm", "https://runescape.wiki/index.php?title=File%3A7th_Realm.ogg")//✅
		.put("Adventure", "https://runescape.wiki/index.php?title=File%3AGarden.ogg")//✅ subbed
		.put("Al Kharid", "https://runescape.wiki/index.php?title=File%3AA_Song_For_Khnum.ogg")//✅ subbed
		.put("Alone", "https://runescape.wiki/index.php?title=File%3AAlone.ogg")//✅
		.put("Alternative Root", "https://runescape.wiki/index.php?title=File%3AAlternative_Root.ogg")//✅
		.put("Arabian", "https://runescape.wiki/index.php?title=File%3AKharidian_Bustle.ogg")//✅ subbed
		.put("Arabian 2", "https://runescape.wiki/index.php?title=File%3ASands_of_Time.ogg")//✅ subbed
		.put("Arabian 3", "https://runescape.wiki/index.php?title=File%3ADune.ogg")//✅ subbed
		.put("Armadyl Alliance", "https://runescape.wiki/index.php?title=File%3AArmadyl_Alliance.ogg")//✅ 
		.put("Armageddon", "https://runescape.wiki/index.php?title=File%3AArmageddon.ogg")//✅
		.put("Army of Darkness", "https://runescape.wiki/index.php?title=File%3AArmy_of_Darkness.ogg")//✅
		.put("Arrival", "https://runescape.wiki/index.php?title=File%3AArrival.ogg")//✅
		.put("Assault and Battery", "https://runescape.wiki/index.php?title=File%3AAssault_and_Battery.ogg")//✅
		.put("Attack 1", "https://runescape.wiki/index.php?title=File%3AAttack_I.ogg")//✅
		.put("Attack 2", "https://runescape.wiki/index.php?title=File%3AAttack_II.ogg")//✅
		.put("Attack 3", "https://runescape.wiki/index.php?title=File%3AAttack_III.ogg")//✅
		.put("Attack 4", "https://runescape.wiki/index.php?title=File%3AAttack_IV.ogg")//✅
		.put("Attack 5", "https://runescape.wiki/index.php?title=File%3AAttack_V.ogg")//✅
		.put("Attack 6", "https://runescape.wiki/index.php?title=File%3AAttack_VI.ogg")//✅
		.put("Attention", "https://runescape.wiki/index.php?title=File%3AWeaving.ogg")//✅ subbed
		.put("Autumn Voyage", "https://runescape.wiki/index.php?title=File%3AAutumn_Voyage.ogg")//✅
		.put("Aye Car Rum Ba", "https://runescape.wiki/index.php?title=File%3AAye_Car_Rum_Ba.ogg")//✅
		.put("Back to Life", "https://runescape.wiki/index.php?title=File%3ABack_to_Life.ogg")//✅
		.put("Background", "https://runescape.wiki/index.php?title=File%3ABackground.ogg")//✅
		.put("Ballad of Enchantment", "https://runescape.wiki/index.php?title=File%3ABallad_of_Enchantment.ogg")//✅
		.put("Ballad of the Basilisk", "https://runescape.wiki/index.php?title=File%3ABallad_of_the_Basilisk.ogg")//✅
		.put("Bandos Battalion", "https://runescape.wiki/index.php?title=File%3ABandos_Battalion.ogg")//✅
		.put("Bane", "https://runescape.wiki/index.php?title=File%3AShining_Spirit.ogg")//✅ subbed
		.put("Barb Wire", "https://runescape.wiki/index.php?title=File%3ABarb_Wire.ogg")//✅
		.put("Barbarianism", "https://runescape.wiki/index.php?title=File%3AVillage_Life.ogg")//✅
		.put("Baroque", "https://runescape.wiki/index.php?title=File%3ABaroque.ogg")//✅
		.put("Beyond", "https://runescape.wiki/index.php?title=File%3ABeyond.ogg")//✅
		.put("Big Chords", "https://runescape.wiki/index.php?title=File%3ABig_Chords.ogg")//✅
		.put("Bloodbath", "https://runescape.wiki/index.php?title=File%3ABloodbath.ogg")//✅
		.put("Bone Dance", "https://runescape.wiki/index.php?title=File%3ABone_Dance.ogg")//✅
		.put("Book of Spells", "https://runescape.wiki/index.php?title=File%3ABook_of_Spells.ogg")//✅
		.put("Borderland", "https://runescape.wiki/index.php?title=File%3ABorderland.ogg")//✅
		.put("Breeze", "https://runescape.wiki/index.php?title=File%3ABreeze.ogg")//✅
		.put("Camelot", "https://runescape.wiki/index.php?title=File%3ACamelot.ogg")//✅
		.put("Castle Wars", "https://runescape.wiki/index.php?title=File%3ACastle_Wars.ogg")//✅
		.put("Cave Background", "https://runescape.wiki/index.php?title=File%3ACave_Background.ogg")//✅
		.put("Cave of the Goblins", "https://runescape.wiki/index.php?title=File%3ACave_of_the_Goblins.ogg")//✅
		.put("Cavern", "https://runescape.wiki/index.php?title=File%3ACavern.ogg")//✅
		.put("City of the Dead", "https://runescape.wiki/index.php?title=File%3ACity_of_the_Dead.ogg")//✅
		.put("Clan Wars", "https://runescape.wiki/index.php?title=File%3AClan_Wars.ogg")//✅
		.put("Close Quarters", "https://runescape.wiki/index.php?title=File%3AArmy_of_Darkness.ogg")//✅ subbed
		.put("Courage", "https://runescape.wiki/index.php?title=File%3ACourage.ogg")//✅
		.put("Crystal Castle", "https://runescape.wiki/index.php?title=File%3ACrystal_Castle.ogg")//✅
		.put("Crystal Sword", "https://runescape.wiki/index.php?title=File%3ACrystal_Sword.ogg")//✅
		.put("Cursed", "https://runescape.wiki/index.php?title=File%3ACursed.ogg")//✅
		.put("Dagannoth Dawn", "https://runescape.wiki/index.php?title=File%3ADagannoth_Dawn.ogg")//✅
		.put("Dance of the Undead", "https://runescape.wiki/index.php?title=File%3ADance_of_the_Undead.ogg")//✅
		.put("Dangerous", "https://runescape.wiki/index.php?title=File%3ADangerous.ogg")//✅
		.put("Dark", "https://runescape.wiki/index.php?title=File%3ADark.ogg")//✅
		.put("Dead Can Dance", "https://runescape.wiki/index.php?title=File%3ADark.ogg")//✅ subbed
		.put("Dead Quiet", "https://runescape.wiki/index.php?title=File%3ADead_Quiet.ogg")//✅
		.put("Deadlands", "https://runescape.wiki/index.php?title=File%3ADeadlands.ogg")//✅
		.put("Deep Wildy", "https://runescape.wiki/index.php?title=File%3ADeep_Wildy.ogg")//✅
		.put("Desert Heat", "https://runescape.wiki/index.php?title=File%3ADesert_Heat.ogg")//✅
		.put("Desert Voyage", "https://runescape.wiki/index.php?title=File%3ADesert_Voyage.ogg")//✅
		.put("Distant Land", "https://runescape.wiki/index.php?title=File%3ADistant_Land.ogg")//✅
		.put("Doorways", "https://runescape.wiki/index.php?title=File%3ADoorways.ogg")//✅
		.put("Dorgeshuun City", "https://runescape.wiki/index.php?title=File%3ADorgeshuun_City.ogg")//✅
		.put("Dragontooth Island", "https://runescape.wiki/index.php?title=File%3ADragontooth_Island.ogg")//✅
		.put("Dream", "https://runescape.wiki/index.php?title=File%3ADream.ogg")//✅
		.put("Duel Arena", "https://runescape.wiki/index.php?title=File%3ADuel_Arena.ogg")//✅
		.put("Dunjun", "https://runescape.wiki/index.php?title=File%3ADunjun.ogg")//✅
		.put("Dwarf Theme", "https://runescape.wiki/index.php?title=File%3ASecond_Harmony.ogg")//✅ subbed
		.put("Dynasty", "https://runescape.wiki/index.php?title=File%3ADynasty.ogg")//✅
		.put("Egypt", "https://runescape.wiki/index.php?title=File%3AEgypt.ogg")//✅
		.put("Elven Mist", "https://runescape.wiki/index.php?title=File%3AElven_Mist.ogg")//✅
		.put("Elven Seed", "https://runescape.wiki/index.php?title=File%3AElven_Seed.ogg")//✅
		.put("Emotion", "https://runescape.wiki/index.php?title=File%3AEmotion.ogg")//✅
		.put("Emperor", "https://runescape.wiki/index.php?title=File%3AGetting_on_With_Things.ogg")//✅
		.put("Espionage", "https://runescape.wiki/index.php?title=File%3AEspionage.ogg")//✅
		.put("Everlasting Fire", "https://runescape.wiki/index.php?title=File%3AEverlasting_Fire.ogg")//✅
		.put("Everywhere", "https://runescape.wiki/index.php?title=File%3AEverywhere.ogg")//✅
		.put("Expanse", "https://runescape.wiki/index.php?title=File%3AExpanse.ogg")//✅
		.put("Expecting", "https://runescape.wiki/index.php?title=File%3AExpecting.ogg")//✅
		.put("Exposed", "https://runescape.wiki/index.php?title=File%3AExposed.ogg")//✅
		.put("Faithless", "https://runescape.wiki/index.php?title=File%3AFaithless.ogg")//✅
		.put("Fanfare", "https://runescape.wiki/index.php?title=File%3AFanfare.ogg")//✅
		.put("Far Away", "https://runescape.wiki/index.php?title=File%3AFar_Away.ogg")//✅
		.put("Fenkenstrain's Refrain", "https://runescape.wiki/index.php?title=File%3AFenkenstrain%27s_Refrain.ogg")//✅
		.put("Fight or Flight", "https://runescape.wiki/index.php?title=File%3AFight_or_Flight.ogg")//✅
		.put("Fishing", "https://runescape.wiki/index.php?title=File%3AFishing_(music_track).ogg")//✅
		.put("Flute Salad", "https://runescape.wiki/index.php?title=File%3AVenture.ogg")//✅ subbed
		.put("Forbidden", "https://runescape.wiki/index.php?title=File%3ADangerous.ogg")//✅ subbed
		.put("Forest", "https://runescape.wiki/index.php?title=File%3AForest.ogg")//✅ subbed
		.put("Forever", "https://runescape.wiki/index.php?title=File%3AVillage_Fate.ogg")//✅ subbed
		.put("Forgotten", "https://runescape.wiki/index.php?title=File%3AForgotten.ogg")//✅
		.put("Gaol", "https://runescape.wiki/index.php?title=File%3AGaol.ogg")//✅
		.put("Garden", "https://runescape.wiki/index.php?title=File%3AGarden.ogg")//✅
		.put("Gnome King", "https://runescape.wiki/index.php?title=File%3AGnome_King.ogg")//✅
		.put("Gnome Village", "https://runescape.wiki/index.php?title=File%3AGnome_Village_I.ogg")//✅
		.put("Gnome Village 2", "https://runescape.wiki/index.php?title=File%3AGnome_Village_II.ogg")//✅
		.put("Gnomeball", "https://runescape.wiki/index.php?title=File%3AGnomeball.ogg")//✅
		.put("Goblin Game", "https://runescape.wiki/index.php?title=File%3AGoblin_Game.ogg")//✅
		.put("Goblin Village", "https://runescape.wiki/index.php?title=File%3AGoblin_Village.ogg")//✅
		.put("Greatness", "https://runescape.wiki/index.php?title=File%3AGreatness.ogg")//✅
		.put("Grip of the Talon", "https://runescape.wiki/index.php?title=File%3AGrip_of_the_Talon.ogg")//✅
		.put("Grotto", "https://runescape.wiki/index.php?title=File%3AGrotto.ogg")//✅
		.put("Grumpy", "https://runescape.wiki/index.php?title=File%3AGrumpy.ogg")//✅
		.put("Harmony", "https://runescape.wiki/index.php?title=File%3AHarmony.ogg")//✅
		.put("Have an Ice Day", "https://runescape.wiki/index.php?title=File%3AHave_an_Ice_Day.ogg")//✅
		.put("High Seas", "https://runescape.wiki/index.php?title=File%3AHigh_Seas.ogg")//✅
		.put("Home Sweet Home", "https://runescape.wiki/index.php?title=File%3AHome_Sweet_Home.ogg")//✅
		.put("Horizon", "https://runescape.wiki/index.php?title=File%3AHorizon.ogg")//✅
		.put("Iban", "https://runescape.wiki/index.php?title=File%3AIban.ogg")//✅
		.put("Ice Melody", "https://runescape.wiki/index.php?title=File%3AIce_Melody.ogg")//✅
		.put("In the Manor", "https://runescape.wiki/index.php?title=File%3AIn_the_Manor.ogg")//✅
		.put("Incantation", "https://runescape.wiki/index.php?title=File%3AIncantation.ogg")//✅
		.put("Insect Queen", "https://runescape.wiki/index.php?title=File%3AInsect_Queen.ogg")//✅
		.put("Inspiration", "https://runescape.wiki/index.php?title=File%3ACrystal_Sword.ogg")//✅
		.put("Intrepid", "https://runescape.wiki/index.php?title=File%3AIntrepid.ogg")//✅
		.put("Jolly-R", "https://runescape.wiki/index.php?title=File%3AJolly-R.ogg")//✅
		.put("Jungle Hunt", "https://runescape.wiki/index.php?title=File%3AJungle_Hunt.ogg")//✅
		.put("Jungly 2", "https://runescape.wiki/index.php?title=File%3AJungly2.ogg")//✅
		.put("Karamja Jam", "https://runescape.wiki/index.php?title=File%3AKaramja_Jam.ogg")//✅
		.put("La Mort", "https://runescape.wiki/index.php?title=File%3ALa_Mort.ogg")//✅
		.put("Labyrinth", "https://runescape.wiki/index.php?title=File%3ALabyrinth.ogg")//✅)
		.put("Land of Snow", "https://runescape.wiki/index.php?title=File%3ALand_of_Snow.ogg")//✅
		.put("Land of the Dwarves", "https://runescape.wiki/index.php?title=File%3ALand_of_the_Dwarves.ogg")//✅
		.put("Landlubber", "https://runescape.wiki/index.php?title=File%3ALandlubber.ogg")//✅
		.put("Last Stand", "https://runescape.wiki/index.php?title=File%3ALast_Stand.ogg")//✅
		.put("Lasting", "https://runescape.wiki/index.php?title=File%3ALasting.ogg")//✅
		.put("Legend", "https://runescape.wiki/index.php?title=File%3ALegend.ogg")//✅
		.put("Legion", "https://runescape.wiki/index.php?title=File%3ALegion.ogg")//✅
		.put("Lighthouse", "https://runescape.wiki/index.php?title=File%3ALighthouse.ogg")//✅
		.put("Lightness", "https://runescape.wiki/index.php?title=File%3ADarkness.ogg")//✅
		.put("Lightwalk", "https://runescape.wiki/index.php?title=File%3ALightwalk.ogg")//✅
		.put("Long Ago", "https://runescape.wiki/index.php?title=File%3ALong_Ago.ogg")//✅
		.put("Long Way Home", "https://runescape.wiki/index.php?title=File%3ALong_Road.ogg")//✅
		.put("Looking Back", "https://runescape.wiki/index.php?title=File%3ALooking_Back.ogg")//✅
		.put("Lost Soul", "https://runescape.wiki/index.php?title=File%3ALost_Soul.ogg")//✅
		.put("Lullaby", "https://runescape.wiki/index.php?title=File%3ALullaby.ogg")//✅
		.put("Mage Arena", "https://runescape.wiki/index.php?title=File%3AMage_Arena.ogg")//✅
		.put("Magic Dance", "https://runescape.wiki/index.php?title=File%3AMagic_Dance.ogg")//✅
		.put("Magical Journey", "https://runescape.wiki/index.php?title=File%3AMagical_Journey.ogg")//✅
		.put("March", "https://runescape.wiki/index.php?title=File%3AMarch.ogg")//✅
		.put("Mausoleum", "https://runescape.wiki/index.php?title=File%3AMausoleum.ogg")//✅
		.put("Medieval", "https://runescape.wiki/index.php?title=File%3AMedieval.ogg")//✅
		.put("Mellow", "https://runescape.wiki/index.php?title=File%3AMellow.ogg")//✅
		.put("Melodrama", "https://runescape.wiki/index.php?title=File%3AMelodrama.ogg")//✅
		.put("Meridian", "https://runescape.wiki/index.php?title=File%3AMeridian.ogg")//✅
		.put("Miles Away", "https://runescape.wiki/index.php?title=File%3AMedieval_II.ogg")//✅ subbed
		.put("Monarch Waltz", "https://runescape.wiki/index.php?title=File%3AMonarch_Waltz.ogg")//✅
		.put("Monster Melee", "https://runescape.wiki/index.php?title=File%3AMonster_Melee.ogg")//✅
		.put("Moody", "https://runescape.wiki/index.php?title=File%3AMoody.ogg")//✅
		.put("Morytania", "https://runescape.wiki/index.php?title=File%3AMorytania.ogg")//✅
		.put("Mudskipper Melody", "https://runescape.wiki/index.php?title=File%3AMudskipper_Melody.ogg")//✅
		.put("Natural", "https://runescape.wiki/index.php?title=File%3ANatural.ogg")//✅
		.put("Neverland", "https://runescape.wiki/index.php?title=File%3ANeverland.ogg")//✅
		.put("Newbie Melody", "https://runescape.wiki/index.php?title=File%3ANewbie_Melody.ogg")//✅
		.put("Nightfall", "https://runescape.wiki/index.php?title=File%3AWander_Waltz.ogg")//✅ subbed
		.put("Nomad", "https://runescape.wiki/index.php?title=File%3ANomad_(music_track).ogg")//✅
		.put("Null and Void", "https://runescape.wiki/index.php?title=File%3ANull_and_Void.ogg")//✅
		.put("On the Wing", "https://runescape.wiki/index.php?title=File%3AOn_the_Wing.ogg")//✅
		.put("Out of the Deep", "https://runescape.wiki/index.php?title=File%3AOut_of_the_Deep.ogg")//✅
		.put("Overpass", "https://runescape.wiki/index.php?title=File%3AOverpass.ogg")//✅
		.put("Overture", "https://runescape.wiki/index.php?title=File%3AOverture.ogg")//✅
		.put("Parade", "https://runescape.wiki/index.php?title=File%3AGarden_Echo.ogg")
		.put("Path of Peril", "https://runescape.wiki/index.php?title=File%3APath_of_Peril.ogg")
		.put("Pathways", "https://runescape.wiki/index.php?title=File%3APathways.ogg")
		.put("Pest Control", "https://runescape.wiki/index.php?title=File%3APest_Control.ogg")
		.put("Pharaoh's Tomb", "https://runescape.wiki/index.php?title=File%3APharaoh%27s_Tomb.ogg")
		.put("Phasmatys", "https://runescape.wiki/index.php?title=File%3APhasmatys.ogg")
		.put("Pheasant Peasant", "https://runescape.wiki/index.php?title=File%3APheasant_Peasant.ogg")
		.put("Pinball Wizard", "https://runescape.wiki/index.php?title=File%3APinball_Wizard.ogg")
		.put("Pirates of Penance", "https://runescape.wiki/index.php?title=File%3APirates_of_Penance.ogg")
		.put("Pirates of Peril", "https://runescape.wiki/index.php?title=File%3APirates_of_Peril.ogg")
		.put("Poles Apart", "https://runescape.wiki/index.php?title=File%3APoles_Apart.ogg")
		.put("Prime Time", "https://runescape.wiki/index.php?title=File%3APrime_Time.ogg")
		.put("Principality", "https://runescape.wiki/index.php?title=File%3APrincipality.ogg")
		.put("Quest", "https://runescape.wiki/index.php?title=File%3AQuest.ogg")
		.put("Rat a Tat Tat", "https://runescape.wiki/index.php?title=File%3ARat_a_Tat_Tat.ogg")
		.put("Rat Hunt", "https://runescape.wiki/index.php?title=File%3ARat_Hunt.ogg")
		.put("Ready for Battle", "https://runescape.wiki/index.php?title=File%3AReady_for_Battle.ogg")
		.put("Regal", "https://runescape.wiki/index.php?title=File%3ARegal.ogg")
		.put("Reggae", "https://runescape.wiki/index.php?title=File%3AReggae.ogg")
		.put("Reggae 2", "https://runescape.wiki/index.php?title=File%3AReggae_2.ogg")
		.put("Rellekka", "https://runescape.wiki/index.php?title=File%3ARellekka.ogg")
		.put("Right on Track", "https://runescape.wiki/index.php?title=File%3ARight_on_Track.ogg")
		.put("Righteousness", "https://runescape.wiki/index.php?title=File%3ARighteousness.ogg")
		.put("Rising Damp", "https://runescape.wiki/index.php?title=File%3ARising_Damp.ogg")
		.put("Riverside", "https://runescape.wiki/index.php?title=File%3ARiverside.ogg")
		.put("Roc and Roll", "https://runescape.wiki/index.php?title=File%3ARoc_and_Roll.ogg")
		.put("Roll the Bones", "https://runescape.wiki/index.php?title=File%3ARoll_the_Bones.ogg")
		.put("Romancing the Crone", "https://runescape.wiki/index.php?title=File%3ARomancing_the_Crone.ogg")
		.put("Romper Chomper", "https://runescape.wiki/index.php?title=File%3ARomper_Chomper.ogg")
		.put("Roots and Flutes", "https://runescape.wiki/index.php?title=File%3ARoots_and_Flutes.ogg")
		.put("Royale", "https://runescape.wiki/index.php?title=File%3ARoyale.ogg")
		.put("Rune Essence", "https://runescape.wiki/index.php?title=File%3ARune_Essence.ogg")
		.put("Sad Meadow", "https://runescape.wiki/index.php?title=File%3ASad_Meadow.ogg")
		.put("Safety in Numbers", "https://runescape.wiki/index.php?title=File%3ASafety_in_Numbers.ogg")
		.put("Saga", "https://runescape.wiki/index.php?title=File%3ASaga.ogg")
		.put("Sarcophagus", "https://runescape.wiki/index.php?title=File%3ASarcophagus.ogg")
		.put("Sarim's Vermin", "https://runescape.wiki/index.php?title=File%3ASarim%27s_Vermin.ogg")
		.put("Scape Cave", "https://runescape.wiki/index.php?title=File%3AScape_Cave.ogg")
		.put("Scape Hunter", "https://runescape.wiki/index.php?title=File%3AScape_Hunter.ogg")
		.put("Scape Main", "https://runescape.wiki/index.php?title=File%3AScape_Bold.ogg")
		.put("Scape Original", "https://runescape.wiki/index.php?title=File%3ANewbie_Melody.ogg")
		.put("Scape Sad", "https://runescape.wiki/index.php?title=File%3AScape_Sad.ogg")
		.put("Scape Santa", "https://runescape.wiki/index.php?title=File%3AScape_Santa.ogg")
		.put("Scape Scared", "https://runescape.wiki/index.php?title=File%3AScape_Scared.ogg")
		.put("Scape Soft", "https://runescape.wiki/index.php?title=File%3AScape_Soft.ogg")
		.put("Scape Wild", "https://runescape.wiki/index.php?title=File%3AWilderness_III.ogg")//✅ subbed
		.put("Scarab", "https://runescape.wiki/index.php?title=File%3AScarab.ogg")
		.put("School's Out", "https://runescape.wiki/index.php?title=File%3ASchool%27s_Out.ogg")
		.put("Sea Shanty", "https://runescape.wiki/index.php?title=File%3ASea_Shanty.ogg")
		.put("Sea Shanty 2", "https://runescape.wiki/index.php?title=File%3ASea_Shanty_2.ogg")
		.put("Sea Shanty XMAS", "https://runescape.wiki/index.php?title=File%3ASea_Shanty_XMAS.ogg")
		.put("Serenade", "https://runescape.wiki/index.php?title=File%3ASerenade.ogg")
		.put("Serene", "https://runescape.wiki/index.php?title=File%3ASerene.ogg")
		.put("Settlement", "https://runescape.wiki/index.php?title=File%3ASettlement.ogg")
		.put("Shadowland", "https://runescape.wiki/index.php?title=File%3AShadowland.ogg")
		.put("Shine", "https://runescape.wiki/index.php?title=File%3AShine.ogg")
		.put("Shining", "https://runescape.wiki/index.php?title=File%3AScape_Sad.ogg")//✅ subbed
		.put("Shining Spirit", "https://runescape.wiki/index.php?title=File%3AShining_Spirit.ogg")
		.put("Shipwrecked", "https://runescape.wiki/index.php?title=File%3AShipwrecked.ogg")
		.put("Showdown", "https://runescape.wiki/index.php?title=File%3AShowdown.ogg")
		.put("Sigmund's Showdown", "https://runescape.wiki/index.php?title=File%3ASigmund%27s_Showdown.ogg")
		.put("Slice of Silent Movie", "https://runescape.wiki/index.php?title=File%3ASlice_of_Silent_Movie.ogg")
		.put("Slice of Station", "https://runescape.wiki/index.php?title=File%3ASlice_of_Station.ogg")
		.put("Slither and Thither", "https://runescape.wiki/index.php?title=File%3ASlither_and_Thither.ogg")
		.put("Slug a Bug Ball", "https://runescape.wiki/index.php?title=File%3ASlug_a_Bug_Ball.ogg")
		.put("Sojourn", "https://runescape.wiki/index.php?title=File%3ASojourn.ogg")
		.put("Soundscape", "https://runescape.wiki/index.php?title=File%3ASoundscape.ogg")
		.put("Sphinx", "https://runescape.wiki/index.php?title=File%3ASphinx.ogg")
		.put("Spirit", "https://runescape.wiki/index.php?title=File%3ASpirit.ogg")
		.put("Spirits of Elid", "https://runescape.wiki/index.php?title=File%3ASpirits_of_Elid.ogg")
		.put("Splendour", "https://runescape.wiki/index.php?title=File%3ASplendour.ogg")
		.put("Spooky", "https://runescape.wiki/index.php?title=File%3ASpooky.ogg")
		.put("Spooky 2", "https://runescape.wiki/index.php?title=File%3ASpooky_2.ogg")
		.put("Spooky Jungle", "https://runescape.wiki/index.php?title=File%3ASpooky_Jungle.ogg")
		.put("Stagnant", "https://runescape.wiki/index.php?title=File%3AStagnant.ogg")
		.put("Starlight", "https://runescape.wiki/index.php?title=File%3AStarlight.ogg")
		.put("Start", "https://runescape.wiki/index.php?title=File%3AWhile_We_Sleep.ogg")
		.put("Stillness", "https://runescape.wiki/index.php?title=File%3AStillness.ogg")
		.put("Still Night","https://runescape.wiki/index.php?title=File%3ABusy_Night.ogg")//✅
		.put("Storm Brew", "https://runescape.wiki/index.php?title=File%3AStorm_Brew.ogg")
		.put("Stranded", "https://runescape.wiki/index.php?title=File%3AStranded.ogg")
		.put("Strange Place", "https://runescape.wiki/index.php?title=File%3AStrange_Place.ogg")
		.put("Stratosphere", "https://runescape.wiki/index.php?title=File%3AStratosphere.ogg")
		.put("Strength of Saradomin", "https://runescape.wiki/index.php?title=File%3AStrength_of_Saradomin.ogg")
		.put("Subterranea", "https://runescape.wiki/index.php?title=File%3ASubterranea.ogg")
		.put("Sunburn", "https://runescape.wiki/index.php?title=File%3ASunburn.ogg")
		.put("Superstition", "https://runescape.wiki/index.php?title=File%3ASuperstition.ogg")
		.put("Suspicious", "https://runescape.wiki/index.php?title=File%3ASuspicious.ogg")
		.put("Tale of Keldagrim", "https://runescape.wiki/index.php?title=File%3ATale_of_Keldagrim.ogg")
		.put("Talking Forest", "https://runescape.wiki/index.php?title=File%3ATalking_Forest.ogg")
		.put("Tears of Guthix", "https://runescape.wiki/index.php?title=File%3ATears_of_Guthix.ogg")
		.put("Technology", "https://runescape.wiki/index.php?title=File%3ATechnology.ogg")
		.put("Temple", "https://runescape.wiki/index.php?title=File%3ATemple.ogg")
		.put("Temple of Light", "https://runescape.wiki/index.php?title=File%3ATemple_of_Light.ogg")
		.put("The Cellar Dwellers", "https://runescape.wiki/index.php?title=File%3AThe_Cellar_Dwellers.ogg")
		.put("The Depths", "https://runescape.wiki/index.php?title=File%3AThe_Depths.ogg")
		.put("The Desert", "https://runescape.wiki/index.php?title=File%3AThe_Desert.ogg")//✅
		.put("The Enchanter", "https://runescape.wiki/index.php?title=File%3AThe_Enchanter.ogg")
		.put("The Far Side", "https://runescape.wiki/index.php?title=File%3AThe_Far_Side.ogg")
		.put("The Galleon", "https://runescape.wiki/index.php?title=File%3AThe_Galleon.ogg")
		.put("The Genie", "https://runescape.wiki/index.php?title=File%3AThe_Genie.ogg")
		.put("The Golem", "https://runescape.wiki/index.php?title=File%3AThe_Golem.ogg")
		.put("The Last Shanty", "https://runescape.wiki/index.php?title=File%3AThe_Last_Shanty.ogg")
		.put("The Lost Melody", "https://runescape.wiki/index.php?title=File%3AThe_Lost_Melody.ogg")
		.put("The Lost Tribe", "https://runescape.wiki/index.php?title=File%3AThe_Lost_Tribe.ogg")
		.put("The Lunar Isle", "https://runescape.wiki/index.php?title=File%3AThe_Lunar_Isle.ogg")
		.put("The Mad Mole", "https://runescape.wiki/index.php?title=File%3AThe_Mad_Mole.ogg")
		.put("The Mollusc Menace", "https://runescape.wiki/index.php?title=File%3AThe_Mollusc_Menace.ogg")
		.put("The Monsters Below", "https://runescape.wiki/index.php?title=File%3AThe_Monsters_Below.ogg")
		.put("The Navigator", "https://runescape.wiki/index.php?title=File%3AThe_Navigator.ogg")
		.put("The Nightmare Continues", "https://runescape.wiki/index.php?title=File%3AThe_Nightmare_Continues.ogg")
		.put("The Noble Rodent", "https://runescape.wiki/index.php?title=File%3AThe_Noble_Rodent.ogg")
		.put("The Other Side", "https://runescape.wiki/index.php?title=File%3AThe_Other_Side.ogg")
		.put("The Power of Tears", "https://runescape.wiki/index.php?title=File%3AThe_Power_of_Tears.ogg")
		.put("The Rogues' Den", "https://runescape.wiki/index.php?title=File%3AThe_Rogues%27_Den.ogg")
		.put("The Shadow", "https://runescape.wiki/index.php?title=File%3AThe_Shadow.ogg")
		.put("The Slayer", "https://runescape.wiki/index.php?title=File%3AThe_Slayer.ogg")
		.put("The Terrible Caverns", "https://runescape.wiki/index.php?title=File%3AThe_Terrible_Caverns.ogg")
		.put("The Terrible Tower", "https://runescape.wiki/index.php?title=File%3AThe_Terrible_Tower.ogg")
		.put("The Terrible Tunnels", "https://runescape.wiki/index.php?title=File%3AThe_Terrible_Tunnels.ogg")
		.put("The Tower", "https://runescape.wiki/index.php?title=File%3AThe_Tower.ogg")
		.put("The Trade Parade", "https://runescape.wiki/index.php?title=File%3AMisthalin_Mood_II.ogg")//✅ subbed
		.put("Theme", "https://runescape.wiki/index.php?title=File%3ATheme.ogg")
		.put("Throne of the Demon", "https://runescape.wiki/index.php?title=File%3AThrone_of_the_Demon.ogg")
		.put("Time Out", "https://runescape.wiki/index.php?title=File%3ATime_Out.ogg")
		.put("Time to Mine", "https://runescape.wiki/index.php?title=File%3ATime_to_Mine.ogg")
		.put("Tiptoe", "https://runescape.wiki/index.php?title=File%3ATiptoe.ogg")
		.put("Title Fight", "https://runescape.wiki/index.php?title=File%3ATitle_Fight.ogg")
		.put("Tomb Raider", "https://runescape.wiki/index.php?title=File%3ATomb_Raider.ogg")
		.put("Tomorrow", "https://runescape.wiki/index.php?title=File%3ATomorrow.ogg")
		.put("Too Many Cooks...", "https://runescape.wiki/index.php?title=File%3AToo_Many_Cooks....ogg")
		.put("Trawler", "https://runescape.wiki/index.php?title=File%3ATrawler.ogg")
		.put("Trawler Minor", "https://runescape.wiki/index.php?title=File%3ATrawler_Minor.ogg")
		.put("Tree Spirits", "https://runescape.wiki/index.php?title=File%3ATree_Spirits.ogg")
		.put("Tremble", "https://runescape.wiki/index.php?title=File%3ATremble.ogg")
		.put("Tribal", "https://runescape.wiki/index.php?title=File%3ATribal.ogg")
		.put("Tribal 2", "https://runescape.wiki/index.php?title=File%3ATribal_2.ogg")
		.put("Tribal Background", "https://runescape.wiki/index.php?title=File%3ATribal_Background.ogg")
		.put("Trinity", "https://runescape.wiki/index.php?title=File%3ATrinity.ogg")
		.put("Trouble Brewing", "https://runescape.wiki/index.php?title=File%3ATrouble_Brewing.ogg")
		.put("Troubled", "https://runescape.wiki/index.php?title=File%3ARegal.ogg")//✅ subbed
		.put("Twilight", "https://runescape.wiki/index.php?title=File%3ATwilight.ogg")
		.put("TzHaar!", "https://runescape.wiki/index.php?title=File%3ATzHaar!.ogg")
		.put("Undead Dungeon", "https://runescape.wiki/index.php?title=File%3AUndead_Dungeon.ogg")
		.put("Undercurrent", "https://runescape.wiki/index.php?title=File%3ADeep_Wildy.ogg")//✅ subbed
		.put("Underground", "https://runescape.wiki/index.php?title=File%3AArmy_of_Darkness.ogg")//✅ subbed
		.put("Underground Pass", "https://runescape.wiki/index.php?title=File%3AUnderground_Pass.ogg")
		.put("Understanding", "https://runescape.wiki/index.php?title=File%3AUnderstanding.ogg")
		.put("Unknown Land", "https://runescape.wiki/index.php?title=File%3ADarkness_in_Misthalin.ogg")
		.put("Untouchable", "https://runescape.wiki/index.php?title=File%3AUntouchable.ogg")
		.put("Upcoming", "https://runescape.wiki/index.php?title=File%3AUpcoming.ogg")
		.put("Upir Likhyi", "https://runescape.wiki/index.php?title=File%3AUpir_Likhyi.ogg")
		.put("Venture", "https://runescape.wiki/index.php?title=File%3AVenture.ogg")
		.put("Venture 2", "https://runescape.wiki/index.php?title=File%3AVenture_2.ogg")
		.put("Victory is Mine", "https://runescape.wiki/index.php?title=File%3AVictory_is_Mine.ogg")
		.put("Village", "https://runescape.wiki/index.php?title=File%3AVillage.ogg")
		.put("Vision", "https://runescape.wiki/index.php?title=File%3AVision.ogg")
		.put("Volcanic Vikings", "https://runescape.wiki/index.php?title=File%3AVolcanic_Vikings.ogg")
		.put("Voodoo Cult", "https://runescape.wiki/index.php?title=File%3AVoodoo_Cult.ogg")
		.put("Voyage", "https://runescape.wiki/index.php?title=File%3AVoyage.ogg")
		.put("Waking Dream", "https://runescape.wiki/index.php?title=File%3AWaking_Dream.ogg")
		.put("Wander", "https://runescape.wiki/index.php?title=File%3AWander.ogg")
		.put("Warrior", "https://runescape.wiki/index.php?title=File%3AWarrior.ogg")
		.put("Warriors' Guild", "https://runescape.wiki/index.php?title=File%3AWarriors%27_Guild.ogg")
		.put("Waterfall", "https://runescape.wiki/index.php?title=File%3AWaterfall.ogg")
		.put("Waterlogged", "https://runescape.wiki/index.php?title=File%3AWaterlogged.ogg")
		.put("Way of the Enchanter", "https://runescape.wiki/index.php?title=File%3AWay_of_the_Enchanter.ogg")
		.put("Wayward", "https://runescape.wiki/index.php?title=File%3AWayward.ogg")
		.put("Well of Voyage", "https://runescape.wiki/index.php?title=File%3AWell_of_Voyage.ogg")
		.put("Where Eagles Lair", "https://runescape.wiki/index.php?title=File%3AWhere_Eagles_Lair.ogg")
		.put("Wild Isle", "https://runescape.wiki/index.php?title=File%3AEverlasting_Fire.ogg")//✅ subbed
		.put("Wild Side", "https://runescape.wiki/index.php?title=File%3AWilderness_III.ogg")//✅ subbed
		.put("Wilderness", "https://runescape.wiki/index.php?title=File%3AWilderness_I.ogg")//✅
		.put("Wilderness 2", "https://runescape.wiki/index.php?title=File%3AEruption.ogg")//✅ subbed
		.put("Wilderness 3", "https://runescape.wiki/index.php?title=File%3AWilderness_III.ogg")//✅ subbed
		.put("Wildwood", "https://runescape.wiki/index.php?title=File%3AWilderness_I.ogg")//✅ subbed
		.put("Winter Funfair", "https://runescape.wiki/index.php?title=File%3AWinter_Funfair.ogg")
		.put("Witching", "https://runescape.wiki/index.php?title=File%3AFaithless.ogg") //✅ subbed
		.put("Woe of the Wyvern", "https://runescape.wiki/index.php?title=File%3AWoe_of_the_Wyvern.ogg")
		.put("Wolf Mountain", "https://runescape.wiki/index.php?title=File%3AWolf_Mountain.ogg")
		.put("Wonder", "https://runescape.wiki/index.php?title=File%3ADoorways.ogg")//✅ subbed
		.put("Wonderous", "https://runescape.wiki/index.php?title=File%3AWonderous.ogg")
		.put("Woodland", "https://runescape.wiki/index.php?title=File%3AWoodland.ogg")
		.put("Work Work Work", "https://runescape.wiki/index.php?title=File%3AWork_Work_Work.ogg")
		.put("Workshop", "https://runescape.wiki/index.php?title=File%3AWorkshop.ogg")
		.put("Wrath and Ruin", "https://runescape.wiki/index.php?title=File%3AWrath_and_Ruin.ogg")
		.put("Xenophobe", "https://runescape.wiki/index.php?title=File%3AXenophobe.ogg")
		.put("Yesteryear", "https://runescape.wiki/index.php?title=File%3AYesteryear.ogg")
		.put("Zamorak Zoo", "https://runescape.wiki/index.php?title=File%3AZamorak_Zoo.ogg")
		.put("Zealot", "https://runescape.wiki/index.php?title=File%3AZealot.ogg")
		.put("Zogre Dance", "https://runescape.wiki/index.php?title=File%3AZogre_Dance.ogg")
		.put("Zombiism", "https://runescape.wiki/index.php?title=File%3AZombiism.ogg")
		.build();

    /**
     * Checks {@link #trackList} for the specified track.
     * @param name the name of the track to lookup
     * @return true if the track exists, false otherwise
     */
	public static Boolean ContainsTrack(String name)
	{
		return trackList.containsKey(name);
	}

    /**
     * Gets the {@code link} for the specified track.
     * <p>
     * Note: the link is not a direct download of the track.
     * it is only a link to the file page containing the download
     * @param name the track name used to get the link from {@link #trackList}
     * @return the string of the tracks link, otherwise null if the track does not exist in {@link #trackList}
     */
	public static String GetTrackLink(String name)
	{
		return trackList.get(name);
	}

}



