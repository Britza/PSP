package com.company.Evaluacion1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Parking {

    static int tope=0;
    static boolean ocupado;
    static int[]plazas= new int[5];
    static int ramdon;



    public static void main(String[] args) throws InterruptedException {

        Entrada e = new Entrada();
        Entrada e1 = new Entrada();
        Entrada e2 = new Entrada();

        Salida s = new Salida();
        Salida s1 = new Salida();
        Salida s2 = new Salida();

        e.start();
        //e.join();

        e1.start();
        e2.start();

        // e1.join();


        s.start();
        s1.start();
        s2.start();
    }

    public static class Entrada extends Thread{


        public synchronized void run(){

            while(ocupado==true || tope >=5){
                try {
                    System.out.println("El coche tiene que esperar para entrar");
                    wait();

                } catch (InterruptedException ex) {
                    Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            ocupado=true;
            System.out.println("El coche ha entrado");
            tope ++;
            ramdon = (int) (Math.random()*4);
            plazas[ramdon] = 1;
            ocupado=false;
            System.out.println("Puede entrar otro");
            notify();

        }

    }


    public static class Salida extends Thread{

        public synchronized void run(){

            while(ocupado==true || tope<=0){
                try {
                    System.out.println("El coche tiene que esperar para salir");
                    wait();

                } catch (InterruptedException ex) {
                    Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            ocupado=true;
            System.out.println("El coche ha salido");
            tope --;
            ramdon = (int) (Math.random()*4);
            plazas[ramdon]=0;
            ocupado=false;

            notify();

        }

    }
}
