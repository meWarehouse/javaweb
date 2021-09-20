package com.kc.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {
	
	private String value;
	private String count;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	

	//标签体的实际逻辑应该写到该方法中
	@Override
	public void doTag() throws JspException, IOException {
		
//		System.out.println("value:"+value+",count:"+count);
//		
//		System.out.println("doTag");
//		
//		pageContext.getOut().print("hello word");
//		
//		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
//		pageContext.getOut().print("hello:"+request.getParameter("name"));
//		
		
		JspWriter out = pageContext.getOut();
		int c = 0;
		
		c = Integer.parseInt(count);
		for(int i = 0;i<c;i++) {
			out.print(value);
			out.print("<br>");
		}
		
		
		
	}
	
	private PageContext pageContext;
	
	// JSP 引擎调用，然后将代表 JSP 页面的 PageContext 对象传入
	// PageContext 可以获取JSP页面的其他 8 个隐含对象 所以凡事 JSP 页面可以做的 标签处理器都可以完成
	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println(arg0 instanceof PageContext);
		
		this.pageContext = (PageContext) arg0;

	}

	@Override
	public void setParent(JspTag parent) {
		System.out.println("getParent");

	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}



	@Override
	public void setJspBody(JspFragment jspBody) {
		System.out.println("setJspBody");

	}

}













