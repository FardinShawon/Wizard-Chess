package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class HighLight {
//    private static final String BorderFactory = null;
    UserInterface ui = new UserInterface();
    int x, y, square;

    HighLight(int x, int y, int square) {
        this.x = x;
        this.y = y;
        this.square = square;
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect(x, y, square, square);
//		g.setStoke(5);
//		Border l = BorderFactory.createLineBorder();
//        Rectangle rect = new Rectangle(x, y, square, square);
//        rect.set

        HashMap<String, Point> chessImagePosition = new HashMap<>() {
            {
                put("A", new Point(0, 0));
                put("a", new Point(0, 1));
                put("B", new Point(3, 0));
                put("b", new Point(3, 1));
                put("K", new Point(4, 0));
                put("k", new Point(4, 1));
                put("P", new Point(5, 0));
                put("p", new Point(5, 1));
                put("Q", new Point(1, 0));
                put("q", new Point(1, 1));
                put("R", new Point(2, 0));
                put("r", new Point(2, 1));
            }
        };

        //chess image
        Image chessPiecesImage;
        chessPiecesImage = new ImageIcon("ChessPieces.png").getImage();
        for (int i = 0; i < 64; i++) {
            String item = AlphaBetaChess.chessBoard[i / 8][i % 8];
            if (chessImagePosition.containsKey(item)) {
                Point point = chessImagePosition.get(item);
                g.drawImage(chessPiecesImage, (i % 8) * square, (i / 8) * square, (i % 8 + 1) * square, (i / 8 + 1) * square, point.x * 64, point.y * 64, (point.x + 1) * 64, (point.y + 1) * 64, ui);
            }
        }
    }
}


