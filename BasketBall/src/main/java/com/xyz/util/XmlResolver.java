package com.xyz.util;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlResolver extends DefaultHandler{

	SAXParserFactory factory;
	
	private XmlResolver () {
		factory = SAXParserFactory.newInstance();
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

	public void parseXmlToPojo(String mappingLocation){
		SAXParser parser = factory.newSAXParser();
		File sqlXmls = new File(mappingLocation);
		if(sqlXmls.isDirectory()) {
			for(File sql : sqlXmls.listFiles()) {
				
			}
		}
        
        
        parser.parse(new File("books.xml"), new XmlResolver());

	}
}
