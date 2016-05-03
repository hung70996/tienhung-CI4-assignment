package controller;

import Model.GameObject;
import Model.GameVector;
import view.GameDrawer;

import java.awt.*;

/**
 * Created by Administrator on 4/29/2016.
 */
public class SingleController implements Controller {

    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;
    public SingleController (GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();
    }
    @Override
    public void run() {
        gameObject.move(gameVector);
    }

    @Override
    public void paint(Graphics g) {
        gameDrawer.paint(this.gameObject, g);
    }
}
