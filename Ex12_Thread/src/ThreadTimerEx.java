
import java.awt.*;
import javax.swing.*;

public class ThreadTimerEx extends JFrame//GUI �Ƕ���, �ܼ־ƴ�! 
{

	public ThreadTimerEx()//�ʱ�ȭ
	{
		setTitle("����11111");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// Ÿ�̸� ���� ����� ���̺� ����
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);

		TimerThread th = new TimerThread(timerLabel);
		
		setSize(250,150);
		setVisible(true);
		th.start(); // Ÿ�̸� �������� ������ �����ϰ� �Ѵ�.

		
		
		
		
		
		
		setVisible(true);
	}
	
}
