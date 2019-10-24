package org.academiadecodigo.stringrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Response {

    private Response() {
        return;
    }

    public static String headerReader(Socket clientRequest) throws IOException {

        BufferedReader bReader = new BufferedReader(new InputStreamReader(clientRequest.getInputStream()));

        String firstLine = bReader.readLine();
        String[] line = firstLine.split(" ");

        if(firstLine == null){
            return null;
        }




        return null;
    }



}
