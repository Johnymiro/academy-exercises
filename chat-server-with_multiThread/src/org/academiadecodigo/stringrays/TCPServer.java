package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) {
        int port= 11001;
        Server server = new Server(port);
        server.start();


    }
}
