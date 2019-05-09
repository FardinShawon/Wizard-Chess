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

public class boardchoice extends JFrame {

	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	private Container c;
	private Font f;
	private ImageIcon img1,img2,img3,img4,img5;
	private static FileWriter file;
	private static int choice;
	public int getChoice() {
		return choice;
	}
	boardchoice()
	{
		
	   try {
		file = new FileWriter("D:\\choice1.txt");
		//file.write("0");
	
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
		c=this.getContentPane();
		c.setBackground(Color.CYAN);
		c.setLayout(null);
		f=new Font("Arial",Font.BOLD,18);
		img1=new ImageIcon("image/board5.JPG");
		img2=new ImageIcon("image/board1.JPG");
		img3=new ImageIcon("image/board3.JPG");
		img4=new ImageIcon("image/board4.JPG");
		img5=new ImageIcon("image/board2.JPG");
		
		b1=new JButton(img1);
		b1.setBounds(500,300,250,60);
		b1.setForeground(Color.black);
		b1.setBackground(Color.lightGray);
		b1.setFont(f);
		//imglabel.add(b1);
	// img1 = new ImageIcon("image/board1.JPG");
	    //JButton button = new JButton(icon1);
	   // frame.add(button);
		c.add(b1);
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
			mainboard1 s1=new mainboard1 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);}
			
				
			});
		
		b2=new JButton(img2);
		b2.setBounds(500, 400,250,60);
		b2.setForeground(Color.black);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setFont(f);
		//imglabel.add(b2);
		c.add(b2);
		//c.add(imglabel);
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
			mainboard2 s1=new mainboard2 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);}
			
				
			});
		b3=new JButton(img4);
		b3.setBounds(500, 500,250,60);
		b3.setForeground(Color.black);
		b3.setBackground(Color.LIGHT_GRAY);
		b3.setFont(f);
		//imglabel.add(b2);
		c.add(b3);
		//c.add(imglabel);
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
			mainboard3 s1=new mainboard3 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);}
			
				
			}); 
		
		b4=new JButton(img3);
		b4.setBounds(500, 600,250,60);
		b4.setForeground(Color.black);
		b4.setBackground(Color.LIGHT_GRAY);
		b4.setFont(f);
		//imglabel.add(b2);
		c.add(b4);
		//c.add(imglabel);
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
			mainboard4 s1=new mainboard4 ();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);}
			
				
			});
		
		b5=new JButton(img5);
		b5.setBounds(500, 700,250,60);
		b5.setForeground(Color.black);
		b5.setBackground(Color.LIGHT_GRAY);
		b5.setFont(f);
		//imglabel.add(b2);
		c.add(b5);
		//c.add(imglabel);
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
			mainboard5 s1=new mainboard5();
			//s1.setBounds(50,20,1042, 1065);
			s1.setVisible(true);}
			
				
			});
		
		b6=new JButton("Accept-Board1");
		b6.setBounds(200, 300,250,60);
		b6.setForeground(Color.black);
		b6.setBackground(Color.LIGHT_GRAY);
		b6.setFont(f);
		c.add(b6);
		
		b6.addActionListener(new ActionListener() {

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
		
		b7=new JButton("Accept-Board2");
		b7.setBounds(200, 400,250,60);
		b7.setForeground(Color.black);
		b7.setBackground(Color.LIGHT_GRAY);
		b7.setFont(f);
		c.add(b7);
		
		b7.addActionListener(new ActionListener() {

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
		
		b8=new JButton("Accept-Board3");
		b8.setBounds(200, 500,250,60);
		b8.setForeground(Color.black);
		b8.setBackground(Color.LIGHT_GRAY);
		b8.setFont(f);
		c.add(b8);
		
		b8.addActionListener(new ActionListener() {

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
		
		b9=new JButton("Accept-Board4");
		b9.setBounds(200, 600,250,60);
		b9.setForeground(Color.black);
		b9.setBackground(Color.LIGHT_GRAY);
		b9.setFont(f);
		c.add(b9);
		
		b9.addActionListener(new ActionListener() {

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
		
		b10=new JButton("Accept-Board5");
		b10.setBounds(200, 700,250,60);
		b10.setForeground(Color.black);
		b10.setBackground(Color.LIGHT_GRAY);
		b10.setFont(f);
		c.add(b10);
		
		b10.addActionListener(new ActionListener() {

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

		b11=new JButton("Back");
		b11.setBounds(300,800,250,60);
		b11.setForeground(Color.black);
		b11.setBackground(Color.LIGHT_GRAY);
		b11.setFont(f);
		
		c.add(b11);
		b11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				chessfont s1=new chessfont();
			s1.setBounds(50,20,1000,1000);
			s1.setVisible(true);
			
				
			}
			
			
			
		});
		
	}
	

	public static void main(String[] args) {
		
		
		boardchoice frame =new boardchoice();
		//UserInterface f=new UserInterface(frame);
		frame.setBounds(50,50,1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

