package org.example;

import java.util.*;

public class Setup {


    private ArrayList<Movie> movies = new ArrayList<>();

    private ArrayList<Series> series = new ArrayList<>();

    FileIO io = new FileIO();

    TextUI ui = new TextUI();

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


        //loadMovies();
        loadSeries();


    }


    private void registerMovie(String title, int release, ArrayList<String> genre, double rating) {

        Movie m = new Movie(title, release, genre, rating);

        movies.add(m);


    }

    private void displayMovies() {
        String m = "THE ENTIRE MOVIE COLLECTION:\n\n";

        for (Movie movies : movies) {

            m = m.concat(movies.toString() + "\n");

        }

        ui.displayMessage(m);
    }

    private void loadMovies() {

        ArrayList<String> movieData = io.readMediaData("Textdata/100bedstefilm.txt");


        for (String s : movieData) {

            String[] row = s.split(";");
            String title = row[0].trim();
            int release = Integer.parseInt(row[1].trim());

            ArrayList<String> genreRow = new ArrayList<>(Arrays.asList(row[2].split(",")));

            String commaReplacer = row[3].trim().replace(",", ".");

            double rating = Double.parseDouble(commaReplacer);

            registerMovie(title, release, genreRow, rating);


        }

        displayMovies();

    }

    private void registerSeries(String title, String runTime, ArrayList<String> genre, double rating, String season, String episode) {

        Series s = new Series(title, runTime, genre, rating, season, episode);

        series.add(s);

    }

    private void displaySeries() {

        String s = "THE ENTIRE SERIES COLLECTION:\n\n";

        for (Series series : series) {

            s = s.concat(series.toString() + "\n");

        }

        ui.displayMessage(s);

    }

    private void loadSeries() {


        ArrayList<String> seriesData = io.readMediaData("SP3/100bedsteserier.txt");

        for (String s : seriesData) {

            String[] row = s.split(";");
            String title = row[0].trim();
            String runTime = row[1].trim();
            ArrayList<String> genreRow = new ArrayList<>(Arrays.asList(row[2].split(",")));
            String commaReplacer = row[3].trim().replace(",", ".");
            double rating = Double.parseDouble(commaReplacer);


            String[] seasonAndEpisode = row[4].split(",");
            for (String sae : seasonAndEpisode) {
                String[] divider = sae.trim().split("-");
                String season = divider[0].trim();
                String episode = divider[1].trim();


                registerSeries(title, runTime, genreRow, rating, season, episode);


            }


        }

        displaySeries();


    }


    private void registerUser(String userName, String passWord) {
        //User u = new User(userName,passWord);
        users.put(userName, passWord);
        //users.put(u.toString(),"");
        //Skal der laves user objects??
    }
}
