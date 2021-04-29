package com.weiqiang.tank.factory;

import com.weiqiang.tank.Dir;
import com.weiqiang.tank.Group;
import com.weiqiang.tank.TankFrame;

import java.awt.*;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/27 22:26
 **/
public abstract class BaseTank {
    public int x, y;
    public  Dir dir = Dir.DOWN;//默认方向
    public Group group = Group.BAD;//坦克分类，默认是敌人坦克
    public TankFrame tf = null;
    public abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir up);
}
