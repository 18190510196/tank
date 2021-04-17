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

    static {
        try {
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
