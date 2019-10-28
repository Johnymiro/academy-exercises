package org.academiadecodigo.stringrays;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class User {

    private final String name;
    private final byte[] password;


    public User(String name, String password){
        this.name = name;
        this.password = UsersData.passwordHash(password);
    }



    public String getName(){
        return name;
    }
    public byte[] getPassword(){return password;}








}
