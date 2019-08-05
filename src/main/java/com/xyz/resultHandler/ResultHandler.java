package com.xyz.resultHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class ResultHandler {

    public static List<?> formateResult(ResultSet result, Class resultType) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Object instance = resultType.newInstance();

        ResultSetMetaData metaData = result.getMetaData();
        int count = metaData.getColumnCount();

        while(result.next()){
            for(int i = 1;i<=count;i++){
                String columnName = result.getMetaData().getColumnLabel(i);
                Field declaredField = resultType.getDeclaredField(columnName);
                declaredField.setAccessible(true);
                declaredField.set(instance,result.getObject(columnName));
            }
        }
    }

}
