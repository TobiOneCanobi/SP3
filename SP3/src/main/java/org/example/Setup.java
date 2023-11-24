package org.example;

import java.util.*;

public class Setup {

    private ArrayList<Series> series = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    FileIO io = new FileIO();
    TextUI ui = new TextUI();
    Login login;
    MainMenu menu;

    private HashMap<String, String> users = new HashMap<>();

    public Setup(){
       this.login = new Login(this);
       this.menu = new MainMenu(this);
       this.login.setMenu(menu);
       this.menu.setLogin(login);
    }
    public void setup() {

        loadUser();
        loadMovies();
        //System.out.println(movies);
        loadSeries();
        //displayMovies();
        //displaySeries();
        //getMovies();
        login.loginOrCreate();
    }

    public HashMap<String, String> getUsers() {
        return users;
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

    }



    public void registerMovie(String title, int release, ArrayList<String> genre, double rating) {

        Movie m = new Movie(title, release, genre, rating);

        movies.add(m);
    }

    private void displayMovies() {
        String m = "THE ENTIRE MOVIE COLLECTION:\n\n";
        //System.out.println(movies);
        for (Movie movies : movies) {

            m = m.concat(movies.toString() + "\n");

        }

        ui.displayMessage(m);

    }

    public void loadSeries() {

        ArrayList<String> seriesData = io.readMediaData("Textdata/100bedsteserier.txt");

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
    public void loadUser(){
        ArrayList<String> data = io.readUserData("Textdata/User.txt"); //

        for (String s : data) {
            String[] row = s.split(",");
            String userName = row[0].trim();
            String passWord = row[1].trim();

            registerUser(userName, passWord);

        }
      //  System.out.println("tester i loadUser"+users); //Tester
    }
    private void registerUser(String userName, String passWord) {
        //User u = new User(userName,passWord);
        users.put(userName, passWord);
        //users.put(u.toString(),"");
        //Skal der laves user objects??
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Series> getSeries() {
        return series;
    }
}
