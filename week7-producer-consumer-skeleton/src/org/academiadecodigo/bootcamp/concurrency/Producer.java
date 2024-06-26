package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {


        for (int i = 0; i < elementNum; i++) {



            queue.offer((int) (Math.random() * 100 + 1));
            System.out.println("[" + Thread.currentThread().getName() +
                    "]  produced: " + (i + 1) + " elements");

            try {
                Thread.sleep(1900);
            } catch (InterruptedException e) {
                System.out.println("in Producer's run()");
            }

            if (i == (elementNum - 1)) {
                System.out.println(Thread.currentThread().getName() +
                        ": Produced the maximum number of element");
            }
        }
    }
}


