package com.weiqiang.tank;

import com.weiqiang.tank.factory.BaseTank;

/**
 * @Description 坦克默认开火模式
 * @Author weiqiang
 * @Date 2021/4/25 21:52
 **/
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        t.tf.gf.createBullet(bX,bY,t.dir,t.group,t.tf);
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).run();
    }
}
