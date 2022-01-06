package no6.ex12;

import java.awt.*;
import javax.swing.*;

public class MyLabel extends JLabel 
{
	private int barSize = 0; // 바의 크기
	private int maxBarSize;

	public MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = (int) (((double) (getWidth())) / maxBarSize * barSize);
		if (width == 0)
			return; // 크기가 0이기 때문에 바를 그릴 필요 없음
		g.fillRect(0, 0, width, this.getHeight());
	}

	synchronized void fill() {
		if (barSize == maxBarSize) {
			try {
				wait(); // 바의 크기가 최대이면, ComsumerThread에 의해 바의 크기가 줄어들 때까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint(); // 바 다시 그리기
		notify(); // 기다리는 ConsumerThread 스레드 깨우기
	}

	synchronized void consume() {
		if (barSize == 0) {
			try {
				wait(); // 바의 크기가 0이면 바의 크기가 0보다 커질때까지 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint(); // 바 다시 그리기
		notify(); // 기다리는 이벤트 스레드 깨우기
	}
}
