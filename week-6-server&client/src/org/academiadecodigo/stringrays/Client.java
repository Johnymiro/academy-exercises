package org.academiadecodigo.stringrays;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try{
            int portNumber = 4040;


            byte[] sendBuffer = new byte[1024];
            byte[] recvBuffer = new byte[1024];
            String str = scanner.nextLine();

            sendBuffer = str.getBytes();

            /**
             * Open a UDP (datagram) socket
             */
            DatagramSocket socket = new DatagramSocket(portNumber);

            /**
             * Transform user input to bytes and send to server
             */
            //System.out.println(s.toString());
            DatagramPacket sendPacket = new DatagramPacket
                    (sendBuffer, sendBuffer.length, InetAddress.getLocalHost(), 3030 );
            socket.send(sendPacket);


            /**
             * Create and receive UDP datagram packet from the socket and put the data inside the buffer
             */
            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(receivePacket);

            /**
             *
             */

            System.out.println(new String(recvBuffer, 0, receivePacket.getLength()));


        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
