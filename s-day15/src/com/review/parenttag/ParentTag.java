package com.review.parenttag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport{

	private String name = "ATMYTAG";
	
	public String getName() {
		return name;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("父标签处理器的name:"+name);
		getJspBody().invoke(null);
		
		
	}
	
}
