package com.blog.bean;
/**
 * ��Ӧ������ʵ����
 * @ClassName:     Critique.java
 * @Description:   TODO  
 * @author         Jim  Teacher 
 * @version        jdk8.0  
 * @Date           2018��8��8��   ����10:48:24 
           �޵��Ƕ�ô�ļ�į
     Only those who endure loneliness can become invincible.
 */
public class Critique {
        private    Integer   id;
        private    String    content;
        private    String    name;
        private    String    time;
        private    String    photo;
        private    Integer   articleId;
        private    String    type;
        private    String    notice;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public Integer getArticleId() {
			return articleId;
		}
		public void setArticleId(Integer articleId) {
			this.articleId = articleId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getNotice() {
			return notice;
		}
		public void setNotice(String notice) {
			this.notice = notice;
		}
}
