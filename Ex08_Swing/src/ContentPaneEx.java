
import java.awt.*;
import javax.swing.*;

public class ContentPaneEx extends JFrame 
{
	public ContentPaneEx()
	{
		setTitle("2번째 예제");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//1.컨테이너 만들어서, 프레임에 꽂는다.		
		Container c = getContentPane();
		c.setBackground(Color.ORANGE);
		c.setLayout(new FlowLayout());
		
		//2.버튼 만들어서, 컨테이너에 꽂는다.
		c.add(new JButton("오케이"));
		c.add(new JButton("취소"));
		c.add(new JButton("무시"));
		
		setSize(300,500);
		
		setVisible(true);
	}

}
