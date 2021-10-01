package project;


import java.awt.*;
import java.util.HashMap;

public class BoardColor {
    private final Color firstPlayerColor;
    private final Color secondPlayerColor;

    private static final HashMap<Character, BoardColor> availableBoardColors = new HashMap<>() {
        {
            put(BoardType.BOARD_TYPE_1.getType(), new BoardColor(new Color(229, 216, 243), new Color(153, 102, 204)));
            put(BoardType.BOARD_TYPE_2.getType(), new BoardColor(new Color(230, 230, 230), new Color(123, 104, 238)));
            put(BoardType.BOARD_TYPE_3.getType(), new BoardColor(new Color(233, 246, 251), new Color(123, 164, 40)));
            put(BoardType.BOARD_TYPE_4.getType(), new BoardColor(new Color(255, 247, 204), new Color(51, 153, 95)));
            put(BoardType.BOARD_TYPE_5.getType(), new BoardColor(new Color(233, 246, 251), new Color(123, 164, 40)));
            put(BoardType.BOARD_TYPE_DEFAULT.getType(), new BoardColor(Color.WHITE, Color.BLACK));
        }
    };

    public BoardColor(Color firstPlayerColor, Color secondPlayerColor) {
        this.firstPlayerColor = firstPlayerColor;
        this.secondPlayerColor = secondPlayerColor;
    }

    public Color getFirstPlayerColor() {
        return firstPlayerColor;
    }

    public Color getSecondPlayerColor() {
        return secondPlayerColor;
    }

    public static BoardColor getBoardColor(Character boardType) {
        if (availableBoardColors.containsKey(boardType)) {
            return availableBoardColors.get(boardType);
        }
        return availableBoardColors.get(BoardType.BOARD_TYPE_DEFAULT.getType());
    }
}
