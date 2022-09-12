/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpServer;


import tcpClient.TcpClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 *
 * @author turko
 */
public class TcpServer {


    public static void main(String[] args) throws Exception {
        System.out.println("Zəhmət olmasa müştərinin adını və soyadını daxil edin");
        String nameAndSurename = new Scanner(System.in).nextLine();
        System.out.println(nameAndSurename);


        readAsByte();
    }

    public static void readAsByte() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(5678);
        while (true) {
            System.out.println("Yeni socket ucun gozleyirem");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("Urra yeni musteri geldi");
            DataInputStream dataStream = new DataInputStream(connection.getInputStream());
            int  msgLen = dataStream.readInt();
            System.out.println("Message lenth2=" +msgLen);
            byte[] msg = new byte[msgLen];
            dataStream.readFully(msg);
            System.out.println("Message lenth2=" +msg.length);
            Files.write(Paths.get("muraddd.png"), msg);
            System.out.println("uğurla göndərildi");
        }
    }

    public static byte[] readMessage(DataInputStream din) throws Exception {
        int msgLen = din.readInt();
        System.out.println("message length1 =" + msgLen);
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;
    }

    public static void readAsString() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("Yeni socket ucun gozleyirem");
            Socket connection = ourFirstServerSocket.accept();
            System.out.println("Urra yeni musteri geldi");
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(reader);
            String messageFromClient = bReader.readLine();
            System.out.println("Musteri deyir ki:" + messageFromClient);

        }

    }
}
