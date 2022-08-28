/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediaproject;

/**
 *
 * @author travi
 */
public class Music extends Media
{

    protected String artist;

    public Music(String title, String artist)
    {
        super(title);
        this.artist = artist;
        //setTitle(title);
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String newTitle)
    {
        artist = newTitle;
    }

    @Override
    public String toString()
    {
        // System.out.printf("Title: %s \t Artist: %s\n",title,artist);
       // return "Title:  " + title + "\nArtist: " + artist;
        return "Artist:  " + artist + "\nTitle: " + title;

    }
}
