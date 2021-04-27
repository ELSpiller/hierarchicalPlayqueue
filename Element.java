package application;

/**
 * Interface for classes that accept a Visitor object. Based on the Visitor Design Pattern.
 */
public interface Element {
    /**
     * Accept the visitor object.
     * @param visitor the visitor object
     */
    void accept(Visitor visitor);
}
