package com.xyz.controller;

import com.xyz.Translator.Translator;
import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.RunableSql;
import com.xyz.executor.SelectExecutor;
import com.xyz.preparation.SqlXmlFullPreparation;
import com.xyz.util.CommonUtil.CollectionUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	对用户暴露的查询方法
 * 	
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class QueryTemplete implements QueryTempleteInterface {

	private SelectExecutor executor;

	private Translator translator;

	private SqlXmlFullPreparation preparation;
	public QueryTemplete(SelectExecutor executor,Translator translator){
		this.executor = new SelectExecutor();
		this.translator = new Translator();
	}

	public <T> List<T> query(String id,Class<T> resultType) throws Exception{
		return baseQuery(id,null,resultType);
	}


	public <T> List<T> query(String id,Object params,Class<T> resultType) throws Exception{
		return baseQuery(id,CollectionUtils.convertToMap(params),resultType);
	}


	public <T> List<T> query(String id, Class<T> resultType,Map<String,Object> params) throws Exception {
		return baseQuery(id,params,resultType);
	}

/*	public <T> List<T> query(String id,Class<T> resultType,String ... params) throws Exception{
		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		for(String s : params){
			map.put("-",s);
		}
		return baseQuery(id,map,resultType);
	}*/

	public <T> T querySingle(String id,Class<T> resultType) throws Exception{
		List<T> ts = baseQuery(id, null, resultType);
		return ts.get(0);
	}

	public <T> T querySingle(String id, Class<T> resultType,Map<String,Object> params) throws Exception{
		List<T> ts = baseQuery(id, params, resultType);
		return ts.get(0);
	}

	/*public <T> T querySingle(String id,Class<T> resultType,String ... params) throws Exception{
		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		for(String s : params){
			map.put("-",s);
		}
		List<T> ts = baseQuery(id, map, resultType);
		return ts.get(0);
	}*/




	private <T> List<T> baseQuery(String id, Map<String,Object> params,Class<T> resultType) throws Exception {

		preparation.reloadXml();
		//预编译sql，获取最终可执行的sql
		RunableSql<T> runableSql = translator.getRunableSql(id, params, resultType);
		//执行sql
		return executor.execute(runableSql);
	}
}
