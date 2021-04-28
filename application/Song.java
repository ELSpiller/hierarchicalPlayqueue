package application;

/**
 * Class representing a song. Inherits variables and methods from PlayableItem
 */
public class Song extends PlayableItem {

    /**
     * Instantiates a new Song. Passes parameters to PlayableItem.
     *
     * @param name     the name
     * @param artist   the artist
     * @param duration the duration
     */
    public Song(String name, String artist, int duration) {
        super.name = name;
        super.artist = artist;
        super.duration = duration;
    }

    /**
     * Method used to 'play' a song. Prints formatted string representing a song being played, including
     * song name and artist.
     */
    protected void play() {
        System.out.println("Playing the song " + this.name + " by " + this.artist);
    }

    /**
     * Accept a visitor object. Calls the visitors visit() method on itself.
     *
     * @param visitor the visitor object
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
