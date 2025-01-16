package entities;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Player extends Entity {
    private final Image image;

    public Player(int x, int y) {
        super(x, y);
        // Charge l'image du joueur
        this.image = new ImageIcon("resources/images/player.jpg").getImage();
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public boolean isPassable() {
        return false;
    }
}
