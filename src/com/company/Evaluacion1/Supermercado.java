package com.company.Evaluacion1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Supermercado {

    static boolean pasan;
    public static int personas=40;
    public static int aforo=5;

    public static  class entra extends Thread{

        public entra() {
            super();
        }

        public synchronized void run(){

            try {

                entra.sleep((int) Math.random() * ((800 - 100 + 1) + 100));

                while(pasan==true && aforo<personas){

                    pasan=false;
                    aforo++;
                    pasan=true;
                    System.out.println(aforo);


                }
                pasan=false;
                System.out.println("se pone en espera");
                wait();


            } catch (InterruptedException ex) {
                Logger.getLogger(Supermercado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    public static class sale extends Thread {

        public sale() {
            super();
        }


        public synchronized void run() {


            try {
                sale.sleep((int) (Math.random() * ((800 - 100 + 1) + 100)));
                aforo--;
                System.out.println(aforo);
                System.out.println("Salgo pero tengo que avisar ");
                pasan = true;
                notify();
                System.out.println("Sali y ya notifique");
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

        public static void main(String[] args) {

            entra e = new entra();
            entra e1 = new entra();
            entra e2 = new entra();
            sale s = new sale();
            sale s1 = new sale();
            sale s2 = new sale();
            sale s3 = new sale();


            e.start();
            e1.start();
            e2.start();
            s.start();
            s1.start();
            s2.start();
            s3.start();

        }
}
