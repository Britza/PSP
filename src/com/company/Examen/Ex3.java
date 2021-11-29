package com.company.Examen;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex3 {

    static int variable=0;
    static boolean puede=true;

    public static void main(String[] args) throws InterruptedException {

        Sumar s1 = new Sumar();
        Sumar s2 = new Sumar();
        Sumar s3 = new Sumar();
        Restar r1 = new Restar();
        Restar r2 = new Restar();

        s1.start();
        s2.start();
        s3.start();

        r1.start();
        r2.start();

    }

    public static class Sumar extends Thread{

        public synchronized void run(){

            while(!puede || variable>=3){
                try {
                    System.out.println("No puede sumar, tiene que esperar");
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            puede=false;
            variable++;
            System.out.println("El total es: " + variable);
            puede=true;
            notify();
        }

    }

    public static class Restar extends Thread{

        public synchronized void run(){

            while(!puede || variable<1){
                try {
                    System.out.println("No puede restar, tiene que esperar");
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ex3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            puede=false;
            variable --;
            System.out.println("El total es: " + variable);
            puede=true;
            notify();
        }

    }
}
