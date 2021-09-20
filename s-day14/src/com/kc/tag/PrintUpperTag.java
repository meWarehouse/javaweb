package com.kc.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintUpperTag extends SimpleTagSupport {

	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		//1.获取标签体的内容
		JspFragment jspBody = getJspBody();
		StringWriter sw = new StringWriter();
		jspBody.invoke(sw);
		
		//2.转为大写
		String content = sw.toString().toUpperCase();
		
		//3.得到 out 对象 并将转为大写的内容输出到控制台上
		
		int count = 1;
		
		try {
			count = Integer.parseInt(time);
		} catch (NumberFormatException e) {}
		
		JspWriter out = getJspContext().getOut();
		out.print("<br>");
		for(int i = 0;i < count;i++) {
			out.print((1+i)+":"+content);
			out.print("<br>");
		}
		
		
	}
	
}
