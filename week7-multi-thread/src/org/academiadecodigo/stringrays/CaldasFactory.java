package org.academiadecodigo.stringrays;

public class CaldasFactory {

    public static void main(String[] args) {

        Thread worker = new Thread(new CaldasWorker());
        worker.setName("Luis 2");
        worker.start();

        Thread worker2 = new Thread(new CaldasWorker());
        worker2.setName("Eduardo");
        worker2.start();


        try {

            System.out.println("Gerente: À espera que os colaboradores terminem...");
            worker.join();
        }catch (InterruptedException e){
            System.out.println("Acordaram-me de uma sesta, mas ainda nao acabaram ");
            e.printStackTrace();
        }
        System.out.println("Fim da Main");

    }
}
