package com.xyz.entity;

public class SqlDefinition {

    private String sqlFormate;

    private String ResultType;

    private String id;

    private String dataSource;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqlFormate() {
        return sqlFormate;
    }

    public void setSqlFormate(String sqlFormate) {
        this.sqlFormate = sqlFormate;
    }

    public String getResultType() {
        return ResultType;
    }

    public void setResultType(String resultType) {
        ResultType = resultType;
    }
}
