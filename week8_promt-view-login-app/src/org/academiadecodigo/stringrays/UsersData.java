package org.academiadecodigo.stringrays;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UsersData {


    private ArrayList<User> users = new ArrayList<>();

    public UsersData(User user) {

        users.add(user);
    }

    public UsersData() {
    }


    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean handleLogin(String username, String password){

        for (User user : users) {
            if (user.getName().equals(username) &&
                 passwordHash(password).equals(user.getPassword())){
                return true;
            }
        }

        return false;
    }



    public static byte[] passwordHash(String password){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();

            return digest;

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }


}
