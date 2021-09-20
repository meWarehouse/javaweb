package com.blog.dao;

import java.util.List;

import com.blog.bean.Critique;

/**
 * 这个接口是讲述操作评论表
 * 
 * @author Administrator
 *
 */
public interface CritiqueDAO {
	public int addCritique(Critique critique);

	public List<Critique> findCritiquesAll();

	public List<Critique> findCritiquesByPage(int  page);

	public List<Critique> findCritiquesNew();
	public int     findTotalPage();
}







