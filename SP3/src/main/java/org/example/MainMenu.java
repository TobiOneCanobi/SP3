package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    TextUI ui = new TextUI();
    //Login login = new Login();
    Scanner scan = new Scanner(System.in);


    public void welcome(){
    ui.displayMessage("Welcome " + /*user*/  "These are your options, type the number assigned to the option" +
            "\n1: Search Media.\n2: Search Genre.\n3: Check your viewed movies & series." +
            "\n4: Check your saved movie & series.\n5: Save and exit.");
        String input = scan.nextLine();
        switch(input) {
            case "1":
                searchMedia();
                break;
            case "2":
                searchGenre();
                break;
            case "3":
                checkViewedMedia();
                break;
            case "4":
                checkSavedMedia();
                break;
            case "5":
                saveAndExit();
                break;
            default:
                ui.displayMessage("error try again");
                welcome();
        }
    }

    public void searchMedia(){
        System.out.println("search media now");
    }

    public void searchGenre(){
        System.out.println("search genre now");
    }

    public void checkViewedMedia(){
        System.out.println("here is your viewed media");
    }

    public void checkSavedMedia(){
        System.out.println("here is your saved media");
    }
    public void saveAndExit(){
        System.out.println("saving and exiting");
    }

}
