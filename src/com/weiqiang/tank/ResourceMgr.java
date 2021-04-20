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

    static {
        try { 
            //坦克图片加载
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            //子弹图片加载
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
