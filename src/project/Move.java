package project;

public class Move {

	//make move
	public static void makeMove(String move) {
	    if (move.charAt(4)!='P') {
	        AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))]=AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))];
	        AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))]=" ";
	        if ("A".equals(AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))])) {
	            AlphaBetaChess.kingPositionC=8*Character.getNumericValue(move.charAt(2))+Character.getNumericValue(move.charAt(3));
	        }
	    } else {
	        //if pawn promotion
	        AlphaBetaChess.chessBoard[1][Character.getNumericValue(move.charAt(0))]=" ";
	        AlphaBetaChess.chessBoard[0][Character.getNumericValue(move.charAt(1))]=String.valueOf(move.charAt(3));
	    }
	}

	//undo move
	public static void undoMove(String move) {
	    if (move.charAt(4)!='P') {
	        AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))]=AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))];
	        AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))]=String.valueOf(move.charAt(4));
	        if ("A".equals(AlphaBetaChess.chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))])) {
	            AlphaBetaChess.kingPositionC=8*Character.getNumericValue(move.charAt(0))+Character.getNumericValue(move.charAt(1));
	        }
	    } else {
	        //if pawn promotion
	        AlphaBetaChess.chessBoard[1][Character.getNumericValue(move.charAt(0))]="P";
	        AlphaBetaChess.chessBoard[0][Character.getNumericValue(move.charAt(1))]=String.valueOf(move.charAt(2));
	    }
	}

}
