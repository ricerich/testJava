import javax.swing.JLabel;

public class TimerThread extends Thread
{

//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		super.run();
//	}
	
	//Ŭ���� ���鶧 ���� 3���
	//1.��� ����
	//2.������ (�޼ҵ�)
	//3.(�Ϲ�) �޼ҵ�
	
	//��Ŭ�� -> source -> override/implements method
	
	//1.�������
	JLabel tLabel;
	
	//2.������
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
