import controller.EnemyPlaneController;
import controller.PlaneController;
import controller.PlaneDirection;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Timer;

/**
 * Created by Administrator on 4/24/2016.
 */
public class GameWindow extends Frame implements Runnable {



    Image backgroundImage;
    Thread thread;
    Image backbufferImage;
    PlaneController planeController1;
    PlaneController planeController2;
    EnemyPlaneController enemyPlaneController1;
    EnemyPlaneController enemyPlaneController2;
    EnemyPlaneController enemyPlaneController3;
    public GameWindow() {
       // thread = new Thread();
        this.setVisible(true); //Hien thi window
        this.setSize(400,600);
        this.planeController1 = PlaneController.getPlaneController1();
        this.planeController2 = PlaneController.getPlaneController2();
        this.enemyPlaneController1 = EnemyPlaneController.getEnemyPlaneController(75, 0);
        this.enemyPlaneController2 = EnemyPlaneController.getEnemyPlaneController(175, 0);
        this.enemyPlaneController3 = EnemyPlaneController.getEnemyPlaneController(275, 0);
        this.addWindowListener(new WindowListener() { //  close
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                PlaneDirection planeDirection1 = PlaneDirection.NONE;
                PlaneDirection planeDirection2 = PlaneDirection.NONE;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        planeDirection1 = PlaneDirection.UP;
                        break;

                    case KeyEvent.VK_DOWN:
                        planeDirection1 = PlaneDirection.DOWN;
                        break;

                    case KeyEvent.VK_LEFT:
                        planeDirection1 = PlaneDirection.LEFT;
                        break;

                    case KeyEvent.VK_RIGHT:
                        planeDirection1 = PlaneDirection.RIGHT;
                        break;

                    case KeyEvent.VK_W:
                        planeDirection2 = PlaneDirection.UP;
                        break;

                    case KeyEvent.VK_S:
                        planeDirection2 = PlaneDirection.DOWN;
                        break;

                    case KeyEvent.VK_A:
                        planeDirection2 = PlaneDirection.LEFT;
                        break;

                    case KeyEvent.VK_D:
                        planeDirection2 = PlaneDirection.RIGHT;
                        break;

                    case KeyEvent.VK_SPACE:
                        planeController1.shot();
                        break;

                    case KeyEvent.VK_ENTER:
                        planeController2.shot();
                        break;

                    case KeyEvent.VK_U:
                        enemyPlaneController1.shot();
                        enemyPlaneController2.shot();
                        enemyPlaneController3.shot();
                        break;
                }
                planeController1.move(planeDirection1);
                planeController2.move(planeDirection2);

            }
            @Override
            public void keyReleased(KeyEvent e) {
                PlaneDirection planeDirection1 = PlaneDirection.NONE;
                PlaneDirection planeDirection2 = PlaneDirection.NONE;
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        planeDirection1 = PlaneDirection.STOP_Y;
                        break;

                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        planeDirection1 = PlaneDirection.STOP_X;
                        break;

                    case KeyEvent.VK_W:
                    case KeyEvent.VK_S:
                        planeDirection2 = PlaneDirection.STOP_Y;
                        break;

                    case KeyEvent.VK_A:
                    case KeyEvent.VK_D:
                        planeDirection2 = PlaneDirection.STOP_X;
                        break;
                }
                planeController1.move(planeDirection1);
                planeController2.move(planeDirection2);
        }

        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {


            }
        });
        enemyPlaneController1.move();
        enemyPlaneController2.move();
        enemyPlaneController3.move();

        thread = new Thread(this);
        thread.start();
        //repaint();
    }

    @Override
    public void update(Graphics g) {
        if(backbufferImage == null) {
            backbufferImage = new BufferedImage(400, 600, 1);
        }
        Graphics backbufferGraphics = backbufferImage.getGraphics();
        //super.update(g);
        backbufferGraphics.drawImage(backgroundImage, 0, 0, null);
        planeController1.paint(backbufferGraphics);
        planeController2.paint(backbufferGraphics);
        enemyPlaneController1.paint(backbufferGraphics);
        enemyPlaneController2.paint(backbufferGraphics);
        enemyPlaneController3.paint(backbufferGraphics);
        g.drawImage(backbufferImage, 0, 0, null);
    }

    @Override
    public void run() {
        while(true) {
                try {
                    planeController1.run();
                    planeController2.run();
                    enemyPlaneController1.run();
                    enemyPlaneController2.run();
                    enemyPlaneController3.run();
                    enemyPlaneController3.count ++;
                    if (enemyPlaneController3.count == 117) {
                        enemyPlaneController1.shot();
                        enemyPlaneController2.shot();
                        enemyPlaneController3.shot();
                        enemyPlaneController3.count = 0;
                    }
                    repaint();
                    Thread.sleep(17);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }
}
