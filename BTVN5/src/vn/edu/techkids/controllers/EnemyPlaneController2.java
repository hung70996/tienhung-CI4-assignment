package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyBullet;
import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.Plane;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneController2 extends SingleControllerWithHP implements Colliable {

    private EnemyBulletControllerManager2 enemyBulletControllerManager2;
    private EnemyPlaneController2 enemyPlaneController2;
    private int count = 0;

    public EnemyPlaneController2(EnemyPlane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 2;
        this.gameVector.dx = 2;
        enemyBulletControllerManager2 = new EnemyBulletControllerManager2();
        CollisionPool.getInst().add(this);
    }

    /* TODO override run */

    @Override
    public void run() {
        super.run();
        this.enemyBulletControllerManager2.run();
        count++;
        if (GameConfig.getInst().durationInSeconds(count) >= 1) {
            count = 0;
            EnemyBullet enemyBullet = new EnemyBullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.WIDTH / 2,
                    gameObject.getY() + gameObject.getHeight(),
                    EnemyBullet.WIDTH,
                    EnemyBullet.HEIGHT
            );
            ImageDrawer imageDrawer = new ImageDrawer("resources/enemy_bullet.png");
            EnemyBulletController2 enemyBulletController2 = new EnemyBulletController2(
                    enemyBullet,
                    imageDrawer
            );
            this.enemyBulletControllerManager2.add(enemyBulletController2);
        }

        if (!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.enemyBulletControllerManager2.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlaneController){
            Plane plane=(Plane)c.getGameObject();
            plane.decreaseHP(5);
            if(plane.getHp() <= 0) {
                plane.setAlive(false);
            }
        }
    }
}
