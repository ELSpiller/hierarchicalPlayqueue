package application;

import java.util.ArrayList;

/**
 * Class representing the Queue for the Player
 */
public class PlayQueue {
    private final ArrayList<PlayableItem> playQueue = new ArrayList<>();
    private final ArrayList<QueueObserver> observers = new ArrayList<>();

    /**
     * Instantiates a new Play queue.
     */
    public PlayQueue() {
    }

    /**
     * Adds new item to end of playqueue. Objects in queue will be played in the order they are added.
     * Also notifies any queueobservers to changed queue
     *
     * @param queueItem the PlayableItem to be added
     */
    public void addToEnd(PlayableItem queueItem) {
        playQueue.add(queueItem);
        this.notifyObservers();
    }

    /**
     * Returns true if playqueue is not empty
     *
     * @return the boolean representing whether playqueue still contains objects
     */
    protected boolean hasNext() {
        return !this.playQueue.isEmpty();
    }

    /**
     * Returns next item in queue. If queue is empty throws an exception.
     *
     * @return the next PlayableItem object
     * @throws EmptyPlayQueueException if queue is empty
     */
    protected PlayableItem getNext() throws EmptyPlayQueueException {
        if (this.hasNext())
            return this.playQueue.get(0);
        else
            throw new EmptyPlayQueueException("Playqueue is empty!");
    }

    /**
     * Removes next item from playlist and notifies any queueobservers to changed queue
     */
    protected void removeNext() {
        this.playQueue.remove(0);
        this.notifyObservers();
    }

    /**
     * Displays total duration of all objects in queue. Creates DurationVisitor object and sends to each object
     * in playqueue. High-level objects (playlists) then send it to lower level objects.
     *
     * @return the duration in seconds as integer
     */
    public int getDuration() {
        DurationVisitor total = new DurationVisitor();
        for (PlayableItem item : playQueue) {
            item.accept(total);
        }
        return total.getTotalDuration();
    }

    /**
     * Displays item details of all objects in queue. Creates NameVisitor object and sends to each object
     * in playqueue. High-level objects (playlists) then send it to lower level objects.
     *
     * @return the string
     */
    public String displayFullQueue() {
        NameVisitor name = new NameVisitor();
        for (PlayableItem item : playQueue) {
            item.accept(name);
        }
        return name.getItemInfo();
    }

    /**
     * Displays item details of all top-level objects in queue. Accesses each item and adds its formatted name
     * and artist to the itemInfo string
     *
     * @return full queue details as String
     */
    public String displayTopLevelQueue() {
        String itemInfo = "";

        for (PlayableItem item : playQueue) {
            if (item instanceof Song) {
                itemInfo += item.name + " by " + item.artist + "\n";
            } else if (item instanceof Playlist) {
                itemInfo += "---Playlist: " + item.name + "\n";
            }
        }
        return itemInfo;
    }

    /**
     * Add observer to ArrayList. Called by observer objects.
     *
     * @param obsv the observer
     */
    public void addObserver(QueueObserver obsv) {
        this.observers.add(obsv);
    }

    /**
     * Notify observers to changes.
     */
    public void notifyObservers() {
        for (QueueObserver obsv : observers) {
            obsv.update();
        }
    }
}


