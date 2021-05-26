package com.weiqiang.tank.decorator;

import com.weiqiang.tank.GameObject;

import java.awt.*;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/5/26 21:47
 **/
public class RectDecorator extends GODecorator {
    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);
        Color c = g.getColor();
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(super.go.x, super.go.y, super.go.getWidth(), super.go.getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }

}
