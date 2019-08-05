import com.xyz.entity.BasketConfiguration;

import java.util.Properties;

public class TestClass {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("mappingLocation","/com/xyz/sqlxml");
        properties.setProperty("loadStrategy","0");
        properties.setProperty("username","root");
        properties.setProperty("password","etoak");
        properties.setProperty("url","jdbc:mysql://localhost:3306/mysystem");
        properties.setProperty("driverClassName","com.mysql.jdbc.Driver");
        properties.setProperty("dbType","mysql");

        BasketConfiguration configuration = new BasketConfiguration(properties);


    }
}
