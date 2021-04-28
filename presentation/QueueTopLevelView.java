package presentation;

import application.PlayQueue;
import application.QueueObserver;

/**
 * View class used to print top level of items on playqueue to console. Makes use of Observer Design Pattern to notify
 * view objects of changes to Queue.
 */
public class QueueTopLevelView implements QueueObserver {
    private final PlayQueue queue;


    /**
     * Constructor for QueueTopLevelView. Takes queue object as reference and adds itself to the list of Observers
     * Queue reference stored locally for use in updatePlayerView()
     *
     * @param queue the playqueue object
     */
    protected QueueTopLevelView(PlayQueue queue) {
        this.queue = queue;
        queue.addObserver(this);
    }

    /**
     * Update method from QueueObserver. Calls updateQueueTopLevel method from this class.
     */
    @Override
    public void update() {
        this.updateQueueTopLevel();
    }

    /**
     * Calls method in Queue to access items in queue and prints to console.
     */
    private void updateQueueTopLevel() {
        System.out.println("*** Top Queue Display ***");
        System.out.println(queue.displayTopLevelQueue());
    }


}
