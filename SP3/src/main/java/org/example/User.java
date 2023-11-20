package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private ArrayList<Objects>watchedMedia;
    private ArrayList<Objects>savedMedia;


    public User(String username,String password) {
        this.username = username;
        this.password = password;
        this.watchedMedia = new ArrayList<>();
        this.savedMedia = new ArrayList<>();

    }

    public void addToWatchedMedia(Objects a){
        watchedMedia.add(a);
    }
    public void addToSavedMedia(Objects a){
        savedMedia.add(a);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Objects> getWatchedMedia() {
        return watchedMedia;
    }

    public ArrayList<Objects> getSavedMedia() {
        return savedMedia;
    }
}
