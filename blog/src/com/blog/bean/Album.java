package com.blog.bean;
import java.util.List;
/**
 * ������Ƕ�Ӧ�����
 * @ClassName:     Album.java
 * @Description:   ����ʵ���࣬�Ƕ�Ӧ�����
 * @author         Jim  Teacher 
 * @version        jdk8.0  
 * @Date           2018��8��9��   ����8:40:11 
           �޵��Ƕ�ô�ļ�į
     Only those who endure loneliness can become invincible.
 */
public class Album {
	      /**
	       * ����id������ҵ���й�ϵ
	       */
          private      Integer   id;
          private      String    image;
          private      String    title;
          private      String    content;
          private      String    notice;
          private      String    time;
          //һ�Զ�
          private      List<Photo>   photos; //һ����������ǲ����кܶ���Ƭ
          /**
           * ʵ��������
           */
          public   Album(){
        	  
          }
          /**
           * ��ʼ�����󣬲���ʼ��ֵ
           * @param id     ����id��ֵ
           * @param image  
           * @param title
           * @param content
           * @param notice
           * @param time
           * @param photos
           */
		public Album(Integer id, String image, String title, String content,
				String notice, String time, List<Photo> photos) {
			super();
			this.id = id;
			this.image = image;
			this.title = title;
			this.content = content;
			this.notice = notice;
			this.time = time;
			this.photos = photos;
		}
        /**
         * ��ȡid��ֵ
         * @return
         */
		public Integer getId() {
			return id;
		}
		/**
		 * ����id��ֵ
		 * @param id  ����һ�����͵���
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
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
		public String getNotice() {
			return notice;
		}
		public void setNotice(String notice) {
			this.notice = notice;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public List<Photo> getPhotos() {
			return photos;
		}
		public void setPhotos(List<Photo> photos) {
			this.photos = photos;
		}
}
