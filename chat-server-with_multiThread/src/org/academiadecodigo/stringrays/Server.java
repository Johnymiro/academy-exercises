package org.academiadecodigo.stringrays;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{

    private int serverPort;
    private ArrayList<ServerWorker> clientList = new ArrayList<>();

    public Server(int serverPort){
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);

            while(true){

                System.out.println("Waiting to accept client connection");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                ServerWorker worker = new ServerWorker(this, clientSocket);
                clientList.add(worker);
                worker.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void removeWorker(ServerWorker serverWorker) {
        clientList.remove(serverWorker);
    }

    public List<ServerWorker> getClientList(){
        return clientList;
    }
}
