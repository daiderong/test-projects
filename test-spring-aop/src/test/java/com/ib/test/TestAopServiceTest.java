package com.ib.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.test.aop.service.TestService;

public class TestAopServiceTest extends JunitBaseTest {

	
	
	@Resource
	private TestService testService;
	
	@Test
	public void testName() throws Exception {
		testService.doService();
	}
	
}
