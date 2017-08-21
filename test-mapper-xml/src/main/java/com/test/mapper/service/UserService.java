package com.test.mapper.service;

import com.test.mapper.model.User;

public interface UserService {

	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	public User getByName(String name);
	
	
	
	/**
	 * 
	 * @param name
	 * @param pwd
	 */
	public void insertRdTx(String name,String pwd);
	
	
	
	
	/**
	 * 
	 * @param name
	 * @param pwd
	 */
	public void insertRnTx(String name,String pwd);
	
	
	/**
	 * 
	 * @param name
	 * @param pwd
	 */
	public void insert(String name,String pwd) ;
	
	
	/**
	 * 
	 * @param name
	 * @param pwd
	 */
	public void  insertInner(String name, String pwd);
	
	
	
	public void  queryPage();
	
	
	
	
	public void  testRdTx();
	

	public void  testRnTx();
	
}
