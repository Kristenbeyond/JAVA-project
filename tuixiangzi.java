import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tuixiangzi {
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("推箱子1.0");
		gameFrame.setBounds(100, 50, 800, 600);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		//设置关联窗体和面板
		gameFrame.setContentPane(panel);
		
		ImageIcon boxImg = new ImageIcon("imgs/box.png");
		JLabel box = new JLabel(boxImg);
		panel.add(box);
		
		ImageIcon boxImg2 = new ImageIcon("imgs/box2.png");
		JLabel box2 = new JLabel(boxImg2);
		panel.add(box2);
		
		ImageIcon boxImg3 = new ImageIcon("imgs/goal.png");
		JLabel box3 = new JLabel(boxImg3);
		panel.add(box3);
		
		
		gameFrame.setVisible(true);
	}
}
