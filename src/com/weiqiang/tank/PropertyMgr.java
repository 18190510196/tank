package com.weiqiang.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description TODO
 * @Author weiqiang
 * @Date 2021/4/25 22:46
 **/
public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (null == props) return null;
        return props.get(key);
    }

    public static void main(String[] args) {
        Object name = props.get("name");
        System.out.println("=========="+(String)name);
    }
}
