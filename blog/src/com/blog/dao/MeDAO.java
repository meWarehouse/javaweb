package com.blog.dao;

import com.blog.bean.Me;

/**
 * 这个类是讲述MeDAO接口操作me表(增删查改)
 * @author Administrator
 *
 */
public interface MeDAO {
       public     Me    findMeById();  //查询me表
}
