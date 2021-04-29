package com.weiqiang.tank.factory;

import com.weiqiang.tank.Dir;
import com.weiqiang.tank.Group;
import com.weiqiang.tank.TankFrame;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/27 22:24
 **/
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

}
