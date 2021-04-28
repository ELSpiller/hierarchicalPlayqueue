package presentation;

import application.PlayQueue;
import application.QueueObserver;

/**
 * View class used to print full hierarchy of playqueue to console. Makes use of Observer Design Pattern to notify
 * view objects of changes to Queue.
 */
public class QueueFullView implements QueueObserver {
    private final PlayQueue queue;

    /**
     * Constructor for QueueFullView. Takes queue object as reference and adds itself to the list of Observers
     * Queue reference stored locally for use in updatePlayerView()
     *
     * @param queue the playqueue object
     */
    protected QueueFullView(PlayQueue queue) {
        this.queue = queue;
        queue.addObserver(this);
    }

    /**
     * Update method from QueueObserver. Calls updateQueueAll method from this class.
     */
    @Override
    public void update() {
        this.updateQueueAll();
    }

    /**
     * Calls method in Queue to access full hierarchy of queue and prints to console.
     */
    private void updateQueueAll() {
        System.out.println("*** Flat Queue Display ***");
        System.out.println(queue.displayFullQueue());
    }


}
