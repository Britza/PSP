package com.company.Evaluacion2;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketsStream {

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


            byte[] mensaje=new byte[23];
            is.read(mensaje);
            System.out.println("Primer mensaje recibido: "+new String(mensaje));
            String mensaje3 = "Mensaxe 1 desde servidor";
            os.write(mensaje3.getBytes());

            byte[] mensaje1=new byte[23];
            is.read(mensaje1);
            System.out.println("Segundo mensaje recibido: "+new String(mensaje1));
            String mensaje4 = "Mensaxe 2 desde servidor";
            os.write(mensaje4.getBytes());

            byte[] mensaje2=new byte[23];
            is.read(mensaje2);
            System.out.println("Tercer mensaje recibido: "+new String(mensaje2));
            String mensaje5 = "Mensaxe 3 desde servidor";
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
