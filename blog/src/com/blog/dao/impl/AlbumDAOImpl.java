package com.blog.dao.impl;

import java.util.List;

import com.blog.bean.Album;
import com.blog.dao.AlbumDAO;
import com.blog.util.DBUtils;

public class AlbumDAOImpl  implements    AlbumDAO{
	private    DBUtils      dbutils=DBUtils.getDBUtils();//获取DBUtils对象
	@Override
	public List<Album> findAlbumsAll() {
		String  sql="select  *  from   album";
		List<Album>     albumsAll=dbutils.findAlbum(sql);
		return   albumsAll;
	}
}
