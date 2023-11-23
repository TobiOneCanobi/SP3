package org.example;

import java.util.*;

public class MainMenu  {
    TextUI ui = new TextUI();
    Setup setup = new Setup();
    //Login login;
    Scanner scan = new Scanner(System.in);
    FileIO io = new FileIO();

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

    public void searchMedia(User currentUser){
        System.out.println("search for a media now");

    }

    public void searchGenre(User currentUser){
        System.out.println("search genre now");
    }

    public void checkViewedMedia(User currentUser){
        System.out.println("here is your viewed media");

    }

    public void checkSavedMedia(User currentUser){
        System.out.println("here is your saved media");
    }
    public void saveAndExit(User currentUser){
        System.out.println("saving and exiting");
        //currentUser.addToWatchedMedia();
        //currentUser.addToWatchedMedia();
        io.createUserFolder(currentUser);
        System.out.println("done");
    }

}
