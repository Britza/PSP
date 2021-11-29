package com.company.Examen;

public class Ex2 {

    public static void main(String[] args) throws InterruptedException {

        Hilos h1 = new Hilos("Fío 1");
        Hilos h2 = new Hilos("Fío 2");
        Hilos h3 = new Hilos("Fío 3");

        h3.start();
        h3.join();
        h2.start();
        h2.join();
        h1.start();
        h1.join();



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

        }

    }
}
