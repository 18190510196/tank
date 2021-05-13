package com.weiqiang.tank.cor;

import com.weiqiang.tank.Bullet;
import com.weiqiang.tank.GameObject;
import com.weiqiang.tank.Tank;

/**
 * @Description
 * @Author weiqiang
 * @Date 2021/5/13 21:36
 **/
public class BulletTankCollider implements Collider {
    //子弹和坦克碰撞检测
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            b.collideWith(t);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        } else {
            return;
        }

    }
}
