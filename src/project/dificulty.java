package project;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class dificulty extends JFrame {
	private Container c;
	private JButton b1,b2,b3;
	private Font f;
		
		dificulty()
		{
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,300,650,450);
			setTitle("Step ...");
			setResizable(false);
			c=this.getContentPane();
			c.setLayout(null);
			c.setBackground(Color.LIGHT_GRAY);
			f=new Font("Arial",Font.BOLD,18);
			
			
			//easy
			b1=new JButton("Easy");
			b1.setBounds(200,90,200,50);
			b1.setFont(f);
			b1.setBackground(Color.lightGray);
			c.add(b1);
			
			b1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//JOptionPane.showMessageDialog(null,"Start Game..");
					
					AlphaBetaChess z1 = new AlphaBetaChess(2);
					z1.setup();
					dispose();
				}
				
				
			});
			
			
			
			//medium
			b2=new JButton("Medium");
			b2.setBounds(200,190,200,50);
			b2.setFont(f);
			b2.setBackground(Color.lightGray);
			
			c.add(b2);
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//JOptionPane.showMessageDialog(null,"Start Game..");
					
					AlphaBetaChess z2 = new AlphaBetaChess(4);
					z2.setup();
					dispose();
				}
				
				
			});
			
			b3=new JButton("Hard");
			b3.setBounds(200,290,200,50);
			b3.setFont(f);
			b3.setBackground(Color.lightGray);
			
			c.add(b3);
			
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//JOptionPane.showMessageDialog(null,"Star Game....");
					
					AlphaBetaChess z3 = new AlphaBetaChess(6);
					z3.setup();
					dispose();
				}
				
				
			});
		}

		public static void main(String[] args) {
dificulty f=new dificulty ();

f.setVisible(true);



		}

	}



