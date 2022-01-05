
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame4 extends JFrame 
{
	//1.멤버변수
	JLabel la;	
	
	// 2.생성자
	public MyFrame4()// 생성자 만들기
	{
		setTitle("예제4-마우스리스너");
		
		la = new JLabel("헬로우~!");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
//		c.addMouseListener(마우스리스너);
		c.add(la);
//		c.addMouseListener(new MyMouseListener());

		setSize(300, 200);
		setVisible(true);
	}
	
	//4.내부 클래스
	private class MyMouseListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) 
		{
			int x = e.getX();
			int y = e.getY();
			
			la.setLocation(x,y);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}

