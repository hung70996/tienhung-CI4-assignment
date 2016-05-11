package vn.edu.techkids.controllers.EnemyPlanes;

import vn.edu.techkids.controllers.EnemyBulletController;

/**
 * Created by Administrator on 5/9/2016.
 */
public interface EnemyShotBehavior {
    EnemyBulletController doShot(int x, int y);
}
