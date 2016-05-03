package Model;

/**
 * Created by Administrator on 4/29/2016.
 */
public class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;

    public GameObject(int x, int y, int width, int height ) {
        this.x = x;
        this.height = height;
        this.width = width;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void move (GameVector gameVector) {
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }
}
