package org.academiadecodigo.stringrays;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {


        try {
            int portNumber = 3030;
            String str;

            byte[] sendBuffer = new byte[1024];
            byte[] recvBuffer = new byte[1024];


            /**
             * Open a UDP (datagram) socket
             */
            DatagramSocket socket = new DatagramSocket(portNumber);

            /**
             * Create and receive UDP datagram packet from the socket and put the data inside the buffer
             */
            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(receivePacket);

            /**
             * Transform received data from byte to String
             */
            str = new String(recvBuffer, 0, receivePacket.getLength()).toUpperCase();

            /**
             * Transformed String back to sendBuffer
             */
            sendBuffer = str.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);

            System.out.println(str);
            System.out.println(receivePacket.getAddress());

            socket.close();


        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
