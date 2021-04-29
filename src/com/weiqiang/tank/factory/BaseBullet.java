package com.weiqiang.tank.factory;

import com.weiqiang.tank.Tank;

import java.awt.*;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/27 22:26
 **/
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}
