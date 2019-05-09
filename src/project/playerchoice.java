package project;

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

public class playerchoice extends JFrame {
	private JButton b1,b2;
	private Container c;
	private Font f;
	private JLabel imglabel;
	private ImageIcon icon;
	
	playerchoice()
	{
		c=this.getContentPane();
		c.setLayout(null);
		//c.setBackground(Color.blue);
		
		f=new Font("Arial",Font.BOLD,18);
		
		icon=new ImageIcon(getClass().getResource("Chess-PNG.png"));
		imglabel=new JLabel(icon);
		imglabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		
		
		b1=new JButton("Back ");
		b1.setBounds(350,320,250,50);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setForeground(Color.BLACK);
		b1.setFont(f);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				chessfont s1=new chessfont();
			s1.setBounds(50,20,1000,1000);
			s1.setVisible(true);
				
			}
			
			
		});
		imglabel.add(b1);
		
		b2=new JButton("Player to Computer");
		b2.setBounds(350,250,250,50);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setForeground(Color.BLACK);
		b2.setFont(f);
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				dificulty d1=new dificulty();
				d1.setVisible(true);
			}
			
			
		});
		imglabel.add(b2);
		
		
		c.add(imglabel);
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
playerchoice f=new playerchoice();
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setBounds(30,50,1000,900);
//f.setExtendedState(MAXIMIZED_BOTH);
f.setTitle("playercoice...");


	}

}
