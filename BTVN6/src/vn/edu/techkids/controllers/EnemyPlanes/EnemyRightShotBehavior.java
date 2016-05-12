package vn.edu.techkids.controllers.EnemyPlanes;

import vn.edu.techkids.controllers.EnemyBullets.EnemyBulletController;
import vn.edu.techkids.controllers.EnemyBullets.EnemyBulletType;

/**
 * Created by Administrator on 5/12/2016.
 */
public class EnemyRightShotBehavior implements EnemyShotBehavior {
    @Override
    public EnemyBulletController doShot(int x, int y) {
        return EnemyBulletController.creat(EnemyBulletType.RIGHT, x, y);
    }
}
