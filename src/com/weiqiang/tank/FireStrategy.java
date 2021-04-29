package com.weiqiang.tank;

import com.weiqiang.tank.factory.BaseTank;

/**
 * 坦克开火的策略模式设计
 */
public interface FireStrategy {
    void fire(BaseTank t);
}
