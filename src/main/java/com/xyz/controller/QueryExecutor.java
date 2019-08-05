package com.xyz.controller;

import com.xyz.Translator.Translator;
import com.xyz.entity.RunableSql;
import com.xyz.executor.SelectExecutor;
import com.xyz.resultHandler.ResultHandler;

import java.sql.ResultSet;
import java.util.List;
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
public class QueryExecutor  {

	final SelectExecutor executor = new SelectExecutor();

	public List<?> query(String id) throws ClassNotFoundException{
		return baseQuery(id,null);
	}

	public List<?> query(String id, Map<String,Object> params) throws ClassNotFoundException {
		return baseQuery(id,params);
	}

	private List<?> baseQuery(String id, Map<String,Object> params) throws ClassNotFoundException {
		//预编译sql，获取最终可执行的sql
		RunableSql runableSql = Translator.translateSql(id , params);
		//执行sql
		ResultSet execute = executor.execute(runableSql);
		//处理结果集
		return ResultHandler.formateResult(execute,runableSql.getResultType());
	}
}
