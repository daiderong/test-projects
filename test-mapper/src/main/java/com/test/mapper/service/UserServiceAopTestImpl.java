package com.test.mapper.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class UserServiceAopTestImpl implements UserServiceAopTestService {

	
	
	
	@Resource
	private UserService userService;

	@Override
	public void testInnerRdTxOutRdTx() {
		System.out.println("--------testInnerRdTxOutRdTx----------------------------");
		userService.insertRdTx();
		userService.insertRdTx();
		System.out.println("--------testInnerRdTxOutRdTx-END---------------------------");
	}

	@Override
	public void testInnerRdTxOutWithExceptionRdTx() {
		System.out.println("--------testInnerRdTxOutWithExceptionRdTx----------------------------");
		userService.insertRdTx();
		userService.insertExceptionRdTx();
		System.out.println("--------testInnerRdTxOutWithExceptionRdTx-END---------------------------");
	}

	@Override
	public void testInnerSpTxOutRdTx() {
		userService.insert();
		userService.insertSpTx();
		
	}

	@Override
	public void testInnerSpTxOutWithExceptionRdTx() {
		userService.insert();
		userService.insertExceptionSpTx();
		
	}

	@Override
	public void testInnerNsTxOutRdTx() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testInnerNsTxOutWithExceptionRdTx() {
		userService.insertNsTx();
		userService.insertExceptionRdTx();
		
	}

	@Override
	public void testInnerRdTxOutRnTx() {
		userService.insertRdTx();
		userService.insertRnTx();
		
	}

	@Override
	public void testInnerRdTxOutWithExceptionRnTx() {
		System.out.println("--------testInnerRdTxOutWithExceptionRnTx----------------------------");
		userService.insertRdTx();
		userService.insertExceptionRnTx();
		System.out.println("--------testInnerRdTxOutWithExceptionRnTx-END---------------------------");
	}

	@Override
	public void testInnerSpTxOutRnTx() {
		System.out.println("--------testInnerSpTxOutRnTx----------------------------");
		userService.insertSpTx();
		userService.insertRnTx();
		System.out.println("--------testInnerSpTxOutRnTx-END---------------------------");
		
	}

	@Override
	public void testInnerSpTxOutWithExceptionRnTx() {
		System.out.println("--------testInnerSpTxOutWithExceptionRnTx----------------------------");
		userService.insertSpTx();
		userService.insertExceptionRnTx();
		System.out.println("--------testInnerSpTxOutWithExceptionRnTx-END---------------------------");
	}

	@Override
	public void testInnerNsTxOutRnTx() {
		System.out.println("--------testInnerNsTxOutRnTx----------------------------");
		userService.insertNsTx();
		userService.insertRnTx();
		System.out.println("--------testInnerNsTxOutRnTx----------------------------");
		
	}

	@Override
	public void testInnerNsTxOutWithExceptionRnTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		userService.insertNsTx();
		userService.insertExceptionRnTx();
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");
		
	}

	@Override
	public void testInnerRdTxOutSpTx() {
		System.out.println("--------testInnerRdTxOutSpTx----------------------------");
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertRdTx();
		System.out.println("--------testInnerRdTxOutSpTx-END---------------------------");		
	}

	@Override
	public void testInnerRdTxOutWithExceptionSpTx() {
		System.out.println("--------testInnerRdTxOutWithExceptionSpTx----------------------------");
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertRdTx();
		userService.insertExceptionRnTx();
		System.out.println("--------testInnerRdTxOutWithExceptionSpTx-END---------------------------");		
	}

	@Override
	public void testInnerSpTxOutSpTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");		
	}

	@Override
	public void testInnerSpTxOutWithExceptionSpTx() {
		System.out.println("--------testInnerSpTxOutWithExceptionSpTx----------------------------");
		userService.insertSpTx();
		userService.insertExceptionSpTx();
		System.out.println("--------testInnerSpTxOutWithExceptionSpTx-END---------------------------");		
	}

	@Override
	public void testInnerNsTxOutSpTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");		
	}

	@Override
	public void testInnerNsTxOutWithExceptionSpTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");		
	}

	@Override
	public void testInnerRdTxOutNsTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");		
	}

	@Override
	public void testInnerRdTxOutWithExceptionNsTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");		
	}

	@Override
	public void testInnerSpTxOutNsTx() {
		System.out.println("--------testInnerSpTxOutNsTx----------------------------");
		System.out.println("--------testInnerSpTxOutNsTx-END---------------------------");		
	}

	@Override
	public void testInnerSpTxOutWithExceptioNsTx() {
		System.out.println("--------testInnerSpTxOutWithExceptioNsTx----------------------------");
		System.out.println("--------testInnerSpTxOutWithExceptioNsTx-END---------------------------");		
	}

	@Override
	public void testInnerNsTxOutNsTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx----------------------------");
		System.out.println("--------testInnerNsTxOutWithExceptionRnTx-END---------------------------");		
	}

	@Override
	public void testInnerNsTxOutWithExceptionNsTx() {
		System.out.println("--------testInnerNsTxOutWithExceptionNsTx----------------------------");
		userService.insertNsTx();
		userService.insertExceptionNsTx();
		System.out.println("--------testInnerNsTxOutWithExceptionNsTx-END---------------------------");		
	}

	@Override
	public void testInnerRnTxOutWithExceptionRdTx() {
		System.out.println("--------testInnerRnTxOutWithExceptionRdTx----------------------------");
		userService.insertRnTx();
		userService.insertExceptionRdTx();
		System.out.println("--------testInnerRnTxOutWithExceptionRdTx-END---------------------------");		
	}

	
	





}
