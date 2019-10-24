package org.academiadecodigo.stringrays;

public class CaldasWorker implements Runnable {

    @Override
    public void run(){
        for (int i = 0; i < 8 ; i++) {
            System.out.println(Thread.currentThread().getName() + " Aqui a fazer uma loia");

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e ){
                System.out.println(" estava a dormir acordaram-me");
                e.printStackTrace();
            }

        }

        System.out.println(Thread.currentThread().getName() + " : Não faço mais um caralho");
    }
}
