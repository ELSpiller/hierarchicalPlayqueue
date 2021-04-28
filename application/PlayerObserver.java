package application;

/**
 * Interface class for Observer objects to be updated of changes to a particular subject. Makes use of Observer
 * Design Pattern.
 * PlayerObserver and QueueObserver are technically the same class, but for simplicity, naming,
 * and extension purposes, they are made separate.
 */
public interface PlayerObserver {
    /**
     * Called to alert the Observer object to changes to an object. Action depends on implementing class
     */
    void update();
}
