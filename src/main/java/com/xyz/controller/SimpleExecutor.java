package com.xyz.controller;

import java.util.Map;

public class SimpleExecutor extends AbstractExecutor {

	@Override
	public Object execute(String sqlName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object runSql(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int insert(String tableName , Object params) {
		
		return 1;
	}
	
	public int update(String tableName , Object params) {
		
		return 1;
	}
	
	public int delete(String tableName , Object params) {
		
		return 1;
	}
	
	public int select(String tableName , Object params) {
		
		return 1;
	}
}
