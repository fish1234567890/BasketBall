package com.xyz.preparation;

import java.io.File;
import java.net.URL;

import com.xyz.util.XmlResolver;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : SqlXmlFileHolder.java
 * 
 * 	策略类--全部加载
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class SqlXmlFullPreparation implements InitManager{

	private XmlResolver resolver ;
	
	public SqlXmlFullPreparation() {
		resolver = XmlResolver.Instance.XmlResolver.getInstance();
	}
	
	public void init(String mappingLocation) {
		String path = getClass().getResource(mappingLocation).getFile();
		File sqlFiles = new File(path);
		if(!sqlFiles.exists()) {
			throw new RuntimeException("映射文件路径不存在");
		}
		File[] sqlFileList = sqlFiles.listFiles();
		for(File sqlFile : sqlFileList) {
			resolver.parseXml(sqlFile);
		}
	}

}
