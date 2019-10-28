package org.academiadecodigo.stringrays;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class UsersData {


    private ArrayList<User> users = new ArrayList<>();


    public void addUser(User user) {
        users.add(user);
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


}
