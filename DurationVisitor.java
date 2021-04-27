package application;

/**
 * Class implementing Visitor interface. Used to get total duration of a playqueue.
 * Based on the Visitor Design Pattern.
 */
public class DurationVisitor implements Visitor {

    private int totalDuration;
    /**
     * Visit this object and add its duration to the running total.
     * @param item any object of type PlayableItem
     */
    public void visit(PlayableItem item) {
        if (item instanceof Song) {
            totalDuration += item.getDuration();
        }
    }

    /**
     * @return int representing duration of playqueue. Must be used after visit().
     */
    public int getTotalDuration(){
        return totalDuration;
    }
}

