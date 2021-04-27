package application;

import java.util.ArrayList;

/**
 * Class representing a playlist. Inherits variables and methods from PlayableItem
 * Composite Design Pattern used here. Playlist arrays can contain any playable item, such as a song, another playlist,
 * or something else. Enables code reusage and simplifies methods by treating all objects as the same.
 */
public class Playlist extends PlayableItem implements Element {
    /**
     * Array containing any number of PlayableItem elements, such as Songs or other Playlists.
     * Empty playlists are allowed. Duplicate items are allowed.
     */
    private final ArrayList<PlayableItem> playlist = new ArrayList<>();

    /**
     * Instantiates a new Song. Passes name to PlayableItem.
     *
     * @param name the name
     */
    public Playlist(String name) {
        this.name = name;
    }

    /**
     * Method used to 'play' a playlist. Prints formatted string representing a playlist being played, including
     * playlist name. Doesn't play individual songs in playlist.
     */
    protected void play() {
        System.out.println("Playing playlist " + this.name);
        for (PlayableItem item : playlist) {
            item.play();
        }
    }

    /**
     * Add item to playlist. Uses polymorphism to accept any item of a subclass of PlayableItem.
     *
     * @param item the item
     */
    public void add(PlayableItem item) {
        if (this.name.equals(item.name))
            System.out.println("You can't add this playlist to itself!");
        else
            this.playlist.add(item);
    }

    /**
     * Remove an item from the playlist.
     *
     * @param item the item
     */
    public void remove(PlayableItem item) {
        this.playlist.remove(item);
    }

    /**
     * Accept a visitor object. Calls the visitors visit() method on itself.
     *
     * @param visitor the visitor object
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (PlayableItem item : playlist) {
            item.accept(visitor);
        }
    }
}
