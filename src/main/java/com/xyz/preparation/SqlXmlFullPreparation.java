package com.xyz.preparation;

import java.io.File;
import java.net.URL;

import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.XmlFileInfo;
import com.xyz.util.CommonUtil.FileUtils;
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

	private String mappingLocation;

	public SqlXmlFullPreparation(String mappingLocation) {
		resolver = XmlResolver.Instance.XmlResolver.getInstance();
		this.mappingLocation = mappingLocation;
	}
	
	public void init() {
		File sqlFiles = FileUtils.getFromClassPathByName(mappingLocation);
		for(File sqlFile : sqlFiles.listFiles()) {
			loadSingleXmlFile(sqlFile);
		}
		BasketConfiguration.initTime = System.currentTimeMillis();
	}

	public void reloadXml(){
		if(System.currentTimeMillis() - BasketConfiguration.initTime < BasketConfiguration.initInterval){
			return;
		}
		File sqlFiles = FileUtils.getFromClassPathByName(mappingLocation);
		for (File sqlFile : sqlFiles.listFiles()) {
			XmlFileInfo xmlFileInfo = BasketConfiguration.XMLFILELIST.get(sqlFile.getName());
			if(sqlFile.lastModified() != xmlFileInfo.getLastModifyTime()){
				loadSingleXmlFile(sqlFile);
			}
		}
		BasketConfiguration.initTime = System.currentTimeMillis();
	}

	/**
	 * 加载单个sqlXml文件
	 * @param sqlFile
	 */
	private void loadSingleXmlFile(File sqlFile){
		resolver.parseXml(sqlFile);
		BasketConfiguration.XMLFILELIST.put(sqlFile.getName(),new XmlFileInfo(sqlFile.getName(),sqlFile,sqlFile.lastModified()));
	}
}
