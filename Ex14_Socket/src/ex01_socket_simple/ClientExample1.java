package ex01_socket_simple;

import java.io.*;
import java.net.*;

class ClientExample1 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("10.100.204.62", 9000);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            String str = "Hello, Server";
            out.write(str.getBytes());
            byte arr[] = new byte[100];
            in.read(arr);
            System.out.println(new String(arr));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { 
                socket.close(); 
            } 
            catch (Exception e) {
            }
        }
    }
}
