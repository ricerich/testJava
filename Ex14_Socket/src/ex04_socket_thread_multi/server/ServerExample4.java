package ex04_socket_thread_multi.server;

import java.net.*;
class ServerExample4 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9002);
            System.out.println("대기중...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("11111");
                Thread thread = new PerClinetThread(socket);
                thread.start();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
