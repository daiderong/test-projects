package com.mytest.excel.impt.daor;

public class WordUtils {

	
	
	
	/**
	 * 删除（）()及里边的数据及特殊字符
	* @Title: removeParenthese 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public static String removeParenthese(String str){
	
		//把全角替换成半角（）-->()
		if(str.contains("（") || str.contains("）")){
			str = str.replaceAll("（\\w*\\）",  "");
		}
		if(str.contains("(") ){
			str = str.replaceAll("\\(\\w*\\)", "");
		}
		if(str.contains("(") || str.contains(")") ||str.contains("（") || str.contains("）") ){
			str = str.replaceAll("(\\(|\\)|（|)", "");
		}
		return str;
	}
	
	
	public static String removeInvalidChar(String str){
		
		//把全角替换成半角（）-->()
		String invlidCharStr = "\\*|\\$|\\~|\\！|\\!|\\@|\\#|\\￥|\\%|\\…|\\&|\\*|\\-|\\+|\\=|\\—|★|☆";
	
		str = str.replaceAll("("+invlidCharStr+")", "");
		
		return str;
	}
	
	public static void main(String[] args) {
		
		System.out.println(removeInvalidChar(removeParenthese("1asddD★￥%！@#asd（sd）d2(adsdasd)3dsad$)")));
		
	}
}
