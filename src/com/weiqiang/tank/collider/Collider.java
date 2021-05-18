package com.weiqiang.tank.collider;

import com.weiqiang.tank.GameObject;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/5/13 21:32
 **/
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
