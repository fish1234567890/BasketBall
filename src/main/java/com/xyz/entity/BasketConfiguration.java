package com.xyz.entity;


import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.InitializingBean;

import com.xyz.preparation.InitManager;
import com.xyz.preparation.ParsingStartegyFactory;

import lombok.Data;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : BasketConfiguration.java
 * 
 * 	这个类起到存放框架的配置信息和初始化框架的作用，是框架的入口
 * 	这个类实例化的时候可以加载所有的Sqlxml文件。
 * 	使用单例的形式保证全局只有一份
 * 	与Spring集成使用的时候，只需要在applicationContext.xml文件中声明这个bean并且把需要的参数注入就可以
 * 	不需要在使用额外的xml配置文件
 * 	
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
@Data
public class BasketConfiguration implements InitializingBean{
	
	/* sqlXml文件的存放地址 */
	private String mappingLocation;
	
	/* 需要使用的数据库类型（现在支持mysql，oracle） */
	private String dbType;
	
	/* sqlXml文件的加载策略（1：全部加载  2：优先级加载（推荐）） */
	private String loadStrategy;
	
	/*存放第一优先级的sqlXml文件*/
	public static final HashMap<String, SqlConfiguration> sqlXmls_High_Priority = new HashMap<>() ;
	
	/*存放第其余优先级的sqlXml文件*/
	public static final LinkedHashMap<String, SqlConfiguration> sqlXmls_other_Priority = new LinkedHashMap<>() ;
	
	private BasketConfiguration() {}

	/*
	 * 	等待对象构造注入结束之后根据加载策略的不同来加载sqlXml文件到内存
	 * */
	@Override
	public void afterPropertiesSet() throws Exception {
		if(mappingLocation == null || dbType == null || loadStrategy == null) {
			throw new RuntimeException("初始化参数错误 -"+mappingLocation+","+dbType+","+loadStrategy);
		}
		InitManager strategy = ParsingStartegyFactory.getInstance(loadStrategy);
		strategy.init(mappingLocation);
	}
}
