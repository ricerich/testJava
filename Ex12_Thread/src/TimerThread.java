import javax.swing.JLabel;

public class TimerThread extends Thread
{

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//	}
	
	//클래스 만들때 구성 3요소
	//1.멤버 변수
	//2.생성자 (메소드)
	//3.(일반) 메소드
	
	//우클릭 -> source -> override/implements method
	
	//1.멤버변수
	JLabel tLabel;
	
	//2.생성자
	public TimerThread(JLabel timerLabel)
	{
		tLabel = timerLabel;
	}
	
	public void run()
	{
		int n = 0;
		while(true)
		{
			tLabel.setText(""+n);
			n++;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
