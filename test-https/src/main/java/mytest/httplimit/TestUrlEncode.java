/**   
* @Title: TestUrlEncode.java 
* @Package mytest.httplimit 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年10月24日 下午6:21:33 
* @version V1.0   
*/
package mytest.httplimit;

import java.net.URLEncoder;

import org.apache.http.client.entity.UrlEncodedFormEntity;

/** 
* @ClassName: TestUrlEncode 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年10月24日 下午6:21:33 
*  
*/
public class TestUrlEncode {

	
	public static void main(String[] args) {
		System.out.println(URLEncoder.encode("http://164.com?apa=dd&ap=12"));
	}
}
