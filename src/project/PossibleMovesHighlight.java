package project;

import java.awt.Graphics;

public class PossibleMovesHighlight {
    private final int x;
    private final int y;
    private final int square;
    private final int position;
    private int hFlag;
    private final Graphics g;

    public PossibleMovesHighlight(int x, int y, int square, Graphics g) {
        this.x = x;
        this.y = y;
        this.square = square;
        this.g = g;
        this.position = x * 8 + y;

        System.out.println(x + "" + y);

        draw();
    }

    public void draw() {
        if ("P".equals(AlphaBetaChess.chessBoard[x][y])) {
            System.out.println("P");
            possibleP(position);
        } else if ("R".equals(AlphaBetaChess.chessBoard[x][y])) {
            System.out.println("R");
            possibleR(position);
        } else if ("B".equals(AlphaBetaChess.chessBoard[x][y])) {
            System.out.println("B");
            possibleB(position);
        } else if ("K".equals(AlphaBetaChess.chessBoard[x][y])) {
            System.out.println("K");
            possibleK(position);
        } else if ("Q".equals(AlphaBetaChess.chessBoard[x][y])) {
            System.out.println("Q");
            possibleQ(position);
        } else if ("A".equals(AlphaBetaChess.chessBoard[x][y])) {
            System.out.println("A");
            possibleA(position);
        }
    }

    //pawn
    public String possibleP(int pos) {
        StringBuilder list = new StringBuilder();
        String oldPiece;
        int r = pos / 8, c = pos % 8;
        for (int j = -1; j <= 1; j += 2) {

            //capture
            try {
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r - 1][c + j].charAt(0)) && pos >= 16) {
                    hFlag = 0;

                    oldPiece = AlphaBetaChess.chessBoard[r - 1][c + j];
                    AlphaBetaChess.chessBoard[r][c] = " ";
                    AlphaBetaChess.chessBoard[r - 1][c + j] = "P";
                    if (isKingSafe()) {
                        list.append(r).append(c).append(r - 1).append(c + j).append(oldPiece);

                        hFlag = 1;
                    }
                    AlphaBetaChess.chessBoard[r][c] = "P";
                    AlphaBetaChess.chessBoard[r - 1][c + j] = oldPiece;

                    //paint
                    if (hFlag == 1) {
                        HighLight h = new HighLight((c + j) * square, (r - 1) * square, square);
                        h.paintComponent(g);
                        hFlag = 0;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //promotion && capture
            try {
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r - 1][c + j].charAt(0)) && pos < 16) {
                    hFlag = 0;

                    String[] temp = {"Q", "R", "B", "K"};
                    for (int k = 0; k < 4; k++) {
                        oldPiece = AlphaBetaChess.chessBoard[r - 1][c + j];
                        AlphaBetaChess.chessBoard[r][c] = " ";
                        AlphaBetaChess.chessBoard[r - 1][c + j] = temp[k];
                        if (isKingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list.append(c).append(c + j).append(oldPiece).append(temp[k]).append("P");

                            hFlag = 1;
                        }
                        AlphaBetaChess.chessBoard[r][c] = "P";
                        AlphaBetaChess.chessBoard[r - 1][c + j] = oldPiece;

                        //paint
                        if (hFlag == 1) {
                            HighLight h = new HighLight((c + j) * square, (r - 1) * square, square);
                            h.paintComponent(g);
                            hFlag = 0;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //move one up
        try {
            if (" ".equals(AlphaBetaChess.chessBoard[r - 1][c]) && pos >= 16) {
                hFlag = 0;

                oldPiece = AlphaBetaChess.chessBoard[r - 1][c];
                AlphaBetaChess.chessBoard[r][c] = " ";
                AlphaBetaChess.chessBoard[r - 1][c] = "P";
                if (isKingSafe()) {
                    list.append(r).append(c).append(r - 1).append(c).append(oldPiece);

                    hFlag = 1;
                }
                AlphaBetaChess.chessBoard[r][c] = "P";
                AlphaBetaChess.chessBoard[r - 1][c] = oldPiece;

                if (hFlag == 1) {
                    HighLight h = new HighLight(c * square, (r - 1) * square, square);
                    h.paintComponent(g);
                    hFlag = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //promotion && no capture
        try {
            if (" ".equals(AlphaBetaChess.chessBoard[r - 1][c]) && pos < 16) {
                hFlag = 0;

                String[] temp = {"Q", "R", "B", "K"};
                for (int k = 0; k < 4; k++) {
                    oldPiece = AlphaBetaChess.chessBoard[r - 1][c];
                    AlphaBetaChess.chessBoard[r][c] = " ";
                    AlphaBetaChess.chessBoard[r - 1][c] = temp[k];
                    if (isKingSafe()) {
                        //column1,column2,captured-piece,new-piece,P
                        list.append(c).append(c).append(oldPiece).append(temp[k]).append("P");

                        hFlag = 1;
                    }
                    AlphaBetaChess.chessBoard[r][c] = "P";
                    AlphaBetaChess.chessBoard[r - 1][c] = oldPiece;

                    //paint
                    if (hFlag == 1) {
                        HighLight h = new HighLight(c * square, (r - 1) * square, square);
                        h.paintComponent(g);
                        hFlag = 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //move two up
        try {
            if (" ".equals(AlphaBetaChess.chessBoard[r - 1][c]) && " ".equals(AlphaBetaChess.chessBoard[r - 2][c]) && pos >= 48) {
                hFlag = 0;

                oldPiece = AlphaBetaChess.chessBoard[r - 2][c];
                AlphaBetaChess.chessBoard[r][c] = " ";
                AlphaBetaChess.chessBoard[r - 2][c] = "P";
                if (isKingSafe()) {
                    list.append(r).append(c).append(r - 2).append(c).append(oldPiece);

                    hFlag = 1;
                }
                AlphaBetaChess.chessBoard[r][c] = "P";
                AlphaBetaChess.chessBoard[r - 2][c] = oldPiece;

                //paint
                if (hFlag == 1) {
                    HighLight h = new HighLight(c * square, (r - 2) * square, square);
                    h.paintComponent(g);
                    hFlag = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list.toString();
    }


    //rock
    public String possibleR(int pos) {
        StringBuilder list = new StringBuilder();
        String oldPiece;
        int r = pos / 8, c = pos % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            try {
                while (" ".equals(AlphaBetaChess.chessBoard[r][c + temp * j])) {
                    hFlag = 0;

                    oldPiece = AlphaBetaChess.chessBoard[r][c + temp * j];
                    AlphaBetaChess.chessBoard[r][c] = " ";
                    AlphaBetaChess.chessBoard[r][c + temp * j] = "R";
                    if (isKingSafe()) {
                        list.append(r).append(c).append(r).append(c + temp * j).append(oldPiece);

                        hFlag = 1;
                    }
                    AlphaBetaChess.chessBoard[r][c] = "R";
                    AlphaBetaChess.chessBoard[r][c + temp * j] = oldPiece;

                    //paint
                    if (hFlag == 1) {
                        HighLight h = new HighLight((c + temp * j) * square, r * square, square);
                        h.paintComponent(g);
                        hFlag = 0;
                    }
                    temp++;
                }
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r][c + temp * j].charAt(0))) {
                    hFlag = 0;

                    oldPiece = AlphaBetaChess.chessBoard[r][c + temp * j];
                    AlphaBetaChess.chessBoard[r][c] = " ";
                    AlphaBetaChess.chessBoard[r][c + temp * j] = "R";
                    if (isKingSafe()) {
                        list.append(r).append(c).append(r).append(c + temp * j).append(oldPiece);

                        hFlag = 1;
                    }
                    AlphaBetaChess.chessBoard[r][c] = "R";
                    AlphaBetaChess.chessBoard[r][c + temp * j] = oldPiece;

                    //paint
                    if (hFlag == 1) {
                        HighLight h = new HighLight((c + temp * j) * square, r * square, square);
                        h.paintComponent(g);
                        hFlag = 0;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            temp = 1;
            try {
                while (" ".equals(AlphaBetaChess.chessBoard[r + temp * j][c])) {
                    hFlag = 0;

                    oldPiece = AlphaBetaChess.chessBoard[r + temp * j][c];
                    AlphaBetaChess.chessBoard[r][c] = " ";
                    AlphaBetaChess.chessBoard[r + temp * j][c] = "R";
                    if (isKingSafe()) {
                        list.append(r).append(c).append(r + temp * j).append(c).append(oldPiece);

                        hFlag = 1;
                    }
                    AlphaBetaChess.chessBoard[r][c] = "R";
                    AlphaBetaChess.chessBoard[r + temp * j][c] = oldPiece;

                    //paint
                    if (hFlag == 1) {
                        HighLight h = new HighLight(c * square, (r + temp * j) * square, square);
                        h.paintComponent(g);
                        hFlag = 0;
                    }
                    temp++;
                }
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r + temp * j][c].charAt(0))) {
                    hFlag = 0;

                    oldPiece = AlphaBetaChess.chessBoard[r + temp * j][c];
                    AlphaBetaChess.chessBoard[r][c] = " ";
                    AlphaBetaChess.chessBoard[r + temp * j][c] = "R";
                    if (isKingSafe()) {
                        list.append(r).append(c).append(r + temp * j).append(c).append(oldPiece);

                        hFlag = 1;
                    }
                    AlphaBetaChess.chessBoard[r][c] = "R";
                    AlphaBetaChess.chessBoard[r + temp * j][c] = oldPiece;

                    //paint
                    if (hFlag == 1) {
                        HighLight h = new HighLight(c * square, (r + temp * j) * square, square);
                        h.paintComponent(g);
                        hFlag = 0;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            temp = 1;
        }
        return list.toString();
    }

    //knight
    public String possibleK(int pos) {
        String list = "", oldPiece;
        int r = pos / 8, c = pos % 8;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r + j][c + k * 2].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r + j][c + k * 2])) {
                        hFlag = 0;

                        oldPiece = AlphaBetaChess.chessBoard[r + j][c + k * 2];
                        AlphaBetaChess.chessBoard[r][c] = " ";
                        if (isKingSafe()) {
                            list = list + r + c + (r + j) + (c + k * 2) + oldPiece;

                            hFlag = 1;
                        }
                        AlphaBetaChess.chessBoard[r][c] = "K";
                        AlphaBetaChess.chessBoard[r + j][c + k * 2] = oldPiece;

                        //paint
                        if (hFlag == 1) {
                            HighLight h = new HighLight((c + k * 2) * square, (r + j) * square, square);
                            h.paintComponent(g);
                            hFlag = 0;
                        }
                    }

                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r + j * 2][c + k].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r + j * 2][c + k])) {
                        hFlag = 0;

                        oldPiece = AlphaBetaChess.chessBoard[r + j * 2][c + k];
                        AlphaBetaChess.chessBoard[r][c] = " ";

                        if (isKingSafe()) {
                            list = list + r + c + (r + j * 2) + (c + k) + oldPiece;

                            hFlag = 1;
                        }
                        AlphaBetaChess.chessBoard[r][c] = "K";
                        AlphaBetaChess.chessBoard[r + j * 2][c + k] = oldPiece;

                        //paint
                        if (hFlag == 1) {
                            HighLight h = new HighLight((c + k) * square, (r + j * 2) * square, square);
                            h.paintComponent(g);
                            hFlag = 0;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


    //bishop
    public String possibleB(int pos) {
        StringBuilder list = new StringBuilder();
        String oldPiece;
        int r = pos / 8, c = pos % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    while (" ".equals(AlphaBetaChess.chessBoard[r + temp * j][c + temp * k])) {
                        hFlag = 0;

                        oldPiece = AlphaBetaChess.chessBoard[r + temp * j][c + temp * k];
                        AlphaBetaChess.chessBoard[r][c] = " ";
                        AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = "B";

                        if (isKingSafe()) {
                            list.append(r).append(c).append(r + temp * j).append(c + temp * k).append(oldPiece);

                            hFlag = 1;
                        }
                        AlphaBetaChess.chessBoard[r][c] = "B";
                        AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = oldPiece;

                        //paint
                        if (hFlag == 1) {
                            HighLight h = new HighLight((c + temp * k) * square, (r + temp * j) * square, square);
                            h.paintComponent(g);
                            hFlag = 0;
                        }
                        temp++;
                    }
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                        hFlag = 0;

                        oldPiece = AlphaBetaChess.chessBoard[r + temp * j][c + temp * k];
                        AlphaBetaChess.chessBoard[r][c] = " ";
                        AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = "B";

                        if (isKingSafe()) {
                            list.append(r).append(c).append(r + temp * j).append(c + temp * k).append(oldPiece);

                            hFlag = 1;
                        }
                        AlphaBetaChess.chessBoard[r][c] = "B";
                        AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = oldPiece;

                        //paint
                        if (hFlag == 1) {
                            HighLight h = new HighLight((c + temp * k) * square, (r + temp * j) * square, square);
                            h.paintComponent(g);
                            hFlag = 0;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                temp = 1;
            }
        }
        return list.toString();
    }


    //queen
    public String possibleQ(int pos) {
        StringBuilder list = new StringBuilder();
        String oldPiece;
        int r = pos / 8, c = pos % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if (j != 0 || k != 0) {
                    try {
                        while (" ".equals(AlphaBetaChess.chessBoard[r + temp * j][c + temp * k])) {
                            hFlag = 0;

                            oldPiece = AlphaBetaChess.chessBoard[r + temp * j][c + temp * k];
                            AlphaBetaChess.chessBoard[r][c] = " ";
                            AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = "Q";

                            if (isKingSafe()) {
                                list.append(r).append(c).append(r + temp * j).append(c + temp * k).append(oldPiece);

                                hFlag = 1;
                            }
                            AlphaBetaChess.chessBoard[r][c] = "Q";
                            AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = oldPiece;


                            //paint
                            if (hFlag == 1) {
                                HighLight h = new HighLight((c + temp * k) * square, (r + temp * j) * square, square);
                                h.paintComponent(g);
                                hFlag = 0;
                            }
                            temp++;
                        }
                        if (Character.isLowerCase(AlphaBetaChess.chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                            hFlag = 0;

                            oldPiece = AlphaBetaChess.chessBoard[r + temp * j][c + temp * k];
                            AlphaBetaChess.chessBoard[r][c] = " ";
                            AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = "Q";

                            if (isKingSafe()) {
                                list.append(r).append(c).append(r + temp * j).append(c + temp * k).append(oldPiece);

                                hFlag = 1;
                            }
                            AlphaBetaChess.chessBoard[r][c] = "Q";
                            AlphaBetaChess.chessBoard[r + temp * j][c + temp * k] = oldPiece;

                            //paint
                            if (hFlag == 1) {
                                HighLight h = new HighLight((c + temp * k) * square, (r + temp * j) * square, square);
                                h.paintComponent(g);
                                hFlag = 0;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    temp = 1;
                }
            }
        }
        return list.toString();
    }


    //king
    public String possibleA(int pos) {
        StringBuilder list = new StringBuilder();
        String oldPiece;
        int r = pos / 8, c = pos % 8;
        for (int j = 0; j < 9; j++) {
            if (j != 4) {
                try {
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r - 1 + j / 3][c - 1 + j % 3].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r - 1 + j / 3][c - 1 + j % 3])) {
                        hFlag = 0;

                        oldPiece = AlphaBetaChess.chessBoard[r - 1 + j / 3][c - 1 + j % 3];
                        AlphaBetaChess.chessBoard[r][c] = " ";
                        AlphaBetaChess.chessBoard[r - 1 + j / 3][c - 1 + j % 3] = "A";
                        int kingTemp = AlphaBetaChess.kingPositionC;
                        AlphaBetaChess.kingPositionC = pos + (j / 3) * 8 + j % 3 - 9;

                        if (isKingSafe()) {
                            list.append(r).append(c).append(r - 1 + j / 3).append(c - 1 + j % 3).append(oldPiece);

                            hFlag = 1;
                        }
                        AlphaBetaChess.chessBoard[r][c] = "A";
                        AlphaBetaChess.chessBoard[r - 1 + j / 3][c - 1 + j % 3] = oldPiece;
                        AlphaBetaChess.kingPositionC = kingTemp;

                        //paint
                        if (hFlag == 1) {
                            HighLight h = new HighLight((c - 1 + j % 3) * square, (r - 1 + j / 3) * square, square);
                            h.paintComponent(g);
                            hFlag = 0;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //need to add casting later
        return list.toString();
    }

    //king safe
    public boolean isKingSafe() {
        //bishop/queen
        int temp = 1;
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    while (" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + temp * i][AlphaBetaChess.kingPositionC % 8 + temp * j])) {
                        temp++;
                    }
                    if ("b".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + temp * i][AlphaBetaChess.kingPositionC % 8 + temp * j]) ||
                            "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + temp * i][AlphaBetaChess.kingPositionC % 8 + temp * j])) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                temp = 1;
            }
        }

        //rook/queen
        for (int i = -1; i <= 1; i += 2) {
            try {
                while (" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8][AlphaBetaChess.kingPositionC % 8 + temp * i])) {
                    temp++;
                }
                if ("r".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8][AlphaBetaChess.kingPositionC % 8 + temp * i]) ||
                        "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8][AlphaBetaChess.kingPositionC % 8 + temp * i])) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            temp = 1;
            try {
                while (" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + temp * i][AlphaBetaChess.kingPositionC % 8])) {
                    temp++;
                }
                if ("r".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + temp * i][AlphaBetaChess.kingPositionC % 8]) ||
                        "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + temp * i][AlphaBetaChess.kingPositionC % 8])) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            temp = 1;
        }

        //knight
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    if ("k".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + i][AlphaBetaChess.kingPositionC % 8 + j * 2])) {
                        return false;
                    }

                    if ("k".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + i * 2][AlphaBetaChess.kingPositionC % 8 + j])) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //pawn
        if (AlphaBetaChess.kingPositionC >= 16) {
            try {
                if ("p".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 - 1][AlphaBetaChess.kingPositionC % 8 - 1])) {
                    return false;
                }

                if ("p".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 - 1][AlphaBetaChess.kingPositionC % 8 + 1])) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //king
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        try {
                            if ("a".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC / 8 + i][AlphaBetaChess.kingPositionC % 8 + j])) {
                                return false;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return true;
    }


}
