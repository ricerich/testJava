package chat;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

class ChatSub extends JFrame implements ActionListener, Runnable, WindowListener 
{
	//1.GUI 부분
	private Container con;
	private CardLayout cl = new CardLayout();
	private JPanel first_pane = new JPanel(new BorderLayout(5, 5));//로그인할때 초기 패널
	private JPanel second_pane = new JPanel(new BorderLayout(5, 5));//로그인후에 채팅하는 패널
	
	ImageIcon icon = new ImageIcon("img/surffing.jpg");   
    Image img = icon.getImage();
	Image resizeImg = img.getScaledInstance(400, 260, Image.SCALE_SMOOTH);

	private ImageIcon intro_ii = new ImageIcon(resizeImg);
//	private ImageIcon intro_ii = new ImageIcon("img/surffing.jpg");
	private JLabel intro_lb = new JLabel(intro_ii);
	private JTextField id_tf = new JTextField(10);
//	private JPasswordField pass_pf = new JPasswordField(10);
//	private JButton register_bt = new JButton("회원가입");
	private JButton login_bt = new JButton("로그인");	

	private JTextField nickname_tf = new JTextField();
	private JButton set_bt = new JButton("대화시작");
	private JTextArea view_ta = new JTextArea();
	private JScrollPane view_jsp = new JScrollPane(view_ta);
	private JTextField talk_tf = new JTextField();
	private JButton send_bt = new JButton("전송");
	private JLabel inwon_lb = new JLabel("명");
	private JTextField inwon_tf = new JTextField("0", 3);
	private Vector inwon_vc = new Vector();
	private JList inwon_li = new JList(inwon_vc);
	private JScrollPane inwon_jsp = new JScrollPane(inwon_li);
//	private ButtonGroup bg = new ButtonGroup();
//	private JRadioButton hide_jrb = new JRadioButton("귓속말 설정", false);
//	private JRadioButton show_jrb = new JRadioButton("귓속말 해제", true);
	private JButton end_bt = new JButton("나가기");

	//2.네트워크 부분
	private Socket soc;
	private PrintWriter out;
	private BufferedReader in;
	private Thread currentThread;

	//3.생성자
	public ChatSub() 
	{
		super("Chatting!!");
		
		this.init();
		this.start();
		this.setSize(500, 400);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		int xpos = (int) (screen.getWidth() / 2 - frm.getWidth() / 2);
		int ypos = (int) (screen.getHeight() / 2 - frm.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
	}

	public void init() 
	{
		con = this.getContentPane();
		con.setLayout(cl);
		first_pane.add("Center", intro_lb);
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel jp1 = new JPanel(new BorderLayout());
		JPanel jp2 = new JPanel(new GridLayout(1, 1));
		jp2.add(id_tf);
//		jp2.add(pass_pf);
		id_tf.setBorder(new TitledBorder("ID"));
//		pass_pf.setBorder(new TitledBorder("PASS"));
		jp1.add("Center", jp2);
		JPanel jp3 = new JPanel(new GridLayout(1, 2));
//		jp3.add(register_bt);
		
		jp3.add(login_bt);
		jp1.add("South", jp3);
		jp1.setBorder(new TitledBorder("Login Module"));//테두리 넣고, 제목 표시
		jp.add(jp1);
		first_pane.add("South", jp);
		con.add("intro", first_pane);

		JPanel jp4 = new JPanel(new BorderLayout(5, 5));
		JPanel jp5 = new JPanel(new BorderLayout());
		jp5.add("Center", nickname_tf);
		jp5.add("East", set_bt);
		jp5.setBorder(new TitledBorder("NICK NAME"));
		jp4.add("North", jp5);
		view_jsp.setBorder(new TitledBorder("VIEW PANE"));
		jp4.add("Center", view_jsp);
		JPanel jp6 = new JPanel(new BorderLayout());
		jp6.add("Center", talk_tf);
		jp6.add("East", send_bt);
		jp6.setBorder(new TitledBorder("TALK DATA"));
		jp4.add("South", jp6);
		second_pane.add("Center", jp4);
		JPanel jp7 = new JPanel(new BorderLayout(5, 5));
		JPanel jp8 = new JPanel(new BorderLayout());
		JPanel jp9 = new JPanel(new GridBagLayout());
		inwon_tf.setHorizontalAlignment(SwingConstants.CENTER);
		inwon_tf.setBorder(new BevelBorder(BevelBorder.LOWERED));
		inwon_tf.setEditable(false);
		jp9.add(inwon_tf);
		jp9.add(inwon_lb);
		jp9.setBorder(new TitledBorder("총인원"));
		jp8.add("North", jp9);
		inwon_vc.add("== Room Member ==");
		jp8.add("Center", inwon_jsp);
		jp8.setBorder(new TitledBorder("인원표시"));
		jp7.add("Center", jp8);
		JPanel jp10 = new JPanel(new GridLayout(3, 1));
//		jp10.add(hide_jrb);
//		jp10.add(show_jrb);
		JPanel jp11 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp11.add(end_bt);
		jp10.add(jp11);
		jp10.setBorder(new TitledBorder("OPTION"));
		jp7.add("South", jp10);
		second_pane.add("East", jp7);
		con.add("chat", second_pane);
		view_ta.setForeground(Color.RED);
		view_ta.setBackground(Color.white);
		view_ta.setDisabledTextColor(Color.RED);
		view_ta.setFont(new Font("Sans-Serif", Font.BOLD, 15));
//		bg.add(hide_jrb);
//		bg.add(show_jrb);
	}

	public void start() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_bt.addActionListener(this);
		end_bt.addActionListener(this);
		nickname_tf.addActionListener(this);
		set_bt.addActionListener(this);
		talk_tf.addActionListener(this);
		send_bt.addActionListener(this);
		this.addWindowListener(this);
		end_bt.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == talk_tf || e.getSource() == send_bt) { 
			String str = talk_tf.getText();
			if (str == null || str.trim().length() == 0)
				return;
//			if (hide_jrb.isSelected()) {
//				String dest = (String) inwon_li.getSelectedValue();
//				if (dest == null)
//					return;
//				String data = "/w" + dest + "-" + str;
//				out.println(data);
//			} else {
//				out.println(str);
//			}
			
			out.println(str);
			
			out.flush();
			talk_tf.setText("");
			talk_tf.requestFocus();
		} else if (e.getSource() == nickname_tf || e.getSource() == set_bt) {
			String nick = nickname_tf.getText();
			if (nick == null || nick.trim().length() == 0) {
				return;
			}
			nick = nick.trim();
			try {
				soc = new Socket("localhost", 486);
				
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(soc.getOutputStream())));
				
				in = new BufferedReader(new InputStreamReader(soc
						.getInputStream()));
				//계속 듣기.. 감시자 붙이기.
				currentThread = new Thread(this);
				currentThread.start();
				out.println(nick);
				out.flush();
				nickname_tf.setEnabled(false);
				set_bt.setEnabled(false);
				talk_tf.requestFocus();
			} catch (IOException ee) {
				System.err.println("접속에러!");
				return;
			}
		} else if (e.getSource() == login_bt) {
			String id = id_tf.getText();
//			String pass = pass_pf.getText();
			if (id == null || id.trim().length() == 0) {
				JOptionPane.showMessageDialog(this, "ID가 비었습니다.", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			cl.show(con, "chat");
		} else if (e.getSource() == end_bt) {
			id_tf.setText("");
//			pass_pf.setText("");
			cl.show(con, "intro");
			out.println("/q");
			out.flush();
			currentThread.interrupt();
			currentThread = null;
			soc = null;
			out = null;
			in = null;
			nickname_tf.setEnabled(true);
			set_bt.setEnabled(true);
			nickname_tf.setText("");
			inwon_vc.clear();
			inwon_vc.add("== Room Member ==");
			inwon_li.setListData(inwon_vc);
			inwon_tf.setText("0");
			view_ta.setText("");
		}
	}

	public void run() { //감시자...
		view_ta.setEnabled(false);
		view_ta.setText("### 대화방에 입장 하셨습니다. ###\n\n");
		while (true) {
			try {
				String str = in.readLine();
				//if(str == null) beak;
				if (str.charAt(0) == '/') {
					if (str.charAt(1) == 'q') {
						String name = str.substring(2).trim();
						view_ta.append("%%% " + name + "님께서 퇴장하셨습니다.%%%\n");
						for (int i = 0; i < inwon_vc.size(); i++) {
							String imsi = (String) inwon_vc.elementAt(i);
							if (imsi.equals(name)) {
								int pos = inwon_li.getSelectedIndex();
								inwon_vc.removeElementAt(i);
								inwon_li.setListData(inwon_vc);
								inwon_li.setSelectedIndex(pos);
								break;
							}
						}
						int xx = Integer.parseInt(inwon_tf.getText());
						inwon_tf.setText(String.valueOf(--xx));
					} else if (str.charAt(1) == 'p') {
						int pos = inwon_li.getSelectedIndex();
						String user = str.substring(2).trim();
						inwon_vc.add(user);
						inwon_li.setListData(inwon_vc);
						inwon_li.setSelectedIndex(pos);
						view_ta.append("*** " + user + "님께서 입장하셨습니다.***\n");
						int xx = Integer.parseInt(inwon_tf.getText().trim());
						inwon_tf.setText(String.valueOf(++xx));
					} else if (str.charAt(1) == 'o') {
						String user = str.substring(2).trim();
						inwon_vc.add(user);
						inwon_li.setListData(inwon_vc);
						int xx = Integer.parseInt(inwon_tf.getText().trim());
						inwon_tf.setText(String.valueOf(++xx));
					}
				} else {
					view_ta.append(str + "\n");
					view_ta.setCaretPosition(view_ta.getText().trim().length()
							- str.trim().length() + 1);
				}
			} catch (IOException ee) {
				System.err.println("read error = " + ee.toString());
			}
		}
	}

	public void windowActivated(WindowEvent arg0) {

	}

	public void windowClosed(WindowEvent arg0) {
	}

	public void windowClosing(WindowEvent arg0) {

		if (out != null) {
			out.println("/q");
			out.flush();
			currentThread.interrupt();
		}
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent arg0) {

	}

	public void windowDeiconified(WindowEvent arg0) {

	}

	public void windowIconified(WindowEvent arg0) {

	}

	public void windowOpened(WindowEvent arg0) {
	}
}

public class ChattingClient {
	public static void main(String[] args) {
		new ChatSub();
	}
}
