package vn.edu.techkids.controllers;

import vn.edu.techkids.models.BulletPresent;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Administrator on 5/11/2016.
 */
public class BulletPresentController extends SingleController implements Colliable{
    public BulletPresentController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void paint(Graphics g) {
        if (gameObject.isAlive()) {
            super.paint(g);
        }
    }

    private static BulletPresentController bulletPresentController;
    public static BulletPresentController getBulletPresentController() {
        if(bulletPresentController == null) {
            BulletPresent bulletPresent = new BulletPresent(400, 400, BulletPresent.WIDTH, BulletPresent.HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/bulletpresent.png");
            bulletPresentController = new BulletPresentController(bulletPresent, imageDrawer);
        }
        return bulletPresentController;
    }


    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlaneController) {
            gameObject.setAlive(false);
            BulletController.increase();
        }
    }
}
