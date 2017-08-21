package com.test.mapper.pager;

import java.io.Serializable;
import java.util.List;


/**
 * 用于分页查询的DTO
* @ClassName: Pager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年7月22日 上午11:38:04 
* 
* @param <T>
 */
public class Pager<T> implements Serializable  {

	

	
	private static final long serialVersionUID = 1L;
	
	
	protected int curPage = 1;
	protected int pageSize = 15;
	private int totalCount = 0;
	private List<T> resultList;

	
	public Pager(int curPage, int pageSize) {
		setCurPage(curPage);
		setPageSize(pageSize);
	}

	public Pager(int curPage, int pageSize, int totalCount,
			List<T> resultList) {
		this(curPage,pageSize);
		this.totalCount = totalCount;
		this.resultList = resultList;
	}

	
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		if (curPage < 0) {
			curPage = 1;
		}
		this.curPage = curPage;
	}

	public int getPageSize() {
		if (pageSize < 0) {
			pageSize = 1;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount < 0) {
			totalCount = 0;
		}
		this.totalCount = totalCount;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}


	/**
	 * 总页数无数据时是0，有数据时至少是1
	 * @return
	 */
	public int getPageCount(){
		int pageCount = totalCount/pageSize +  (totalCount%pageSize==0?0:1);
		return pageCount ;
	}
}
	