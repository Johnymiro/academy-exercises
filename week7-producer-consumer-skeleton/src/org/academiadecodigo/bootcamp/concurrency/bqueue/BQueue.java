package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.ArrayList;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private final int limit;
    private final ArrayList <T> elements;
    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {

       this.limit = limit;
       elements =  new ArrayList<>(limit);
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {


        try{
            while(elements.size() == limit){
                System.out.println("[" + Thread.currentThread().getName() +
                        "] waiting in offer");
                wait();
            }
        }catch (InterruptedException e){
            System.out.println("In offer()");
            e.printStackTrace();
        }
        elements.add(data);
        System.out.println("[" + Thread.currentThread().getName() +
                "] Added element: " + data);
        notifyAll();

    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        try {
            while (elements.size() == 0) {
                System.out.println("[" + Thread.currentThread().getName() +
                        "]  waiting in poll");
                wait();
            }
        }catch(InterruptedException e){
            System.out.println("In poll()");
            e.printStackTrace();
        }

        System.out.println("[" + Thread.currentThread().getName() +
                "] consumed: " + elements.get(0));
        return elements.remove(0);

    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {

       return elements.size();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {

        return limit;
    }
}
