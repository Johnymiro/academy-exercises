package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

        for (int i = 0; i < elementNum; i++) {

            queue.poll();
            System.out.println("[" + Thread.currentThread().getName() +
                    "] consumer: " + (elementNum - i + 1) +
                    " elements left to consume");

            try {
                Thread.sleep(1900);

            } catch (InterruptedException e) {
                System.out.println("In consumer");
                e.printStackTrace();
            }

            if (i == (elementNum-1)) {
                System.out.println("[" +
                        Thread.currentThread().getName() +
                        "] already consumed: " + (i + 1) +
                        " elements");

                System.out.println("[" + Thread.currentThread().getName() +
                        "]  finished consuming.");

            }
        }
    }
}
