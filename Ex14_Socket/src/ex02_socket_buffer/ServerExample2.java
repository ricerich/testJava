package ex02_socket_buffer;
import java.io.*;
import java.net.*;
class ServerExample2 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            
            //1.클라에서 받기
            BufferedReader reader = new BufferedReader(
            		new InputStreamReader(socket.getInputStream()));            
            String str = reader.readLine();
            System.out.println(str);
            //정리: ①InputStream -> ②InputStreamReader -> ③BufferedReader -> ④String 
            
            //2.클라로 보내기
            PrintWriter writer = 
            		new PrintWriter(socket.getOutputStream());
            writer.println("Hello, Client");
            writer.flush();
        }
        catch (Exception e) {System.out.println(e.getMessage());}
        finally {
            try { 
                socket.close(); 
            } 
            catch (Exception ignored) {}
            try { 
                serverSocket.close(); 
            } 
            catch (Exception ignored) {}
        }
    }
}
