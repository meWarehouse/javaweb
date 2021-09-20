package com.practice;

import java.io.IOException;
import java.net.ContentHandlerFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SaxTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//获取解析器工厂
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		
		//通过解析器工厂获取解析器
		SAXParser saxParser = saxFactory.newSAXParser();
		
		//通过解析器获取到阅读器
		XMLReader xmlReader = saxParser.getXMLReader();
		
		//通过月读取读取需要操作的内容
		xmlReader.setContentHandler(new useContentHandler());
		
		xmlReader.parse("src/com/practice/test.xml");
		
		
	}
}



class useContentHandler extends  ContentHandlerImp{
	
	private boolean flag = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
//		System.out.println("------------------"+"uri"+uri + "---------localName"+localName+"---------qName" + qName + "---------atts" +atts);
		
		if(qName.equals("teacher")){
			flag = true;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
//		System.out.println(new String(ch,start,length));
		if(flag){
			System.out.println(new String(ch,start,length));
		
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("****************"+"uri" + uri + "********localName" + localName + "********qName" + qName);
		
		if(qName.equals("teacher")){
			flag = false;
		}
		
	}
	
}


class ContentHandlerImp implements ContentHandler{

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}
