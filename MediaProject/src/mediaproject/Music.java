
package mediaproject;

/**
 *
 * @author travi
 */
public class Music extends Media
{

    protected String artist;
/**
 * constructor
 * @param title title is in common with all media
 * @param artist artist is specific to music
 */
    public Music(String title, String artist)
    {
        super(title);
        this.artist = artist;
        //setTitle(title);
    }
/**
 * used to access artist
 * @return 
 */
    public String getArtist()
    {
        return artist;
    }
/**
 * used to adjust the artist name if we wanted to add feature
 * @param newArtist 
 */
    public void setArtist(String newArtist)
    {
        artist = newArtist;
    }
/**
 * override to string to make it easy to sort items later
 * @return 
 */
    @Override
    public String toString()
    {
        // System.out.printf("Title: %s \t Artist: %s\n",title,artist);
       // return "Title:  " + title + "\nArtist: " + artist;
        return "Artist: " + artist + "\nTitle: " + title;

    }
}
