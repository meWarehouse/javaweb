package com.blog.bean;
import java.util.List;
/**
 * 这个类是对应的相册
 * @ClassName:     Album.java
 * @Description:   这是实体类，是对应的相册
 * @author         Jim  Teacher 
 * @version        jdk8.0  
 * @Date           2018年8月9日   下午8:40:11 
           无敌是多么的寂寞
     Only those who endure loneliness can become invincible.
 */
public class Album {
	      /**
	       * 这是id，不跟业务有关系
	       */
          private      Integer   id;
          private      String    image;
          private      String    title;
          private      String    content;
          private      String    notice;
          private      String    time;
          //一对多
          private      List<Photo>   photos; //一个相册里面是不是有很多照片
          /**
           * 实例化对象
           */
          public   Album(){
        	  
          }
          /**
           * 初始化对象，并初始化值
           * @param id     接收id的值
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
         * 获取id的值
         * @return
         */
		public Integer getId() {
			return id;
		}
		/**
		 * 设置id的值
		 * @param id  接收一个整型的数
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
