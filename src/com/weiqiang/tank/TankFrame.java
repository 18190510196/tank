package com.weiqiang.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/12 22:36
 **/
public class TankFrame extends Frame {
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 800, SPEED = 10;
    Tank tank = new Tank(200, 200, Dir.DOWN, this);
    List<Bullet> bullets = new ArrayList<Bullet>();

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setTitle("tank war");
        setResizable(false);
        setVisible(true);//设置窗口可见
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //    双缓冲解决页面刷新问题
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+bullets.size(),10,60);
        g.setColor(c);
        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {

            bullets.get(i).paint(g);
        }

    }

    class MyKeyListener extends KeyAdapter {
        boolean bu = false;//向上
        boolean bd = false;//向下
        boolean br = false;//向右
        boolean bl = false;//向左

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bu && !bl && !bd && !br) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if (bu) tank.setDir(Dir.UP);
                if (bd) tank.setDir(Dir.DOWN);
                if (br) tank.setDir(Dir.RIGHT);
                if (bl) tank.setDir(Dir.LEFT);
            }
        }

    }


}
