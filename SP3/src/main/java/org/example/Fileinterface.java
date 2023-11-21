package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public interface Fileinterface {

    public ArrayList<String> readUserData(String filePath);


    public void saveUserData(User currentUser);


    public ArrayList<String> readMediaData(String filePath);
}
