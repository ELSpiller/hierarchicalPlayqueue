package application;

/**
 * Interface class used to generate Visitor objects. Based on the Visitor Design Pattern.
 */
public interface Visitor {
    /**
     * Visit this object. Action will depend on implementing class.
     * @param item any object of type PlayableItem
     */
    void visit(PlayableItem item);
}
