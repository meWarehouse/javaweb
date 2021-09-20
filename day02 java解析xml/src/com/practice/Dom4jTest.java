package com.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.XMLReader;

public class Dom4jTest {
	public static void main(String[] args) throws DocumentException, IOException {
		
		SAXReader saxread = new SAXReader();
		
		Document document = saxread.read(new File("src/com/practice/test.xml"));
		
//		read(document);
		
		findXpath(document);
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public static void read(Document document) throws IOException{
		
		Element rootElement = document.getRootElement();
//		System.out.println(rootElement.getStringValue());
//		System.out.println(rootElement.getText());
		
//		Element element = rootElement.element("aa");
		Element element = rootElement.element("teacher");
//		Element element2 = element.element("name");
//		String text = element2.getText();
//		System.out.println(text);
//
//		element2.setAttributeValue("ids","000");
//		
		
		
//		Attribute attribute = element.attribute("id");
//		String value = attribute.getValue();
//		System.out.println(value);
		
		Element createElement = DocumentHelper.createElement("pppp");
		createElement.setAttributeValue("idc", "009");
		createElement.setText("scdvfvcdsf");
		element.add(createElement);
		
		boolean remove = element.remove(element.element("age"));
		System.out.println(remove);
		
		XMLWriter w = new XMLWriter(new FileOutputStream("src/com/practice/test.xml"));
		w.write(document);
		
	}
	
	
	public static void findXpath(Document document){
		
		List selectNodes = document.selectNodes("//创建");
		Element e = (Element) selectNodes.get(2);
		System.out.println(e.getText());
		
		
		
	}
	
	
}
