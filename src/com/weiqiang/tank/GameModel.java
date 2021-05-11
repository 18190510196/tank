package com.weiqiang.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/5/11 22:51
 **/
public class GameModel {

    Tank mainTank = new Tank(200, 600, Dir.DOWN, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<Bullet>();
    public List<Tank> tanks = new ArrayList<Tank>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        for (int i = 0; i < 5; i++) {
            tanks.add(new Tank(50 + i * 50, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + tanks.size(), 10, 100);
        g.setColor(c);
        mainTank.paint(g);

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //子弹和敌人塔克的碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return mainTank;
    }
}
