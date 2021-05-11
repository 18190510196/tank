package com.weiqiang.tank.factory;

import com.weiqiang.tank.*;

import java.awt.*;
import java.util.Random;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/12 22:56
 **/
public class RectTank extends BaseTank {
    public Rectangle rect = new Rectangle();
    private static final int SPEED = 6;//移动速度

    private boolean moving = true;//为false的时候坦克停止
    private boolean living = true;//存活状态
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    Random random = new Random();

    FireStrategy fs;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.group = group;
        this.tf = tf;
        rect.x = x;
        rect.y = y;
        rect.height = HEIGHT;
        rect.width = WIDTH;
        if (group == Group.GOOD) {
            String goodName = (String) PropertyMgr.get("goodFS");
            try {
                fs = (FourFireStrategy) Class.forName(goodName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            String badName = (String) PropertyMgr.get("badFS");
            try {
                fs = (DefaultFireStrategy) Class.forName(badName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
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
@Override
    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
        }
        Color c=g.getColor();
        g.setColor(group==Group.BAD?Color.blue:Color.yellow);
        g.fillRect(x,y,50,50);
        g.setColor(c);
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
        if (random.nextInt(100) > 95 && this.group == Group.BAD) {
            this.fire();
        }
        //敌人坦克随机移动
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            randomMove();
        }
        boundsCheck();
        rect.x = this.x;
        rect.y = this.y;
    }

    //坦克边界控制
    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH - RectTank.WIDTH - 2) x = TankFrame.GAME_WIDTH - RectTank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT - 2;
    }

    private void randomMove() {
        dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        fs.fire(this);
    }

    public void die() {
        living = false;
    }
}
