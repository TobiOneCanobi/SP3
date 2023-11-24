package org.example;

public class Main {
    public static void main(String[] args) {
        Setup setup = new Setup();
        Login login = new Login();
        MainMenu menu = new MainMenu();

        setup.setup();
        login.loginOrCreate();

       FileIO io = new FileIO();
       // System.out.println(io.readUserData("users.txt"));
        //System.out.println(io.readMediaData("100bedstefilm.txt"));



    }
}