package com.blog.dao;
import java.util.List;
import com.blog.bean.Photo;

public interface PhotoDAO {
         public    List<Photo>    findAllPhotos(int   album_id);
}
