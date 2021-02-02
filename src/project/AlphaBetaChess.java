package project;

import java.util.Arrays;

import javax.swing.*;

public class AlphaBetaChess {
	
	
    static String chessBoard[][]={
        {"r","k","b","q","a","b","k","r"},
        {"p","p","p","p","p","p","p","p"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"P","P","P","P","P","P","P","P"},
        {"R","K","B","Q","A","B","K","R"}};
    
    static int kingPositionC, kingPositionL;
    static int humanAsWhite=-1;//1=human as white, 0=human as black
    static int globalDepth;
    
    
    AlphaBetaChess(int depth)
    {
    	globalDepth=depth;
    }
    
    
    public static void main(String[] args) {
    	setup();  
    }
    
    
    public static void setup() {
    	
    	while (!"A".equals(chessBoard[kingPositionC/8][kingPositionC%8])) {kingPositionC++;}//get King's location
        while (!"a".equals(chessBoard[kingPositionL/8][kingPositionL%8])) {kingPositionL++;}//get king's location
        
        JFrame frame=new JFrame("Wizerd Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        UserInterface ui=new UserInterface();
        frame.add(ui);
        
        frame.setSize(1022, 1060);
        frame.setVisible(true);
        
        
        System.out.println(MovesSorting.sortMoves(PossibleMoves.posibleMoves()));
        
        
        Object[] option={"Computer","Human"};
        humanAsWhite=JOptionPane.showOptionDialog(null, "Who will move first?", "Move Options", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
        
        if (humanAsWhite==0) {
            long startTime=System.currentTimeMillis();
            Move.makeMove(alphaBeta(globalDepth, 1000000, -1000000, "", 0));
            long endTime=System.currentTimeMillis();
            System.out.println("That took "+(endTime-startTime)+" milliseconds");
            FlipBoard.flipBoard();
            frame.repaint();
        }
        
//        makeMove("7655 ");
//        undoMove("7655 ");
        
        //print the board
        for (int i=0;i<8;i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
        
    }
    
    
    
    //AI
    public static String alphaBeta(int depth, int beta, int alpha, String move, int player) {
        //return in the form of 1234b##########
        String list=PossibleMoves.posibleMoves();
        if (depth==0 || list.length()==0) {return move+(Rating.rating(list.length(), depth)*(player*2-1));}
        list=MovesSorting.sortMoves(list);
        
        player=1-player;//either 1 or 0
        
        for (int i=0;i<list.length();i+=5) {
            Move.makeMove(list.substring(i,i+5));
            FlipBoard.flipBoard();
            
            String returnString=alphaBeta(depth-1, beta, alpha, list.substring(i,i+5), player);
            int value=Integer.valueOf(returnString.substring(5));
            FlipBoard.flipBoard();
            Move.undoMove(list.substring(i,i+5));
            
            if (player==0) {
                if (value<=beta) {beta=value; if (depth==globalDepth) {move=returnString.substring(0,5);}}
            } else {
                if (value>alpha) {alpha=value; if (depth==globalDepth) {move=returnString.substring(0,5);}}
            }
            if (alpha>=beta) {
                if (player==0) {return move+beta;} else {return move+alpha;}
            }
        }
        if (player==0) {return move+beta;} else {return move+alpha;}
    }
    
    
    
    //Flip the board
	/**
	 * @deprecated Use {@link FlipBoard#flipBoard()} instead
	 */
	public static void flipBoard() {
		FlipBoard.flipBoard();
	}
    
    
    
    //make move
	/**
	 * @deprecated Use {@link Move#makeMove(String)} instead
	 */
	public static void makeMove(String move) {
		Move.makeMove(move);
	}
    
    //undo move
	/**
	 * @deprecated Use {@link Move#undoMove(String)} instead
	 */
	public static void undoMove(String move) {
		Move.undoMove(move);
	}
    
   
    
    //possible moves
	/**
	 * @deprecated Use {@link PossibleMoves#posibleMoves()} instead
	 */
	public static String posibleMoves() {
		return PossibleMoves.posibleMoves();
	}
    
    
    
    //Pawn
	/**
	 * @deprecated Use {@link PossiblePawnMoves#possiblePawnMove(int)} instead
	 */
	public static String possiblePawnMove(int i) {
		return PossiblePawnMoves.possiblePawnMove(i);
	}
    
    
    
    //Rock
	/**
	 * @deprecated Use {@link PossibleRockMoves#possibleRockMove(int)} instead
	 */
	public static String possibleRockMove(int i) {
		return PossibleRockMoves.possibleRockMove(i);
	}
    
    
    
    //knight
	/**
	 * @deprecated Use {@link PossibleKnightMoves#possibleKnightMove(int)} instead
	 */
	public static String possibleKnightMove(int i) {
		return PossibleKnightMoves.possibleKnightMove(i);
	}
    
    
    
    //bishop
	/**
	 * @deprecated Use {@link PossibleBishopMoves#possibleBishopMove(int)} instead
	 */
	public static String possibleBishopMove(int i) {
		return PossibleBishopMoves.possibleBishopMove(i);
	}
    
    
    
    //Queen
	/**
	 * @deprecated Use {@link PossibleQueenMoves#possibleQueenMove(int)} instead
	 */
	public static String possibleQueenMove(int i) {
		return PossibleQueenMoves.possibleQueenMove(i);
	}
    
    
    
    //king
	/**
	 * @deprecated Use {@link PossibleKingMoves#possibleKingMove(int)} instead
	 */
	public static String possibleKingMove(int i) {
		return PossibleKingMoves.possibleKingMove(i);
	} 
    
    
    
    //King safe
	/**
	 * @deprecated Use {@link CheckKingSafety#isKingSafe()} instead
	 */
	public static boolean isKingSafe() {
		return CheckKingSafety.isKingSafe();
	}
    
    
    
	//Sort Moves
	/**
	 * @deprecated Use {@link MovesSorting#sortMoves(String)} instead
	 */
	public static String sortMoves(String list) {
		return MovesSorting.sortMoves(list);
	}
    
    
}
