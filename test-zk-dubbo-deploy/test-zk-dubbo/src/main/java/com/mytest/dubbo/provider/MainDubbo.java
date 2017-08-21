package com.mytest.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDubbo {

	
	 public static void main(String[] args) throws Exception {  
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
	                new String[] { "dubbo-pro.xml" });  
	        context.start();  
	        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟  
	    }  
}
