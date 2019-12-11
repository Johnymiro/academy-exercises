package academiadecodigo.stringrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;


public class FetchIP {


    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        String ip = "/52.18.96.198";

        MyPojo myPojo = null;
        try {
            myPojo = mapper.readValue(new URL(ipWrapper(ip)), MyPojo.class);


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(myPojo.toString());
    }

    private static String ipWrapper(String ip){

        return "https://ipinfo.io" + ip + "/json";
    }

}




