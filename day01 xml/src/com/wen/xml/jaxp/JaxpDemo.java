package com.wen.xml.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JaxpDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException{
	
		/*
		 * java API javax.xml.parsers 类 DocumentBuilderFactory
		 * 
		 */
		
		/*
		 * 获取工厂类	
		 * DocumentBuilderFactory：
		 * 	public static DocumentBuilderFactory newInstance()
		 * 		获取 DocumentBuilderFactory 的新实例。
		 * 		
		 */
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		/*
		 * 使用工厂产生解析器 
		 *  DocumentBuilderFactory：
		 * 	public abstract DocumentBuilder newDocumentBuilder()throws ParserConfigurationException
		 * 		使用当前配置的参数创建一个新的 DocumentBuilder 实例。 
		 * 		返回：新的 DocumentBuilder 实例。 
		 * 	
		 */
		DocumentBuilder db = factory.newDocumentBuilder();
		
		/*
		 * 通过解析器解析xml文件
		 * 	DocumentBuilder:
		 * 		public Document parse(File f)throws SAXException,IOException 返回一个新的 DOM Document 对象
		 */
		Document document = db.parse(new File("src/com/wen/xml/jaxp/text.xml"));
		
		//获取节点内容
		read(document);
		
		update(document);
		
	}
	
	//获取节点内容
	public static void read(Document document){
		NodeList lists = document.getElementsByTagName("讲师");
		
		/*NodeList 接口提供对节点的有序集合的抽象，没有定义或约束如何实现此集合。DOM 中的 NodeList 对象是活动的
		 * 	Node item(int index)
		 * 		返回集合中的第 index 个项
		 * 		返回一个Note对象
		 */
		Node node = lists.item(1);
		
		/*
		 *	Node 
		 *		getTextContent() 获取节点内容
		 */
		String textContent = node.getTextContent();
		System.out.println(textContent);
		
	}
	
	//修改节点内容
	public static void update(Document document) throws TransformerException{
		
		//通过标签名 获取DOM中的NoteList对象
		NodeList lists = document.getElementsByTagName("人数");
		
		//定位到需要操作的节点
		Node node = lists.item(0);
		
		//设置节点内容   setTextContent();
		node.setTextContent("200"); //只在内存中修改
		
		/*
		 * 	类Source:所有已知实现类： DOMSource, JAXBSource, SAXSource, StAXSource, StreamSource 
		 * 		public interface Source
		 * 			实现此接口的对象包含充当源输入（XML 源或转换指令）所需的信息 
		 * 
		 * 		Source的实现类 DOMSource
		 * 			public DOMSource(Node n)
		 * 				创建带有 DOM 节点的新输入源 该操作将应用于以此节点为根的子树
		 */
		//源
//		Source xmlSource = new DOMSource(node);//DOM 节点的新输入源
		Source xmlSource = new DOMSource(document);
		
		/*
		 * javax.xml.transform 接口 Result
		 *		public interface Result 实现此接口的对象包含构建转换结果树所需的信息  充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记
		 *		该接口的实现类 DOMResult, JAXBResult, SAAJResult, SAXResult, StAXResult, StreamResult
		 *			该接口的实现类 DOMResult构造
		 *					public StreamResult(File f)
		 *						从 File 构造 StreamResult。 
		 */
		//目的
		Result result = new StreamResult(new File("src/com/wen/xml/jaxp/text.xml"));
		
		/*
		 * javax.xml.transform 
		 * 	类 Transformer 
		 * 		public abstract class Transformerextends Object 该类可以通过 TransformerFactory.newTransformer 方法获取此类的实例
		 * 			此抽象类的实例能够将源树转换为结果树
		 * 			public abstract void transform(Source xmlSource,Result outputTarget)throws TransformerException 将 XML Source 转换为 Result
		 * 				xmlSource - 要转换的 XML 输入
		 * 				outputTarget - 转换 xmlSource 的 Result
		 */
		
		/*
		 * TransformerFactory抽象类通过类public static TransformerFactory newInstance()throws TransformerFactoryConfigurationError方法
		 * 	获取 TransformerFactory 的新实例，再通过实例调用TransformerFactory.newTransformer() 方法获取Transformer类的实例
		 * 
		 */
		TransformerFactory fac = TransformerFactory.newInstance();
		Transformer newTransformer = fac.newTransformer();
		
		newTransformer.transform(xmlSource, result);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
