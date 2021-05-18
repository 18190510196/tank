package com.weiqiang.tank.collider;

import com.weiqiang.tank.Bullet;
import com.weiqiang.tank.Explode;
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
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.group == t.getGroup()) return true;
            if (b.rect.intersects(t.rect)) {
                t.die();
                b.die();
                //控制爆炸在坦克中心位置
                int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                new Explode(eX, eY);
                return false;
            }
            return true;

        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        }
        return true;

    }
}
