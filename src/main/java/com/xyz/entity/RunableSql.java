package com.xyz.entity;

import javax.sql.DataSource;
import java.util.Map;

public class RunableSql<T> {

    private String sql;

    private DataSource datasource;

    private Class<T> resultType;

    private Map<String,Object> RealParams;

    public Map<String, Object> getRealParams() {
        return RealParams;
    }

    public void setRealParams(Map<String, Object> realParams) {
        RealParams = realParams;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public DataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    public Class<T> getResultType() {
        return resultType;
    }

    public void setResultType(Class<T> resultType) {
        this.resultType = resultType;
    }
}
