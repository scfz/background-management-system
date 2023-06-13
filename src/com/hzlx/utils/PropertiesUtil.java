package com.hzlx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// 读取配置文件
public class PropertiesUtil {
    private static Properties properties;
    private PropertiesUtil(){};
    // 静态代码块创建对象(单例模式实现方法)
    static {
        properties = new Properties();
    }
    /**
     * 读取配件的名字
     * 只需输入名字即可,无需加后缀名
     * */
    public static void load(String fileName){
        // 专门用来读取properties文件
        // 配置文件转成一个流  只需写名字即可
        InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName + ".properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            System.out.println("加载配置文件异常");
            e.printStackTrace();
        }
    }
    /**
     * 根据配置文件中的key获取指定的值
     *
     */
    public static String getValue(String Key){
        return properties.get(Key).toString();
    }
}
