package com.xyz.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.SqlDefinition;
import com.xyz.entity.SqlXmlFileHolder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 	Copyright (C), 2006-2010, Xu.
 * 
 * 	文件名 : XmlResolver.java
 * 
 * 	解析XML文件的工具类
 * 	采用jdk的SAX来解析XML文件
 * 	多线程调用同一个本实例的parseXml()方法是线程不安全的。
 * 	因为在本框架中解析xml的过程天然不存在并发，所以并没有做并发控制。如果需要在并发场景中使用，请打开注释
 *
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class XmlResolver extends DefaultHandler{

	/*枚举实现单例*/
	public enum Instance {

		XmlResolver;
		private XmlResolver instance = null;

		private Instance() {
			instance = new XmlResolver();
		}
		public XmlResolver getInstance() {
			return instance;
		}

	}

	/*因为SAXParser是线程不安全的，因为框架的解析式动态的，所有为了追求解析的速度，采用ThreadLoacl来避免枷锁*//*
	private ThreadLocal<SAXParser> parser = new ThreadLocal<SAXParser>() ;
	protected SAXParser initialValue() {
		SAXParser newParser = null;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		try {
			newParser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return newParser;
	}*/
	


	private SqlXmlFileHolder holder = null;
	private String fileName = null;
	SqlDefinition definition;
	StringBuilder buff = null;
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(definition != null){
			buff.append(ch,start,length);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("=========sax文件解析结束============");
		BasketConfiguration.SQLXMLS_HIGH_PRIORITY.put(fileName,holder);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("sql".equals(qName)){
			definition.setSqlFormate(buff.toString().trim());
			holder.addToMap(definition.getId(),definition);
			definition = null;
		}
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("=========sax文件解析开始============");

		holder = new SqlXmlFileHolder();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if("sql".equals(qName)){
			definition = new SqlDefinition();
			buff = new StringBuilder();
			definition.setId(attributes.getValue("id"));
			definition.setResultType(attributes.getValue("resultType"));
			definition.setDataSource(attributes.getValue("datasource"));
		}
		if("filename".equals(qName)){
			fileName = attributes.getValue("value");
		}
	}
	
	/*外部调用这个方法解析一个xml文件*/
	public void parseXml(File sqlFile){
		fileName = sqlFile.getName();
        try {
			// 1. 得到SAX解析工厂
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			// 2. 让工厂生产一个sax解析器
			SAXParser newSAXParser = saxParserFactory.newSAXParser();
			// 3. 传入输入流和handler，解析
			newSAXParser.parse(sqlFile, new XmlResolver());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
