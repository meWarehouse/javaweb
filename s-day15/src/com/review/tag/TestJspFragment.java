package com.review.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {

	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		JspFragment jspBody = getJspBody();
		
		StringWriter sw = new StringWriter();
		
		jspBody.invoke(sw);
		
		String c = sw.toString().toUpperCase();
		
//		System.out.println(sw);
		
		int n = 0;
		try {
			n = Integer.parseInt(time);
			
			for(int i = 0;i < n;i++) {
				getJspContext().getOut().print(i+":"+c);
			}
		} catch (NumberFormatException e) {
			System.out.println("数据类型错误");
		}
		
		/*
		 * 如何得到 JspFragment
		 * 		在 SimpleTag 接口 中，有一个 setJspBody(JspFragment jspBody),若在 tld 文件中配置了标签有标签体，
		 * 			则 JSP 引擎就会调用 该方法把 代表标签体的 JspFragment 对象传给标签处理器类
		 *		而在 SimpleTagSupport 中，实现了 setJspBody(JspFragment jspBody) 方法，并且定义了 getJspBody() 方法
		 *			返回 JspFragment 对象：
		 *				private JspFragment jspBody;
		 *				@Override
					    public void setJspBody( JspFragment jspBody ) {
					        this.jspBody = jspBody;
					    }
					   protected JspFragment getJspBody() {
					        return this.jspBody;
					    }
   					所以若标签处理器类继承了  SimpleTagSupport 则可以直接调用 getJspBody() 方法得到 JspFragment 对象的引用
   						将标签体内容直接输出到页面上
   							getJspBody().invoke(null)
    	
		 * 
		 * 
		 * 
		 */
		
		
	}
	
}
