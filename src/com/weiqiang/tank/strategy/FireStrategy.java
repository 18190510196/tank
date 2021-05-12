package com.weiqiang.tank.strategy;

import com.weiqiang.tank.Tank;

/**
 * 坦克开火的策略模式设计
 */
public interface FireStrategy {
    void fire(Tank t);
}
