package project;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Dificulty extends JFrame {
	private Container cntnr;
	private JButton easyButton,mediumButton,hardButton;
	private Font font;
		
	Dificulty()
	{
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(500,300,650,450);
		this.setTitle("Dificulty");
		this.setResizable(false);
		
		cntnr=this.getContentPane();
		cntnr.setLayout(null);
		cntnr.setBackground(Color.LIGHT_GRAY);
		font=new Font("Arial",Font.BOLD,18);
		
		
		//easy
		easyButton=new JButton("Easy");
		easyButton.setBounds(200,90,200,50);
		easyButton.setFont(font);
		easyButton.setBackground(Color.lightGray);
		easyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null,"Start Game..");
				AlphaBetaChess z1 = new AlphaBetaChess(2);
				z1.setup();
				dispose();
			}
		});
		cntnr.add(easyButton);
		
		
		//medium
		mediumButton=new JButton("Medium");
		mediumButton.setBounds(200,190,200,50);
		mediumButton.setFont(font);
		mediumButton.setBackground(Color.lightGray);
		mediumButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null,"Start Game..");
				AlphaBetaChess z2 = new AlphaBetaChess(4);
				z2.setup();
				dispose();
			}	
		});
		cntnr.add(mediumButton);
		
		
		//hard
		hardButton=new JButton("Hard");
		hardButton.setBounds(200,290,200,50);
		hardButton.setFont(font);
		hardButton.setBackground(Color.lightGray);
		hardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null,"Star Game....");
				AlphaBetaChess z3 = new AlphaBetaChess(6);
				z3.setup();
				dispose();
			}
		});
		cntnr.add(hardButton);
	}
	
}



