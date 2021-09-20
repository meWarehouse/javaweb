package com.review.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MaxTag implements SimpleTag {

	private String num1;
	private String num2;
	
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	
	public void setNum2(String num2) {
		this.num2 = num2;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		int a = 0;
		int b = 0;
		
		try {
			a = Integer.parseInt(num1);
			b = Integer.parseInt(num2);
			
			pageContext.getOut().print("最大值为：" + (a > b ? a : b));
			
		} catch (NumberFormatException e) {
			System.out.println("输入的数据类型有误");
		}
		
		

	}

	private PageContext pageContext;
	
	@Override
	public void setJspContext(JspContext pc) {
		this.pageContext = (PageContext) pc;

	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setParent(JspTag parent) {
		// TODO Auto-generated method stub

	}

}
