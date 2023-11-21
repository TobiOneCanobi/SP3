package org.example;

import java.util.ArrayList;

public class Series extends Media {

    private int runTime;
    private int season;

    private int episode;

    public Series(String title, int runTime, ArrayList<String> genre, double rating, int season, int episode) {
        super(title, genre, rating);

        this.runTime = runTime;
        this.season = season;
        this.episode = episode;
    }

    public int getRunTime() {


        return this.runTime;
    }

    public int getSeason() {

        return this.season;
    }

    public int getEpisode() {

        return this.episode;
    }


    @Override
    public String toString() {
        return null;
    }
}
