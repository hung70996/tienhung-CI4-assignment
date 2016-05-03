package view;

import Model.GameObject;

import java.awt.*;

/**
 * Created by Administrator on 4/29/2016.
 */
public interface GameDrawer {
    void paint (GameObject gameObject, Graphics g);
}
