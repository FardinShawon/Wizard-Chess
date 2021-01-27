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

public class chessfont extends JFrame {
	private JButton button11,button22,button3;
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
		
		
		
		button11=new JButton("Play Game");
		button11.setBounds(400,320,150,50);
		button11.setBackground(Color.BLACK);
		button11.setForeground(Color.lightGray);
		button11.setFont(f);
	
		imglabel.add(button11);
		button11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			playerchoice s1=new playerchoice();
			s1.setBounds(50,20,1000,1000);
			s1.setVisible(true);
						
			}	
		});
		
		button22=new JButton("Settings");
		button22.setBounds(400,390,150,50);
		button22.setBackground(Color.BLACK);
		button22.setForeground(Color.lightGray);
		button22.setFont(f);
		imglabel.add(button22);
		button22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			settings s1=new settings();
			s1.setBounds(50,20,1000,1000);
			s1.setVisible(true);
			
				
			}
			
			
			
		});
		
		
		
		
		button3=new JButton("Exit");
		button3.setBounds(400,460,150,50);
		button3.setBackground(Color.BLACK);
		button3.setForeground(Color.lightGray);
		button3.setFont(f);
		
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//JOptionPane.showConfirmDialog(c, "Are you sure exit");
					System.exit(0);
			}
			
			
		});
		imglabel.add(button3);
		
		c.add(imglabel);
		
		
	}

	public static void main(String[] args) {
chessfont f=new chessfont();
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setBounds(30,50,1000,670);
//f.setExtendedState(MAXIMIZED_BOTH);
f.setTitle("welcome our chess game");


	}

}
