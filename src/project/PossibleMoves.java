package project;

/**
 * @author shuvra
 */
public class PossibleMoves {

    //possible moves
    public static String possibleMoves() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            switch (AlphaBetaChess.chessBoard[i / 8][i % 8]) {
                case "P":
                    list.append(PossiblePawnMoves.possiblePawnMove(i));
                    break;
                case "R":
                    list.append(PossibleRockMoves.possibleRockMove(i));
                    break;
                case "K":
                    list.append(PossibleKnightMoves.possibleKnightMove(i));
                    break;
                case "B":
                    list.append(PossibleBishopMoves.possibleBishopMove(i));
                    break;
                case "Q":
                    list.append(PossibleQueenMoves.possibleQueenMove(i));
                    break;
                case "A":
                    list.append(PossibleKingMoves.possibleKingMove(i));
                    break;
            }
        }
        return list.toString();//x1,y1,x2,y2,captured piece
    }


}
