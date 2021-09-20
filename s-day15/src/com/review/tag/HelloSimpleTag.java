package com.review.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class HelloSimpleTag implements SimpleTag {

	private String value;
	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
		
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = pageContext.getOut();
		int count = 0;
		try {
			count = Integer.parseInt(time);
			for(int i = 0;i < count;i++) {
				out.print((i+1)+":"+value+"<br>");
			}
			
		} catch (NumberFormatException e) {
			System.out.println("输入的数据类型有误");
		}
		
		

	}

	private PageContext pageContext;
	
	@Override
	public void setJspContext(JspContext arg0) {
		this.pageContext = (PageContext) arg0;

	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");

	}

	

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");

	}
	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}
}
