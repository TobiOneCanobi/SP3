package org.example;

import java.util.*;

public class MainMenu {
    TextUI ui = new TextUI();
    Setup setup;
    Login login;
    private HashMap<String, String> users;
    Scanner scan = new Scanner(System.in);
    FileIO io = new FileIO();

    public MainMenu(Setup setup) {
        this.setup = setup;
    }

    public void setLogin(Login login) {
        this.login = login;
        this.users = login.getUsers();
    }

    public void welcome(User currentUser) {
        ui.displayMessage("Welcome " + currentUser.getUsername() + " These are your options, type the number assigned to the option" +
                "\n1: Search media.\n2: Search movie genre.\n3: Search series genre \n4: Check your viewed movies & series." +
                "\n5: Check your saved movie & series.\n6: Save and exit.");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                searchMedia(currentUser);
                break;
            case "2":
                searchMovieGenre(currentUser);
                break;
            case "3":
                searchSerieGenre(currentUser);
                break;

            case "4":
                checkViewedMedia(currentUser);
                break;
            case "5":
                checkSavedMedia(currentUser);
                break;
            case "6":
                saveAndExit(currentUser);
                break;
            default:
                ui.displayMessage("error try again");
                welcome(currentUser);
        }
    }

    public void searchMedia(User currentUser) {

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
                displayOptions(media, currentUser);
                ui.displayMessage("Do u want to watch something else, got to menu or exit? \nPlease press 'y' to " +
                        "continue, 'm' to go back to menu or press any other key to exit");
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    searchMedia(currentUser);
                    break;
                } else if (choice.equalsIgnoreCase("m")) {
                    welcome(currentUser);
                    break;
                } else
                    ui.displayMessage("Thanks for using Chill");
                saveAndExit(currentUser);
                break;
            }
        }

        if (!found) {
            ui.displayMessage("The media you searched for wasn't found. Please search again or browse movie genres.");
            searchMedia(currentUser);
        }
    }

    public void searchMovieGenre(User currentUser) {
        setup.searchMovieGenre();

    }

    public void searchSerieGenre(User currentUser) {
        setup.searchSeriesGenre();

    }

    public void checkViewedMedia(User currentUser) {
        System.out.println("here is your viewed media");

    }

    public void checkSavedMedia(User currentUser) {
        System.out.println("here is your saved media");
        currentUser.addToSavedMedia(null);
        System.out.println(currentUser.getSavedMedia());
    }

    public void saveAndExit(User currentUser) {
        System.out.println("saving and exiting");
        io.saveUserData("Textdata/User.txt", users);
        io.createUserFolder(currentUser);
        System.out.println("done");
    }

    private void displayOptions(Media media, User currentUser) {
        ui.displayMessage("Found " + media.getTitle() + "\nOptions:" +
                "\n1: Watch " + media.getTitle() + "\n2: Save " + media.getTitle()
                + "\n3: Remove from list" + "\n4: Search for another media");

        String input = scan.nextLine();
        switch (input) {
            case "1":
                ui.displayMessage(media.getTitle() + " is now playing. " + media.getTitle() + " has been added to watched media.");
                currentUser.addToWatchedMedia(media);
                break;

            case "2":
                currentUser.addToSavedMedia(media);
                ui.displayMessage(media.getTitle() + " has been added to saved media\n");
                welcome(currentUser);
                break;

            case "3":
                currentUser.removeFromSavedMedia(media);
                ui.displayMessage(media.getTitle() + " has been removed from list of saved media\n");
                break;

            case "4":
                searchMedia(currentUser);
                break;
            default:
                ui.displayMessage("Invalid option, Please try again.");
                displayOptions(media, currentUser);

        }
    }
}
