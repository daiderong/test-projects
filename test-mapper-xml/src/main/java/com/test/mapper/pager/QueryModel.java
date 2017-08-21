/**   
* @Title: QueryBaseModel.java 
* @Package com.test.mapper.pager 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午1:07:06 
* @version V1.0   
*/
package com.test.mapper.pager;

/** 
* @ClassName: QueryModel 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午1:07:06 
*  
*/
public interface QueryModel {

	/**
	 * 必须实现 order by 
	* @Title: getOrderBy 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param   	参数说明 
	* @return String    返回类型
	 */
	String getOrderBy();
	
}
