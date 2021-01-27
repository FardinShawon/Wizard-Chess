package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class HighLight {
	
	private static final String BorderFactory = null;

	UserInterface u1 = new UserInterface(); 
	
	int x, y, square;
	
	
	HighLight(int x, int y, int square)
	{
		this.x=x;
		this.y=y;
		this.square=square;
	}
	
	public void paintComponent(Graphics g)
	{	
		g.setColor(new Color(255, 0, 0));
		//g.setStoke(5);
//		Border l = BorderFactory.createLineBorder();
        g.fillRect(x, y, square, square);
       
//        Rectangle rect = new Rectangle(x, y, square, square);
//        rect.set
      
        
        
        
        //chess image
        Image chessPiecesImage;
        chessPiecesImage=new ImageIcon("ChessPieces.png").getImage();
        for (int i=0;i<64;i++) {
            int j=-1,k=-1;
            switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
                case "P": j=5; k=0;
                    break;
                case "p": j=5; k=1;
                    break;
                case "R": j=2; k=0;
                    break;
                case "r": j=2; k=1;
                    break;
                case "K": j=4; k=0;
                    break;
                case "k": j=4; k=1;
                    break;
                case "B": j=3; k=0;
                    break;
                case "b": j=3; k=1;
                    break;
                case "Q": j=1; k=0;
                    break;
                case "q": j=1; k=1;
                    break;
                case "A": j=0; k=0;
                    break;
                case "a": j=0; k=1;
                    break;
            }
            if (j!=-1 && k!=-1) {
                g.drawImage(chessPiecesImage, (i%8)*square, (i/8)*square, (i%8+1)*square, (i/8+1)*square, j*64, k*64, (j+1)*64, (k+1)*64, u1);
            	}
        	}
        }	
	}


