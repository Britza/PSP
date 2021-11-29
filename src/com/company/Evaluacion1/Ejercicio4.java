package com.company.Evaluacion1;

public class Ejercicio4 {

    public static void main(String[] args) {

        new hilo1().start();
        new hilo2().start();
        new hilo3().start();
    }


    public static class hilo1 extends Thread{

        int suma;

        public void run(){
            for(int i=0; i<1000; i++){
                if(i%2==0){
                    suma = suma+i;

                }
            }
            System.out.println(suma);
        }
    }

    public static class hilo2 extends Thread{

        int suma;

        public void run(){
            for(int i=0; i<1000; i++){
                if(i%2!=0){
                    suma = suma+i;

                }
            }
            System.out.println(suma);
        }
    }

    public static class hilo3 extends Thread{

        int suma;

        public void run(){
            for(int i=0; i<1000; i++){
                if(i%10==2 || i%10==3){
                    suma = suma+i;

                }
            }
            System.out.println(suma);
        }
    }
}
