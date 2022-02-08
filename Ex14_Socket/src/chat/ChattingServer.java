package chat;

import java.io.*;
import java.net.*;
import java.util.*;

class ChatServer extends Thread 
{
	private ServerSocket ss;
	private Vector vc = new Vector();//소켓을 담는 배열 클래스: 자바에서 제공 
	//첫번째 접속자를 소켓에, 다음 벡터에 add() 이런식으로 두번째, 세번째 접속자를 무한 나열
	//Vector 등록되는 모든 데이터를 연속적으로 무한 나열 시킬 수 있다! 같은 위치 덮어쓰기 안됨!
	
	public ChatServer() 
	{
		try
		{
			ss = new ServerSocket(486); //서버소켓 생성: 서버소켓(포트번호) - 서버프로그램에서만 사용되는 소켓!
			this.start();
			System.out.println("서버를 시작!..클라이언트 접속 대기중...");
		} 
		catch (IOException ee) 
		{
			System.err.println("이미 사용중입니다.");
			System.exit(0);
		}
	}

	public void run() 
	{
		while (true) 
		{
			try 
			{
				Socket socket = ss.accept(); // 클라이언트 소켓: 클라이언트 측에서 접속이 들어올때마다 소켓생성(클라이언트와 통신하는 소켓)
				System.out.println("접속자 : " + socket.toString());
				UserInfo ui = new UserInfo(socket);
				for (int i = 0; i < vc.size(); i++) 
				{
					UserInfo uiui = (UserInfo) vc.elementAt(i);
					uiui.getOut().println("/p" + ui.getNickName());
					uiui.getOut().flush();
				}
				vc.add(ui); // User 정보 저장.
				for (int i = 0; i < vc.size(); i++) 
				{
					UserInfo uiui = (UserInfo) vc.elementAt(i);
					ui.getOut().println("/o" + uiui.getNickName());
					ui.getOut().flush();
				}
			} catch (IOException ee) {
			}
		}
	}

	class UserInfo extends Thread 
	{ 
		private Socket soc;
		private String nickname;
		private PrintWriter out;
		private BufferedReader in;

		public UserInfo(Socket s) 
		{
			this.soc = s;
			try 
			{
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())));// 송신(출력) - 파일,콘솔이 아닌 네트워크 스트림! 
				in = new BufferedReader(new InputStreamReader(soc.getInputStream())); // 수신(입력) - 파일,콘솔이 아닌 네트워크 스트림!
				nickname = in.readLine();
				this.start();// 작은 감시자 시작..
			} 
			catch (IOException ee) 
			{
				System.err.println("UserInfo Error.");
			}
		}

		public String getNickName() 
		{
			return nickname;
		}

		public PrintWriter getOut()
		{
			return out;
		}

		public void run() {// 작은 감시자. - 서버와 사용자를 연결
			while (true) 
			{
				try 
				{
					String str = in.readLine();
					if (str.charAt(0) == '/') 
					{
						if (str.charAt(1) == 'q') 
						{
							for (int i = 0; i < vc.size(); i++) 
							{
								UserInfo ui = (UserInfo) vc.elementAt(i);
								if (ui.nickname.equals(nickname)) 
								{
									vc.removeElementAt(i);
									break;
								}
							}
							for (int i = 0; i < vc.size(); i++) 
							{
								UserInfo ui = (UserInfo) vc.elementAt(i);
								ui.out.println("/q" + nickname);
								ui.out.flush();
							}
							break; // 이 사람 Thread 종료...
						} 
						else if (str.charAt(1) == 'w') 
						{
							String dest = str.substring(2, str.indexOf("-")).trim();
							String msg = str.substring(str.indexOf("-") + 1).trim();
							for (int i = 0; i < vc.size(); i++) {
								UserInfo ui = (UserInfo) vc.elementAt(i);
								if (ui.nickname.equals(dest)) 
								{
									ui.out.println(nickname + "(귓속말:"	+ ui.nickname + ") >> " + msg);
									ui.out.flush();
									out.println(nickname + "(귓속말:"+ ui.nickname + ") >> " + msg);
									out.flush();
									break;
								}
							}
						}
					} 
					else 
					{
						for (int i = 0; i < vc.size(); i++) 
						{
							UserInfo ui = (UserInfo) vc.elementAt(i);
							String data = nickname + " > " + str;
							ui.out.println(data);
							ui.out.flush();
						}
					}
				} 
				catch (IOException ee) 
				{
				}
			}
		}
	}
}



public class ChattingServer {
	public static void main(String[] args)
	{
		new ChatServer();
	}
}
