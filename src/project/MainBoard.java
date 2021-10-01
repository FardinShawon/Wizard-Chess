package project;

import javax.swing.*;

public class MainBoard extends JFrame {

    public MainBoard() {
        this(BoardType.BOARD_TYPE_DEFAULT);
    }

    public MainBoard(BoardType boardType) {
        int squareSize = 128;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new Board(squareSize, boardType));
        setSize(1043, 1065);
        setVisible(true);
    }
}
