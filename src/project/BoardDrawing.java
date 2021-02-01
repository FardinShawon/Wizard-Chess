package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardDrawing {
	
//	static int squareSize=128;
//
//	@Override
//    public void paintComponent(Graphics g) {
//    	int boardChoiceIndicator;
//    	FileReader file;
//    	Character indicator=new Character('0');	
//    	
//    	try {
//    		//file= new FileReader("D:\\choice1.txt");
//    		file= new FileReader("/media/shuvra/New Volume/IIT/3rd semester/Project/Chess/Codechoice1.txt");
//    		boardChoiceIndicator=file.read();
//    		 indicator=(char)boardChoiceIndicator;
//    	    //System.out.println("char :"+c);
//    	}
//    	catch(Exception e)
//    	{
//    	
//    	}
//    	
//        super.paintComponent(g);
//        this.setBackground(Color.yellow);
//        this.addMouseListener(this);
//        this.addMouseMotionListener(this);
//       
//
//        //board 1
//        if(indicator.equals('1'))
//        {
//        	System.out.println("1");
//        
//        	for (int i=0;i<64;i+=2) {
//                g.setColor(new Color(229, 216, 243));
//                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
//                g.setColor(new Color(153, 102, 204));
//                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
//            }
//        }
//        
//     
//        //board 2
//        if(indicator.equals('2'))
//        {
//        	System.out.println("2");
//        
//        	for (int i=0;i<64;i+=2) {
//                g.setColor(new Color(230, 230, 230));
//                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
//                g.setColor(new Color(123, 104, 238));
//                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
//            }
//        }
//        
//        
//         
//        //board 3
//        if(indicator.equals('3'))
//        {
//        	//System.out.println("3");
//        
//        	 for (int i=0;i<64;i+=2) {
//                 g.setColor(new Color(233, 246, 251));
//                 g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
//                 g.setColor(new Color(123, 164, 40));
//                 g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
//             }
//        }
//        
//        
//        
//        //board 4
//        if(indicator.equals('4'))
//        {
//        	System.out.println("4");
//        
//        	for (int i=0;i<64;i+=2) {
//                g.setColor(new Color(255, 247, 204));
//                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
//                g.setColor(new Color(51, 153, 95));
//                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
//            }
//        }
//        
//        
//        
//        //board 5
//        if(indicator.equals('5'))
//        {
//        	System.out.println("5");
//        
//        	for (int i=0;i<64;i+=2) {
//                g.setColor(new Color(233, 246, 251));
//                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
//                g.setColor(new Color(123, 164, 40));
//                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
//            }
//        }
//        
//        
//        
//        //chess image
//        Image chessPiecesImage;
//        chessPiecesImage=new ImageIcon("ChessPieces.png").getImage();
//        for (int i=0;i<64;i++) {
//            int j=-1,k=-1;
//            switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
//                case "P": j=5; k=0;
//                    break;
//                case "p": j=5; k=1;
//                    break;
//                case "R": j=2; k=0;
//                    break;
//                case "r": j=2; k=1;
//                    break;
//                case "K": j=4; k=0;
//                    break;
//                case "k": j=4; k=1;
//                    break;
//                case "B": j=3; k=0;
//                    break;
//                case "b": j=3; k=1;
//                    break;
//                case "Q": j=1; k=0;
//                    break;
//                case "q": j=1; k=1;
//                    break;
//                case "A": j=0; k=0;
//                    break;
//                case "a": j=0; k=1;
//                    break;
//            }
//            if (j!=-1 && k!=-1) {
//                g.drawImage(chessPiecesImage, (i%8)*squareSize, (i/8)*squareSize, (i%8+1)*squareSize, (i/8+1)*squareSize, j*64, k*64, (j+1)*64, (k+1)*64, this);
//            }
//        }  
//    }
	
	
}
