package com.kc.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SaxDemo {

	/*
	 * 事件处理器 解析器在解析某一部分的文件时，只要解析到某一部分内容就会自动调用事件处理器处理数据
	 * 
	 * ContentHandler
	 * 
	 */

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// sax方式解析xml

		/*
		 * 获取解析器工厂 public static SAXParserFactory newInstance() 获取
		 * SAXParserFactory 的一个新实例
		 * 
		 */
		SAXParserFactory factory = SAXParserFactory.newInstance();

		/*
		 * 通过工厂创造解析器 public abstract SAXParser newSAXParser() 使用当前配置的工厂参数创建
		 * SAXParser 的一个新实例
		 */
		SAXParser sax = factory.newSAXParser();

		/*
		 * 获取阅读器对象 public abstract XMLReader getXMLReader()
		 */
		XMLReader reader = sax.getXMLReader();
		
		/*
		 * 允许应用程序注册内容事件处理程序
		 * 		void setContentHandler(ContentHandler handler)
		 * 			handler - 内容处理程序
		 */
//		reader.setContentHandler(new UseContentHandler());//传入一个类 该类中有需要处理的程序
		reader.setContentHandler(new UseContentHandlerTwo());

		/*
		 * 通过阅读器解析文件 void parse(String systemId) 从系统标识符 (URI) 解析 XML 文档 systemId
		 * - 系统标识符 (URI)。
		 */
		reader.parse("src/com/kc/sax/sax.xml");

	}

}



/**
 * 定义一个类继承ContentHandlerImp类 内容處理器
 * @Descripyion 描述
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月3日下午8:58:34
 *
 */
class UseContentHandler extends ContentHandlerImp {

	/**
	 * 接收元素开始的通知 
	 * 		uri - 名称空间 URI，如果元素没有名称空间 URI，或者未执行名称空间处理，则为空字符串 
	 * 		localName - 本地名称（不带前缀），如果未执行名称空间处理，则为空字符串
	 * 		qName - 限定名（带有前缀），如果限定名不可用，则为空字符串 
	 *		atts - 连接到元素上的属性。如果没有属性，则它将是空 Attributes 对象。在 startElement 返回后，此对象的值是未定义的
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("当前解析到了" + qName + "，这是个开始标签");
		/*
		 * 返回此列表中的属性个数
		 * 		int getLength()
		 * 通过索引查找属性的 XML 限定（前缀）名
		 * 		String getQName(int index)
		 * 通过 XML 限定（前缀）名查找属性的值
		 * 		String getValue(String qName)
		 * 
		 */
		for(int i = 0;i<atts.getLength();i++){
			String attrName = atts.getQName(i);
			String value = atts.getValue(attrName);
			System.out.println(attrName+"===="+value);
		}
	}

	/**
	 * 接收元素结束的通知 
	 * 		uri - 名称空间 URI，如果元素没有名称空间 URI，或者未执行名称空间处理，则为空字符串
	 * 		localName - 本地名称（不带前缀），如果未执行名称空间处理，则为空字符串
	 * 		qName - 限定的 XML 名称（带前缀），如果限定名不可用，则为空字符串
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("当前解析到了" + qName + "，这是个结束标签");
	}

	/**
	 * 接收字符数据的通知 
	 * 		ch - 来自 XML 文档的字符
	 * 		start - 数组中的开始位置
	 * 		length - 从数组中读取的字符的个数
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("当前解析到的内容为：" + new String(ch, start, length));
	}
}

/**
 * 
 * @Descripyion 定义一个类继承ContentHandlerImp获取指定的标签内容 的内容处理器
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月3日下午9:20:56
 *
 */
class UseContentHandlerTwo extends ContentHandlerImp{
	
	private boolean isFlag = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if(qName.equalsIgnoreCase("tiger")){
			isFlag = true;
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equalsIgnoreCase("tiger")){
			isFlag = false;
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(isFlag){
			System.out.println(new String(ch, start, length));
			
		}
	}
	
}


// 定义一个类实现ContentHandler接口
class ContentHandlerImp implements ContentHandler {

	/**
	 * 接收用来查找 SAX 文档事件起源的对象。
	 */
	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收文档的开始的通知
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收文档的结尾的通知
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 开始前缀 URI 名称空间范围映射
	 */
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 结束前缀 URI 范围的映射
	 */
	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收元素开始的通知
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

	}

	/**
	 * 接收元素结束的通知
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收字符数据的通知
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收元素内容中可忽略的空白的通知
	 */
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收处理指令的通知
	 */
	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	/**
	 * 接收跳过的实体的通知
	 */
	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

}
