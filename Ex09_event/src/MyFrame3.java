
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyFrame3 extends JFrame {
	// 2.생성자
	public MyFrame3()// 생성자 만들기
	{
		setTitle("액션리스너예제1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// 0.버튼 객체 만들기(버튼은 컴포넌트임)
		JButton btn1 = new JButton("Action");

		// 1.버튼 객체에 (이벤트) 리스너 객체를 장착한다
//		btn1.addActionListener(리스너객체);//리스너 클래스를 먼저 만들어야지~!
//		MyActionListener2 listener1 = new MyActionListener2();
//		btn1.addActionListener(listener1);

		// 중요: 클래스를 안만들고, 객체를 생성(만들어서), 사용함(addActionListener의 매개변수로 사용)
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JButton btn2 = (JButton) e.getSource();
				if (btn2.getText().equals("Action"))// 버튼이 영어이면
				{
					btn2.setText("액션");// 한글로 바꾼다
				} else// 그렇지 않고, 버튼이 한글이면
				{
					btn2.setText("Action");// 영어로 바꾼다
				}
			}
		});

//		class A {
//			int a1;
//		}
//		
//		A a2 = new A();

//		btn1.addActionListener(new MyActionListener());//한줄로 줄인 표현

		c.add(btn1);
		setSize(300, 200);
		setVisible(true);
	}
	// 여기에 클래스를 만들면, 위치를 자세히 본다~! -> 4.내부클래스
	// 내부 클래스 //1.멤버변수, 2.생성자, 3.메소드, 4.내부클래스(어려움,생소함)

	// 4.내부 클래스-여기 안쓸꺼임!
//	private class MyActionListener2 implements ActionListener 
//	{
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{
//			JButton btn2 = (JButton)e.getSource();
//			if(btn2.getText().equals("Action"))//버튼이 영어이면
//			{
//				btn2.setText("액션");//한글로 바꾼다
//			}
//			else//그렇지 않고, 버튼이 한글이면 
//			{
//				btn2.setText("Action");//영어로 바꾼다	
//			}
//		}
//	}

}

//여기에 클래슬 만들면, 독립클래스, 즉 외부 클래스는 별도의 파일로 만드는걸 추천 -> 그래서 파일 만들꺼임
//class MyActionListener implements ActionListener
//{
//	
//}
