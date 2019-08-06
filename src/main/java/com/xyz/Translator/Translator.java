package com.xyz.Translator;

import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.RunableSql;
import com.xyz.entity.SqlDefinition;
import com.xyz.entity.SqlXmlFileHolder;

import java.util.Map;

public class Translator {

    public static <T> RunableSql<T> translateSql(String id, Map<String,Object> params,Class<T> resultType) throws ClassNotFoundException {

        String[] split = id.split("\\.");
        SqlXmlFileHolder holder = BasketConfiguration.SQLXMLS_HIGH_PRIORITY.get(split[0]);
        SqlDefinition definition = holder.map.get(split[1]);
        RunableSql<T> runableSql = new RunableSql<>();
        runableSql.setSql(definition.getSqlFormate());
        runableSql.setDatasource(BasketConfiguration.dataSourceList.get(definition.getDataSource()));
        runableSql.setResultType(resultType);
        if (params != null){

        }
        return runableSql;
    }
}
