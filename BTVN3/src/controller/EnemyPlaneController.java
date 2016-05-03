package controller;

import Model.Bullet;
import Model.EnemyBullet;
import Model.GameObject;
import Model.Plane;
import view.GameDrawer;
import view.ImageDrawer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Administrator on 5/2/2016.
 */
public class EnemyPlaneController extends SingleController {

    public int count = 0;
    public final static int SPEED = 1;
    public Vector<EnemyBulletController> enemyBulletControllerVector;
    public EnemyPlaneController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        enemyBulletControllerVector = new Vector<EnemyBulletController>();
    }

    public void move () {
        this.gameVector.dy += SPEED;
    }

    public void shot () {
        EnemyBullet enemyBullet = new EnemyBullet(gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.DEFAULT_WIDTH / 2,
                gameObject.getY() + gameObject.getHeight(),
                EnemyBullet.DEFAULT_WIDTH,
                EnemyBullet.DEFAULT_HEIGHT
                );
        ImageDrawer imageDrawer = new ImageDrawer("resources/bullet.png");
        EnemyBulletController enemyBulletController = new EnemyBulletController(enemyBullet, imageDrawer);
        this.enemyBulletControllerVector.add(enemyBulletController);
    }
    private static EnemyPlaneController enemyPlaneController;
    public static EnemyPlaneController getEnemyPlaneController(int x, int y) {
        Plane plane = new Plane(x, y, 50, 40);
        ImageDrawer imageDrawer = new ImageDrawer("resources/plane1.png");
        enemyPlaneController = new EnemyPlaneController(plane, imageDrawer);
        return enemyPlaneController;
    }

    @Override
    public void run() {
        super.run();
        for(EnemyBulletController enemyBulletController : this.enemyBulletControllerVector) {
            enemyBulletController.run();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(EnemyBulletController enemyBulletController : this.enemyBulletControllerVector) {
            enemyBulletController.paint(g);
        }
    }
}
