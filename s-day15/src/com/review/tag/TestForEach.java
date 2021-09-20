package com.review.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestForEach extends SimpleTagSupport{

	private Collection<?> items;
	private String var;
	
	public void setItems(Collection<?> items) {
		this.items = items;
	}
	
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		for(Object obj : items) {
			
			getJspContext().setAttribute(var,obj);
			
			getJspBody().invoke(null);
			
		}
		
		
	}
	
}
