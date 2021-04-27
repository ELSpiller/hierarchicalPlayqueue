package application;

/**
 * Abstract class representing any item that can be 'played'. Makes use of polymorphism and inheritance.
 * Parent class of Song and Playlist classes, and can be used to create further playable classes, for example
 * podcasts, that can be used in the same way as these.
 */
abstract public class PlayableItem {
    protected String name;
    protected String artist;
    protected int duration;

    /**
     * Instantiates a new Playable item.
     */
    public PlayableItem() {
    }

    /**
     * Gets name of item.
     *
     * @return String of the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets duration of item in seconds. May be 0 for certain objects.
     *
     * @return the duration
     */
    protected int getDuration() {
        return this.duration;
    }

    /**
     * Gets artist of item. May be null for certain objects.
     *
     * @return the artist
     */
    protected String getArtist() {
        return this.artist;
    }

    /**
     * Abstract method overridden in subclasses. Used to play the object.
     */
    abstract protected void play();

    /**
     * Abstract method overridden in subclasses. Used to accept a visitor object.
     *
     * @param visitor the visitor object
     */
    public abstract void accept(Visitor visitor);
}
