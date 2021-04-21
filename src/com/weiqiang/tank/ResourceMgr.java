package com.weiqiang.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * @Description 图片资源管理
 * @Author weiqiang
 * @Date 2021/4/17 15:50
 **/
public class ResourceMgr {
    public static BufferedImage tankL, tankD, tankU, tankR;
    public static BufferedImage bulletL, bulletD, bulletU, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            //坦克图片加载
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankL = ImageUtil.rotateImage(tankU, -90);
            tankR = ImageUtil.rotateImage(tankU, 90);
            tankD = ImageUtil.rotateImage(tankU, 180);
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
