package com.xyz.entity;


import java.util.*;

import com.alibaba.druid.pool.DruidDataSource;
import com.xyz.preparation.InitManager;
import com.xyz.preparation.ParsingStartegyFactory;


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
public class BasketConfiguration{

	/* sqlXml文件的存放地址 */
	private String mappingLocation;

	public static HashMap<String,DruidDataSource> dataSourceList = new HashMap<>();

	/* 需要使用的数据库类型（现在支持mysql，oracle） */
	private String dbType;

	/* sqlXml文件的加载策略（1：全部加载  2：优先级加载（推荐）） */
	private String loadStrategy;

	/*存放第一优先级的sqlXml文件*/
	public static final HashMap<String, SqlXmlFileHolder> SQLXMLS_HIGH_PRIORITY = new HashMap<>() ;

	/*存放第其余优先级的sqlXml文件*/
	public static final LinkedHashMap<String, SqlXmlFileHolder> SQLXMLS_OTHER_PRIORITY = new LinkedHashMap<>() ;

	/***
	 * 初始化配置
	 * */
	public BasketConfiguration(Properties properties) {
		this.mappingLocation = (String)properties.get("mappingLocation");
		//this.dbType = (String)properties.get("dbType");
		this.loadStrategy = (String)properties.get("loadStrategy");
		initDataSource(properties);


		initSqlFile();
	}

	private void initDataSource(Properties properties) {
		if(properties.get("datasource1.url") == null){
			throw new RuntimeException("数据源信息不完整");
		}
		int i = 1;
		while(true){
			if(properties.get("datasource"+i+".url") == null){
				break;
			}
			DruidDataSource dataSource = new DruidDataSource();
			dataSource.setPassword((String)properties.get("datasource"+i+".password"));
			dataSource.setUrl((String)properties.get("datasource"+i+".url"));
			dataSource.setUsername((String)properties.get("datasource"+i+".username"));
			dataSource.setDriverClassName((String)properties.get("datasource"+i+".driverClassName"));
			this.dataSourceList.put("datasource"+i,dataSource);
			i++;
		}
	}

	private void initSqlFile() {
		InitManager strategy = ParsingStartegyFactory.getInstance(loadStrategy);
		strategy.init(mappingLocation);
	}


	/*
	 * 	等待对象构造注入结束之后根据加载策略的不同来加载sqlXml文件到内存
	 * *//*
	@Override
	public void afterPropertiesSet() throws Exception {
		if(mappingLocation == null || dbType == null || loadStrategy == null) {
			throw new RuntimeException("初始化参数错误 -"+mappingLocation+","+dbType+","+loadStrategy);
		}
		InitManager strategy = ParsingStartegyFactory.getInstance(loadStrategy);
		strategy.init(mappingLocation);
	}*/
}
