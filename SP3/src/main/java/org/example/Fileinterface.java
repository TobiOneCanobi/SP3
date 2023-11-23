package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface Fileinterface {

    public ArrayList<String> readUserData(String filePath);


    public void saveUserData(User currentUser);
    public void createUserFolder(User user);

    public void createTextFile(File folder, String fileName, ArrayList<Media> dataList);

    public ArrayList<String> readMediaData(String filePath);
}
