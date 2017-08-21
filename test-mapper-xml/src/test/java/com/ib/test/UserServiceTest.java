package com.ib.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.test.mapper.service.UserService;


/**
 * 本例用来测试aop配置文件的生效情况 
 * @author ddr
 *
 */
public class UserServiceTest  extends JunitBaseTest{

	
	//
	
	@Resource
	private UserService userService;
	
	
//	@Test
//	public void testName() throws Exception {
//		System.out.println(userService.getByName("daiderong"));
//	}
	
	
	//@Test
	public void insert1() throws Exception {
		userService.insert("testTx", "12345");
	}
	
	//@Test
	public void insert2() throws Exception {
		userService.insertRdTx("testNoTx", "12345");
	}
	
//	@Test
	public void test1() throws Exception {
		userService.insertRdTx("insertRdTx", "12345");
		userService.insert("insert", "12345");
	}
	
	

	/**
	 * 测试REQUIRED SUPPORT的异常
	 * @throws Exception
	 */
	//@Test
	public void test3() throws Exception {
		try {
			userService.insertRdTx("insertRdTx", "insertRdTx");
			//有异常时将使事务回滚
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		try {
			userService.insert("insert", "insert");
			//有异常时不会事务回滚
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * 测试事务隔离级别的影响1
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		try {
			userService.testRdTx();
			//有异常时将使事务回滚
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	
	/**
	 * 测试事务隔离级别的影响2
	 * @throws Exception
	 */
	//@Test
	public void test5() throws Exception {
		try {
			userService.testRnTx();
			//有异常时将使事务回滚
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
	
	
//	@Test
		public void insert12() throws Exception {
		}
		
	
}
