/**   
* @Title: OptAndAnalysis.java 
* @Package com.mytest.excel.impt.daor 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年6月29日 下午4:54:49 
* @version V1.0   
*/
package com.mytest.excel.impt.daor;

/** 
* @ClassName: OptAndAnalysis 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年6月29日 下午4:54:49 
*  
*/
public enum OptErrors {
	
		
	EXISTS_CURR_DB("已存在当前数据库中"),
	
	EXPROT_NO_MATCH("未匹配到"),
	
	EXPROT_NO_MATCH_YBDM("未匹配到YBDM医保编码"),
	
	EXPROT_NO_MATCH_BWM("未匹配到BWM本位码"),
	EXPROT_NO_MATCH_YPMLBM("未匹配到YPMLBM人社保药品编码"),
	
	MATCHED_AND_START_Y1("匹配到，并且是Y1开头"),
	
	MATCHED_AND_START_YP("匹配到，并且是YP开头");
	
	
	
	
	private  String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
	private OptErrors(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return errorMsg;
	}
	
	
	
	
	

		
}
