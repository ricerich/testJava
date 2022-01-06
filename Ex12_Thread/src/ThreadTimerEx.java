
import java.awt.*;
import javax.swing.*;

public class ThreadTimerEx extends JFrame//GUI 판때기, 콘솔아님! 
{

	public ThreadTimerEx()//초기화
	{
		setTitle("예제11111");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 타이머 값을 출력할 레이블 생성
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);

		//1.Thread 상속 방식 (사용)
//		TimerThread th = new TimerThread(timerLabel);
//		th.start(); // 타이머 스레드의 실행을 시작하게 한다.

		//2.Runnable 구현방식 (사용)
		TimerRunnable run1 = new TimerRunnable(timerLabel);
		Thread th = new Thread(run1);
		th.start(); // 타이머 스레드의 실행을 시작하게 한다.
		
		
		setSize(250,150);
		setVisible(true);
		
		
		setVisible(true);
	}
	
}
