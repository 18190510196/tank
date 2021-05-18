package com.weiqiang.tank;

import java.awt.*;


/**
 * @Description 墙
 * @Author weiqiang
 * @Date 2021/4/15 22:08
 **/
public class Wall extends GameObject {
    int w, h;
    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rect = new Rectangle(x, y, w, h);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);

    }
}
