package org.example;

import java.io.File;
import java.util.ArrayList;

public class FileIO implements Fileinterface {


    @Override
    public ArrayList<String> readUserData(String filePath) {

        ArrayList<String> userData = new ArrayList<>();

        File file = new File(filePath);


        return null;
    }

    @Override
    public void saveUserData(ArrayList<User> users) {

    }

    @Override
    public ArrayList<String> readMediaData(String filePath, int size) {
        return null;
    }
}
