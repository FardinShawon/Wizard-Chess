/**
 * 
 */
package project;

/**
 * @author shuvra
 *
 */
public class PossibleKnightMoves {

	//knight
	public static String possibleKnightMove(int i) {
	    String list="", oldPiece;
	    int r=i/8, c=i%8;
	    for (int j=-1; j<=1; j+=2) {
	        for (int k=-1; k<=1; k+=2) {
	            try {
	                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+j][c+k*2].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r+j][c+k*2])) {
	                    oldPiece=AlphaBetaChess.chessBoard[r+j][c+k*2];
	                    AlphaBetaChess.chessBoard[r][c]=" ";
	                    if (AlphaBetaChess.isKingSafe()) {
	                        list=list+r+c+(r+j)+(c+k*2)+oldPiece;
	                    }
	                    AlphaBetaChess.chessBoard[r][c]="K";
	                    AlphaBetaChess.chessBoard[r+j][c+k*2]=oldPiece;
	                }
	            } catch (Exception e) {}
	            try {
	                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+j*2][c+k].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r+j*2][c+k])) {
	                    oldPiece=AlphaBetaChess.chessBoard[r+j*2][c+k];
	                    AlphaBetaChess.chessBoard[r][c]=" ";
	                    if (AlphaBetaChess.isKingSafe()) {
	                        list=list+r+c+(r+j*2)+(c+k)+oldPiece;
	                    }
	                    AlphaBetaChess.chessBoard[r][c]="K";
	                    AlphaBetaChess.chessBoard[r+j*2][c+k]=oldPiece;
	                }
	            } catch (Exception e) {}
	        }
	    }
	    return list;
	}

}
