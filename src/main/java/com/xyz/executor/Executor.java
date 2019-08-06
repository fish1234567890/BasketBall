package com.xyz.executor;

import com.xyz.entity.RunableSql;

import java.sql.ResultSet;
import java.util.List;

public interface Executor {

    <T> List<T> execute(RunableSql<T> runableSql);

}
