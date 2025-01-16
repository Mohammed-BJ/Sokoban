package entities;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Wall extends Entity {
    private final Image image;

    public Wall(int x, int y) {
        super(x, y);
        // Charge l'image des murs
        this.image = new ImageIcon("resources/images/wall.jpeg").getImage();
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
