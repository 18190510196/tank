package com.weiqiang.tank.strategy;

import com.weiqiang.tank.*;
import com.weiqiang.tank.decorator.RectDecorator;

/**
 * @Description 坦克默认开火模式
 * @Author weiqiang
 * @Date 2021/4/25 21:52
 **/
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        GameModel.getInstance().add(new RectDecorator(
                new Bullet(bX, bY, t.dir, t.group)));
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).run();
    }
}
