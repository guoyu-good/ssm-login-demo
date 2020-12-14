package com.intouch.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;
@Component
public class PropertiesUtil {
    private static final String PAH="serviceMethods.properties";
    //声明properties对象
    private static Properties props=new Properties();
    //通过静态代码块填充properties文件到properties对象
    static{
        //获取本类的类加载器
        ClassLoader loader= PropertiesUtil.class.getClassLoader();
        //使用类加载器加载properties文件形成输入流
        InputStream is=loader.getResourceAsStream(PAH);
        //使用输入流填充对象
        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println("文件加载失败");
            e.printStackTrace();
        }
    }

    //创建方法通过属性名获取属性值
    public static String getValue(String key){
        String value=props.getProperty(key);
        return value;
    }


}
