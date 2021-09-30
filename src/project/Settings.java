package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Settings extends JFrame {
    private JFrame frame;
    private JButton boardColorButton;
    private Container container;
    private Font font;
    private ImageIcon imgIcon;
    private JLabel imgLabel;

    public Settings() {
        this.setTitle("Settings");
        this.setBounds(50, 50, 1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        container = this.getContentPane();
        container.setLayout(null);
        font = new Font("Arial", Font.BOLD, 18);
        imgIcon = new ImageIcon(getClass().getResource("Chess1-PNg.png"));
        imgLabel = new JLabel(imgIcon);
        imgLabel.setBounds(0, 0, imgIcon.getIconWidth(), imgIcon.getIconHeight());

        boardColorButton = new JButton("Board Color");
        boardColorButton.setBounds(250, 300, 250, 60);
        boardColorButton.setForeground(Color.black);
        boardColorButton.setBackground(Color.lightGray);
        boardColorButton.setFont(font);
        imgLabel.add(boardColorButton);

        boardColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BoardColorChoice s1 = new BoardColorChoice();
                s1.setBounds(50, 20, 1000, 1000);
                s1.setVisible(true);
            }
        });
        container.add(imgLabel);

        //We will add custom cursor in the future.
    }
}

