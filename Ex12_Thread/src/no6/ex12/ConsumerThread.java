package no6.ex12;

public class ConsumerThread extends Thread 
{
	private MyLabel bar;

	public ConsumerThread(MyLabel bar) 
	{
		this.bar = bar;
	}

	@Override
	public void run() 
	{
		while (true) 
		{
			try 
			{
				sleep(1000);
				bar.consume(); // 0.1초마다 바를 1씩 줄인다.
			} 
			catch (InterruptedException e) 
			{
				return;
			}
		}
	}
}
