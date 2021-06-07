package com.weiqiang.tank;

import java.awt.*;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/5/12 23:17
 **/
public abstract class GameObject {
    public int x,y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();
}
