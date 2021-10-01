package project;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class BoardColorChoice extends JFrame {

    private Container container;
    private Font font;
    private int choice;

    public BoardColorChoice() {
        this.setTitle("Board's Color Choice");
        this.setBounds(50, 50, 1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        container = this.getContentPane();
        container.setBackground(Color.CYAN);
        container.setLayout(null);
        font = new Font("Arial", Font.BOLD, 18);

        //Image
        ImageIcon img1 = new ImageIcon("image/board1.JPG");
        ImageIcon img2 = new ImageIcon("image/board2.JPG");
        ImageIcon img3 = new ImageIcon("image/board3.JPG");
        ImageIcon img4 = new ImageIcon("image/board4.JPG");
        ImageIcon img5 = new ImageIcon("image/board5.JPG");

        container.add(createButton(img1, new Rectangle(500, 300, 250, 60), l -> new MainBoard(BoardType.BOARD_TYPE_1)));
        container.add(createButton(img2, new Rectangle(500, 400, 250, 60), l -> new MainBoard(BoardType.BOARD_TYPE_2)));
        container.add(createButton(img3, new Rectangle(500, 500, 250, 60), l -> new MainBoard(BoardType.BOARD_TYPE_3)));
        container.add(createButton(img4, new Rectangle(500, 600, 250, 60), l -> new MainBoard(BoardType.BOARD_TYPE_4)));
        container.add(createButton(img5, new Rectangle(500, 700, 250, 60), l -> new MainBoard(BoardType.BOARD_TYPE_5)));

        container.add(createButton("Accept Board 1", new Rectangle(200, 300, 250, 60), l -> saveChoice(1)));
        container.add(createButton("Accept Board 2", new Rectangle(200, 400, 250, 60), l -> saveChoice(2)));
        container.add(createButton("Accept Board 3", new Rectangle(200, 500, 250, 60), l -> saveChoice(3)));
        container.add(createButton("Accept Board 4", new Rectangle(200, 600, 250, 60), l -> saveChoice(4)));
        container.add(createButton("Accept Board 5", new Rectangle(200, 700, 250, 60), l -> saveChoice(5)));

        //Back button
        container.add(createButton("Back", new Rectangle(300, 800, 250, 60), l -> {
            dispose();
            FrontScreen s1 = new FrontScreen();
            s1.setBounds(50, 20, 1000, 670);
            s1.setVisible(true);
        }));
    }

    private void saveChoice(int choiceValue) {
        choice = choiceValue;
        try {
            //file = new FileWriter("D:\\choice1.txt");
            FileWriter file = new FileWriter("/media/shuvra/New Volume/IIT/3rd semester/Project/Chess/Codechoice1.txt");
            file.flush();
            file.write(choiceValue + "");
            file.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private JButton createButton(String buttonText, Rectangle boundingRectangle, ActionListener l) {
        JButton button = new JButton(buttonText);
        createButton(button, boundingRectangle, l);
        return button;
    }

    private JButton createButton(Icon icon, Rectangle boundingRectangle, ActionListener l) {
        JButton button = new JButton(icon);
        createButton(button, boundingRectangle, l);
        return button;
    }

    private void createButton(JButton button, Rectangle boundingRectangle, ActionListener l) {
        button.setBounds(boundingRectangle);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.lightGray);
        button.setFont(font);
        button.addActionListener(l);
    }

    public int getChoice() {
        return choice;
    }
}
