package com.weiqiang.tank.cor;

import com.weiqiang.tank.GameObject;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/5/13 21:32
 **/
public interface Collider {
    public void collide(GameObject o1, GameObject o2);
}
