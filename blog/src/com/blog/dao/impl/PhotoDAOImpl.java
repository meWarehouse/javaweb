package com.blog.dao.impl;

import java.util.List;

import com.blog.bean.Photo;
import com.blog.dao.PhotoDAO;
import com.blog.util.DBUtils;

public class PhotoDAOImpl implements   PhotoDAO{
    private    DBUtils      dbutils=DBUtils.getDBUtils();
	@Override
	public List<Photo> findAllPhotos(int album_id) {
		String   sql="select * from photo where   album_id=?";
		List<Photo>    list=dbutils.executeQueryPhoto(sql, album_id);
		return list;
	}
        
}
