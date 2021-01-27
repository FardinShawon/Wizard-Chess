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


public class settings extends JFrame {
	private JButton b1,b2;
	private Container c;
	private Font f;
	private ImageIcon icon;
	private JLabel imglabel;
	settings()
	{
		
		
		c=this.getContentPane();
		//c.setBackground(Color.DARK_GRAY);
		c.setLayout(null);
		f=new Font("Arial",Font.BOLD,18);
		
		icon=new ImageIcon(getClass().getResource("Chess1-PNG.png"));
		imglabel=new JLabel(icon);
		imglabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		
		b1=new JButton("Choice board");
		
		b1.setBounds(250,300,250,60);
		b1.setForeground(Color.black);
		b1.setBackground(Color.lightGray);
		b1.setFont(f);
		imglabel.add(b1);
		//c.add(b1);
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			boardchoice s1=new boardchoice();
			s1.setBounds(50,20,1000,1000);
			s1.setVisible(true);
			
				
			}
			
			
			
		});
		
		/*b2=new JButton("choice cursor");
		b2.setBounds(250, 400,250,60);
		b2.setForeground(Color.black);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setFont(f);
		imglabel.add(b2);
		//c.add(b2);*/
		c.add(imglabel);
		
		
	}
	

	public static void main(String[] args) {
		
		
		settings frame =new settings();
		frame.setBounds(50,50,1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

