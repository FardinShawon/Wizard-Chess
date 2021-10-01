package project;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Difficulty extends JFrame {
    private Container container;
    private Font font;

    public Difficulty() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 300, 650, 450);
        this.setTitle("Difficulty");
        this.setResizable(false);

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.LIGHT_GRAY);
        font = new Font("Arial", Font.BOLD, 18);

        //easy
        container.add(createButton("Easy", new Rectangle(200, 90, 200, 50), 2));

        //medium
        container.add(createButton("Medium", new Rectangle(200, 190, 200, 50), 4));

        //hard
        container.add(createButton("Hard", new Rectangle(200, 290, 200, 50), 6));
    }

    private JButton createButton(String buttonText, Rectangle boundingRectangle, int depth) {
        JButton button = new JButton(buttonText);
        button.setBounds(boundingRectangle);
        button.setFont(font);
        button.setBackground(Color.lightGray);
        button.addActionListener(l -> {
            (new AlphaBetaChess(depth)).setup();
            dispose();
        });
        return button;
    }
}



