package com.ib.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.test.mapper.service.UserServiceAopTestService;


/**
 * 本例用来测试aop配置文件的生效情况 
 * @author ddr
 *
 */
public class UserServiceAopTest  extends JunitBaseTest{

	
	//
	
	@Resource
	private UserServiceAopTestService userServiceAopTestService;
	
	
	
	@Test
	public void testInnerRdTxOutRdTx() {
		userServiceAopTestService.testInnerRdTxOutRdTx();
	}
	
	
	@Test
	public void testInnerRdTxOutWithExceptionRdTx() {
		userServiceAopTestService.testInnerRdTxOutWithExceptionRdTx();
	}
	
	
	@Test
	public void testInnerNsTxOutWithExceptionRdTx(){
		userServiceAopTestService.testInnerNsTxOutWithExceptionRdTx();
	}
	
	
	
	@Test
	public void testInnerRdTxOutRnTx() {
		userServiceAopTestService.testInnerRdTxOutRnTx();
	}
	
	
	@Test
	public void testInnerRdTxOutWithExceptionRnTx() {
		userServiceAopTestService.testInnerRdTxOutWithExceptionRnTx();
	}
	
	

	@Test
	public void testInnerRnTxOutWithExceptionRdTx() {
		userServiceAopTestService.testInnerRnTxOutWithExceptionRdTx();
	}
	
	@Test
	public void testInnerSpTxOutWithExceptionSpTx(){
		userServiceAopTestService.testInnerSpTxOutWithExceptionSpTx();
	}
	
	@Test
	public void testInnerRdTxOutSpTx(){
		userServiceAopTestService.testInnerRdTxOutSpTx();
	}
	
	
}
