package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) {

        try {

            int port = 11001;
            ServerSocket server = new ServerSocket(port);

            while(true) {

                Socket client = server.accept();

                Thread t = new Thread(){

                    @Override
                    public void run(){
                        try {
                            clientOutput(client);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                };

                t.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }



    }



    public static void clientOutput(Socket client) throws InterruptedException, IOException{

        OutputStream outputStream = client.getOutputStream();

        for (int i = 0; i < 10; i++) {

            outputStream.write("Hello world\n".getBytes());
            Thread.sleep(1000);
        }
        client.close();
    }

}
