package com.xyz.preparation;

import java.io.File;

import com.xyz.util.XmlResolver;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : SqlConfiguration.java
 * 
 * 	策略类--全部加载
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class SqlXmlFullPreparation implements InitManager{

	private XmlResolver resolver ;
	
	private SqlXmlFullPreparation() {
		resolver = XmlResolver.Instance.XmlResolver.getInstance();
	}
	
	@Override
	public void init(String mappingLocation) {
		File sqlFiles = new File(mappingLocation);
		if(!sqlFiles.exists()) {
			throw new RuntimeException("映射文件路径不存在");
		}
		File[] sqlFileList = sqlFiles.listFiles();
		for(File sqlFile : sqlFileList) {
			resolver.parseXml(sqlFile);
		}
	}

	public enum Instance {
		
		SqlXmlFullPreparation;		
		private SqlXmlFullPreparation instance = null;
		
		private Instance() {
			instance = new SqlXmlFullPreparation();
		}
		public InitManager getInstance() {
			return instance;
		}
		
	}
}
