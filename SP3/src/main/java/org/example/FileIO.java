package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileIO implements Fileinterface {
User user;

    @Override
    public ArrayList<String> readUserData(String filePath) {
        ArrayList<String> userData = new ArrayList<>();
        File file = new File(filePath);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //skip header
            while (scan.hasNextLine()) {
                String s = scan.nextLine() + "\n";
                userData.add(s);
            }
        }
        catch (Exception e){
            System.out.println("User information not found");
        }
        return userData;
    }

    @Override
    public void saveUserData(User currentUser) {
        Scanner scan = new Scanner("Textdata/User.txt");
        try{
            FileWriter writer = new FileWriter("Textdata/User.txt",true);
            //writer.write("username,password" + "\n");
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.isBlank()) {
                    writer.write(currentUser.getUsername() +", "+ currentUser.getPassword());
                    writer.flush();
                } else {
                    writer.write(line);
                    writer.flush();
                }
            }
            //writer.write(currentUser.getUsername() +", "+ currentUser.getPassword() +"\n");
            scan.close();
            writer.close();

        } catch(Exception e) {
            System.out.println("Data can't be written into file");
        }
    }
    public void createUserFolder(User user) {
        // Create a folder with the username
        String userDataPath = "SP3/Userdata";
        File userFolder = new File(userDataPath,user.getUsername());
        if (!userFolder.exists()) {
            userFolder.mkdir();
        }

        // Create watchedmedialist text file
        createTextFile(userFolder, "watchedmedialist.txt", user.getWatchedMedia());

        // Create savedmedialist text file
        createTextFile(userFolder, "savedmedialist.txt", user.getSavedMedia());
    }

    public void createTextFile(File folder, String fileName, ArrayList<Media> dataList) {
        File file = new File(folder, fileName);
        try (FileWriter writer = new FileWriter(file)) {
            for (Media data : dataList) {
                // Write data to the file
                writer.write(data.toString());
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods and getters/setters...




    @Override
    public ArrayList<String> readMediaData(String filePath) {



        ArrayList<String> mediaData = new ArrayList<>();
        File file = new File(filePath);

        try{
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while(scan.hasNextLine()){
                String s = scan.nextLine() +"\n";

                mediaData.add(s);


            }
        }catch(Exception e){

            System.out.println("Media data not found");


        }

        return mediaData;
    }
}
