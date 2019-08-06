package com.xyz.controller;

import com.xyz.Translator.Translator;
import com.xyz.entity.RunableSql;
import com.xyz.executor.SelectExecutor;

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
public class QueryTemplete  {

	final SelectExecutor executor = new SelectExecutor();

	/**
	 * 根据一个sql的id进行查询
	 *
	 * @param id  sql的id
	 * @param resultType  这个查询要返回的类型
	 * @return  一个list，list里面的类型是resultType中指定的类型
	 * @throws Exception
	 */
	public <T> List<T> query(String id,Class<T> resultType) throws Exception{
		return baseQuery(id,null,resultType);
	}

	/**
	 * 根据一个sql的id进行查询
	 *
	 * @param id  sql的id
	 * @param resultType  这个查询要返回的类型
	 * @param params  这个sql中要传递的参数
	 * @return  返回list，list里面的类型是resultType中指定的类型
	 * @throws Exception
	 */
	public <T> List<T> query(String id, Class<T> resultType,Map<String,Object> params) throws Exception {
		return baseQuery(id,params,resultType);
	}

	/**
	 * 根据一个sql的id进行查询
	 *
	 * @param id  sql的id
	 * @param resultType  这个查询要返回的类型
	 * @param params  这个sql中要传递的参数，这里是一个可变参数，可以接收任意个字符串
	 * @return  返回list，list里面的类型是resultType中指定的类型
	 * @throws Exception
	 */
	public <T> List<T> query(String id,Class<T> resultType,String ... params) throws Exception{
		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		for(String s : params){
			map.put("-",s);
		}
		return baseQuery(id,map,resultType);
	}

	/**
	 * 根据一个sql的id进行查询，如果这个sql会查询出多个结果，只会返回第一个结果
	 *
	 * @param id  sql的id
	 * @param resultType  这个查询要返回的类型
	 * @return  单个对象
	 * @throws Exception
	 */
	public <T> T querySingle(String id,Class<T> resultType) throws Exception{
		List<T> ts = baseQuery(id, null, resultType);
		return ts.get(0);
	}

	/**
	 * 根据一个sql的id进行查询，如果这个sql会查询出多个结果，只会返回第一个结果
	 *
	 * @param id  sql的id
	 * @param resultType  这个查询要返回的类型
	 * @param params  这个sql中要传递的参数
	 * @return  单个对象
	 * @throws Exception
	 */
	public <T> T querySingle(String id, Class<T> resultType,Map<String,Object> params) throws Exception{
		List<T> ts = baseQuery(id, params, resultType);
		return ts.get(0);
	}

	/**
	 * 根据一个sql的id进行查询，如果这个sql会查询出多个结果，只会返回第一个结果。
	 *
	 *
	 * @param id  sql的id
	 * @param resultType  这个查询要返回的类型
	 * @param params  这个sql中要传递的参数，这里是一个可变参数，可以接收任意个字符串
	 * @return  单个对象
	 * @throws Exception
	 */
	public <T> T querySingle(String id,Class<T> resultType,String ... params) throws Exception{
		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		for(String s : params){
			map.put("-",s);
		}
		List<T> ts = baseQuery(id, map, resultType);
		return ts.get(0);
	}

	private <T> List<T> baseQuery(String id, Map<String,Object> params,Class<T> resultType) throws Exception {
		//预编译sql，获取最终可执行的sql
		RunableSql<T> runableSql = Translator.translateSql(id, params, resultType);
		//执行sql
		return executor.execute(runableSql);
	}
}
