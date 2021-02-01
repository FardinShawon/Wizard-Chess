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

public class PlayerChoice extends JFrame {
	private JButton backButton, playerToComputerButton;
	private Container cntnr;
	private Font font;
	private JLabel imgLabel;
	private ImageIcon icon;
	
	PlayerChoice()
	{
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(30,50,1000,900);
		//f.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("Player Choice");
		
		cntnr=this.getContentPane();
		cntnr.setLayout(null);
		//c.setBackground(Color.blue);
		
		font=new Font("Arial",Font.BOLD,18);
		icon=new ImageIcon(getClass().getResource("Chess-PNG.png"));
		imgLabel=new JLabel(icon);
		imgLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		playerToComputerButton=new JButton("Player to Computer");
		playerToComputerButton.setBounds(350,250,250,50);
		playerToComputerButton.setBackground(Color.LIGHT_GRAY);
		playerToComputerButton.setForeground(Color.BLACK);
		playerToComputerButton.setFont(font);
		playerToComputerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Dificulty d1=new Dificulty();
				d1.setVisible(true);
			}
		});
		imgLabel.add(playerToComputerButton);
		
		backButton=new JButton("Back");
		backButton.setBounds(350,320,250,50);
		backButton.setBackground(Color.LIGHT_GRAY);
		backButton.setForeground(Color.BLACK);
		backButton.setFont(font);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FrontScreen s1=new FrontScreen();
				s1.setBounds(50,20,1000,670);
				s1.setVisible(true);
			}
		});
		imgLabel.add(backButton);
		
		cntnr.add(imgLabel);
	}

}
