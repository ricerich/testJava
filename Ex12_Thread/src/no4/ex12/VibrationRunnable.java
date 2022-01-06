package no4.ex12;
import java.util.Random;

import javax.swing.*;

public class VibrationRunnable implements Runnable {
	
	JFrame jf;
	
	public VibrationRunnable(JFrame jf)
	{
		this.jf = jf;
	}

	@Override
	public void run() { // 20ms마다 프레임의 위치를 랜덤하게 이동
		Random r = new Random();
		while(true) {
			try {
				Thread.sleep(20); // 20ms 잠자기
			}
			catch(InterruptedException e){
				return; // 리턴하면 스레드 종료
			}
			int x = jf.getX() + r.nextInt()%5; // 새 위치 x
			int y = jf.getY() + r.nextInt()%5; // 새 위치 y 
			jf.setLocation(x, y); // 프레임의 위치 이동
		}
	}

}
