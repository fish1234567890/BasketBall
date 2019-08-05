package com.xyz.executor;

import com.xyz.entity.RunableSql;

import java.sql.ResultSet;

public interface Executor {

    ResultSet execute(RunableSql runableSql);

}
