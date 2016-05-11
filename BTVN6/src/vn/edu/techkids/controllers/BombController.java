package vn.edu.techkids.controllers;

import vn.edu.techkids.controllers.EnemyPlanes.EnemyPlaneController;
import vn.edu.techkids.controllers.EnemyPlanes.EnemyPlaneControllerManager;
import vn.edu.techkids.models.Bomb;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.models.GameObject;
import vn.edu.techkids.models.GameVector;
import vn.edu.techkids.views.GameDrawer;
import vn.edu.techkids.views.ImageDrawer;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Administrator on 5/10/2016.
 */

public class BombController extends SingleController implements Colliable {
    public BombController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dx = 0;
        gameVector.dy = 0;
        CollisionPool.getInst().add(this);
    }

    private static BombController bombController;
    public static BombController getBombController() {
        if (bombController == null) {
            Bomb bomb = new Bomb(300, 300, Bomb.WIDTH, Bomb.HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/bomb.png");
            bombController= new BombController(bomb, imageDrawer);
        }
        return bombController;
    }

    @Override
    public void run() {
        super.run();

    }

    @Override
    public void paint(Graphics g) {
        if(this.gameObject.isAlive())
        super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof PlaneController) {
//            c.getGameObject().setAlive(false);
            gameObject.setAlive(false);
            EnemyPlaneControllerManager enemyPlaneControllerManager = EnemyPlaneControllerManager.getInst();
            Vector<SingleController> enemyPlaneControllerVector = enemyPlaneControllerManager.getSingleControllerVector();
            Iterator<SingleController> iterator = enemyPlaneControllerVector.iterator();
            while(iterator.hasNext()) {
                SingleController singleController = iterator.next();
                iterator.remove();
            }
        }
    }
}
