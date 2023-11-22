package org.example;

import java.util.ArrayList;

public class Movie extends Media {

    private int release;



    public Movie(String title, int release, ArrayList<String> genre, double rating) {

        super(title, genre, rating);
        this.release = release;


    }


    public int getRelease() {

        return this.release;
    }
@Override
    public String toString() {
        return "Title: " + getTitle() + "\n" +" Genre: " + getGenre() + "\n" +" Release year: " + getRelease() + "\n" + " Rating: " + getRating() +"\n";
    }






}
