package org.example;

import java.util.*;

public class User {
    private String username;
    private String password;

    private ArrayList<Media>watchedMedia;
    private ArrayList<Objects>savedMedia;


    public User(String username,String password) {
        this.username = username;
        this.password = password;
        this.watchedMedia = new ArrayList<>();
        this.savedMedia = new ArrayList<>();

    }

    public void addToWatchedMedia(Media media){
        watchedMedia.add(media);
    }
    public void addToSavedMedia(Objects media) {
        savedMedia.add(media);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Media> getWatchedMedia() {
        return watchedMedia;
    }

    public ArrayList<Objects> getSavedMedia() {
        return savedMedia;
    }
}
