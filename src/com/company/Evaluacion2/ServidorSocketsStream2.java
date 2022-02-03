package com.company.Evaluacion2;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;



public class ServidorSocketsStream2 {

    static int tamaño2;

    public static void main(String[] args){
        try{
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket=new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket= serverSocket.accept();

            System.out.println("Conexi�n recibida");

            InputStream is=newSocket.getInputStream();
            OutputStream os=newSocket.getOutputStream();



            byte[] mensaje= new byte[140];
            is.read(mensaje);
            System.out.println("Primer mensaje recibido: "+ new String(mensaje).trim());
            //String mensaje3 = "Mensaxe 1 desde servidor";
            String mensaje3 = JOptionPane.showInputDialog("");
            tamaño2 = mensaje3.length();
            os.write(mensaje3.getBytes());

            byte[] mensaje1=new byte[26];
            is.read(mensaje1);
            System.out.println("Segundo mensaje recibido: "+new String(mensaje1).trim());
            //String mensaje4 = "Mensaxe 2 desde servidor";
            String mensaje4 = JOptionPane.showInputDialog("");
            tamaño2 = mensaje4.length();
            os.write(mensaje4.getBytes());

            byte[] mensaje2=new byte[26];
            is.read(mensaje2);
            System.out.println("Tercer mensaje recibido: "+new String(mensaje2).trim());
            //String mensaje5 = "Mensaxe 3 desde servidor";
            String mensaje5 = JOptionPane.showInputDialog("");
            tamaño2 = mensaje5.length();
            os.write(mensaje5.getBytes());

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
        }
    }
}
