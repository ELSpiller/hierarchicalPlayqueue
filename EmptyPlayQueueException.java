package application;

/**
 * Exception to be thrown when an empty playqueue is played
 */
public class EmptyPlayQueueException extends Exception {

    /**
     * Instantiates a new Empty play queue exception. Creates exception object with error message passed to constructor.
     * @param msg String explaining the error.
     */
    public EmptyPlayQueueException(String msg) {
        super(msg);
    }
}
