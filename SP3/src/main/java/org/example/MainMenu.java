package org.example;

import java.util.*;

public class MainMenu  {
    TextUI ui = new TextUI();
    Setup setup;
    Login login;
    private HashMap<String, String> users;
    Scanner scan = new Scanner(System.in);
    FileIO io = new FileIO();
public MainMenu(Setup setup){
    this.setup = setup;


}
    public void setLogin(Login login) {
        this.login = login;
        this.users = login.getUsers();
    }
    public void welcome(User currentUser){
    ui.displayMessage("Welcome " + currentUser.getUsername() +  " These are your options, type the number assigned to the option" +
            "\n1: Search Media.\n2: Search Genre.\n3: Check your viewed movies & series." +
            "\n4: Check your saved movie & series.\n5: Save and exit.");
        String input = scan.nextLine();
        switch(input) {
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
        /*
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
        */
        //setup.loadMovies();
        //setup.loadSeries();

        ArrayList<Movie> movies = setup.getMovies();
        ArrayList<Series> series = setup.getSeries();

        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.addAll(movies);
        mediaList.addAll(series);

        ui.displayMessage("Please search for a movie or series.");
        String searchForMedia = scan.nextLine().toLowerCase();

        boolean found = false;

        for (Media media : mediaList) {
            if (media.getTitle().toLowerCase().equals(searchForMedia)) {
                found = true;
                displayOptions(media,currentUser);
                break;
            }
        }

        if (!found) {
            ui.displayMessage("The media you searched for wasn't found. Please search again or browse movie genres.");
            searchMedia(currentUser);
        }

    }

    public void searchGenre(User currentUser){
        System.out.println("search genre now");
    }

    public void checkViewedMedia(User currentUser){
        System.out.println("here is your viewed media");

    }

    public void checkSavedMedia(User currentUser){
        System.out.println("here is your saved media");
        currentUser.addToSavedMedia(null);
        System.out.println(currentUser.getSavedMedia());
    }
    public void saveAndExit(User currentUser){
        System.out.println("saving and exiting");
        io.saveUserData("Textdata/User.txt",users);
        io.createUserFolder(currentUser);
        System.out.println("done");

    }

    private void displayOptions(Media media , User currentUser) {
        ui.displayMessage("Found " + media.getTitle() + "\nOptions:" +
                "\n1: Watch " + media.getTitle() + "\n2: Save " + media.getTitle()
                + "\n3: Search for another media");

        String input = scan.nextLine();
        switch (input) {
            case "1":
                ui.displayMessage(media.getTitle() + " is now playing");
                currentUser.addToWatchedMedia(media);
                break;
            case "2":
                currentUser.addToSavedMedia(media);
                ui.displayMessage(media.getTitle() + " has been added to saved media");
                break;
            case "3":
                searchMedia(currentUser);
                break;
            default:
                ui.displayMessage("Invalid option, Please try again.");
                displayOptions(media, currentUser);

        }
        //currentUser.addToWatchedMedia();
        //currentUser.addToWatchedMedia();
        //io.createUserFolder(currentUser);
        //System.out.println("done");
       //System.out.println(users);

    }

}
