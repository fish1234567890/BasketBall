package com.xyz.preparation;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : SqlXmlFileHolder.java
 * 
 * 	生成策略类的工厂类
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class ParsingStartegyFactory {
	
	public static final String STRATEGY_PRIORITY = "1";
	
	public static final String STRATEGY_FULL = "0";
	
	/*public static InitManager getInstance(String strategy) {
		if(strategy == null || "".equals(strategy) || STRATEGY_PRIORITY.equals(strategy)) {
			return SqlXmlPriorityPreparation.Instance.SqlXmlPriorityPreparation.getInstance();
		}else if(STRATEGY_FULL.equals(strategy)){
			return new SqlXmlFullPreparation();
		}else {
			throw new RuntimeException("无法匹配相应的策略");
		}
	} */
}
