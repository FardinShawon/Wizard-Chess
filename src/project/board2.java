package project;

//package userinterface;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class board2 extends JPanel{
    static int mouseX, mouseY, newMouseX, newMouseY;
    static int squareSize=128;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.yellow);
        for (int i=0;i<64;i+=2) {
            g.setColor(new Color(230, 230, 230));
            g.fillRect((i%8+(i/8)%2)*squareSize, (i/8)*squareSize, squareSize, squareSize);
            g.setColor(new Color(123, 104, 238));
            g.fillRect(((i+1)%8-((i+1)/8)%2)*squareSize, ((i+1)/8)*squareSize, squareSize, squareSize);
       
        
        }}}
    
    
    