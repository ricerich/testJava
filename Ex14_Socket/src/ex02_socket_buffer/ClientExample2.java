package ex02_socket_buffer;
import java.io.*;
import java.net.*;
class ClientExample2 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9000);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = 
                new PrintWriter(socket.getOutputStream());
            writer.println("Hello, Server");
            writer.flush();
            String str = reader.readLine();
            System.out.println(str);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { 
                socket.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
