package entities;
import java.awt.Image;
public abstract class Entity {
    protected int x, y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract boolean isPassable();

    public abstract Image getImage();
}
