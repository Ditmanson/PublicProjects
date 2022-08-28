
/**
 * @author Travis Ditmanson
 * @email travisditmanson@gmail.com
 */
//package mediaproject;
/**
 *
 * @author travis
 * media only has title and title getter
 */
public class Media
{

    protected String title;

    public Media(String title)
    {
        this.title = title;
    }

    /**
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * adjust title
     *
     * @param newTitle
     */
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

}
