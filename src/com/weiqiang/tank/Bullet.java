package com.weiqiang.tank;

import java.awt.*;

/**
 * @Description 子弹对象
 * @Author weiqiang
 * @Date 2021/4/15 22:08
 **/
public class Bullet {
    private int x, y;
    private final int SPEED = 2;
    private Dir dir;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    TankFrame tf = null;
    private boolean living = true;//子弹状态

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    //碰撞检测
    public void collideWith(Tank tank) {
        Rectangle brec = new Rectangle(x, y, WIDTH, HEIGHT);
        Rectangle trec = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (brec.intersects(trec)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        living = false;
    }
}
