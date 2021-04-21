package com.weiqiang.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/12 22:56
 **/
public class Tank {
    public int x, y;
    Dir dir = Dir.DOWN;//默认方向
    private static final int SPEED = 3;//移动速度

    private boolean moving = true;//为false的时候坦克停止
    private boolean living = true;//存活状态
    private TankFrame tf = null;
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    private Group group = Group.BAD;//坦克分类，默认是敌人坦克

    Random random = new Random();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;
        this.tf = tf;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
        }
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
        if (random.nextInt(10) > 8) fire();
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public void die() {
        living = false;
    }
}
