package com.test.mapper.service;

import com.test.mapper.model.User;

public interface UserService {

	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	public User getByName(String name);
	
	
	public void insert() ;
	
	public void insertSpTx() ;
	
	public void insertExceptionSpTx() ;
	
	public void insertRdTx();
	
	public void insertExceptionRdTx();
	
	public void insertRnTx();
	
	public void insertExceptionRnTx();
	
	public void insertNsTx();
	
	
	public void insertExceptionNsTx();
	
	

	
	
}
