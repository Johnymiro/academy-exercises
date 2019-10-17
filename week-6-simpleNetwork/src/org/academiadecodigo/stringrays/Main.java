package org.academiadecodigo.stringrays;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {



                InetAddress ip = InetAddress.getLocalHost();

                System.out.println("Host name: " + ip.getHostName());
                System.out.println("IP address: " + ip.getHostAddress());
                System.out.println(ip.isReachable(1000));


        } catch (IOException e) {
            System.out.println("InetAdress --> " + e.getMessage());
        }
    }
}
