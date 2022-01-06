package no6.ex12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame06 extends JFrame 
{
	private MyLabel bar = new MyLabel(100); // 바의 최대 크기를 100으로 설정
	
	public Frame06(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20,  50);
		bar.setSize(300, 20); // 300x20 크기의 바
		c.add(bar);
		
		// 컨텐트팬에 키 이벤트 핸들러 등록
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				bar.fill(); // 키를 누를때마다 바가 1씩 증가한다.
			}
		});
		setSize(350,200);
		setVisible(true);
		
		c.setFocusable(true); // 컨텐트팬이 포커스를 받을 수 있도록 설정
		c.requestFocus(); // 컨텐트팬에게 키 입력 독점권 부여
		ConsumerThread th = new ConsumerThread(bar); // 스레드 생성
		th.start(); // 스레드 시작
	}
}