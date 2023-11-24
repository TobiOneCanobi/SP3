package org.example;

import java.util.ArrayList;

public class Series extends Media {

    private String runTime;
    private String season;

    private String episode;

    public Series(String title, String runTime, ArrayList<String> genre, double rating, String season, String episode) {
        super(title, genre, rating);

        this.runTime = runTime;
        this.season = season;
        this.episode = episode;
    }

    public String getRunTime() {

        return this.runTime;
    }

    public String getSeason() {

        return this.season;
    }

    public String getEpisode() {

        return this.episode;
    }


    @Override
    public String toString() {
        return "Title: " + getTitle() + "\n" + "Runtime: " + getRunTime() + "\n" + "Genre: " + getGenre() +
                "\n" + "Rating: " + getRating() + "\n" + "Season: " + getSeason() + "\n" + "Episodes: " + getEpisode()+"\n";
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
