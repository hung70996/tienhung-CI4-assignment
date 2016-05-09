package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneControllerManager2 extends ControllerManager {

    private int count = 0;

    private EnemyPlaneControllerManager2() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count) > 5) {
            count = 0;

                EnemyPlane enemyPlane= new EnemyPlane(0, 0, 32, 32);
                ImageDrawer imageDrawer =
                        new ImageDrawer("resources/enemy_plane_white_1.png");
                EnemyPlaneController2 enemyPlaneController2 = new EnemyPlaneController2(
                        enemyPlane,
                        imageDrawer
                );
                this.singleControllerVector.add(enemyPlaneController2);

        }
    }

    private static EnemyPlaneControllerManager2 inst;
    public static EnemyPlaneControllerManager2 getInst() {
        if(inst == null) {
            inst = new EnemyPlaneControllerManager2();
        }

        return inst;
    }
}
