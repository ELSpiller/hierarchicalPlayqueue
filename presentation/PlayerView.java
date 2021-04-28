package presentation;

import application.Player;
import application.PlayerObserver;

/**
 * View class used to print name of currently playing song to console. Makes use of Observer Design Pattern to notify
 * view objects of changes to Player.
 */
public class PlayerView implements PlayerObserver {
    private final Player player;

    /**
     * Constructor for PlayerView. Takes player object as reference and adds itself to the list of Observers
     * Player reference stored locally for use in updatePlayerView()
     *
     * @param player the music player object
     */
    protected PlayerView(Player player) {
        this.player = player;
        player.addObserver(this);
    }

    /**
     * Update method from PlayerObserver. Calls updatePlayerView method from this class.
     */
    @Override
    public void update() {
        this.updatePlayerView();
    }

    /**
     * Calls method in Player to access currently playing song and prints to console.
     */
    private void updatePlayerView() {
        System.out.println("The Player is now playing " + player.getNowPlaying() + "\n");
    }
}
