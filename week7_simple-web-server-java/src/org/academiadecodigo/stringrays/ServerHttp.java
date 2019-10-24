package org.academiadecodigo.stringrays;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHttp implements Runnable{


    private String response200Html = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n";
    private String response200CSS = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/css; charset=UTF-8\r\n";

    private String response200Image = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: image/jpg \r\n";
    private String response404 = "HTTP/1.0 404 Not Found\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: 0 \r\n" +
            "\r\n";

    private File image = new File
            ("");
    private File htmlDir = new File
            ("/Users/codecadet/Desktop/academy-exercises/week7_simple-web-server-java/src/org/academiadecodigo/stringrays/websiteData/index.html");

    private  File webSiteImage = new File("/Users/codecadet/Desktop/academy-exercises/week7_simple-web-server-java/src/org/academiadecodigo/stringrays/websiteData/resource/sasuke.jpg");
    private  File websiteCSS = new File("/Users/codecadet/Desktop/academy-exercises/week7_simple-web-server-java/src/org/academiadecodigo/stringrays/websiteData/style.css");
    private File formHtml = new File("/Users/codecadet/Desktop/academy-exercises/week7_simple-web-server-java/src/org/academiadecodigo/stringrays/websiteData/form.html");
    private ServerSocket server;

    private Socket client = null;

    public ServerHttp(ServerSocket server){
        this.server = server;
    }




    public static void main(String[] args) throws IOException{

        ServerHttp webServer = new ServerHttp(new ServerSocket(12001));

        webServer.start();

    }



    @Override
    public void run(){
        go();
    }

    public void start(){

        while(true) {
            if (client != null) {
                new Thread(this).start();
            }
            run();
        }
    }




    private void go() {


        try {

                client = server.accept();

                // Read the client input and print to console line by line in a while loop
                BufferedReader bReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String[] line;
                String firstLine = bReader.readLine();

                if(firstLine == null){
                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    outputStream.write(response404.getBytes());

                    outputStream.close();

                }

                System.out.println(firstLine);
                line = firstLine.split(" ");


                if (!line[0].equals("GET")) {


                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    outputStream.write(response404.getBytes());

                    outputStream.close();
                }
                else if (line[1].equals("/image")) {
                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());


                    String header = response200Image + "Content-Length: " + converter(image).length + "\r\n"
                            + "\r\n";
                    outputStream.write(header.getBytes());
                    outputStream.write(converter(image));


                    outputStream.close();



                } else if (line[1].equals("/index.html")) {

                    System.out.println("index");
                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    String header = response200Html + "Content-Length: " + htmlDir.length() + "\r\n"
                            + "\r\n";
                    outputStream.write(header.getBytes());
                    outputStream.write(converter(htmlDir));

                    outputStream.close();


                } else if(line[1].equals("/org/academiadecodigo/stringrays/websiteData/resource/sasuke.jpg")){
                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    String header2 = response200Image + "Content-Length: " + webSiteImage.length() + "\r\n"
                            + "\r\n";

                    outputStream.write(header2.getBytes());
                    outputStream.write(converter(webSiteImage));

                } else if(line[1].equals("/style.css") || line[1].equals("/Users/codecadet/Desktop/week7_simple-web-server-java/src/org/academiadecodigo/stringrays/websiteData/style.css")){

                    System.out.println("here");
                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    String header = response200CSS + "Content-Length: " + websiteCSS.length() + "\r\n"
                            + "\r\n";

                    outputStream.write(header.getBytes());
                    outputStream.write(converter(websiteCSS));

                    outputStream.close();

                }
                else if(line[1].equals("/Users/codecadet/Desktop/week7_simple-web-server-java/src/org/academiadecodigo/stringrays/websiteData/form.html")){


                    System.out.println("in form");
                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    String header = response200Html + "Content-Length: " + formHtml.length() + "\r\n"
                            + "\r\n";
                    outputStream.write(header.getBytes());
                    outputStream.write(converter(formHtml));

                    outputStream.close();




                }

                else {

                    BufferedOutputStream outputStream = new BufferedOutputStream(client.getOutputStream());
                    outputStream.write(response404.getBytes());
                    outputStream.close();
                }


                client.close();
                client = null;



        } catch (IOException ex) {
            System.out.println("ServerHttp.go() --> " + ex.getMessage());
        }
    }






    private byte[] converter(File file) {
        byte[] fileBytes = new byte[(int) file.length()];

        try {
            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read(fileBytes);

        } catch (IOException e) {
            System.out.println("converter method --> " + e.getMessage());
        }

        return fileBytes;
    }

}
