package vn.edu.techkids.models;

public class Bullet extends GameObject {
    public static final int DEFAULT_WIDTH = 13;
    public static final int DEFAULT_HEIGHT = 33;
    public static int DAMAGE = 1;


    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Bullet(int x, int y, int width, int height, int damage) {
        super(x, y, width, height);
        damage = DAMAGE;
    }

    public static void increase () {
        DAMAGE ++ ;
    }
}
