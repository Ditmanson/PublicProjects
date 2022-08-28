
/**
 * @author Travis Ditmanson
 * @email travisditmanson@gmail.com
 */

//package mediaproject;
/**
 *
 * @author travis ditmanson
 * movie is a subclass of media
 */
public class Movie extends Media
{

    private String genere;

    /**
     * constructor for movie
     *
     * @param title exists for all media objects
     * @param genere specific for movies, i know it could apply to music but
     * that's not the point
     */
    public Movie(String title, String genere)
    {
        super(title);
        this.genere = genere;
    }

    /**
     * getter for genere
     *
     * @return
     */
    public String getGenere()
    {
        return genere;
    }

    /**
     * setter for genere
     *
     * @param newGenere
     */
    public void setGenere(String newGenere)
    {
        genere = newGenere;
    }

    /**
     * to string for genere
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "Genere: " + genere + "\nTitle: " + title;
        // return  "Title:  " + title +"\nGenere: "+genere;
    }
}
