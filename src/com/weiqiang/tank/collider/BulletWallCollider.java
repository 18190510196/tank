package com.weiqiang.tank.collider;

import com.weiqiang.tank.Bullet;
import com.weiqiang.tank.GameObject;
import com.weiqiang.tank.Tank;
import com.weiqiang.tank.Wall;

/**
 * @Description
 * @Author weiqiang
 * @Date 2021/5/13 21:36
 **/
public class BulletWallCollider implements Collider {
    //子弹和墙碰撞检测
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if (b.rect.intersects(w.rect)) {
                b.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            collide(o2, o1);
        }
        return true;

    }
}
