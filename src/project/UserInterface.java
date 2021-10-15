package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileReader;
import java.util.HashMap;

public class UserInterface extends JPanel implements MouseListener, MouseMotionListener {

    private Character indicator = '0';
    private int mouseX;
    private int mouseY;
    private final int squareSize = 128;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.yellow);
        addMouseListener(this);
        addMouseMotionListener(this);

        try {
            // TODO: Remove static file path
            FileReader file = new FileReader("/media/shuvra/New Volume/IIT/3rd semester/Project/Chess/Codechoice1.txt");
            int boardChoiceIndicator = file.read();
            indicator = (char) boardChoiceIndicator;
        } catch (Exception e) {
            e.printStackTrace();
        }

        BoardColor boardColor = BoardColor.getBoardColor(indicator);

        for (int i = 0; i < 64; i += 2) {
            g.setColor(boardColor.getFirstPlayerColor());
            g.fillRect((i % 8 + (i / 8) % 2) * squareSize, (i / 8) * squareSize, squareSize, squareSize);
            g.setColor(boardColor.getSecondPlayerColor());
            g.fillRect(((i + 1) % 8 - ((i + 1) / 8) % 2) * squareSize, ((i + 1) / 8) * squareSize, squareSize, squareSize);
        }

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

        // chess image
        Image chessPiecesImage = new ImageIcon("ChessPieces.png").getImage();
        for (int i = 0; i < 64; i++) {
            String item = AlphaBetaChess.chessBoard[i / 8][i % 8];
            if (chessImagePosition.containsKey(item)) {
                Point point = chessImagePosition.get(item);
                g.drawImage(chessPiecesImage, (i % 8) * squareSize, (i / 8) * squareSize, (i % 8 + 1) * squareSize, (i / 8 + 1) * squareSize, point.x * 64, point.y * 64, (point.x + 1) * 64, (point.y + 1) * 64, this);
            }
        }
    }


    //Mouse functionality
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() < 8 * squareSize && e.getY() < 8 * squareSize) {
            //if inside the board
            mouseX = e.getX();
            mouseY = e.getY();
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX() < 8 * squareSize && e.getY() < 8 * squareSize) {
            //if inside the board
            int newMouseX = e.getX();
            int newMouseY = e.getY();
            if (e.getButton() == MouseEvent.BUTTON1) {
                String dragMove;
                if (newMouseY / squareSize == 0 && mouseY / squareSize == 1 && "P".equals(AlphaBetaChess.chessBoard[mouseY / squareSize][mouseX / squareSize])) {
                    //pawn promotion
                    dragMove = "" + mouseX / squareSize + newMouseX / squareSize + AlphaBetaChess.chessBoard[newMouseY / squareSize][newMouseX / squareSize] + "QP";
                } else {
                    //regular move
                    dragMove = "" + mouseY / squareSize + mouseX / squareSize + newMouseY / squareSize + newMouseX / squareSize + AlphaBetaChess.chessBoard[newMouseY / squareSize][newMouseX / squareSize];
                }
                String userPossibilities = PossibleMoves.possibleMoves();
                if (userPossibilities.replaceAll(dragMove, "").length() < userPossibilities.length()) {
                    //if valid move
                    Move.makeMove(dragMove);
                    FlipBoard.flipBoard();
//                    repaint();
                    Move.makeMove(AlphaBetaChess.alphaBeta(AlphaBetaChess.globalDepth, 1000000, -1000000, "", 0));
                    FlipBoard.flipBoard();
                    repaint();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / squareSize;
        int y = e.getY() / squareSize;
        int tempX = x * squareSize;
        int tempY = y * squareSize;

        (new HighLight(tempX, tempY, squareSize)).paintComponent(getGraphics());
        (new PossibleMovesHighlight(x, y, squareSize, getGraphics())).draw();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
