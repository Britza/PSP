package com.company.Examen;

import com.company.Evaluacion1.Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1 {

    public static void main(String[] args) throws InterruptedException {

        Hilos h1 = new Hilos("Fío 1");
        Hilos h2 = new Hilos("Fío 2");
        Hilos h3 = new Hilos("Fío 3");

        h1.start();
        h1.join();

        h2.start();
        h2.join();

        h3.start();
        h3.join();

        System.out.println("Remataron todos os fíos");

    }

    public static class Hilos extends Thread{

        public Hilos(String name){
            super(name);
        }

        public void run(){

            for(int i=0; i<8; i++){
                System.out.println(i + " " + getName());
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ex1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
