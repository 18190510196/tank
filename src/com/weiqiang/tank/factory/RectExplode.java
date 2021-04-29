package com.weiqiang.tank.factory;

import com.weiqiang.tank.Audio;
import com.weiqiang.tank.ResourceMgr;
import com.weiqiang.tank.TankFrame;

import java.awt.*;

/**
 * @Description 爆炸对象
 * @Author weiqiang
 * @Date 2021/4/15 22:08
 **/
public class RectExplode extends BaseExplode {
    private int x, y;

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    TankFrame tf = null;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(() -> new Audio("audio/explode.wav").play()).run();

    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 20)
            tf.explodes.remove(this);
        g.setColor(c);
    }
}
