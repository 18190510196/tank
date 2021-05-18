package com.weiqiang.tank.collider;

import com.weiqiang.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 设计模式——责任链模式
 * @Author weiqiang
 * @Date 2021/5/13 22:30
 **/
public class ColliderChain implements Collider {
    List<Collider> colliders = new LinkedList<>();


    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c) {
        colliders.add(c);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;

    }
}
