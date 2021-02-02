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

public class FrontScreen extends JFrame {
	
	private JButton playButton,settingsButton,exitButton;
	private Container cntnr;
	private Font font;
	private JLabel imgLabel;
	private ImageIcon icon;
	
	FrontScreen()
	{
		cntnr=this.getContentPane();
		cntnr.setLayout(null);
		//c.setBackground(Color.blue);
		font=new Font("Arial",Font.BOLD,18);
		icon=new ImageIcon(getClass().getResource("chesspic4.png"));
		imgLabel=new JLabel(icon);
		imgLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		
		
		//Play
		playButton=new JButton("Play Game");
		playButton.setBounds(400,320,150,50);
		playButton.setBackground(Color.BLACK);
		playButton.setForeground(Color.lightGray);
		playButton.setFont(font);
		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PlayerChoice s1=new PlayerChoice();
				s1.setBounds(50,20,1000,1000);
				s1.setVisible(true);			
			}	
		});
		imgLabel.add(playButton);
		
		
		//Settings
		settingsButton=new JButton("Settings");
		settingsButton.setBounds(400,390,150,50);
		settingsButton.setBackground(Color.BLACK);
		settingsButton.setForeground(Color.lightGray);
		settingsButton.setFont(font);
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Settings s1=new Settings();
				s1.setBounds(50,20,1000,1000);
				s1.setVisible(true);
			}
		});
		imgLabel.add(settingsButton);
		
		
		//Exit
		exitButton=new JButton("Exit");
		exitButton.setBounds(400,460,150,50);
		exitButton.setBackground(Color.BLACK);
		exitButton.setForeground(Color.lightGray);
		exitButton.setFont(font);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//JOptionPane.showConfirmDialog(c, "Are you sure exit");
				System.exit(0);
			}	
		});
		imgLabel.add(exitButton);
		
		cntnr.add(imgLabel);
	}

	public static void main(String[] args) {
		FrontScreen fs=new FrontScreen();
		fs.setVisible(true);
		fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fs.setBounds(30,50,1000,670);
		//f.setExtendedState(MAXIMIZED_BOTH);
		fs.setTitle("Welcome to Wizerd Chess!!!");
	}
	
}
