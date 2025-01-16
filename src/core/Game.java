package core;

import ui.MainFrame;

public class Game {
    private Board board;

    public Game() {
        board = new Board("resources/levels/level1.txt");
        new MainFrame(board);
    }

    public void resetGame() {
        board.loadLevel("resources/levels/level1.txt");
    }
}
