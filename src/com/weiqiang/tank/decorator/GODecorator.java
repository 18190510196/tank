package com.weiqiang.tank.decorator;

import com.weiqiang.tank.GameObject;

import java.awt.*;

/**
 * @Description decorator装饰模式
 * @Author weiqiang
 * @Date 2021/5/26 21:36
 **/
public abstract class GODecorator extends GameObject {
    GameObject go;

    @Override
    public abstract void paint(Graphics g);

    public GODecorator(GameObject go) {
        this.go = go;
    }
}
