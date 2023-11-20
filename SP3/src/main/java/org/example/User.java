package org.example;

import java.util.ArrayList;

public class User {

    String username;

    String password;
    ArrayList<String> watchedMedia;
    ArrayList<String> savedMedia;

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public ArrayList<String> getWatchedMedia(){

        return this.watchedMedia;
    }

    public ArrayList<String> getSavedMedia(){
        return this.savedMedia;
    }
}
