package com.test.aop.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

@Repository
@Aspect
public class TestServiceLog {

	
	 @Pointcut("execution(* com.test.aop.service..*(..)) ")  
	 private void anyMethod(){}//定义一个切入点  
	
	
	
	 @Before("anyMethod()")  
	public void beforLog(){
		System.out.println("befor ... run....");
	}
	
	 @After("anyMethod()")  
	public void afterLog(){
		System.out.println("after ... run....");
	}
	
	
	
	
}
