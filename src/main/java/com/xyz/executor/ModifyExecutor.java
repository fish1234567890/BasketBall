package com.xyz.executor;

import com.xyz.entity.RunableSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModifyExecutor {

    public <T> Integer execute(RunableSql<T> runableSql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = runableSql.getSql();
        Integer result =  null;
        try{
            //获取链接
            connection = runableSql.getDatasource().getConnection();
            //3.创建语句集
            preparedStatement = connection.prepareStatement(sql);
            //4.执行语句
            result = preparedStatement.executeUpdate();
            //6.关闭结果集，语句集，链接
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try{
                    preparedStatement.close();

                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                }catch (Exception e3){
                    e3.printStackTrace();
                }
            }
        }
        return result;
    }
}
