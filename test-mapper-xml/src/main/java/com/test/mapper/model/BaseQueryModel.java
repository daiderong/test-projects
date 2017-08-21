/**   
* @Title: BaseQueryModel.java 
* @Package com.test.mapper.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午1:11:33 
* @version V1.0   
*/
package com.test.mapper.model;

import com.test.mapper.pager.QueryModel;

/** 
* @ClassName: BaseQueryModel 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午1:11:33 
*  
*/
public class BaseQueryModel implements QueryModel {

	public String orderBy;


	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderby) {
		this.orderBy = orderby;
	}
	
	
}
