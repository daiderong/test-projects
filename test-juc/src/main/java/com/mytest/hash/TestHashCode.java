/**   
* @Title: TestHashCode.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong  
* @date 2017年8月2日 下午9:15:15 
* @version V1.0   
*/
package com.mytest.hash;

import java.util.HashMap;

/** 
* @ClassName: TestHashCode 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong
* @date 2017年8月2日 下午9:15:15 
*  
*/
public class TestHashCode {

	
	
	
	public static void main(String[] args) {
		HashMap<String, Model1> map = new HashMap<>();
		Model1 model1 = new Model1();
		
		
		
		map.put("model1", model1);
		Model1 model1H = map.get("model1");
		System.out.println(model1.equals(model1H));
	}
	
	
	
	
	public static class Model1{
		
		
		@Override
		public int hashCode() {
			System.out.println("--->调用hashCode:"+super.hashCode());
			return super.hashCode();
		}
		
		
		
		
	}
	
}
