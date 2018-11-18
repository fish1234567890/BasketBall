package com.xyz.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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
 * 	sax和dom是jdk自带的两种解析xml的工具，所以也就是最底层的实现。sax的优点是速度贼快但是编码方式复杂，dom的优点是使用简单，但是
 * 	会占用内存，解析速度也很慢，sax的速度可以比dom快3倍左右。
 * 	
 * 
 * 	@author xuchongguang
 * 	@since 2018-11-11
 * 	@version 1.0.0
 * */
public class XmlResolver extends DefaultHandler{
	
	/*因为SAXParser是线程不安全的，因为框架的解析式动态的，所有为了追求解析的速度，采用ThreadLoacl来避免枷锁*/
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
		};
	
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
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}
	
	/*外部调用这个方法解析一个xml文件*/
	public void parseXml(File sqlFile){
		
        try {
			parser.get().parse(sqlFile, new XmlResolver());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
