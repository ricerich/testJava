
import java.awt.event.*;
import javax.swing.*;

public class MyActionListener implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton btn2 = (JButton)e.getSource();
		if(btn2.getText().equals("Action"))//버튼이 영어이면
		{
			btn2.setText("액션");//한글로 바꾼다
		}
		else//그렇지 않고, 버튼이 한글이면 
		{
			btn2.setText("Action");//영어로 바꾼다	
		}
	}
}
