package ui;

import core.Board;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(Board board) {
        setTitle("Sokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        add(new GamePanel(board));
        setVisible(true);
    }
}