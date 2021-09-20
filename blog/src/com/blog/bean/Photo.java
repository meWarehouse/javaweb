package com.blog.bean;
/**
 * 这个类是对应的照片类
 * @ClassName:     Photo.java
 * @Description:   TODO  
 * @author         Jim  Teacher 
 * @version        jdk8.0  
 * @Date           2018年8月9日   下午8:36:10 
           无敌是多么的寂寞
     Only those who endure loneliness can become invincible.
 */
public class Photo {
        private    Integer   id;
        private    String    image;
        private    String    note;
        private    String    content;
        private    String    type;
        private    String    notice;
        private    String    time;
        private    Album     album;  //对应的就是album_id   //
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
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
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public Album getAlbum() {
			return album;
		}
		public void setAlbum(Album album) {
			this.album = album;
		}
}
