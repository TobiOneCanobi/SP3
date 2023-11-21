package org.example;
import java.util.ArrayList;
import java.util.HashMap;

public class Setup {
    FileIO io = new FileIO();

    public static HashMap<String,String> users = new HashMap<>();


    public void setup() {
        ArrayList<String> data = io.readUserData("SP3/src/main/java/org/example/User.txt");

        for (String s : data) {
            String[] row = s.split(",");
            String userName = row[0].trim();
            String passWord = row[1].trim();
            registerUser(userName, passWord);

        }
        System.out.println(users); //Tester
    }

    private void registerUser(String userName, String passWord){
        //User u = new User(userName,passWord);
        users.put(userName,passWord);
        //users.put(u.toString(),"");
        //Skal der laves user objects??
    }
}
