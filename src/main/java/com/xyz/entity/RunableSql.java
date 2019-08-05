package com.xyz.entity;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class RunableSql {

    private String sql;

    private DataSource datasource;

    private Class resultType;

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

    public Class getResultType() {
        return resultType;
    }

    public void setResultType(Class resultType) {
        this.resultType = resultType;
    }
}
