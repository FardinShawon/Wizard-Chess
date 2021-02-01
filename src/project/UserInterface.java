package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

import java.io.FileReader;

import javax.swing.*;

public class UserInterface extends JPanel implements MouseListener, MouseMotionListener{
	
	int boardChoiceIndicator;
	FileReader file;
	Character indicator=new Character('0');	
    static int mouseX, mouseY, newMouseX, newMouseY,tempx,tempy, x, y;
    static int squareSize=128;
//    static Graphics g;
    
//    g.addMouseListener(g);
//    this.addMouseMotionListener(this);
    
    
    @Override
    public void paintComponent(Graphics g) {
    	
    	try {
    		//file= new FileReader("D:\\choice1.txt");
    		file= new FileReader("/media/shuvra/New Volume/IIT/3rd semester/Project/Chess/Codechoice1.txt");
    		boardChoiceIndicator=file.read();
    		 indicator=(char)boardChoiceIndicator;
    	    //System.out.println("char :"+c);
    	}
    	catch(Exception e){
    	
    	}
    	
        super.paintComponent(g);
        this.setBackground(Color.yellow);
        addMouseListener(this);
        addMouseMotionListener(this);
       

        //board 1
        if(indicator.equals('1'))
        {
        	System.out.println("1");
        
        	for (int i=0;i<64;i+=2) {
                g.setColor(new Color(229, 216, 243));
                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
                g.setColor(new Color(153, 102, 204));
                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
            }
        }
        
     
        //board 2
        if(indicator.equals('2'))
        {
        	System.out.println("2");
        
        	for (int i=0;i<64;i+=2) {
                g.setColor(new Color(230, 230, 230));
                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
                g.setColor(new Color(123, 104, 238));
                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
            }
        }
        
        
        //board 3
        if(indicator.equals('3'))
        {
        	//System.out.println("3");
        
        	 for (int i=0;i<64;i+=2) {
                 g.setColor(new Color(233, 246, 251));
                 g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
                 g.setColor(new Color(123, 164, 40));
                 g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
             }
        }
        
        
        
        //board 4
        if(indicator.equals('4'))
        {
        	System.out.println("4");
        
        	for (int i=0;i<64;i+=2) {
                g.setColor(new Color(255, 247, 204));
                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
                g.setColor(new Color(51, 153, 95));
                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
            }
        }
        
        
        
        //board 5
        if(indicator.equals('5'))
        {
        	System.out.println("5");
        
        	for (int i=0;i<64;i+=2) {
                g.setColor(new Color(233, 246, 251));
                g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
                g.setColor(new Color(123, 164, 40));
                g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
            }
        }
        
        
        
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
                g.drawImage(chessPiecesImage, (i%8)*squareSize, (i/8)*squareSize, (i%8+1)*squareSize, (i/8+1)*squareSize, j*64, k*64, (j+1)*64, (k+1)*64, this);
            }
        }  
    }
    
    
    //Mouse functionality
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            //if inside the board
            mouseX=e.getX();
            mouseY=e.getY();
            repaint();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX()<8*squareSize &&e.getY()<8*squareSize) {
            //if inside the board
            newMouseX=e.getX();
            newMouseY=e.getY();
            if (e.getButton()==MouseEvent.BUTTON1) {
                String dragMove;
                if (newMouseY/squareSize==0 && mouseY/squareSize==1 && "P".equals(AlphaBetaChess.chessBoard[mouseY/squareSize][mouseX/squareSize])) {
                    //pawn promotion
                    dragMove=""+mouseX/squareSize+newMouseX/squareSize+AlphaBetaChess.chessBoard[newMouseY/squareSize][newMouseX/squareSize]+"QP";
                } else {
                    //regular move
                    dragMove=""+mouseY/squareSize+mouseX/squareSize+newMouseY/squareSize+newMouseX/squareSize+AlphaBetaChess.chessBoard[newMouseY/squareSize][newMouseX/squareSize];
                }
                String userPosibilities=AlphaBetaChess.posibleMoves();
                if (userPosibilities.replaceAll(dragMove, "").length()<userPosibilities.length()) {
                    //if valid move
                    Move.makeMove(dragMove);
                    FlipBoard.flipBoard();
//                    repaint();
                    Move.makeMove(AlphaBetaChess.alphaBeta(AlphaBetaChess.globalDepth, 1000000, -1000000, "", 0));
                    FlipBoard.flipBoard();
                    repaint();
                }
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    	tempx = e.getX();
    	tempy = e.getY();
    	x=tempx/squareSize;
    	y=tempy/squareSize;
    	tempx=x*squareSize;
    	tempy=y*squareSize;
    	
    	HighLight h = new HighLight(tempx, tempy, squareSize);
    	h.paintComponent(getGraphics());
    	
    	PossibleMovesHighlight pmh = new PossibleMovesHighlight(x, y, squareSize, getGraphics());
    	pmh.Draw();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
