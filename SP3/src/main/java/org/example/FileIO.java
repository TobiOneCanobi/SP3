package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO implements Fileinterface {


    @Override
    public ArrayList<String> readUserData(String filePath) {

        ArrayList<String> userData = new ArrayList<>();

        File file = new File(filePath);

        try{
        Scanner scan = new Scanner(file);
        scan.nextLine();
        while(scan.hasNextLine()){
            String s = scan.nextLine() + "\n";
            userData.add(s);
        }
        catch (Exception e){
            System.out.println("User information not found");
        }
        return userData;
    }

    @Override
    public void saveUserData(ArrayList<User> users) {

        try{

            FileWriter writer = new FileWriter("users.txt");
            writer.write("username,password" + "\n");
            for(User u : users){
                String dataToSave = u.getUsername() + "," + u.getPassword();
                writer.write(dataToSave + "\n");

            }

            writer.close();

        } catch(Exception e) {

            System.out.println("Data can't be written into file");
        }

    }

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

            System.out.println("Data not found");


        }

        return mediaData;
    }
}
