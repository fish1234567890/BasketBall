package com.xyz.controller;

import java.io.File;
import java.sql.ResultSet;
import java.util.Map;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : Executor.java
 * 
 * 	所有查询调度类都要集成的抽象类，里面规定了查询执行类需要具备的能力
 * 	
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public abstract class AbstarctQueryExecutor extends AbstractExecutor {
	
	
	private String resolve(String sqlName , Object params) {
		if(sqlName == null || !sqlName.contains(".")) 
			throw new RuntimeException("sqlName格式错误： 我们需要【文件名】.【sql名】，但现在是" + sqlName);
		int index = sqlName.indexOf(".");
		File sqlFile = new File(sqlName.substring(0, index));
		String sql =  sqlName.substring(index+1);
		//TODO 调用sql预处理层的方法返回一个String类型的sql
		return "";
	}
	
	@Override
	protected String getSql(String sqlName , Map<String,Object> params) {
		String sql = resolve(sqlName,params);
		return sql;
	}
	
	@Override
	protected String getSql(String sqlName, String param) {
		String sql = resolve(sqlName,param);
		return sql;
	}

	@Override
	protected String getSql(String sqlName, int param) {
		String sql = resolve(sqlName , param);
		return sql;
	}

	@Override
	protected String getSql(String sqlName, double params) {
		String sql = resolve(sqlName , params);
		return sql;
	}

	@Override
	protected String getSql(String sqlName, boolean params) {
		String sql = resolve(sqlName , params);
		return sql;
	}

	@Override
	protected <T> String getSql(String sqlName, Class<T> params) {
		String sql = resolve(sqlName , params);
		return sql;
	}

	@Override
	protected String getSql(String sqlName) {
		String sql = resolve(sqlName , null);
		return sql;
	}

	@Override
	protected final ResultSet runSql(String sql) {
		//TODO 调用sql处理层的方法执行这个sql语句
		return null;
	}
	
	protected ResultSet getCache(String sql) {
		//TODO
		return null;
	};
	
	protected void addToCache(ResultSet result) {
		
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
			addToCache(result);
		}
		return formatResult(result);
	}
	


}
