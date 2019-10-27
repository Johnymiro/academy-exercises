package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerWorker extends Thread{

    private Socket clientSocket;
    private Server server;
    private String login = null;
    private OutputStream outputStream;


    public ServerWorker(Server server, Socket clientSocket){
        this.server = server;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){

        try {

            handleClientSocket();

        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    public String getLogin(){
        return login;
    }



    //This is a global method to handle clients socket/connection
    public void handleClientSocket() throws InterruptedException, IOException {

        InputStream inputStream = clientSocket.getInputStream();
        this.outputStream = clientSocket.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] tokens = line.split(" ");

            if(tokens != null && tokens.length > 0) {
                String cmd = tokens[0];

                if (cmd.equals("/quit")) {
                    outputStream.write("Bye bye\n".getBytes());
                    break;

                }else if("login".equals(cmd)){ // If user logs in, handleLogin method will handle it

                    handleLogin(outputStream, tokens);
                }

                else{
                    String msg = "unknown " + cmd + "\n";
                    outputStream.write(msg.getBytes());
                }
                // outputStream.write(("You typed: " + line + "\n").getBytes());
            }
        }

        clientSocket.close();
    }



    private  void handleLogin(OutputStream outputStream, String[] tokens) throws IOException{

        if(tokens.length == 3 ){
            String login = tokens[1];
            String password = tokens[2];

            if((login.equals("guest") && password.equals("guest")) ||
                    (login.equals("Jim") && password.equals("Jim")) ){

                String msg = "You are logged as: " + login + "\n";
                outputStream.write(msg.getBytes());

                this.login = login;
                System.out.println("User logged in: " + login + "\n");

                String onlineMsg = "online " + login + "\n";
                List<ServerWorker> clientsList = server.getClientList();
                for(ServerWorker client: clientsList){
                   client.send(onlineMsg);
                }
            }else{

                String msg = "error login\n";
                outputStream.write(msg.getBytes());
            }
        }
    }


    private void send(String onlineMessage) throws IOException{
        outputStream.write(onlineMessage.getBytes());

    }


}

