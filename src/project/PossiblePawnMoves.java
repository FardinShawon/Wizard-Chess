/**
 * 
 */
package project;

/**
 * @author shuvra
 *
 */
public class PossiblePawnMoves {

	//pawn
	public static String possiblePawnMove(int i) {
	    String list="", oldPiece;
	    int r=i/8, c=i%8;
	    for (int j=-1; j<=1; j+=2) {
	    	
	    	//capture
	        try {
	            if (Character.isLowerCase(AlphaBetaChess.chessBoard[r-1][c+j].charAt(0)) && i>=16) {
	                oldPiece=AlphaBetaChess.chessBoard[r-1][c+j];
	                AlphaBetaChess.chessBoard[r][c]=" ";
	                AlphaBetaChess.chessBoard[r-1][c+j]="P";
	                if (AlphaBetaChess.isKingSafe()) {
	                    list=list+r+c+(r-1)+(c+j)+oldPiece;
	                }
	                AlphaBetaChess.chessBoard[r][c]="P";
	                AlphaBetaChess.chessBoard[r-1][c+j]=oldPiece;
	            }
	        } catch (Exception e) {}
	        
	      //promotion && capture
	        try {
	            if (Character.isLowerCase(AlphaBetaChess.chessBoard[r-1][c+j].charAt(0)) && i<16) {
	                String[] temp={"Q","R","B","K"};
	                for (int k=0; k<4; k++) {
	                    oldPiece=AlphaBetaChess.chessBoard[r-1][c+j];
	                    AlphaBetaChess.chessBoard[r][c]=" ";
	                    AlphaBetaChess.chessBoard[r-1][c+j]=temp[k];
	                    if (AlphaBetaChess.isKingSafe()) {
	                        //column1,column2,captured-piece,new-piece,P
	                        list=list+c+(c+j)+oldPiece+temp[k]+"P";
	                    }
	                    AlphaBetaChess.chessBoard[r][c]="P";
	                    AlphaBetaChess.chessBoard[r-1][c+j]=oldPiece;
	                }
	            }
	        } catch (Exception e) {}
	    }
	    
	  //move one up
	    try {
	        if (" ".equals(AlphaBetaChess.chessBoard[r-1][c]) && i>=16) {
	            oldPiece=AlphaBetaChess.chessBoard[r-1][c];
	            AlphaBetaChess.chessBoard[r][c]=" ";
	            AlphaBetaChess.chessBoard[r-1][c]="P";
	            if (AlphaBetaChess.isKingSafe()) {
	                list=list+r+c+(r-1)+c+oldPiece;
	            }
	            AlphaBetaChess.chessBoard[r][c]="P";
	            AlphaBetaChess.chessBoard[r-1][c]=oldPiece;
	        }
	    } catch (Exception e) {}
	    
	    
	  //promotion && no capture
	    try {
	        if (" ".equals(AlphaBetaChess.chessBoard[r-1][c]) && i<16) {
	            String[] temp={"Q","R","B","K"};
	            for (int k=0; k<4; k++) {
	                oldPiece=AlphaBetaChess.chessBoard[r-1][c];
	                AlphaBetaChess.chessBoard[r][c]=" ";
	                AlphaBetaChess.chessBoard[r-1][c]=temp[k];
	                if (AlphaBetaChess.isKingSafe()) {
	                    //column1,column2,captured-piece,new-piece,P
	                    list=list+c+c+oldPiece+temp[k]+"P";
	                }
	                AlphaBetaChess.chessBoard[r][c]="P";
	                AlphaBetaChess.chessBoard[r-1][c]=oldPiece;
	            }
	        }
	    } catch (Exception e) {}
	    
	    
	  //move two up
	    try {
	        if (" ".equals(AlphaBetaChess.chessBoard[r-1][c]) && " ".equals(AlphaBetaChess.chessBoard[r-2][c]) && i>=48) {
	            oldPiece=AlphaBetaChess.chessBoard[r-2][c];
	            AlphaBetaChess.chessBoard[r][c]=" ";
	            AlphaBetaChess.chessBoard[r-2][c]="P";
	            if (AlphaBetaChess.isKingSafe()) {
	                list=list+r+c+(r-2)+c+oldPiece;
	            }
	            AlphaBetaChess.chessBoard[r][c]="P";
	            AlphaBetaChess.chessBoard[r-2][c]=oldPiece;
	        }
	    } catch (Exception e) {}
	    return list;
	}

}
