package org.example;

import java.util.*;

public class Setup {

    TextUI ui = new TextUI();

    private ArrayList<Movie> movies;

    public Setup() {
        this.movies = new ArrayList<>();
    }


    FileIO io = new FileIO();

    public static HashMap<String, String> users = new HashMap<>();


    public void setup() {
        ArrayList<String> data = io.readUserData("SP3/User.txt"); //

        for (String s : data) {
            String[] row = s.split(",");
            String userName = row[0].trim();
            String passWord = row[1].trim();

            registerUser(userName, passWord);

        }
        System.out.println(users); //Tester

        ArrayList<String> mediaData = io.readMediaData("100bedstefilm.txt");


        for (String s : mediaData) {

            String[] row = s.split(";");
            String title = row[0].trim();
            int release = Integer.parseInt(row[1].trim());

            ArrayList<String> genreRow = new ArrayList<>(Arrays.asList(row[2].split(",")));

            String dot = row[3].trim().replace(",", ".");

            double rating = Double.parseDouble(dot);


            registerMovie(title, release, genreRow, rating);



        }

        displayMovies();


    }

    private void registerMovie(String title, int release, ArrayList<String> genre, double rating) {

        Movie m = new Movie(title, release, genre, rating);

        movies.add(m);


    }

    private void displayMovies(){
        String s = "THE ENTIRE MOVIE COLLECTION:\n\n";

        for(Movie movies : movies){

            s = s.concat(movies.toString() + "\n");

        }

        ui.displayMessage(s);
    }

    private void displaySeries(){

    }



    private void registerUser(String userName, String passWord) {
        //User u = new User(userName,passWord);
        users.put(userName, passWord);
        //users.put(u.toString(),"");
        //Skal der laves user objects??
    }
}
