package com.xyz.preparation;

import java.io.File;

import com.xyz.util.XmlResolver;

public class SqlXmlFullPreparation implements InitManager{

	private XmlResolver resolver ;
	
	private SqlXmlFullPreparation() {
		resolver = XmlResolver.Instance.XmlResolver.getInstance();
	}
	
	@Override
	public void init(String mappingLocation) {
		File sqlFiles = new File(mappingLocation);
		if(!sqlFiles.exists())
			throw new RuntimeException("映射文件路径不存在");
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
