package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    public void displayMessage(String msg){

        System.out.println(msg);
    }

    public String getChoice(ArrayList<String> options, String msg){
        System.out.println(msg);

        String input = getInput("");

        if(!options.contains(input)){
            System.out.println("Your input is not on the list of Movies or series");
            input = getChoice(options, msg);
        }
        return input;
    }

    public String getInput(String msg){
        this.displayMessage(msg);
        return scan.nextLine();
    }

    public void displayMenu(){ //A method that shows the menu

    }



}
