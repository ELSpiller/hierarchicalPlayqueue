package presentation;

import application.*;

/**
 * Main class for song queue and music player.
 */
public class SongQueueController {
    public static void main(String[] args) {
        //Creating player and queue objects
        Player player = new Player();
        PlayQueue queue = new PlayQueue();

        //Creating all view objects. They take player or queue parameters and pass themselves as observers to these
        PlayerView playerView = new PlayerView(player);
        QueueTopLevelView queueTopLevelView = new QueueTopLevelView(queue);
        QueueFullView queueFullView = new QueueFullView(queue);
        DurationView durationView = new DurationView(queue);

        //Initialising songs and playlists
        Song societyEddieVedder = new Song("Society", "Eddie Vedder", 237);
        Song walkPantera = new Song("Walk", "Pantera", 316);
        Song theDanceGarthBrooks = new Song("The Dance", "Garth Brooks", 213);
        Song buckRogersFeeder = new Song("Buck Rogers", "Feeder", 194);
        Song iWillAlwaysWhitneyHouston = new Song("I Will Always Love You", "Whitney Houston", 266);
        Song girlsJustWannaCyndiLauper = new Song("Girls Just Wanna Have Fun", "Cyndi Lauper", 239);

        Playlist gymPlaylist = new Playlist("Gym");
        gymPlaylist.add(iWillAlwaysWhitneyHouston);
        gymPlaylist.add(girlsJustWannaCyndiLauper);

        Playlist workPlaylist = new Playlist("Work");
        workPlaylist.add(walkPantera);
        workPlaylist.add(theDanceGarthBrooks);
        workPlaylist.add(buckRogersFeeder);

        Playlist allPlaylists = new Playlist("All my playlists");
        allPlaylists.add(workPlaylist);
        allPlaylists.add(gymPlaylist);

        //Adding songs and playlists to queue
        queue.addToEnd(societyEddieVedder);
        queue.addToEnd(allPlaylists);
        queue.addToEnd(buckRogersFeeder);
        queue.addToEnd(workPlaylist);

        System.out.println("Playing songs:");

        //Calls playSong 20 times. Will break when EmptyPlayQueueException (ie when PlayQueue is empty)
        for (int i = 0; i < 20; i++) {
            try {
                player.playSong(queue);
            } catch (EmptyPlayQueueException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
