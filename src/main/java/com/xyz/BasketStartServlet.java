package com.xyz;

import com.xyz.entity.BasketConfiguration;
import com.xyz.util.PropertyResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BasketStartServlet extends HttpServlet {

    private final String DEFAULT_CONFIG_LOCATION = "classpath:basketConfig.properties";

    public static BasketConfiguration configuration= null;
    @Override
    public void init() throws ServletException {
        //解析配置文件
        String configLocation = this.getInitParameter("configLocation");
        if(configLocation == null){
            configLocation = DEFAULT_CONFIG_LOCATION;
        }
        try {
            Properties properties = PropertyResolver.getFromClassPath(configLocation);
            configuration = new BasketConfiguration(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
