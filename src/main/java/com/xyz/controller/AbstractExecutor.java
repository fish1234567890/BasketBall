package com.xyz.controller;

import java.io.File;
import java.sql.ResultSet;
import java.util.Map;
/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : Executor.java
 * 
 * 	声明所有调度类都需要的方法
 * 
 * 	为什么把这些方法单独成一个抽象类而不是在Exceutor接口声明？
 * 	由于这两个方法是所有调度类都需要的方法并且我希望这些方法都仅仅是在实现类内部可用（这样可以最大可能的
 * 	避免内存逃逸现象的出现），
 * 	所以不能将这两个方法放在Executor接口中声明，因此我单独开了这一个抽象类，
 *  继承自Executor，声明了两个protect方法。
 *  以后如果还要新增其他所有调度类都需要并且希望仅仅是在实现类内部可用的方法，可以在这里面声明
 *  如果需要新增的方法是对外提供的，直接在Executor接口声明就好~
 *  
 * 	本框架里面还有两个实现这个类的抽象类：
 * 	1.AbstarctQueryExecutor
 * 	2.AbstarctModifyExecutor
 * 	这两个抽象类为查询操作和增删改操作实现了其特有的方法，其余的sql执行实现类都是直接继承自
 *	这两个抽象类
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public abstract class AbstractExecutor implements Executor{

	/*protected abstract String getSql(String sqlName , int param);
	
	protected abstract String getSql(String sqlName , double params);
	
	protected abstract String getSql(String sqlName , boolean params);*/
	
	protected String getSql(String sqlName, Map<String,Object> params) {
		String sql = resolve(sqlName , params);
		return sql;
	}
	protected String getSql(String sqlName) {
		String sql = resolve(sqlName , null);
		return sql;
	}
	
	protected abstract Object runSql(String sql);
	
	protected String resolve(String sqlName , Object params) {
		//1.根据sqlName找到sql语句
		if(sqlName == null || !sqlName.contains(".")) 
			throw new RuntimeException("sqlName格式错误： 我们需要【文件名】.【sql名】，但现在是" + sqlName);
		int index = sqlName.indexOf(".");
		File sqlFile = new File(sqlName.substring(0, index));
		String sql =  sqlName.substring(index+1);
		//TODO 调用sql预处理层的方法返回一个String类型的sql
		return "";
	}
	
}
