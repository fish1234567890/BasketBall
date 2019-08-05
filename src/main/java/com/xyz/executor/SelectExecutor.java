package com.xyz.executor;

import com.xyz.entity.RunableSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectExecutor implements Executor {

    @Override
    public ResultSet execute(RunableSql runableSql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = runableSql.getSql();
        try{
            //获取链接
            connection = runableSql.getDatasource().getConnection();
            //3.创建语句集
            connection.prepareStatement(sql);
            //4.执行语句
            resultSet = preparedStatement.executeQuery();
            //5.整理结果集
            while(resultSet.next()){
                int anInt = resultSet.getInt(0);
                String string = resultSet.getString(1);
                System.out.println(anInt+"   "+string);
            }

            //6.关闭结果集，语句集，链接
        }catch(Exception e){

        }

        return null;
    }
}
