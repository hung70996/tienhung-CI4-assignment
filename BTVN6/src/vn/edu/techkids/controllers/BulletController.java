package vn.edu.techkids.controllers;

import vn.edu.techkids.controllers.EnemyBullets.EnemyBulletController;
import vn.edu.techkids.controllers.EnemyPlanes.EnemyPlaneController;
import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class BulletController extends SingleController implements Colliable {

    public static int SPEED = 15;

    public BulletController(Bullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = -SPEED;
        CollisionPool.getInst().add(this);
    }

    public BulletController(Bullet gameObject, ImageDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer);
        this.gameVector = gameVector;
        CollisionPool.getInst().add(this);
    }

    public static void increase () {
        SPEED *= 2;
        Bullet.increase();
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
        if (c instanceof EnemyPlaneController) {
            EnemyPlane enemyPlane = (EnemyPlane) c.getGameObject();
            enemyPlane.decreaseHP(Bullet.DAMAGE);
            if (enemyPlane.getHp() <= 0) {
                enemyPlane.setAlive(false);
            }
            gameObject.setAlive(false);

        } else if (c instanceof EnemyBulletController) {
            c.getGameObject().setAlive(false);
            gameObject.setAlive(false);
        }

    }
}







