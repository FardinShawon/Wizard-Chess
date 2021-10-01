package project;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final int squareSize;
    private final BoardColor boardColor;

    public Board(int squareSize, BoardType boardType) {
        this.squareSize = squareSize;
        this.boardColor = BoardColor.getBoardColor(boardType.getType());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.YELLOW);

        for (int i = 0; i < 64; i += 2) {
            g.setColor(boardColor.getFirstPlayerColor());
            g.fillRect((i % 8 + (i / 8) % 2) * squareSize, (i / 8) * squareSize, squareSize, squareSize);
            g.setColor(boardColor.getSecondPlayerColor());
            g.fillRect(((i + 1) % 8 - ((i + 1) / 8) % 2) * squareSize, ((i + 1) / 8) * squareSize, squareSize, squareSize);
        }
    }
}
