package org.example;

import java.util.ArrayList;

public interface Fileinterface {

    public ArrayList<String> readUserData(String filePath);


    public void saveUserData(ArrayList<User> users);


    public ArrayList<String> readMediaData(String filePath, int size);
}
