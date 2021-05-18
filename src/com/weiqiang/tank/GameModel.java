package com.weiqiang.tank;

import com.weiqiang.tank.collider.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author weiqiang
 * @Date 2021/5/11 22:51
 **/
public class GameModel {

    //单例模式
    private static final GameModel INSTATNCE = new GameModel();

    static {
        INSTATNCE.init();
    }

    Tank mainTank;
    List<GameObject> objects = new ArrayList<>();
    ColliderChain chain = new ColliderChain();

    public static GameModel getInstance() {
        return INSTATNCE;
    }

    private void init() {
        mainTank = new Tank(200, 600, Dir.DOWN, Group.GOOD);
        for (int i = 0; i < 5; i++) {
            new Tank(50 + i * 50, 200, Dir.DOWN, Group.BAD);
        }
        add(new Wall(200, 100, 80, 100));
        add(new Wall(500, 400, 50, 100));
        add(new Wall(600, 100, 60, 90));
        add(new Wall(400, 300, 70, 80));
    }

    private GameModel() {
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
                chain.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return mainTank;
    }
}
