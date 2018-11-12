package com.xyz.util;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.xyz.preparation.InitManager;
import com.xyz.preparation.SqlXmlFullPreparation;

public class XmlResolver extends DefaultHandler{

	private ThreadLocal<SAXParser> parser = new ThreadLocal<SAXParser>() {
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
	};
	

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

	public void parseXml(File sqlFile){
		
        parser.parse(sqlFile, new XmlResolver());

	}
}
