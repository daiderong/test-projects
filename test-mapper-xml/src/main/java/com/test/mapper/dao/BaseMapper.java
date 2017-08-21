/**   
* @Title: BaseMapper.java 
* @Package com.test.mapper.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午12:30:28 
* @version V1.0   
*/
package com.test.mapper.dao;

import java.io.Serializable;
import java.util.List;

import com.test.mapper.pager.Pager;
import com.test.mapper.pager.QueryModel;

/** 
* @ClassName: BaseMapper 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午12:30:28 
*  
*/
public interface BaseMapper<T extends QueryModel,ID extends Serializable > {
	
	
	int insert(T t);
	
	int insertList(List<T> list);
	
	boolean deleteById(ID id);
	
	int deleteByIds (ID ... ids );
	
	
	boolean update(T t);
	
	boolean updateList(List<T> list);
	
	
	T getById(ID id);
	
	List<T> getByIds(ID ... ids);
	
	Pager<T> queryPager(QueryModel param);
	
	List<T> queryPagerList(int curPage,int pageSize,QueryModel param);
	
	List<T> queryListFromIndex(int startIndex,int size,QueryModel param);
	
	List<T> queryListTop(int size,QueryModel param);
	
	
 }
