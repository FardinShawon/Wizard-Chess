/**
 * 
 */
package project;

/**
 * @author shuvra
 *
 */
public class PossibleBishopMoves {

	//bishop
	public static String possibleBishopMove(int i) {
	    String list="", oldPiece;
	    int r=i/8, c=i%8;
	    int temp=1;
	    for (int j=-1; j<=1; j+=2) {
	        for (int k=-1; k<=1; k+=2) {
	            try {
	                while(" ".equals(AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]))
	                {
	                    oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c+temp*k];
	                    AlphaBetaChess.chessBoard[r][c]=" ";
	                    AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]="B";
	                    if (CheckKingSafety.isKingSafe()) {
	                        list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
	                    }
	                    AlphaBetaChess.chessBoard[r][c]="B";
	                    AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]=oldPiece;
	                    temp++;
	                }
	                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+temp*j][c+temp*k].charAt(0))) {
	                    oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c+temp*k];
	                    AlphaBetaChess.chessBoard[r][c]=" ";
	                    AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]="B";
	                    if (CheckKingSafety.isKingSafe()) {
	                        list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
	                    }
	                    AlphaBetaChess.chessBoard[r][c]="B";
	                    AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]=oldPiece;
	                }
	            } catch (Exception e) {}
	            temp=1;
	        }
	    }
	    return list;
	}

}
