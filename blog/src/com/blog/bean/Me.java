package com.blog.bean;
/**
 * 对应的关于我实体类
 * @ClassName:     Me.java
 * @Description:   TODO  
 * @author         Jim  Teacher 
 * @version        jdk8.0  
 * @Date           2018年8月8日   下午10:46:12 
           无敌是多么的寂寞
     Only those who endure loneliness can become invincible.
 */
public class Me {
       private   Integer   id;    //id号
       private   String    name;  //名字
       private   String    content;//内容：关于我的
       private   String    notice; //
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
}
