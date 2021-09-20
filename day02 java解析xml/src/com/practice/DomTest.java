package com.practice;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {
	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = factory.newDocumentBuilder();

		Document document = db.parse(new File("src/com/practice/test.xml"));

		domOperation(document);

	}

	public static void domOperation(Document document) throws TransformerException {

		// 读取节点内容
		// System.out.println("---------------------------------读取节点内容---------------------------------");
		// NodeList nodeList = document.getElementsByTagName("student");
		// Node node = nodeList.item(0);
		// String textContent = node.getTextContent();
		// System.out.println(textContent);

		// 设置节点内容
		System.out.println("---------------------------------设置节点内容---------------------------------");
		// NodeList nodeListSet = document.getElementsByTagName("name");
		// Node nodeSet = nodeListSet.item(1);
		// System.out.println(nodeListSet.getLength());
		// // for (int i = 0; i < nodeListSet.getLength(); i++) {
		// // System.out.println(nodeListSet.item(i).getTextContent());
		// // }
		// nodeSet.setTextContent("aa");
		// output(document);

		System.out.println("---------------------------------创建,插入，删除节点---------------------------------");
//
//		Element createElement = document.createElement("创建");
//		createElement.setTextContent("xdcfvgydvudi");
//
//		Element parentNode = (Element) document.getElementsByTagName("student").item(0);
//		// parentNode.appendChild(createElement);
//
//		// 插入
//		parentNode.insertBefore(createElement, document.getElementsByTagName("kc").item(0));
//
//		// 删除
//		Node removeChild = parentNode.removeChild(document.getElementsByTagName("班级").item(0));

		System.out.println("---------------------------------属性---------------------------------");

		NodeList student = document.getElementsByTagName("student");
		Element stu = (Element) student.item(0);
//		String attr = stu.getAttribute("id");
//		System.out.println(attr);
		
		stu.setAttribute("name","attrName");
		
		
		output(document);

	}

	private static void output(Document document) throws TransformerException {
		// 将内存中数据写入到文档中
		Source xmlSource = new DOMSource(document);
		Result xmlResult = new StreamResult(new File("src/com/practice/test.xml"));

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.transform(xmlSource, xmlResult);
	}

}
