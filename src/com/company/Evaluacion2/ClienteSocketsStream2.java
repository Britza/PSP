package com.company.Evaluacion2;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketsStream2 {

    static int tamaño;
    public static void main(String[] args){
        try{

            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexión");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            //String mensaje="Mensaxe 1 desde cliente";
            String mensaje = JOptionPane.showInputDialog("");
            tamaño = mensaje.length();
            os.write(mensaje.getBytes());
            byte[] mensaje3=new byte[140];
            is.read(mensaje3);
            System.out.println("Primer mensaje recibido: "+new String(mensaje3).trim());


            //String mensaje1 = "Mensaxe 2 desde cliente";
            String mensaje1 = JOptionPane.showInputDialog("");
            tamaño = mensaje1.length();
            os.write(mensaje1.getBytes());
            byte[] mensaje4=new byte[140];
            is.read(mensaje4);
            System.out.println("Segundo mensaje recibido: "+new String(mensaje4).trim());


            //String mensaje2 = "Mensaxe 3 desde cliente";
            String mensaje2 = JOptionPane.showInputDialog("");
            tamaño = mensaje2.length();
            os.write(mensaje2.getBytes());
            byte[] mensaje5=new byte[140];
            is.read(mensaje5);
            System.out.println("Tercer mensaje recibido: "+new String(mensaje5).trim());

            //System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

