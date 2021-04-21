package com.weiqiang.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @Description 图片资源管理
 * @Author weiqiang
 * @Date 2021/4/17 15:50
 **/
public class ResourceMgr {
    public static BufferedImage goodTankL, goodTankD, goodTankU, goodTankR;
    public static BufferedImage badTankL, badTankD, badTankU, badTankR;
    public static BufferedImage bulletL, bulletD, bulletU, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            //坦克图片加载
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            //子弹图片加载
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);

            //爆炸图片加载
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
