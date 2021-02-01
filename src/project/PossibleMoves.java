package project;

/**
 * @author shuvra
 *
 */
public class PossibleMoves {

	//possible moves
	public static String posibleMoves() {
	    String list="";
	    for (int i=0; i<64; i++) {
	        switch (AlphaBetaChess.chessBoard[i/8][i%8]) {
	            case "P": list+=AlphaBetaChess.possiblePawnMove(i);
	                break;
	            case "R": list+=PossibleRockMoves.possibleRockMove(i);
	                break;
	            case "K": list+=PossibleKnightMoves.possibleKnightMove(i);
	                break;
	            case "B": list+=PossibleBishopMoves.possibleBishopMove(i);
	                break;
	            case "Q": list+=PossibleQueenMoves.possibleQueenMove(i);
	                break;
	            case "A": list+=AlphaBetaChess.possibleKingMove(i);
	                break;
	        }
	    }
	    return list;//x1,y1,x2,y2,captured piece
	}


}
