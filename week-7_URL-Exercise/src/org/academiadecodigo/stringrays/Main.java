package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {


    public static void main(String[] args) {

        String text;
        String result = "";
        File file = new File("/Users/codecadet/Desktop/week-7_URL-Exercise/resources/file.txt");

        try {
            String urlStr =
                    "https://docs.oracle.com/en/java/javase/12/docs/api/java.desktop/javax/print/DocFlavor.URL.html";
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();

            BufferedReader bReader = new BufferedReader
                    (new InputStreamReader(urlConnection.getInputStream()));

            while ((text = bReader.readLine()) != null){

                result += text + "\n";
            }

            // Write the result string to a file

            FileWriter writer = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(writer);

            writer.write(result);

        }
        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){

            System.out.println(e.getMessage());
        }
    }
}
