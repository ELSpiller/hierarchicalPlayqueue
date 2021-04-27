package application;

/**
 * Class implementing Visitor interface. Used to return name and artist, where applicable, of all objects in
 * a playqueue. Based on the Visitor Design Pattern.
 */
public class NameVisitor implements Visitor {
    private String itemInfo = "";

    /**
     * Visit this object and add its formatted name and artist to the itemInfo string
     * @param item any object of type PlayableItem
     */
    @Override
    public void visit(PlayableItem item) {
        if (item instanceof Song) {
            itemInfo += item.name + " by " + item.artist + "\n";
        } else if (item instanceof Playlist) {
            itemInfo += "---Playlist: " + item.name + "\n";
        }
    }

    /**
     * Gets full details of all objects in the playqueue visit() was called on. Must be used after visit().
     * @return String of all items' names and artists
     */
    public String getItemInfo() {
        return itemInfo;
    }
}
