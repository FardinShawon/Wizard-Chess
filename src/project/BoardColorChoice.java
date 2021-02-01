package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoardColorChoice extends JFrame {

	private JButton board1Button,board2Button,board3Button,board4Button,board5Button,board1AcceptButton,board2AcceptButton,board3AcceptButton,board5AcceptButton,board4AcceptButton,backButton;
	private Container cntnr;
	private Font font;
	private ImageIcon img1,img2,img3,img4,img5;
	private static FileWriter file;
	private static int choice;
	
	public int getChoice() {
		return choice;
	}
	
	
	BoardColorChoice()
	{
	   try {
		//file = new FileWriter("D:\\choice1.txt");
		file = new FileWriter("/media/shuvra/New Volume/IIT/3rd semester/Project/Chess/Codechoice1.txt");
		} 
	   catch (IOException e1) {
			e1.printStackTrace();// TODO Auto-generated catch block
		} 
	   
	   	this.setTitle("Board's Color Choice");
	   	this.setBounds(50,50,1000,1000);
	   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	this.setVisible(true);
	   
		cntnr=this.getContentPane();
		cntnr.setBackground(Color.CYAN);
		cntnr.setLayout(null);
		font=new Font("Arial",Font.BOLD,18);
		
		//Image
		img1=new ImageIcon("image/board1.JPG");
		img2=new ImageIcon("image/board2.JPG");
		img3=new ImageIcon("image/board3.JPG");
		img4=new ImageIcon("image/board4.JPG");
		img5=new ImageIcon("image/board5.JPG");
		
		
		//Board 1
		board1Button=new JButton(img1);
		board1Button.setBounds(500,300,250,60);
		board1Button.setForeground(Color.black);
		board1Button.setBackground(Color.lightGray);
		board1Button.setFont(font);
		board1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mainboard1 s1=new mainboard1 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);
			}
		});
		cntnr.add(board1Button);
		
		
		//Board 2
		board2Button=new JButton(img2);
		board2Button.setBounds(500, 400,250,60);
		board2Button.setForeground(Color.black);
		board2Button.setBackground(Color.LIGHT_GRAY);
		board2Button.setFont(font);
		board2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mainboard2 s1=new mainboard2 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);
			}
		});
		cntnr.add(board2Button);
		
		
		//Board 3
		board3Button=new JButton(img4);
		board3Button.setBounds(500, 500,250,60);
		board3Button.setForeground(Color.black);
		board3Button.setBackground(Color.LIGHT_GRAY);
		board3Button.setFont(font);
		board3Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mainboard3 s1=new mainboard3 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);
		    }
		}); 
		cntnr.add(board3Button);
		
		
		//Board 4
		board4Button=new JButton(img3);
		board4Button.setBounds(500, 600,250,60);
		board4Button.setForeground(Color.black);
		board4Button.setBackground(Color.LIGHT_GRAY);
		board4Button.setFont(font);
		board4Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mainboard4 s1=new mainboard4 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);
			}
		});
		cntnr.add(board4Button);
		
		
		//Board 5
		board5Button=new JButton(img5);
		board5Button.setBounds(500, 700,250,60);
		board5Button.setForeground(Color.black);
		board5Button.setBackground(Color.LIGHT_GRAY);
		board5Button.setFont(font);
		board5Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mainboard5 s1=new mainboard5();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);
			}
		});
		cntnr.add(board5Button);
		
		//Accept board 1 
		board1AcceptButton=new JButton("Accept-Board1");
		board1AcceptButton.setBounds(200, 300,250,60);
		board1AcceptButton.setForeground(Color.black);
		board1AcceptButton.setBackground(Color.LIGHT_GRAY);
		board1AcceptButton.setFont(font);
		board1AcceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice=1;
				try {
					file.write("1");
					file.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		cntnr.add(board1AcceptButton);
		
		
		////Accept board 2
		board2AcceptButton=new JButton("Accept-Board2");
		board2AcceptButton.setBounds(200, 400,250,60);
		board2AcceptButton.setForeground(Color.black);
		board2AcceptButton.setBackground(Color.LIGHT_GRAY);
		board2AcceptButton.setFont(font);
		board2AcceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice=2;
				try {
					file.write("2");
					file.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cntnr.add(board2AcceptButton);
		
		
		//Accept board 3
		board3AcceptButton=new JButton("Accept-Board3");
		board3AcceptButton.setBounds(200, 500,250,60);
		board3AcceptButton.setForeground(Color.black);
		board3AcceptButton.setBackground(Color.LIGHT_GRAY);
		board3AcceptButton.setFont(font);
		board3AcceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice=3;
				try {
					file.write("3");
					file.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cntnr.add(board3AcceptButton);
		
		
		//Accept board 4
		board4AcceptButton=new JButton("Accept-Board5");
		board4AcceptButton.setBounds(200, 700,250,60);
		board4AcceptButton.setForeground(Color.black);
		board4AcceptButton.setBackground(Color.LIGHT_GRAY);
		board4AcceptButton.setFont(font);
		board4AcceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					file.write("5");
					file.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		cntnr.add(board4AcceptButton);
		
		
		//Accept board 5
		board5AcceptButton=new JButton("Accept-Board4");
		board5AcceptButton.setBounds(200, 600,250,60);
		board5AcceptButton.setForeground(Color.black);
		board5AcceptButton.setBackground(Color.LIGHT_GRAY);
		board5AcceptButton.setFont(font);
		board5AcceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice=4;
				try {
					file.flush();
					file.write("4");
					file.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
				
		});
		cntnr.add(board5AcceptButton);
		
		
		
		//Back button
		backButton=new JButton("Back");
		backButton.setBounds(300,800,250,60);
		backButton.setForeground(Color.black);
		backButton.setBackground(Color.lightGray);
		backButton.setFont(font);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				FrontScreen s1=new FrontScreen();
				s1.setBounds(50,20,1000,670);
				s1.setVisible(true);	
			}			
		});
		cntnr.add(backButton);
	}
	
}

