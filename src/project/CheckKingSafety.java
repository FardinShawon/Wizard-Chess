/**
 * 
 */
package project;

/**
 * @author shuvra
 *
 */
public class CheckKingSafety {

	//King safe
	public static boolean isKingSafe() {
		
	    //bishop/queen
	    int temp=1;
	    for (int i=-1; i<=1; i+=2) {
	        for (int j=-1; j<=1; j+=2) {
	            try {
	                while(" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8+temp*j])) {temp++;}
	                if ("b".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8+temp*j]) ||
	                        "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8+temp*j])) {
	                    return false;
	                }
	            } catch (Exception e) {}
	            temp=1;
	        }
	    }
	    
	    //rook/queen
	    for (int i=-1; i<=1; i+=2) {
	        try {
	            while(" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8][AlphaBetaChess.kingPositionC%8+temp*i])) {temp++;}
	            if ("r".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8][AlphaBetaChess.kingPositionC%8+temp*i]) ||
	                    "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8][AlphaBetaChess.kingPositionC%8+temp*i])) {
	                return false;
	            }
	        } catch (Exception e) {}
	        temp=1;
	        try {
	            while(" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8])) {temp++;}
	            if ("r".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8]) ||
	                    "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8])) {
	                return false;
	            }
	        } catch (Exception e) {}
	        temp=1;
	    }
	    
	    //knight
	    for (int i=-1; i<=1; i+=2) {
	        for (int j=-1; j<=1; j+=2) {
	            try {
	                if ("k".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+i][AlphaBetaChess.kingPositionC%8+j*2])) {
	                    return false;
	                }
	            } catch (Exception e) {}
	            try {
	                if ("k".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+i*2][AlphaBetaChess.kingPositionC%8+j])) {
	                    return false;
	                }
	            } catch (Exception e) {}
	        }
	    }
	    
	    //pawn
	    if (AlphaBetaChess.kingPositionC>=16) {
	        try {
	            if ("p".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8-1][AlphaBetaChess.kingPositionC%8-1])) {
	                return false;
	            }
	        } catch (Exception e) {}
	        try {
	            if ("p".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8-1][AlphaBetaChess.kingPositionC%8+1])) {
	                return false;
	            }
	        } catch (Exception e) {}
	        
	        //king
	        for (int i=-1; i<=1; i++) {
	            for (int j=-1; j<=1; j++) {
	                if (i!=0 || j!=0) {
	                    try {
	                        if ("a".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+i][AlphaBetaChess.kingPositionC%8+j])) {
	                            return false;
	                        }
	                    } catch (Exception e) {}
	                }
	            }
	        }
	    }
	    return true;
	}

}
