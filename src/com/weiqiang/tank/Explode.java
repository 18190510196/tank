package com.weiqiang.tank;

import java.awt.*;


/**
 * @Description 爆炸对象
 * @Author weiqiang
 * @Date 2021/4/15 22:08
 **/
public class Explode extends GameObject{

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    GameModel gm = null;
    private int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(()-> new Audio("audio/explode.wav").play()).run();

    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
           gm.remove(this);
    }
}
