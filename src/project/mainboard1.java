package project;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

//import userinterface.board1;

public class mainboard1 extends JFrame {
	private Container c;
	private JButton b1;
	
	mainboard1()
	{

		
		
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        board1 ui=new board1();
        add(ui);
       setSize(1043, 1065);
      setVisible(true);
		
      /*c = this.getContentPane();
      b1=new JButton("Accept");
      b1.setBounds(1200,50,100,50);
c.add(b1);*/
	}
	
	 public static void main(String[] args) {
	        
	        JFrame f=new JFrame("Chess Tutorial");
	        }
}

