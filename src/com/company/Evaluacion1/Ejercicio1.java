package com.company.Evaluacion1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 {

        public static void main(String[] args) throws InterruptedException {

            Hilos h1 = new Hilos(" Hilo1");
            h1.setPriority(10);
            Hilos h2 = new Hilos(" Hilo2");
            h2.setPriority(1);

            h1.start();
            h2.start();

            System.out.println(" Termina el Hilo ");

        }

    public static class Hilos extends Thread {

        public Hilos(String nome){
            super(nome);

        }
        public void run(){
            for(int i=0; i<10; i++){

                System.out.println(i+ " " +getName());
                try{
                    int numero = (int) (Math.random()*((800-100+1)+100));
                    Thread.sleep(numero);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
            System.out.println("Termina el" + getName());
        }
    }
}
