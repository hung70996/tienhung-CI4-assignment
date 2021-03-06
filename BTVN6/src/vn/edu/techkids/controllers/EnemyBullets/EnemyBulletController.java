package vn.edu.techkids.controllers.EnemyBullets;


import vn.edu.techkids.controllers.*;
import vn.edu.techkids.models.*;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 5;
        CollisionPool.getInst().add(this);
    }

    public EnemyBulletController(GameObject gameObject,GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlaneController) {
            Plane plane = (Plane) c.getGameObject();
            plane.decreaseHP();
            if (plane.getHp() <= 0) {
                plane.setAlive(false);
            }
        } else if (c instanceof BulletController) {
            Bullet bullet = (Bullet) c.getGameObject();
            bullet.setAlive(false);
        }
    }

    public static EnemyBulletController creat (EnemyBulletType enemyBulletType, int x, int y) {
        EnemyBullet enemyBullet = new EnemyBullet(x, y, EnemyBullet.WIDTH, EnemyBullet.HEIGHT);
        EnemyBulletController enemyBulletController = null;
        GameVector gameVector = null;
        ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
        switch (enemyBulletType) {
            case DIRECT:
                gameVector = new GameVector(0 , 3);
                break;
            case LEFT:
                gameVector = new GameVector(-3 , 3);
                break;
            case RIGHT:
                gameVector = new GameVector(3 , 3);
                break;
        }
        enemyBulletController = new EnemyBulletController(enemyBullet, imageDrawer, gameVector);
        return enemyBulletController;
    }
}
