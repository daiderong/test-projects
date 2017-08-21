package com.test.mapper.pager;

/**
 * 
* @ClassName: PagerQuery 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年11月4日 下午12:46:24 
*
 */
public class PagerQuery   {

	
	protected int curPage = 1;
	protected int pageSize = 15;
	
	
	public PagerQuery(int curPage, int pageSize) {
		setCurPage(curPage);
		setPageSize(pageSize);
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


	
}
	