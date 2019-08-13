package com.xyz.Translator;

import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.RunableSql;
import com.xyz.entity.SqlDefinition;
import com.xyz.entity.SqlXmlFileHolder;
import com.xyz.util.CommonUtil.CollectionUtils;
import com.xyz.util.CommonUtil.StringUtils;

import java.util.Map;

public abstract class AbstractTranslator implements Translator {

    protected ExpressionHandler expressionHandler = new ExpressionHandler();

    @Override
    public <T> RunableSql<T> getRunableSql(String id, Map<String,Object> params,Class<T> resultType)  {
        //根据sql的id获取SqlDefinition
        SqlDefinition definition = getSqlDefinition(id);
        //解析sql语句，拼装参数
        RunableSql<T> runableSql = getTranslatedSql(definition, params, resultType);

        return runableSql;
    }

    protected static SqlDefinition getSqlDefinition(String id) {
        String[] split = id.split("\\.");
        //根据前缀获取SqlXmlFileHolder
        SqlXmlFileHolder holder = BasketConfiguration.SQLXMLS_HIGH_PRIORITY.get(split[0]);
        //根据后缀获取SqlXmlFileHolder中的一个SqlDefinition
        return holder.map.get(split[1]);
    }

    protected <T> RunableSql<T> getTranslatedSql(SqlDefinition definition, Map<String,Object> params, Class<T> resultType){
        //获取sql语句中的参数列表
        Map<String, Object> sqlParamList = StringUtils.getPatternList("#{}", definition.getSqlFormate());
        //获取实际参数列表
        Map<String, Object> realParams = CollectionUtils.getIntersection(sqlParamList, params);
        //擦除sql中多余的参数并且替换成？
        String sql = translate(definition.getSqlFormate(),realParams);

        RunableSql<T> runable = new RunableSql<>();
        runable.setSql(sql);
        runable.setDatasource(BasketConfiguration.dataSourceList.get(definition.getDataSource()));
        runable.setResultType(resultType);

        return runable;
    }

    protected abstract String translate(String originalSql, Map<String, Object> realParams);
}
