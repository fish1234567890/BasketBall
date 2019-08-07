import com.xyz.controller.ModifyTemplete;
import com.xyz.controller.QueryTemplete;
import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.User;

import java.util.List;
import java.util.Properties;

public class TestClass {

    public static void main(String[] args) {
        //初始化框架
        Properties properties = new Properties();
        properties.setProperty("mappingLocation","/com/xyz/sqlxml");
        properties.setProperty("loadStrategy","0");
        properties.setProperty("datasource1.username","root");
        properties.setProperty("datasource1.password","etoak");
        properties.setProperty("datasource1.url","jdbc:mysql://localhost:3306/mysystem");
        properties.setProperty("datasource1.driverClassName","com.mysql.jdbc.Driver");
        properties.setProperty("dbType","mysql");
        BasketConfiguration configuration = new BasketConfiguration(properties);


        //开始CRUD
        /*QueryTemplete templete = new QueryTemplete();
        try{
            User user = new User();
            user.setId(1);
            List<User> query = templete.query("sql_first.mysql1", user, User.class);
            templete.query("")
            System.out.println("结束");
        }catch(Exception e){
            e.printStackTrace();
        }*/

        ModifyTemplete templete1 = new ModifyTemplete();
        try {
            templete1.execute("sql_first.mysql2");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
