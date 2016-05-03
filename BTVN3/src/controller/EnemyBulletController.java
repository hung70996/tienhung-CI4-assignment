package controller;

import Model.GameObject;
import view.GameDrawer;

/**
 * Created by Administrator on 5/2/2016.
 */
public class EnemyBulletController extends SingleController {
    public static final int SPEED = 5;
    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
    }

}
