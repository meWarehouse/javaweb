package com.blog.bean;
/**
 * ������ǽ���������
 * @ClassName:     Aritcle.java
 * @Description:   TODO  
 * @author         Jim  Teacher 
 * @version        jdk8.0  
 * @Date           2018��8��4��   ����9:56:57 
           �޵��Ƕ�ô�ļ�į
     Only those who endure loneliness can become invincible.
 */
public class Article {
	
	     private   Integer   id;
         private   String    title;   //����
         private   String    content; //����
         private   String    image;   //ͼƬ
         private   String    time;    //ʱ��
         private   String    editer;  //����
         private   Integer    count;   //������
         private   Integer    count1;  //������
         private   String    type;  //����    ���磺�ĵñʼ�   �ĵ����   HTML5   CSS3
         private   String    keywords;  //�ؼ���
         private   String    notice;   //���������»����Ƽ�����
         public   Article(){}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getEditer() {
			return editer;
		}
		public void setEditer(String editer) {
			this.editer = editer;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public Integer getCount1() {
			return count1;
		}
		public void setCount1(Integer count1) {
			this.count1 = count1;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getKeywords() {
			return keywords;
		}
		public void setKeywords(String keywords) {
			this.keywords = keywords;
		}
		public String getNotice() {
			return notice;
		}
		public void setNotice(String notice) {
			this.notice = notice;
		}
		public Article(Integer id, String title, String content, String image,
				String time, String editer, Integer count, Integer count1,
				String type, String keywords, String notice) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.image = image;
			this.time = time;
			this.editer = editer;
			this.count = count;
			this.count1 = count1;
			this.type = type;
			this.keywords = keywords;
			this.notice = notice;
		}
		 
}
