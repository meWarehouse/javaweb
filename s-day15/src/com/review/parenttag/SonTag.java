package com.review.parenttag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SonTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		//1.得到父标签的引用
		JspTag parent = getParent(); //父标签无法获取子标签的引用   父标签的类型为 JspTag 类型(该接口是一个空接口  存在意义：用来统一 SimpleTag 和 Tag 的)
		
		//2.获取父标签的 name 属性
		ParentTag parentTag = (ParentTag)parent;
		String name = parentTag.getName();
		
		//3.将 name 值打印到 JSP 页面上
		getJspContext().getOut().print(name);
		
		
		
	}
	
	
}
