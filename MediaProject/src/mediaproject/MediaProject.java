/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mediaproject;

import java.io.*;
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

        String[] menu = new String[8];
        menu[0] = "Please make a selection:";
        menu[1] = "1 - Add Song";
        menu[2] = "2 - Add a movie";
        menu[3] = "3 - Display All Media On Screen";
        menu[4] = "4 - Display Music, option to export to txt file";
        menu[5] = "5 - Display Movies, option to export to txt file";
        menu[6] = "6 - import list previously created list";
        menu[7] = "7 - Quit";

        ArrayList<Media> allMedia = new ArrayList<Media>();
        String yesOrNo = "n";
        int menuChoice = promptForMenuSelection(input, menu);
       // int movieSize = 0;
       // int musicSize = 0;
        boolean shouldExit = false;
        while (shouldExit == false)
        {
            switch (menuChoice)
            {
                case 1:
                    addMusic(input, allMedia, TITLE_PROMPT, ARTIST_PROMPT);
                  //  musicSize++;
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 2:
                    addMovie(input, allMedia, TITLE_PROMPT, GENERE_PROMPT);
                   // movieSize++;
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 3:
                    printMedia(allMedia);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 4:
                    int musicSize = countMusic(allMedia);
                    String[] sortedMusic = new String[musicSize];
                    sortedMusic = createMusicArray(allMedia, musicSize);
                    Arrays.sort(sortedMusic);
                    printStringArray(sortedMusic);
                    yesOrNo = promptForString(input, "Type yes to export list to txt file");
                    yesOrNo = yesOrNo.toUpperCase();
                    if (yesOrNo.equals("YES"))
                    {
                        exportStringArray(sortedMusic, input);
                    }
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 5:
                      int movieSize = countMovie(allMedia);
                    String[] sortedMovie = new String[movieSize];
                    sortedMovie = createMovieArray(allMedia, movieSize);
                    Arrays.sort(sortedMovie);
                    printStringArray(sortedMovie);
                    yesOrNo = promptForString(input, "Type yes to export list to txt file");
                    yesOrNo = yesOrNo.toUpperCase();
                    if (yesOrNo.equals("YES"))
                    {
                        exportStringArray(sortedMovie, input);
                    }
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 6:
                    System.out.println("This function is designed to import lists created from this program");
                    importList(input, allMedia);
                    menuChoice = promptForMenuSelection(input, menu);
                    break;
                case 7:
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
/**
 * imports previously created lists
 * @param input scanner for inputing file name
 * @param media array list
 */
    public static void importList(Scanner input, ArrayList<Media> media)
    {
        String fileName = promptForString(input, "Please enter file name");
        File inputFileName = new File(fileName);
        try
        {
            Scanner inputFile = new Scanner(inputFileName);
            while (inputFile.hasNext())
            {
                String tag1 = inputFile.next();
                String artistOrGenere = removeLeadingSpaces(inputFile.nextLine());
                String tag2 = inputFile.next();
                String title = removeLeadingSpaces(inputFile.nextLine());
                if (tag1.contains("Artist"))
                {
                    media.add(new Music(title, artistOrGenere));
                          //  media.add(new Music(title, artist));

                } else if (tag1.contains("genere"))
                {
                    media.add(new Movie(title, artistOrGenere));
                         //   media.add(new Movie(title, genere));

                } else
                {
                    System.out.println("Can only import from txt files formatted from this program");
                }

            }
            inputFile.close();
        } catch (FileNotFoundException ex)
        {
            System.out.printf("File %s not found.\n", fileName);
        }
    }

    /**
     * export string to txt file in java folder
     *
     * @param stringArray sorted array
     * @param input scanner used to name file
     */
    public static void exportStringArray(String[] stringArray, Scanner input)
    {
        String fileName = promptForString(input, "Please enter file name");
        fileName = fileName + ".txt";
        try
        {
            PrintWriter outputFile = new PrintWriter(fileName);
            for (int i = 0; i < stringArray.length; i++)
            {
                outputFile.println(stringArray[i]);
            }
            outputFile.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("File could not be created");
        }
    }

    /**
     * print all of the strings in the array
     *
     * @param stringArray
     */
    public static void printStringArray(String[] stringArray)
    {
        for (int i = 0; i < stringArray.length; i++) // (String a : stringArray)
        {
            System.out.println(stringArray[i]);
        }
    }

    /**
     * creates string array from instances of movies
     *
     * @param media array list to create string array from
     * @param movieSize size of array we are creating
     * @return returned string array
     */
    public static String[] createMovieArray(ArrayList<Media> media, int movieSize)
    {
        String[] sortedMovie = new String[movieSize];
        int movieCount = 0;
        for (int i = 0; i < media.size(); i++)
        {

            if (media.get(i) instanceof Movie)
            {
                sortedMovie[movieCount] = media.get(i).toString();
                movieCount++;
            }
        }
        return sortedMovie;
    }

    /**
     * creates string array from music
     *
     * @param media array list
     * @param musicSize size of array we are making
     * @return string array
     */
    public static String[] createMusicArray(ArrayList<Media> media, int musicSize)
    {
        String[] sortedMusic = new String[musicSize];
        int musicCount = 0;
        for (int i = 0; i < media.size(); i++)
        {
            if (media.get(i) instanceof Music)
            {
                sortedMusic[musicCount] = media.get(i).toString();
                musicCount++;
            }
        }
        return sortedMusic;
    }
/**
     * @param media media list
     * @return count for each instance of movie
     */
   
    public static int countMovie(ArrayList<Media> media)
    {
        int count = 0;
        for (int i = 0; i < media.size(); i++)
        {
            if (media.get(i) instanceof Movie)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * @param media media list
     * @return count for each instance of music
     */
    public static int countMusic(ArrayList<Media> media)
    {
        int count = 0;
        for (int i = 0; i < media.size(); i++)
        {
            if (media.get(i) instanceof Music)
            {
                System.out.println(media.get(i));
                count++;
            }
        }
        System.out.println();
        return count;
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
     * removes blank spaces from strings
     *
     * @param string
     * @return string without empty space infront of it
     */
    public static String removeLeadingSpaces(String string)
    {
        while (string.length() > 0 && string.charAt(0) == ' ')
        {
            string = string.substring(1);

        }
        return string;
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
