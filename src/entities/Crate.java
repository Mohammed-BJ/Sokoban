package entities;

import javax.swing.*;
import java.awt.Image;

public class Crate extends Entity {
    private final ImageIcon icon = new ImageIcon("resources/images/crate.png");

    public Crate(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isPassable() {
        return false; // Les caisses bloquent le passage
    }

    @Override
    public Image getImage() {
        return icon.getImage();
    }
}