package com.company.Evaluacion1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio2 {

    public static void main(String[] args) throws InterruptedException {
        Hilos h1 = new Hilos(" Hilo1");
        Hilos h2 = new Hilos(" Hilo2");
        Hilos h3 = new Hilos(" Hilo3");
        Hilos h4 = new Hilos(" Hilo4");

        h1.start();
        h1.join();
        h2.start();
        h2.join();
        h3.start();
        h3.join();
        h4.start();
        h4.join();

        System.out.println(" Terminado ");
    }

    public static class Hilos extends Thread {

        public Hilos(String nome){
            super(nome);
        }
        public void run(){
            for(int i=0; i<5; i++){

                System.out.println(i+ " " +getName());
                try{
                    int numero = (int) (Math.random()*((800-100+1)+100));
                    Thread.sleep(numero);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Termina el" + getName());
        }
    }
}
