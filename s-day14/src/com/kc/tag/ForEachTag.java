package com.kc.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {

	private Collection<?> item;
	private String var;

	public void setItem(Collection<?> item) {
		this.item = item;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {

		// 1.遍历 item 对应的集合
		for (Object obj : item) {

			// 2.将正在遍历的对象放入到 pagecontext中 键：var 值：正在遍历的对象
			getJspContext().setAttribute(var, obj);

			// 3.把标签的内容直接输出到页面上
			getJspBody().invoke(null);

		}

	}

}
