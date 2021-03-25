import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class tuixiangzi {
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("����1.0");
		gameFrame.setBounds(100, 50, 22*48+15, 13*48+35);
		//���õ�ǰ���岻�ɸı�
		gameFrame.setResizable(false);
		//���õ�ǰ�������
		gameFrame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		//���ò���Ϊ�Զ��岼�� 
		panel.setLayout(null);
		//���ù�����������
		gameFrame.setContentPane(panel);
		
		ImageIcon boxImg = new ImageIcon("imgs/box.png");
		JLabel box = new JLabel(boxImg);
		panel.add(box);
		box.setBounds(3*48, 4*48, 48, 48);
		
		ImageIcon goalImg = new ImageIcon("imgs/goal2.png");
		JLabel goal = new JLabel(goalImg);
		panel.add(goal);
		goal.setBounds(4*48, 9*48, 48, 48);
		
		ImageIcon workerImg3 = new ImageIcon("imgs/workerDown2.png");
		JLabel worker = new JLabel(workerImg3);
		panel.add(worker);
		worker.setBounds(11*48, 11*48, 48, 48);
		
		//��Χǽ	
		JLabel[] walls = new JLabel[22 * 2 +(13 - 2) * 2 + 30];
		ImageIcon walling = new ImageIcon("imgs/wall2.png");
		
		for(int i = 0;i < walls.length;i++) {
			walls[i] = new JLabel(walling);
		}
		
		int index = 0;   //��¼ʹ�õ��������ĸ�Ԫ��
		for (int i = 0; i < 22; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 0, 48, 48);
			
			panel.add(walls[index]);
			walls[index++].setBounds(i * 48, 12 * 48, 48, 48);
		}
		
		for(int i = 1; i <= 11; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds(0, i * 48, 48, 48);
			
			panel.add(walls[index]);
			walls[index++].setBounds(21 * 48, i * 48, 48, 48);
		}
		
		//�����ϰ���
		for(int i = 0;i < 5; i++) {
			panel.add(walls[index]);
			walls[index++].setBounds((3 + i) * 48, 3 * 48, 48, 48);
			
			panel.add(walls[index]);
			walls[index++].setBounds((12 + i) * 48, (5 + i) * 48, 48, 48);
		}
		
		//���������ƶ�ʱ�䴦��
		gameFrame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}	
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int x = 0,y = 0;
				int keyCode = e.getKeyCode();
				String workerImgPath = "WorkerLeft2.png";
				if( keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
					x = -48;
					workerImgPath = "WorkerLeft2.png";
				}else if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
					x = 48;
					workerImgPath = "WorkerRight2.png";
				}else if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
					y = -48;
					workerImgPath = "WorkerUp2.png";
					
				}else if(keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
					y = 48;
					workerImgPath = "WorkerDown2.png";
				}
				
				//�����������µ�ͼƬ·��
				worker.setBounds(worker.getBounds().x + x, worker.getBounds().y + y, 48, 48);
				ImageIcon img = new ImageIcon("imgs/" + workerImgPath);
				worker.setIcon(img);
				
				//�жϹ����Ƿ�ǽ
				for (int i = 0; i < walls.length; i++) {
					if(worker.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, 
								worker.getBounds().y - y, 48, 48);
					}
				}
				//�ù����ƶ�����
				if (worker.getBounds().contains(box.getBounds())) {
				box.setBounds(box.getBounds().x + x, 
						box.getBounds().y + y, 48, 48);
				}
				//�ж������Ƿ�ǽ
				for (int i = 0; i < walls.length; i++) {
					if(box.getBounds().contains(walls[i].getBounds())) {
						worker.setBounds(worker.getBounds().x - x, 
								worker.getBounds().y - y, 48, 48);
						box.setBounds(box.getBounds().x - x, 
								box.getBounds().y - y, 48, 48);
					}
				}
				//���ӱ��Ƶ�Ŀ���ʱ��ʾʤ��
				if (box.getBounds().contains(goal.getBounds())) {
					JOptionPane.showMessageDialog(null, "congratulations!");
					System.exit(0);
				}
			}
		});
		//�����
		gameFrame.setVisible(true);
	}
}
