package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrontScreen extends JFrame {
    private Container container;
    private final Font font;
    private JLabel imgLabel;
    private ImageIcon icon;

    public FrontScreen() {
        container = this.getContentPane();
        container.setLayout(null);
        //c.setBackground(Color.blue);
        font = new Font("Arial", Font.BOLD, 18);
        icon = new ImageIcon(getClass().getResource("chesspic4.png"));
        imgLabel = new JLabel(icon);
        imgLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        //Play
        imgLabel.add(createButton("Play Game", new Rectangle(400, 320, 150, 50), l -> {
            dispose();
            PlayerChoice s1 = new PlayerChoice();
            s1.setBounds(50, 20, 1000, 1000);
            s1.setVisible(true);
        }));

        //Settings
        imgLabel.add(createButton("Settings", new Rectangle(400, 390, 150, 50), l -> {
            dispose();
            Settings s1 = new Settings();
            s1.setBounds(50, 20, 1000, 1000);
            s1.setVisible(true);
        }));

        //Exit
        imgLabel.add(createButton("Exit", new Rectangle(400, 460, 150, 50), l -> System.exit(0)));

        container.add(imgLabel);
    }

    private JButton createButton(String buttonText, Rectangle boundingRectangle, ActionListener l) {
        JButton button = new JButton(buttonText);
        button.setBounds(boundingRectangle);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.lightGray);
        button.setFont(font);
        button.addActionListener(l);
        return button;
    }

    public static void main(String[] args) {
        FrontScreen fs = new FrontScreen();
        fs.setVisible(true);
        fs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fs.setBounds(30, 50, 1000, 670);
        //f.setExtendedState(MAXIMIZED_BOTH);
        fs.setTitle("Welcome to Wizerd Chess!!!");
    }
}
