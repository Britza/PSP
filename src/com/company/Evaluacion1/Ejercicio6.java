package com.company.Evaluacion1;

public class Ejercicio6 {

    public static int caja=100;
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            new ingresar("100").start();
        }

        for(int i=0;i<5;i++){
            new extraer("100").start();
        }
    }

    public static class ingresar extends Thread{

        public ingresar(String name) {
            super(name);
        }
        //int ingreso = Integer.parseInt(JOptionPane.showInputDialog("Cantidad deseada a introducir"));

        public void run(){

            //for(int i=0;i<10;i++){

            caja += Integer.parseInt(getName());
            //caja+=ingreso;

            //}
            System.out.println("El total en la caja ahora es: " + caja);

        }
    }


    public static class extraer extends Thread{

        public extraer(String name) {
            super(name);
        }

        //int extraccion = Integer.parseInt(JOptionPane.showInputDialog("Cantidad deseada a extraer"));

        public void run(){

            //for(int i=0;i<5;i++){

            caja -= Integer.parseInt(getName());
            //caja-=extraccion;

            //}
            System.out.println("El total en la caja ahora es: " + caja);
        }
    }
}
