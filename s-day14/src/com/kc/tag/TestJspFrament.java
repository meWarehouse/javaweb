package com.kc.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFrament extends SimpleTagSupport{

	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspFragment bodyContent = getJspBody();
		
		//JspFragment.invoke(Writer) :Writer 即为标签体内容输出的字符流，若为 null 则输出到 getJspContext().getOut() 即输出到页面面上
//		bodyContent.invoke(null);
		
		//1. 利用 StringWriter 得到标签体的内容
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);
		
		//2. 将标签体的内容都变为大写
		String content = sw.toString().toUpperCase();
		
		//3. 获取 JSP 页面中的 out 对象 输出到页面
		getJspContext().getOut().print(content);
		
		
	}
	
	
}
