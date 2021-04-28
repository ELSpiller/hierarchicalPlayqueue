package presentation;

import application.PlayQueue;
import application.QueueObserver;

/**
 * View class used to print total duration of playqueue to console. Makes use of Observer Design Pattern to notify
 * view objects of changes to Queue.
 */
public class DurationView implements QueueObserver {
    private final PlayQueue queue;

    /**
     * Constructor for DurationView. Takes queue object as reference and adds itself to the list of Observers
     * Queue reference stored locally for use in updatePlayerView()
     *
     * @param queue the playqueue object
     */
    protected DurationView(PlayQueue queue) {
        this.queue = queue;
        queue.addObserver(this);
    }

    /**
     * Update method from QueueObserver. Calls updateDuration method from this class.
     */
    @Override
    public void update() {
        this.updateDuration();
    }

    /**
     * Calls method in Queue to access total duration of queue and prints to console.
     */
    private void updateDuration() {
        System.out.println("*** Queue Length Display ***");
        System.out.println("The queue is currently " + queue.getDuration() + " seconds long.\n");
    }
}
