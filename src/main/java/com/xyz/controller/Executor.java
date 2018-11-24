package com.xyz.controller;

import java.util.Map;
/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : Executor.java
 * 
 * 	所有执行调度类的父接口，实现这个接口可有拥有初级执行sql语句的能力。
 * 	execute() 是模板模式的模板方法，外部只能调用这个方法来执行一条sql语句，
 *  但是在不同场景下它的实现不同。
 *  
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public interface Executor {
	
	Object execute(String sqlName , Map<String,Object> params);
}
