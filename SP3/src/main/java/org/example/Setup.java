package org.example;

import java.util.*;

public class Setup {
    FileIO io = new FileIO();

    public static HashMap<String, String> users = new HashMap<>();


    public void setup() {
        ArrayList<String> data = io.readUserData("src/User.txt");

        for (String s : data) {
            String[] row = s.split(",");
            String userName = row[0].trim();
            String passWord = row[1].trim();
            registerUser(userName, passWord);

        }
        System.out.println(users); //Tester

        ArrayList<String> mediaData = io.readMediaData("100bedstefilm.txt");

        ArrayList<String> genreList = new ArrayList<>();

        for (String s : mediaData) {

            String[] row = s.split(";");
            String title = row[0].trim();
            int release = Integer.parseInt(row[1].trim());

            //String genre = Arrays.toString(row[2].trim().split(","));

            ArrayList<String> genreRow = new ArrayList<>(Arrays.asList(row[2].split(",")));

            String dot = row[3].trim().replace(",", ".");

            double rating = Double.parseDouble(dot);

            Movie m = new Movie(title, release, genreRow, rating);

            System.out.println(m);








        }


    }

    private void registerUser(String userName, String passWord) {
        //User u = new User(userName,passWord);
        users.put(userName, passWord);
        //users.put(u.toString(),"");
        //Skal der laves user objects??
    }
}
