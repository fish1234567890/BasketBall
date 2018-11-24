package com.xyz.controller;

import java.io.File;
import java.sql.ResultSet;
import java.util.Map;

public abstract class AbstarctQueryExecutor extends AbstractExecutor {

	@Override
	protected String getSql(String sqlName , Map<String,Object> params) {
		if(sqlName == null || !sqlName.contains(".")) 
			throw new RuntimeException("sqlName格式错误： 我们需要【文件名】.【sql名】，但现在是" + sqlName);
		int index = sqlName.indexOf(".");
		File sqlFile = new File(sqlName.substring(0, index));
		String sql = sqlName.substring(index+1);
		//TODO 调用sql预处理层的方法返回一个String类型的sql
		return null;
	}
	@Override
	protected ResultSet runSql(String sql) {
		//TODO 调用sql处理层的方法执行这个sql语句
		return null;
	}
	
	protected ResultSet getCache(String sql) {
		return null;
	};
	
	protected void addToCache() {
		
	}
	
	protected Object formatResult(ResultSet result ) {
		
		return null;
		
	}
	@Override
	public Object execute(String sqlName , Map<String , Object> params) {
		String sql = getSql(sqlName , params);
		ResultSet result = getCache(sql);
		if(result == null) {
			result = runSql(sql);
		}
		return formatResult(result);
	}
	


}
