package com.mytest.webservice.tl;

public enum ActionEm {

	
	
//	1、参保人基本信息
//	 2、申请工单接口
//	 3、评估工单接口
//	 4、等级评定数据回写

	BASE_INFO(1),
	ORDER_APPLY(2),
	ORDER_ASSESS(3),
	LEVEL_CALLBACK(4);
	
	
	
	private int action ;

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}
	
	private ActionEm(int action){
		this.action = action;
	}
	
	
	
}
