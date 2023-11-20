package org.example;

import java.awt.*;

import java.util.HashMap;
import java.util.Scanner;

public class Login {
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();
    private Scanner scan = new Scanner(System.in);

    HashMap <String,String> users = new HashMap<>();

    //MainMenu menu = new MainMenu();


    public void tester(){
        users.put("Peter","123");
        users.put("Janas","Janas");
        System.out.println(users);
    }
    public void loginOrCreate(){
        tester();
        ui.displayMessage("Welcome to the streaming website Chill,\ntype login or register to continue");
        String response = scan.nextLine();

        if (response.equalsIgnoreCase("Login")){
            ui.displayMessage("type Username and then Password to continue");
            login();
        }
        else if (response.equalsIgnoreCase("register")){
            ui.displayMessage("Create a Username and then Password to continue");
            register();
        }
        else {
            ui.displayMessage("invalid input");
            loginOrCreate();
        }
    }

    public void login(){
        String userName = scan.next();
        String passWord = scan.next();

        // tror den checker alles value men skal kun check den value der hÃ¸rer til key
        if(users.containsKey(userName)&& users.containsValue(passWord)){
            ui.displayMessage("logging you in");
            //menu.welcome(); start funkion i menu skal blive kaldt her
        } else if (userName.equalsIgnoreCase("Q")||passWord.equalsIgnoreCase("Q")) {
            loginOrCreate();

        } else {
            ui.displayMessage("Username or Password is wrong try again");
            login();
        }
    }
    public void register() {
        String userName = scan.next();
        String passWord = scan.next();
        //String input = scan.nextLine();
        if (users.containsKey(userName)) {
            ui.displayMessage("username already taken try again");
            register();
        } else if (userName.equalsIgnoreCase("Q")||passWord.equalsIgnoreCase("Q")) {
            loginOrCreate();
        }
        else {
            users.put(userName,passWord);
            ui.displayMessage("registration successful, logging you in");
            //menu.welcome(); start funkion i menu skal blive kaldt her
            System.out.println(users); //Tester
        }
    }
}

