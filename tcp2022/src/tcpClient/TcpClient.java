/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpClient;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 *
 * @author turko
 */
public class TcpClient {
    public static void main(String[] args) throws IOException, Exception {
        System.out.println("bu şəkli göndərmək istədiyiniz şəxsin(serverin) portunu daxil edin:");
        int port = new Scanner(System.in).nextInt();
        System.out.println("bu şəkli göndərmək istədiyiniz şəxsin(serverin) ip-ini daxil edin:");
        String ip = new Scanner(System.in).nextLine();

        //ip = "127.0.0.1":
        // port = 5678;
        Socket socket = new Socket (ip, port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("Zəhmət olmasa göndərmək istədiyiniz faylın yerləşdiyi keçidi qeyd edin");
        byte[] bytes = Files.readAllBytes(Paths.get(new Scanner(System.in).nextLine()));
        //"/Users/turko/MuradShukur.jpg"

        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
    }
}
