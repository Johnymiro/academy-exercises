package org.academiadecodigo.stringrays;

import java.util.ArrayList;

public final class ContentQueue {

    private ArrayList<String> messages = new ArrayList<>();
    private boolean received  = false;

    public ContentQueue(){


    }

    public synchronized void dataStore(String message) throws InterruptedException{

        messages.add(message);
        notifyAll();
    }

    public synchronized String getData() throws InterruptedException{
        while(!received){
            wait();
        }
        return messages.get(messages.size() - 1);
    }



}
