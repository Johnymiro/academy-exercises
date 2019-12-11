package org.academiadecodigo.stringrays;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class UsersData {


    private ArrayList<User> users = new ArrayList<>();
    private File file = new File
            ("/Users/codecadet/Desktop/academy-exercises/week8_promt-view-login-app/src/resources/data.txt");




    public UsersData(){
        fileReader();
    }


    public void addUser(User user) {
        users.add(user);
        fileWriter(user.getName(), user.getPassword());
    }


    public boolean handleLogin(String username, String password) {

        for (User user : users) {
            if (user.getName().equals(username) &&
                    hashGenerator(password).equals(user.getPassword())) {

                return true;
            }
        }

        return false;
    }


    public static String hashGenerator(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < digest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void fileWriter(String userName, String password) {


        String data = userName + "/" + password + " \n";
        String line;
        String result = "";

        BufferedWriter bWriter = null;
        BufferedReader bReader = null;

        try {
            bReader = new BufferedReader(new FileReader(file));

            while ((line = bReader.readLine()) != null) {
                result += line;
            }
            result += data;

            bWriter = new BufferedWriter(new FileWriter(file));
            bWriter.write(result);

        } catch (IOException e) {
            System.out.println("In fileWriter");
            e.printStackTrace();
        } finally {
            try {

                bWriter.close();
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void fileReader() {

        BufferedReader bReader = null;

        try {
            String line;
            String[] userData;
            bReader = new BufferedReader(new FileReader(file));

            while ((line = bReader.readLine()) != null) {
                userData = line.split("/");

                addUser(new User(userData[0], userData[1]));
            }


        } catch (IOException e) {
            System.out.println("In fileReader");
            e.printStackTrace();

        } finally {

            try {
                bReader.close();

            } catch (IOException e) {
                System.out.println("In fileReader");
                e.printStackTrace();
            }
        }
    }


}
