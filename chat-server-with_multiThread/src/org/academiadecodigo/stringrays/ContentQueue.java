package org.academiadecodigo.stringrays;

import java.util.ArrayList;

public final class ContentQueue {

    //This class serves to store all the data

    private ArrayList<String> messages = new ArrayList<>();
    private boolean received  = false;

    public ContentQueue(){
    }

    public synchronized void dataStore(String message) throws InterruptedException{

        messages.add(message);
    }

    public synchronized String getData() throws InterruptedException{
        while(!received){
        }
        return messages.get(messages.size() - 1);
    }



}
