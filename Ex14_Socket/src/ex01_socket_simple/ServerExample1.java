package ex01_socket_simple;

import java.io.*;
import java.net.*;

class ServerExample1 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			System.out.println("서버소켓열림!");
			
			//클라이언트가 접속시도하면 받아줌~!
			socket = serverSocket.accept();
			
			//in 클라로부터 받는 것!
			InputStream in = socket.getInputStream();
			//out 클라로 보내는 것!
			OutputStream out = socket.getOutputStream();
			
			//in으로 받아서 저장할 공간을 마련!
			byte arr[] = new byte[100];
			in.read(arr);//in으로 받은거를 arr에 저장
			System.out.println(new String(arr));
			//정리: ①InputStream -> ②byte[] -> ③String
			
			
			//out으로 보낼 메세지
			String str = "Hello, Client";
			out.write(str.getBytes());//out을 보냄
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (Exception ignored) {}
			try {
				serverSocket.close();
			} catch (Exception ignored) {}
		}
	}
}
