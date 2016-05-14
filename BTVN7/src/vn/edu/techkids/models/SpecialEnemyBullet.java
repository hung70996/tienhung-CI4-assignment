package vn.edu.techkids.models;

/**
 * Created by Administrator on 5/14/2016.
 */
public class SpecialEnemyBullet extends GameObject {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int DAMAGE_DEFAULT = 2;

    private int damage = DAMAGE_DEFAULT;

    public SpecialEnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public SpecialEnemyBullet(int x, int y, int width, int height, int damage)
    {
        this(x, y, width, height);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
