package com.xyz.preparation;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : SqlConfiguration.java
 * 
 * 	生成策略类的工厂类
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class ParsingStartegyFactory {
	
	public static final String Strategy_Priority = "1";
	
	public static final String Strategy_Full = "0";
	
	public static InitManager getInstance(String strategy) {
		if(strategy == null || "".equals(strategy) || Strategy_Priority.equals(strategy)) {
			return SqlXmlPriorityPreparation.Instance.SqlXmlPriorityPreparation.getInstance();
		}else if(Strategy_Full.equals(strategy)){
			return SqlXmlFullPreparation.Instance.SqlXmlFullPreparation.getInstance();
		}else {
			throw new RuntimeException("无法匹配相应的策略");
		}
	} 
}
