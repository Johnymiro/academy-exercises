package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerWorker extends Thread{

    private Socket clientSocket;
    private Server server;
    private String login = null;
    private OutputStream outputStream;

    String greetingMsg = "\n-Welcome to chat room!\n-Login cmd: /login -<name>\n" +
                         "-Text all user cmd: /all message\n" +
                         "-Whisper cmd: /whisper -<user[3-12 chars]> message\n" +
                         "-Quit cmd: /quit or /logoff\n" +
                         "-and enjoy the chat :D\n\n";


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

        outputStream.write(greetingMsg.getBytes());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] tokens = line.split(" ");

            if(tokens != null && tokens.length > 0) {
                String cmd = tokens[0];

                if (cmd.equals("/quit") || cmd.equals("/logoff")) {
                    outputStream.write("Bye bye\n".getBytes());

                    handleLogOff();
                    break;

                }else if("/login".equals(cmd)){ // If user logs in,

                    handleLogin(outputStream, tokens);
                }else if("/whisper".equals(cmd)){
                    handleWhisper(tokens);
                }else if("/all".equals(cmd)){
                    handleMessageToAll(tokens);
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

    private void handleMessageToAll(String[] tokens) throws IOException {
       List<ServerWorker> workerList = server.getClientList();
       String text = "";

        for (int i = 0; i < (tokens.length - 1); i++) {
            text += tokens[i+1] + " ";
        }
        String msgToSend = "[" + login + "] " + text + "\n";

        for (ServerWorker worker : workerList) {
            if(!login.equals(worker.getLogin())) {
                worker.send(msgToSend);
            }
        }
    }


    // format: "/whisper"  "-user" text...
    private void handleWhisper(String[] tokens) throws IOException {
        String sendTo = tokens[1].substring(1);

        List<ServerWorker> workerList = server.getClientList();
        for (ServerWorker worker : workerList) {
            if (sendTo.equals(worker.getLogin())){
                String text = "";
                for (int i = 0; i < (tokens.length - 2); i++) {
                    text += tokens[i+2] + " ";
                }

                String message = "{whisper}[" + login + "]: " + text + "\n";
                worker.send(message);
            }
        }
    }


    private void handleLogOff() throws IOException {
        server.removeWorker(this);

        List<ServerWorker> clientsList = server.getClientList();
        String offlineMessage = "offline: " + login + "\n";

        for(ServerWorker client: clientsList){
            if(client.getLogin() != null && !login.equals(client.getLogin())) {
                client.send(offlineMessage);
            }
        }
        clientSocket.close();
    }


    private  void handleLogin(OutputStream outputStream, String[] tokens) throws IOException{

        if(tokens.length == 2){
            String login = tokens[1];

            System.out.println("Trying to login as: " + login);
            if(login != null) {

                String msg = "You are logged as: " + login + "\n";
                outputStream.write(msg.getBytes());

                this.login = login;
                System.out.println("User logged in: " + login + "\n");

                String onlineMsg = "now online: " + login + "\n";
                List<ServerWorker> clientsList = server.getClientList();


                //send current user all other online logins
                for(ServerWorker client: clientsList){

                    if(client.getLogin() != null && !login.equals(client.getLogin())) {
                        String msg2 = "now online: " + client.getLogin() + "\n";
                        send(msg2);
                    }
                }

                //send other users current user's status
                for(ServerWorker client: clientsList){
                    if(!login.equals(client.getLogin())) {
                        client.send(onlineMsg);
                    }
                }
            }

            else{
                String msg = "error login\n";
                outputStream.write(msg.getBytes());
            }
        }
    }


    private void send(String onlineMessage) throws IOException{
        if(login != null) {
            outputStream.write(onlineMessage.getBytes());
        }
    }


}

