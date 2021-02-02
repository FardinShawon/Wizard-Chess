/**
 * 
 */
package project;

/**
 * @author shuvra
 *
 */
public class PossibleRockMoves {

	//Rock
	public static String possibleRockMove(int i) {
	    String list="", oldPiece;
	    int r=i/8, c=i%8;
	    int temp=1;
	    for (int j=-1; j<=1; j+=2) {
	        try {
	            while(" ".equals(AlphaBetaChess.chessBoard[r][c+temp*j]))
	            {
	                oldPiece=AlphaBetaChess.chessBoard[r][c+temp*j];
	                AlphaBetaChess.chessBoard[r][c]=" ";
	                AlphaBetaChess.chessBoard[r][c+temp*j]="R";
	                if (CheckKingSafety.isKingSafe()) {
	                    list=list+r+c+r+(c+temp*j)+oldPiece;
	                }
	                AlphaBetaChess.chessBoard[r][c]="R";
	                AlphaBetaChess.chessBoard[r][c+temp*j]=oldPiece;
	                temp++;
	            }
	            if (Character.isLowerCase(AlphaBetaChess.chessBoard[r][c+temp*j].charAt(0))) {
	                oldPiece=AlphaBetaChess.chessBoard[r][c+temp*j];
	                AlphaBetaChess.chessBoard[r][c]=" ";
	                AlphaBetaChess.chessBoard[r][c+temp*j]="R";
	                if (CheckKingSafety.isKingSafe()) {
	                    list=list+r+c+r+(c+temp*j)+oldPiece;
	                }
	                AlphaBetaChess.chessBoard[r][c]="R";
	                AlphaBetaChess.chessBoard[r][c+temp*j]=oldPiece;
	            }
	        } catch (Exception e) {}
	        temp=1;
	        try {
	            while(" ".equals(AlphaBetaChess.chessBoard[r+temp*j][c]))
	            {
	                oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c];
	                AlphaBetaChess.chessBoard[r][c]=" ";
	                AlphaBetaChess.chessBoard[r+temp*j][c]="R";
	                if (CheckKingSafety.isKingSafe()) {
	                    list=list+r+c+(r+temp*j)+c+oldPiece;
	                }
	                AlphaBetaChess.chessBoard[r][c]="R";
	                AlphaBetaChess.chessBoard[r+temp*j][c]=oldPiece;
	                temp++;
	            }
	            if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+temp*j][c].charAt(0))) {
	                oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c];
	                AlphaBetaChess.chessBoard[r][c]=" ";
	                AlphaBetaChess.chessBoard[r+temp*j][c]="R";
	                if (CheckKingSafety.isKingSafe()) {
	                    list=list+r+c+(r+temp*j)+c+oldPiece;
	                }
	                AlphaBetaChess.chessBoard[r][c]="R";
	                AlphaBetaChess.chessBoard[r+temp*j][c]=oldPiece;
	            }
	        } catch (Exception e) {}
	        temp=1;
	    }
	    return list;
	}

}
