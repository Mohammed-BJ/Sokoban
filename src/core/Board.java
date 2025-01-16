package core;

import entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Board {
    private int rows, cols;
    private Entity[][] grid;
    private Player player;

    public Board(String levelPath) {
        loadLevel(levelPath);
    }

    public void loadLevel(String levelPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(levelPath))) {
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            rows = lines.size();
            cols = lines.get(0).length();
            grid = new Entity[rows][cols];

            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    char c = lines.get(y).charAt(x);
                    switch (c) {
                        case '#': grid[y][x] = new Wall(x, y); break;
                        case '@': player = new Player(x, y); grid[y][x] = player; break;
                        case '$': grid[y][x] = new Crate(x, y); break;
                        case '.': grid[y][x] = new TargetZone(x, y); break;
                        case ' ': grid[y][x] = null; break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void movePlayer(int dx, int dy) {
        int newX = player.getX() + dx;
        int newY = player.getY() + dy;

        if (canMoveTo(newX, newY)) {
            Entity nextEntity = grid[newY][newX];
            if (nextEntity instanceof Crate) {
                int crateX = newX + dx;
                int crateY = newY + dy;
                if (canMoveTo(crateX, crateY)) {
                    moveEntity((Crate) nextEntity, crateX, crateY);
                } else return;
            }
            moveEntity(player, newX, newY);
        }
    }

    private void moveEntity(Entity entity, int newX, int newY) {
        grid[entity.getY()][entity.getX()] = null;
        entity.setPosition(newX, newY);
        grid[newY][newX] = entity;
    }

    private boolean canMoveTo(int x, int y) {
        return x >= 0 && y >= 0 && x < cols && y < rows && (grid[y][x] == null || grid[y][x].isPassable());
    }

    public Entity[][] getGrid() {
        return grid;
    }
}
