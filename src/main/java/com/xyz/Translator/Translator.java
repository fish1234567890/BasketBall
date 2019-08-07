package com.xyz.Translator;

import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.RunableSql;
import com.xyz.entity.SqlDefinition;
import com.xyz.entity.SqlXmlFileHolder;

import java.util.Map;

public class Translator {

    public <T> RunableSql<T> getRunableSql(String id, Map<String,Object> params,Class<T> resultType) throws ClassNotFoundException {
        //根据sql的id获取SqlDefinition
        SqlDefinition definition = getSqlDefinition(id);
        //解析sql语句，拼装参数
        getTranslatedSql(definition.getSqlFormate(),params);

        RunableSql<T> runableSql = new RunableSql<>();
        runableSql.setSql(definition.getSqlFormate());
        runableSql.setDatasource(BasketConfiguration.dataSourceList.get(definition.getDataSource()));
        runableSql.setResultType(resultType);

        return runableSql;
    }

    private static SqlDefinition getSqlDefinition(String id) {
        String[] split = id.split("\\.");
        //根据前缀获取SqlXmlFileHolder
        SqlXmlFileHolder holder = BasketConfiguration.SQLXMLS_HIGH_PRIORITY.get(split[0]);
        //根据后缀获取SqlXmlFileHolder中的一个SqlDefinition
        return holder.map.get(split[1]);
    }

    private String getTranslatedSql(String originalSql,Map<String,Object> params){
        return "";
    }
}
