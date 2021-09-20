package com.kc.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jDemo {
	public static void main(String[] args) throws DocumentException, IOException {
		
		//创建SAXReader对象
		SAXReader reader = new SAXReader();
		
		
		Document document = reader.read(new File("src/com/kc/jaxp/testContent.xml"));
		
		read(document);
		
//		add(document);
		
//		update(document);
		
//		delete(document);
		
		
	}
	
	//读取
	public static void read(Document document){
		//获取根节点
		Element root = document.getRootElement();
		//通过根节点获取指定节点对象
		Element element = root.element("content");
		Attribute attribute2 = root.attribute("id");
		System.out.println("test:id="+attribute2.getValue());
		//获取节点内容
		String text = element.getText();
		
		System.out.println("content:"+text);
		
		Element element2 = root.element("people");
		//读取属性名
		Attribute attribute = element2.attribute("idName");
		//通过属性名获取属性值
		String value = attribute.getValue();
		System.out.println("people:idName= "+value);
		
	}
	
	//添加
	@SuppressWarnings("resource")
	public static void add(Document document) throws IOException{
		
		//创建节点
		Element element = DocumentHelper.createElement("aa");
		
		element.setText("好多aaaaaaaaaaaa");
		
		//将节点挂到父节点上
		document.getRootElement().add(element);
		
		//读取到文件中
//		XMLWriter w = new XMLWriter();
//		OutputStream stream = new FileOutputStream("src/com/kc/jaxp/testContent.xml");
		XMLWriter w = new XMLWriter(new FileOutputStream("src/com/kc/jaxp/testContent.xml"));
		w.write(document);
	}
	
	//修改
	public static void update(Document document) throws IOException{
		
		//获取需要更改的节点
		Element element = document.getRootElement().element("测试");
		element.setText("efrvfdgfb");
		
		XMLWriter w = new XMLWriter(new FileOutputStream("src/com/kc/jaxp/testContent.xml"));
		w.write(document);
		
		
	}
	
	//删除
	public static void delete(Document document) throws IOException{
		
		Element element = document.getRootElement().element("content");
		element.getParent().remove(element);
		
		XMLWriter w = new XMLWriter(new FileOutputStream("src/com/kc/jaxp/testContent.xml"));
		w.write(document);
	}
}
