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
        
        
        System.out.println(sortMoves(PossibleMoves.posibleMoves()));
        
        
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
        list=sortMoves(list);
        
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
    
    
    
    //pawn
    public static String possiblePawnMove(int i) {
        String list="", oldPiece;
        int r=i/8, c=i%8;
        for (int j=-1; j<=1; j+=2) {
        	
        	//capture
            try {
                if (Character.isLowerCase(chessBoard[r-1][c+j].charAt(0)) && i>=16) {
                    oldPiece=chessBoard[r-1][c+j];
                    chessBoard[r][c]=" ";
                    chessBoard[r-1][c+j]="P";
                    if (isKingSafe()) {
                        list=list+r+c+(r-1)+(c+j)+oldPiece;
                    }
                    chessBoard[r][c]="P";
                    chessBoard[r-1][c+j]=oldPiece;
                }
            } catch (Exception e) {}
            
          //promotion && capture
            try {
                if (Character.isLowerCase(chessBoard[r-1][c+j].charAt(0)) && i<16) {
                    String[] temp={"Q","R","B","K"};
                    for (int k=0; k<4; k++) {
                        oldPiece=chessBoard[r-1][c+j];
                        chessBoard[r][c]=" ";
                        chessBoard[r-1][c+j]=temp[k];
                        if (isKingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list=list+c+(c+j)+oldPiece+temp[k]+"P";
                        }
                        chessBoard[r][c]="P";
                        chessBoard[r-1][c+j]=oldPiece;
                    }
                }
            } catch (Exception e) {}
        }
        
      //move one up
        try {
            if (" ".equals(chessBoard[r-1][c]) && i>=16) {
                oldPiece=chessBoard[r-1][c];
                chessBoard[r][c]=" ";
                chessBoard[r-1][c]="P";
                if (isKingSafe()) {
                    list=list+r+c+(r-1)+c+oldPiece;
                }
                chessBoard[r][c]="P";
                chessBoard[r-1][c]=oldPiece;
            }
        } catch (Exception e) {}
        
        
      //promotion && no capture
        try {
            if (" ".equals(chessBoard[r-1][c]) && i<16) {
                String[] temp={"Q","R","B","K"};
                for (int k=0; k<4; k++) {
                    oldPiece=chessBoard[r-1][c];
                    chessBoard[r][c]=" ";
                    chessBoard[r-1][c]=temp[k];
                    if (isKingSafe()) {
                        //column1,column2,captured-piece,new-piece,P
                        list=list+c+c+oldPiece+temp[k]+"P";
                    }
                    chessBoard[r][c]="P";
                    chessBoard[r-1][c]=oldPiece;
                }
            }
        } catch (Exception e) {}
        
        
      //move two up
        try {
            if (" ".equals(chessBoard[r-1][c]) && " ".equals(chessBoard[r-2][c]) && i>=48) {
                oldPiece=chessBoard[r-2][c];
                chessBoard[r][c]=" ";
                chessBoard[r-2][c]="P";
                if (isKingSafe()) {
                    list=list+r+c+(r-2)+c+oldPiece;
                }
                chessBoard[r][c]="P";
                chessBoard[r-2][c]=oldPiece;
            }
        } catch (Exception e) {}
        return list;
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
    
    
    
    //king safe
    public static boolean isKingSafe() {
    	
        //bishop/queen
        int temp=1;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j])) {temp++;}
                    if ("b".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j]) ||
                            "q".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        
        //rook/queen
        for (int i=-1; i<=1; i+=2) {
            try {
                while(" ".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i])) {temp++;}
                if ("r".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i]) ||
                        "q".equals(chessBoard[kingPositionC/8][kingPositionC%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8])) {temp++;}
                if ("r".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8]) ||
                        "q".equals(chessBoard[kingPositionC/8+temp*i][kingPositionC%8])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
        }
        
        //knight
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    if ("k".equals(chessBoard[kingPositionC/8+i][kingPositionC%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {}
                try {
                    if ("k".equals(chessBoard[kingPositionC/8+i*2][kingPositionC%8+j])) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        
        //pawn
        if (kingPositionC>=16) {
            try {
                if ("p".equals(chessBoard[kingPositionC/8-1][kingPositionC%8-1])) {
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("p".equals(chessBoard[kingPositionC/8-1][kingPositionC%8+1])) {
                    return false;
                }
            } catch (Exception e) {}
            
            //king
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (i!=0 || j!=0) {
                        try {
                            if ("a".equals(chessBoard[kingPositionC/8+i][kingPositionC%8+j])) {
                                return false;
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return true;
    }
    
    
    
  //sort moves
    public static String sortMoves(String list) {
        int[] score=new int [list.length()/5];
        for (int i=0;i<list.length();i+=5) {
            Move.makeMove(list.substring(i, i+5));
            score[i/5]=-Rating.rating(-1, 0);
            Move.undoMove(list.substring(i, i+5));
        }
        String newListA="", newListB=list;
        for (int i=0;i<Math.min(6, list.length()/5);i++) {//first few moves only
            int max=-1000000, maxLocation=0;
            for (int j=0;j<list.length()/5;j++) {
                if (score[j]>max) {max=score[j]; maxLocation=j;}
            }
            score[maxLocation]=-1000000;
            newListA+=list.substring(maxLocation*5,maxLocation*5+5);
            newListB=newListB.replace(list.substring(maxLocation*5,maxLocation*5+5), "");
        }
        return newListA+newListB;
    }
    
    
}
