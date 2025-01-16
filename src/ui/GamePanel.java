package ui;

import core.Board;
import entities.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private static final int TILE_SIZE = 64; // Taille des tuiles (en pixels)
    private final Board board;

    public GamePanel(Board board) {
        this.board = board;
        setPreferredSize(new Dimension(board.getGrid()[0].length * TILE_SIZE, board.getGrid().length * TILE_SIZE));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> board.movePlayer(0, -1);
                    case KeyEvent.VK_DOWN -> board.movePlayer(0, 1);
                    case KeyEvent.VK_LEFT -> board.movePlayer(-1, 0);
                    case KeyEvent.VK_RIGHT -> board.movePlayer(1, 0);
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Entity[][] grid = board.getGrid();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] != null) {
                    g.drawImage(grid[y][x].getImage(), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
                }
            }
        }
    }
}