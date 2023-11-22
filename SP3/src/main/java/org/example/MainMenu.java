package org.example;

import java.util.*;

public class MainMenu  {
    TextUI ui = new TextUI();
    //Login login = new Login();
    Scanner scan = new Scanner(System.in);
    ArrayList<String> testgenre = new ArrayList<>(); // tester

    Movie it = new Movie("it",1999,testgenre,9.1); // tester
    HashMap<User, ArrayList<Objects>> hashMapWatchedMedia = new HashMap<>();
    Setup setup = new Setup();

    public void welcome(User currentUser){
        testgenre.add("action");
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

    public void searchMedia(User currentUser){
        System.out.println("search media now");

    }

    public void searchGenre(User currentUser){
        System.out.println("search genre now");
        //setup.getMovies(); tester

    }

    public void checkViewedMedia(User currentUser){
        System.out.println("here is your viewed media");
        currentUser.addToWatchedMedia(it);
        System.out.println(currentUser.getWatchedMedia());
    }

    public void checkSavedMedia(User currentUser){
        System.out.println("here is your saved media");
    }
    public void saveAndExit(User currentUser){
        System.out.println("saving and exiting");
    }

}
