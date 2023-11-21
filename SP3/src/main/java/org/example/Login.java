package org.example;
import java.awt.*;

import java.util.HashMap;
import java.util.Scanner;

public class Login {
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private Scanner scan = new Scanner(System.in);
    HashMap<String, String> users = Setup.users;
    ;
    //MainMenu menu = new MainMenu();


    public void tester() {
        //System.out.println("done");
    }

    public void loginOrCreate() {
        ui.displayMessage("Welcome to the streaming website Chill," +
                "\ntype login or register to continue, press q to return");
        String response = scan.nextLine();

        if (response.equalsIgnoreCase("Login")) {
            ui.displayMessage("type Username");
            login();
        } else if (response.equalsIgnoreCase("register")) {
            ui.displayMessage("Create a Username");
            register();
        } else {
            ui.displayMessage("invalid input");
            loginOrCreate();
        }
    }

    public void login() {
        String userName = scan.nextLine();

        if (users.containsKey(userName)) {
            ui.displayMessage("type in your password");
            String passWord = scan.nextLine();


            if (passWord.equals(users.get(userName))) {
                ui.displayMessage("logging you in");
                tester();
                //menu.welcome(); start funkion i menu skal blive kaldt her
            } else if (passWord.equalsIgnoreCase("Q")) {
                loginOrCreate();
            } else {
                System.out.println("Error try again or q to go back");
                login();
            }
        } else if (userName.equalsIgnoreCase("Q")) {
            loginOrCreate();
        } else {
            ui.displayMessage("Username or Password is wrong try again");
            login();
        }
    }

    public void register() {
        String userName = scan.nextLine();
        if (users.containsKey(userName)) {
            ui.displayMessage("username already taken try again");
            register();
        } else if (userName.equalsIgnoreCase("Q")) {
            loginOrCreate();
        } else {
            ui.displayMessage("Choose a Password");
            if (userName.equalsIgnoreCase("Q")) {
                loginOrCreate();
            }
            String passWord = scan.next();
            users.put(userName, passWord);
            ui.displayMessage("registration successful, logging you in");
            System.out.println(users); //Tester
            //noget med filewriter for at skrive det nye login i database
            //menu.welcome(); start funkion i menu skal blive kaldt her
        }
    }
}














