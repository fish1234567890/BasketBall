package com.xyz.util;

import com.xyz.BasketStartServlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyResolver {

    /*枚举实现单例*/
    public enum Instance {

        PropertyResolver;
        private PropertyResolver instance = null;

        private Instance() {
            instance = new PropertyResolver();
        }
        public PropertyResolver getInstance() {
            return instance;
        }

    }

    public static Properties getFromClassPath(String path) throws IOException {
        //读取配置文件
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStream in = BasketStartServlet.class.getClassLoader().getResourceAsStream(path);
        // 使用properties对象加载输入流
        properties.load(in);
        return properties;
    }
}
