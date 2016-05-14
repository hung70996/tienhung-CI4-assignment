package vn.edu.techkids.models;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBullet extends GameObject {

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int DAMAGE_DEFAULT = 1;
    public static int SLOW;

    private int damage = DAMAGE_DEFAULT;
    private int slow = SLOW;

    public EnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public EnemyBullet(int x, int y, int width, int height, int damage)
    {
        this(x, y, width, height);
        this.damage = damage;
    }

    public EnemyBullet(int x, int y, int width, int height, int damage, int slow)
    {
        this(x, y, width, height);
        this.damage = damage;
        this.slow = slow;
    }

    public int getDamage() {
        return damage;
    }
}
