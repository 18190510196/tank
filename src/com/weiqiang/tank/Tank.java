package com.weiqiang.tank;

import java.awt.*;
import java.nio.Buffer;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/12 22:56
 **/
public class Tank {
    private static int x, y;
    Dir dir = Dir.DOWN;//默认方向
    private static final int SPEED = 10;//移动速度

    private boolean moving = false;//为false的时候坦克停止
    private TankFrame tf = null;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();


    public Tank(int x, int y, Dir dir, TankFrame tf) {
        super();
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            default:
                break;
        }
        move();

    }

    //判断坦克是否需要移动
    private void move() {
        if (!moving) return;
        switch (dir) {
            case DOWN:
                y += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.tf));
    }
}
