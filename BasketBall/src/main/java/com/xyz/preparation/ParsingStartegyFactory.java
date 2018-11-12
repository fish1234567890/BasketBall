package com.xyz.preparation;

public class ParsingStartegyFactory {
	
	public static final String Strategy_Priority = "1";
	
	public static final String Strategy_full = "0";
	
	public static InitManager getInstance(String strategy) {
		if(strategy == null || "".equals(strategy) || Strategy_Priority.equals(strategy)) {
			return SqlXmlPriorityPreparation.Instance.SqlXmlPriorityPreparation.getInstance();
		}else {
			return SqlXmlFullPreparation.Instance.SqlXmlFullPreparation.getInstance();
		}
	} 
}
