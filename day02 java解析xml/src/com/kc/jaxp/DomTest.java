package com.kc.jaxp;

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
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {
	private static final String Element = null;

	public static void main(String[] args) throws Exception {
		
		//获取工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//通过工厂产生解析器
		DocumentBuilder db = factory.newDocumentBuilder();
		
		//解析器解析xml文件返回一个新的 DOM Document 对象
		Document document = db.parse(new File("src/com/kc/jaxp/test.xml"));
		
		Document documentTest = db.parse(new File("src/com/kc/jaxp/testContent.xml"));
		
//		read(document);
		
//		update(document);
		
//		add(documentTest);
		
//		insert(documentTest);
		
//		delete(documentTest);
		
		updateAttr(documentTest);
		
	}
	
	//获取节点内容
	public static void read( Document document){
		
		//通过标签名获取标签对象
		NodeList nodeList = document.getElementsByTagName("name");
		
		Node node = nodeList.item(2);
		
		String textContent = node.getTextContent();
		
		System.out.println(textContent);
		
	} 
	
	//修改节点内容
	public static void update(Document document) throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError{
		
		NodeList nodeList = document.getElementsByTagName("course");
		
		Node node = nodeList.item(5);
		
		node.setTextContent("c++");//当前只在内存中修改  不能修改文件中内容
		
//		TransformerFactory.newTransformer
		
//		TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
		
//		Source xmlSource = new DOMSource(document);//源头
		
//		Result outputTarget = new StreamResult("src/com/kc/jaxp/test.xml");//写入的目标文件 
		
		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document),new StreamResult("src/com/kc/jaxp/test.xml"));
		
	}
	
	
	//创建节点
	public static void add(Document document) throws TransformerFactoryConfigurationError, TransformerException{
		/*
		 * 创建需要添加的节点
		 * 	Element createElement(String tagName)throws DOMException
		 * 		创建指定类型的元素
		 */
		Element el = document.createElement("备注");
		
		/*
		 * 添加节点内容
		 * 		Element的父Note
		 * 			void setTextContent(String textContent)
		 * 				此属性返回此节点及其后代的文本内容
		 * 
		 */
		el.setTextContent("天天学习，好好向上！！！");
		
		/*
		 * 获取增加节点的父
		 * 
		 */
		NodeList list = document.getElementsByTagName("test");
		Node parent = list.item(0);
		
		/*
		 * 将需要添加的节点挂到父节点上
		 * 		Node appendChild(Node newChild)throws DOMException
		 * 			将节点 newChild 添加到此节点的子节点列表的末尾。如果 newChild 已经存在于树中，则首先移除它。 	
		 * 			newChild - 要添加的节点
		 */
		parent.appendChild(el);
		
		/*
		 * 将内存中的数据添加到文档中
		 * 		public abstract void transform(Source xmlSource,Result outputTarget)
		 */
		Source xmlSource = new DOMSource(document);
		Result outputTarget = new StreamResult(new File("src/com/kc/jaxp/testContent.xml"));
		Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
		newTransformer.transform(xmlSource, outputTarget);
		
	}
	
	//插入节点
	public static void insert(Document document) throws Exception{
		
		//创建需要插入的节点
		Element element = document.createElement("测试");
		
		//为节点设置文本内容
		element.setTextContent("测试内容的节点");
		
		//获取父节点
		Node parent = document.getElementsByTagName("test").item(0);
		
		/*
		 * Node insertBefore(Node newChild,Node refChild)throws DOMException
		 * 		在现有子节点 refChild 之前插入节点 newChild
		 * 		newChild - 要插入的节点
		 * 		refChild - 引用节点，即必须在其前插入新节点的节点
		 */
		parent.insertBefore(element,document.getElementsByTagName("text").item(0));
		
		//将内存数据添加到文档中
		Source xmlSource = new DOMSource(document);//源
		Result outputTarget = new StreamResult(new File("src/com/kc/jaxp/testContent.xml"));//终
		TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
		
		
	}

	//删除
	public static void delete(Document document)throws Exception {
		
		//删除text标签
		Node node = document.getElementsByTagName("text").item(0);
		Node removeChild = node.getParentNode().removeChild(node);
		System.out.println(removeChild);
		
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File("src/com/kc/jaxp/testContent.xml"));
		TransformerFactory.newInstance().newTransformer().transform(domSource, streamResult);
		
	}

	//操作xml标签的属性
	public static void updateAttr(Document document) throws Exception{
		
		//获取需要操作属性的标签
		Node node = document.getElementsByTagName("test").item(0);
		Element el = (Element) node;
		
		Element el2 = (Element)document.getElementsByTagName("people").item(0);
	
		
		/*
		 * 设置标签属性
		 * 		void setAttribute(String name, String value)
		 * 			name - 要创建或更改的属性名称
		 * 			value - 以字符串形式设置的值
		 * 			如果属性名已存在则会更改,没如果不存在则创建
		 */
		el.setAttribute("name","name1001");
		el.setAttribute("id", "001");
		
		/*
		 * 移除一个属性
		 * 		void removeAttribute(String name)
		 */
		el.removeAttribute("name");
		
		
		/*
		 * 获取标签属性
		 * 		String getAttribute(String name) 
		 * 			通过名称获得属性值
		 */
		String attribute = el2.getAttribute("idName");
		System.out.println(attribute);
		
		DOMSource domSource = new DOMSource(document);
		StreamResult streamResult = new StreamResult(new File("src/com/kc/jaxp/testContent.xml"));
		TransformerFactory.newInstance().newTransformer().transform(domSource, streamResult);
		
		
	}
	
	
}
