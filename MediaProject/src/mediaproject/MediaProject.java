/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediaproject;
import java.util.*;

/**
 *
 * @author travi
 */
public class MediaProject
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        final String TITLE_PROMPT = "Please enter a title: ";
        final String ARTIST_PROMPT = "Please enter an artist: ";
        final String GENERE_PROMPT = "Please enter movie's genere: ";
        Scanner input = new Scanner(System.in);
        String[] menu = new String[7];
        menu[0] = "Please make a selection:";
        menu[1] = "1 - Add Song";
        menu[2] = "2 - Add a movie";
        menu[3] = "3 - Display All Media On Screen";
        menu[4] = "4 - Display Music";
        menu[5] = "5 - Display Movies";
        menu[6] = "6 - Quit";

        ArrayList<Media> allMedia = new ArrayList<Media>();

        int menuChoice = promptForMenuSelection(input, menu);
        boolean shouldExit = false;
        while (shouldExit == false)
        {
            switch (menuChoice)
            {
                case 1:
                    addMusic(input, allMedia, TITLE_PROMPT, ARTIST_PROMPT);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 2:
                    addMovie(input, allMedia, TITLE_PROMPT, GENERE_PROMPT);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 3:
                    printMedia(allMedia);
                    //System.out.println(allMedia);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 4:
                     printMusic(allMedia);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 5:
                    printMovies(allMedia);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 6:
                    shouldExit = true;
                    System.out.println(
                            "Thanks for checking it out,\nplease send feedback to:\ntravisditmanson@gmail.com");
                    break;
                default:
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
            }
        }

    }

     public static void printMovies(ArrayList<Media> media)
    {
        for (int i = 0; i < media.size(); i++)
        {
            if (media.get(i) instanceof Movie)
            {
                System.out.println(media.get(i));
            }
        }
        System.out.println();
    }
    
   /**
    * prints only the music
    * @param media 
    */
    public static void printMusic(ArrayList<Media> media)
    {
        for (int i = 0; i < media.size(); i++)
        {
            if (media.get(i) instanceof Music)
            {
                System.out.println(media.get(i));
            }
        }
        System.out.println();
    }

    /**
     * prints all media to screen
     *
     * @param media
     */
    public static void printMedia(ArrayList<Media> media)
    {
        for (int i = 0; i < media.size(); i++)
        {
            System.out.println(media.get(i));
        }
        System.out.println();
    }

    /**
     * adds movie to array list
     *
     * @param input scanner object
     * @param media polymorphic array
     * @param titlePrompt string constant
     * @param generePrompt string constant
     */
    public static void addMovie(Scanner input, ArrayList<Media> media, String titlePrompt, String generePrompt)
    {
        String title = promptForString(input, titlePrompt);
        String genere = promptForString(input, generePrompt);
        media.add(new Movie(title, genere));
    }

    /**
     * adds music to array list
     *
     * @param input scanner object
     * @param media polymorphic array
     * @param titlePrompt string constant
     * @param artistPrompt string constant
     */
    public static void addMusic(Scanner input, ArrayList<Media> media, String titlePrompt, String artistPrompt)
    {
        String title = promptForString(input, titlePrompt);
        String artist = promptForString(input, artistPrompt);
        media.add(new Music(title, artist));
    }

    /**
     * displays array, returns an int if one is entered, an error if one is not
     *
     * @param input scanner object
     * @param menu array of strings to display
     * @return int representing menu selection
     */
    public static int promptForMenuSelection(Scanner input, String[] menu)
    {
        for (String s : menu)
        {
            System.out.println(s);
        }
        int integer = 0;
        try
        {
            integer = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e)
        {
            System.out.println("Oops, looks like you didn't enter a number");
        }
        if (integer < 1 || integer > menu.length - 1)
        {
            System.out.println("Please try a valid number");
        }
        return integer;
    }

    /**
     * prompts for string
     *
     * @param input scanner object
     * @param prompt welcome prompt
     * @return string from user input
     */
    public static String promptForString(Scanner input, String prompt)
    {
        System.out.println(prompt);
        String userInput = "";
        userInput = input.nextLine();
        return userInput;
    }
}

    

