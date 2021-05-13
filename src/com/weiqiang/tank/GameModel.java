package com.weiqiang.tank;

import com.weiqiang.tank.cor.BulletTankCollider;
import com.weiqiang.tank.cor.Collider;
import com.weiqiang.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 设计模式——门面模式（facade）
 * @Author weiqiang
 * @Date 2021/5/11 22:51
 **/
public class GameModel {

    Tank mainTank = new Tank(200, 600, Dir.DOWN, Group.GOOD, this);
    //    List<Bullet> bullets = new ArrayList<Bullet>();
//    public List<Tank> tanks = new ArrayList<Tank>();
//    List<Explode> explodes = new ArrayList<>();
    List<GameObject> objects = new ArrayList<>();
    BulletTankCollider cor = new BulletTankCollider();
    TankTankCollider ttc = new TankTankCollider();

    public GameModel() {
        for (int i = 0; i < 5; i++) {
            add(new Tank(50 + i * 50, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);
        mainTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //子弹和敌人塔克的碰撞检测
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                cor.collide(o1, o2);
                ttc.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return mainTank;
    }
}
