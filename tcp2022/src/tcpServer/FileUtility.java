/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpServer;

import java.io.*;

/**
 *
 * @author turko
 */
public class FileUtility {

    private static void writeIntoFile(String fileName, String text, boolean append) throws Exception {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append));) {
            bw.write(text);
        }
    }

    public static void writeIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    public static String read(String fileName) throws Exception {
        try (InputStream in = new FileInputStream(fileName);
                InputStreamReader r = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(r);) {
            String line = null;
            String result = "";
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
            return result;
        }
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytesArray);
        return bytesArray;
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        try (FileOutputStream fop = new FileOutputStream(fileName);) {
            fop.write(data);
            fop.flush();
            fop.close();
            System.out.println("done");
        }

    }
    
    public static Object readFileDeserialize(String name) {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))) 
            {
                obj = in.readObject();
            }finally{
                return obj;
            
        }
        }

    

    public static boolean writeObjectToFile(Object obj, String name) throws RuntimeException {
        try (FileOutputStream fout = new FileOutputStream(name);
                ObjectOutputStream oos = new ObjectOutputStream(fout);) {
            oos.writeObject(obj);
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }

    }
}
