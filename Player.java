package application;

import java.util.ArrayList;

/**
 * Class representing a music player.
 */
public class Player {
    private final ArrayList<PlayerObserver> observers = new ArrayList<>();
    /**
     * Reference to playqueue stored as variable.
     */
    PlayQueue queue;

    /**
     * Method used to play next item in a playqueue. Creates PlayVisitor object to visit next item and play the item.
     * Then notifies any playerobservers to display currently playing song.
     * Removes item from queue once played.
     *
     * @param queue the playqueue being played
     * @throws EmptyPlayQueueException thrown if method called on an empty playqueue.
     */
    public void playSong(PlayQueue queue) throws EmptyPlayQueueException {
        if (queue.hasNext()) {
            this.queue = queue;
            queue.getNext().play();
            this.notifyObservers();
            queue.removeNext();
        } else
            throw new EmptyPlayQueueException("Playqueue is empty!");
    }

    /**
     * Returns name of currently playing song.
     *
     * @return name of the now playing PlayableItem as a String
     */
    public String getNowPlaying() {
        try {
            PlayableItem next = this.queue.getNext();
            return next.getName();
        } catch (EmptyPlayQueueException e) {
            return (e.getMessage());
        }
    }

    /**
     * Add observer to ArrayList. Called by observer objects.
     *
     * @param obsv the observer
     */
    public void addObserver(PlayerObserver obsv) {
        this.observers.add(obsv);
    }

    /**
     * Notify observers to changes.
     */
    public void notifyObservers() {
        for (PlayerObserver obsv : observers) {
            obsv.update();
        }
    }
}
