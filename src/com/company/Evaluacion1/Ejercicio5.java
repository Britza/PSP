package com.company.Evaluacion1;

public class Ejercicio5 {

    public static void main(String[] args) throws InterruptedException {

        hilos h1 = new hilos("numero 1");
        //h1.setPriority(Thread.MIN_PRIORITY);
        hilos h2 = new hilos("numero 2");
        //h2.setPriority(Thread.MAX_PRIORITY);

        h2.start();
        h2.join();
        h1.start();

        /* h1.start();
       h2.start();*/

    }

    public static class hilos extends Thread{

        public hilos(String numero){
            super(numero);
        }
        public void run(){

            System.out.println("Ola, son o fío " + getName());
        }

    }
}
