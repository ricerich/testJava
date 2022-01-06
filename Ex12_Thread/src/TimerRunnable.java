import javax.swing.JLabel;

public class TimerRunnable implements Runnable {

	//1.멤버변수
	JLabel tLabel;
	
	//2.생성자
	public TimerRunnable(JLabel timerLabel)
	{
		tLabel = timerLabel;
	}

	@Override
	public void run() {
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
