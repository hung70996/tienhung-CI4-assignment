package vn.edu.techkids.controllers.enemybullets;


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

    public EnemyBulletController(EnemyBullet gameObject,
                                 GameDrawer gameDrawer,
                                 GameVector gameVector) {
        super(gameObject, gameDrawer, gameVector);
        //System.out.println(gameObject.getClass().toString());
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
            ((PlaneController) c).slow(2);
            Plane plane = (Plane) c.getGameObject();
            EnemyBullet enemyBullet = (EnemyBullet)gameObject;
            plane.decreaseHP(enemyBullet.getDamage());

            if (plane.getHp() <= 0) {
                plane.setAlive(false);
            }

        }
        else if(c instanceof BulletController){
            //c.getGameObject().setAlive(false);
        }
    }

    public static EnemyBulletController creat (EnemyBulletType enemyBulletType, int x, int y) {
        EnemyBulletController enemyBulletController = null;
        GameVector gameVector = new GameVector(0, 3);
        ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
        switch (enemyBulletType) {
            case NORMAL:
                EnemyBullet normalEnemyBullet = new EnemyBullet(x, y, EnemyBullet.WIDTH, EnemyBullet.HEIGHT, 1);
                enemyBulletController = new EnemyBulletController(normalEnemyBullet, imageDrawer, gameVector);
                break;
            case SPECIAL:
                EnemyBullet specialEnemyBullet = new EnemyBullet(x, y, EnemyBullet.WIDTH, EnemyBullet.HEIGHT, 2, 2);
                enemyBulletController = new EnemyBulletController(specialEnemyBullet, imageDrawer, gameVector);
                break;
        }
        return enemyBulletController;
    }
}
