package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.enemybullets.EnemyBulletController;
import vn.edu.techkids.controllers.enemybullets.EnemyBulletType;

/**
 * Created by Administrator on 5/14/2016.
 */
public class EnemySpecialShotBehavior implements EnemyShotBehavior {
    @Override
    public EnemyBulletController doShot(int x, int y) {
        return EnemyBulletController.creat(EnemyBulletType.SPECIAL, x, y);
    }
}
