package controller;

import Model.GameObject;
import view.GameDrawer;
import view.ImageDrawer;

/**
 * Created by Administrator on 4/29/2016.
 */
public class BulletController extends SingleController {
    public static final int SPEED = 15;
    public BulletController(GameObject gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = -SPEED;
    }

}
