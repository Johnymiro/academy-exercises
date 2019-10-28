package org.academiadecodigo.stringrays;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class PromptScanner {

    private UsersData usersData;
    private Prompt prompt = new Prompt(System.in, System.out);

    public PromptScanner(UsersData usersData){

        this.usersData = usersData;
    }


    public void go(){

        if(menuLauncher() == 1){
            handleRegister();
        }
        loginHandler();
    }



    private void handleRegister(){

        System.out.println("\n   *** Register ***\n");

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("New username: ");

        PasswordInputScanner question2 = new PasswordInputScanner();
        question2.setMessage("New password: ");


        String userName = prompt.getUserInput(question1);
        String password = prompt.getUserInput(question2);

        usersData.addUser(new User(userName, password));

        System.out.println("Register Successful\n");

    }



    private void loginHandler(){

        System.out.println("Please enter your user information\n");

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



    private int menuLauncher(){

        String[] options = {"Register", "Sign in"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Welcome wonderful person, choose an option");
        int answerIndex = prompt.getUserInput(scanner);

        return answerIndex;
    }
}
