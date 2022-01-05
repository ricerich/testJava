import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

// Item 리스너 구현
class MyItemListener implements ItemListener {
	private int sum = 0; // 가격의 합
	
//	private JCheckBox [] fruits;
//	private JLabel sumLabel; // 계산 합을 출력할 레이블
	
	JFrame05 jf5;
	
	
//	public MyItemListener(JCheckBox[] fruits, JLabel sumLabel) 
//	{
//		this.fruits = fruits;
//		this.sumLabel = sumLabel;
//	}
	
	public MyItemListener(JFrame05 jf5) 
	{
		this.jf5 = jf5;
	}


	// 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) { // 체크박스가 선택된 경우
			if(e.getItem() == jf5.fruits[0]) // 사과 체크박스 
				sum += 100;
			else if(e.getItem() == jf5.fruits[1]) // 배 체크박스
				sum += 500;
			else if(e.getItem() == jf5.fruits[2])// 체리 체그박스
				sum += 20000;
		}
		else { // 체크박스가 해제된 경우
			if(e.getItem() == jf5.fruits[0]) // 사과 체크박스 
				sum -= 100;
			else if(e.getItem() == jf5.fruits[1]) // 배 체크박스
				sum -= 500;
			else if(e.getItem() == jf5.fruits[2])// 체리 체그박스
				sum -= 20000;				
		}
		jf5.sumLabel.setText("현재 "+sum+"원 입니다."); // 합 출력
	}
}
