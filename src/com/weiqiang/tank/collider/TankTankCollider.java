package com.weiqiang.tank.collider;

import com.weiqiang.tank.GameObject;
import com.weiqiang.tank.Tank;

/**
 * @Description
 * @Author weiqiang
 * @Date 2021/5/13 21:36
 **/
public class TankTankCollider implements Collider {
    //坦克和坦克碰撞检测
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.back();
                t2.back();
            }
        }
        return true;

    }
}