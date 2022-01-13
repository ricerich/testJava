package ex03_socket_thread.server;
import java.io.*;
import java.net.*;
class ReceiverThread extends Thread {
    Socket socket;
    ReceiverThread(Socket socket) {  
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            
            while (true) {
                String str = reader.readLine();
                if (str == null)
                    break;
                System.out.println("수신>" + str);
            }
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
