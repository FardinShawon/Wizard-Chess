package project;

public class FlipBoard {

	//Flip the board
	public static void flipBoard() {
	    String temp;
	    for (int i=0;i<32;i++) {
	        int r=i/8, c=i%8;
	        if (Character.isUpperCase(AlphaBetaChess.chessBoard[r][c].charAt(0))) {
	            temp=AlphaBetaChess.chessBoard[r][c].toLowerCase();
	        } else {
	            temp=AlphaBetaChess.chessBoard[r][c].toUpperCase();
	        }
	        if (Character.isUpperCase(AlphaBetaChess.chessBoard[7-r][7-c].charAt(0))) {
	            AlphaBetaChess.chessBoard[r][c]=AlphaBetaChess.chessBoard[7-r][7-c].toLowerCase();
	        } else {
	            AlphaBetaChess.chessBoard[r][c]=AlphaBetaChess.chessBoard[7-r][7-c].toUpperCase();
	        }
	        AlphaBetaChess.chessBoard[7-r][7-c]=temp;
	    }
	    int kingTemp=AlphaBetaChess.kingPositionC;
	    AlphaBetaChess.kingPositionC=63-AlphaBetaChess.kingPositionL;
	    AlphaBetaChess.kingPositionL=63-kingTemp;
	}

}
