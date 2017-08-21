package com.mytest.excel.impt.utils;

public class StringUtils {

	public static boolean isEmpty(String str){
		return str == null || str.trim().length() == 0;
	}
	
	public static String ifEmptyRetunDefault(String str,String dafultVal){
		if(isEmpty(str)){
			return dafultVal;
		}
		return str;
	}
	
}
