package com.xyz.preparation;

import java.io.File;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : SqlConfiguration.java
 * 
 * 	策略类--优先级加载
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class SqlXmlPriorityPreparation implements InitManager{

	@Override
	public void init(String mappingLocation) {
		File sqlFiles = new File(mappingLocation);
		if(!sqlFiles.exists()) {
			throw new RuntimeException("映射文件路径不存在");
		}
		File[] sqlFileList = sqlFiles.listFiles();
		for(File sqlFile : sqlFileList) {
			//TODO 按优先级解析
		}
		
	}
	public enum Instance {
		
		SqlXmlPriorityPreparation;		
		private SqlXmlPriorityPreparation instance = null;
		
		private Instance() {
			instance = new SqlXmlPriorityPreparation();
		}
		public InitManager getInstance() {
			return instance;
		}
		
	}
}
