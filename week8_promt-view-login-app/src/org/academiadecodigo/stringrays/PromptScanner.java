package org.academiadecodigo.stringrays;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.List;

public class PromptScanner {

    private UsersData usersData;

    public PromptScanner(UsersData usersData){

        this.usersData = usersData;
    }

    public void start(){


        Prompt prompt = new Prompt(System.in, System.out);

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("Username: ");

        PasswordInputScanner question2 = new PasswordInputScanner();
        question2.setMessage("Password: ");


        String userName = prompt.getUserInput(question1);
        String password = prompt.getUserInput(question2);


        boolean isUser = usersData.handleLogin(userName, password);

        if(isUser){
            System.out.println
                    ("Login succesful. \nWelcome " + userName + "\n");
        }
        else{
            System.out.println("Incorrect credentials.");
        }
    }
}
