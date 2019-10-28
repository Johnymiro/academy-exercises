package org.academiadecodigo.stringrays;

public class Main {

    public static void main(String[] args) {


        UsersData users = new UsersData();
        users.addUser(new User("Johny", "123456"));
        users.addUser(new User("Kira", "deathnote"));


        PromptScanner prompt = new PromptScanner(users);
        prompt.start();

    }
}
