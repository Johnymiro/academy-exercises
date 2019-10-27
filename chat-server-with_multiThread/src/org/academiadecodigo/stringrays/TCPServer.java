package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) {

        int port= 11001;
        int port2= 12001;

        Server server = new Server(port);
        Server server1 = new Server(port2);

        server.start();
        server1.start();


    }
}
