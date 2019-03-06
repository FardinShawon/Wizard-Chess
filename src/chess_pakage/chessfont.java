package JAVA1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class chessfont extends JFrame {
	private JButton button;
	private Container c;
	private Font f;
	private JLabel imglabel;
	private ImageIcon icon;
	
	chessfont()
	{
		c=this.getContentPane();
		c.setLayout(null);
		//c.setBackground(Color.blue);
		
		f=new Font("Arial",Font.BOLD,18);
		
		icon=new ImageIcon(getClass().getResource("chesspic4.png"));
		imglabel=new JLabel(icon);
		imglabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		
		
		button=new JButton(" PLAY GAME");
		button.setBounds(400,300,150,70);
		//button.setBackground(Color.BLUE);
		//button.setForeground(Color.WHITE);
		button.setFont(f);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"Start Chess Game");
			}
			
			
		});
		imglabel.add(button);
		
		
		
		c.add(imglabel);
		
		
	}

	public static void main(String[] args) {
chessfont f=new chessfont();
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setBounds(30,50,1000,650);
//f.setExtendedState(MAXIMIZED_BOTH);
f.setTitle("welcome our chess game");


	}

}
