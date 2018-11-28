package com.xyz.controller;

import java.util.Map;

public class ModifyExecutor extends AbstractExecutor {

	@Override
	public Object execute(String sqlName, Map<String, Object> params) {
		String sql = getSql(sqlName , params);
		return runSql(sql);
	}

	@Override
	protected Integer runSql(String sql) {
		//TODO 调用sql与处理层的方法执行sql，返回受影响的行数
		return null;
	}

}
