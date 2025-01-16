package entities;

import javax.swing.ImageIcon;
import java.awt.Image;

public class TargetZone extends Entity {
    private final ImageIcon icon = new ImageIcon("resources/images/target.jpg");

    public TargetZone(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isPassable() {
        return true; // Le joueur et les caisses peuvent passer
    }

    @Override
    public Image getImage() {
        return icon.getImage();
    }
}
