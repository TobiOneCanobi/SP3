package org.example;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainMenu {
    TextUI ui = new TextUI();
    //Login login = new Login();
    Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);
    ArrayList<String> testgenre = new ArrayList<>(); // tester

    Movie it = new Movie("it", 1999, testgenre, 9.1); // tester
    HashMap<User, ArrayList<Objects>> hashMapWatchedMedia = new HashMap<>();
    Setup setup = new Setup();

    FileIO io = new FileIO();

    public void welcome(User currentUser) {
        testgenre.add("action");
        ui.displayMessage("Welcome " + currentUser.getUsername() + " These are your options, type the number assigned to the option" +
                "\n1: Search Media.\n2: Search Genre.\n3: Check your viewed movies & series." +
                "\n4: Check your saved movie & series.\n5: Save and exit.");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                searchMedia(currentUser);
                break;
            case "2":
                searchGenre(currentUser);
                break;
            case "3":
                checkViewedMedia(currentUser);
                break;
            case "4":
                checkSavedMedia(currentUser);
                break;
            case "5":
                saveAndExit(currentUser);
                break;
            default:
                ui.displayMessage("error try again");
                welcome(currentUser);

        }
    }

    public void searchMedia(User currentUser) {

        /*
        ArrayList<String> movieData = io.readMediaData("Textdata/100bedstefilm.txt");
        ArrayList<String> seriesData = io.readMediaData("Textdata/100bedsteserier.txt");

        ArrayList<String> movieTitle = new ArrayList<>();
        ArrayList<String> seriesTitle = new ArrayList<>();

        for (String s : movieData) {
            String[] row = s.split(";");
            movieTitle.add(row[0].trim());
        }

        for (String s : seriesData) {
            String[] row = s.split(";");
            seriesTitle.add(row[0].trim());
        }

        movieTitle.addAll(seriesTitle);
        System.out.println(movieTitle);
        System.out.println("Please search for a movie or series.");
        String searchForMedia = scan.nextLine();

        if (movieTitle.contains(searchForMedia)) {
            System.out.println(searchForMedia + " is now playing." + "\n" + "Thanks for watching " + searchForMedia + ".");

        } else {
            System.out.println("Media not found. Please search again or browse movie genres.");
            searchMedia(currentUser);

        }
        */


        setup.getMovies();
        setup.getSeries();

        System.out.println(setup.getMovies());
        System.out.println("Please search for a movie or series.");
        String searchForMedia = scan.nextLine();

        if (setup.getMovies().contains(searchForMedia)) {
            System.out.println(searchForMedia + " now playing." + "\n" + "Thanks for watching " + searchForMedia + ".");
        } else {
            System.out.println("The media you searched for wasn't found. Please search again or browse movie genres.");
            searchMedia(currentUser);

        }

    }

    public void searchGenre(User currentUser) {
        System.out.println("search genre now");
        //setup.getMovies(); tester

    }

    public void checkViewedMedia(User currentUser) {
        System.out.println("here is your viewed media");
        currentUser.addToWatchedMedia(it);
        System.out.println(currentUser.getWatchedMedia());
    }

    public void checkSavedMedia(User currentUser) {
        System.out.println("here is your saved media");
    }

    public void saveAndExit(User currentUser) {
        System.out.println("saving and exiting");
    }

}
