package com.company.Evaluacion2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ClienteSocketsStream {

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

            String mensaje="Mensaxe 1 desde cliente";
            os.write(mensaje.getBytes());
            byte[] mensaje3=new byte[24];
            is.read(mensaje3);
            System.out.println("Primer mensaje recibido: "+new String(mensaje3));


            String mensaje1 = "Mensaxe 2 desde cliente";
            os.write(mensaje1.getBytes());
            byte[] mensaje4=new byte[24];
            is.read(mensaje4);
            System.out.println("Segundo mensaje recibido: "+new String(mensaje4));


            String mensaje2 = "Mensaxe 3 desde cliente";
            os.write(mensaje2.getBytes());
            byte[] mensaje5=new byte[24];
            is.read(mensaje5);
            System.out.println("Tercer mensaje recibido: "+new String(mensaje5));

            //System.out.println("Mensaje enviado");

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

