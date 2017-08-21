package com.test.mapper.service;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.test.mapper.dao.UserMapper;
import com.test.mapper.model.User;

@Service
public class UserServiceImpl implements UserService {

	
	@Resource(name="userAuth-sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory ;  
	
	@Resource(name="userAuth-sqlSessionTemplate")
	private SqlSessionTemplate sessionTemplate;
	
	private String array = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private String random(){
		return RandomStringUtils.random(10, array);
	}



	@Override
	public User getByName(String name) {
		return getByName(name);
	}



	@Override
	public void insertSpTx() {
		System.out.println("-----insertSpTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertSpTx-----END---->");
	}



	@Override
	public void insertRdTx() {
		System.out.println("-----insertRdTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertRdTx-----END---->");
	}



	@Override
	public void insertRnTx() {
		System.out.println("-----insertRnTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertRnTx-----END---->");
		
		
	}



	@Override
	public void insertNsTx() {
		System.out.println("-----insertNsTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertNsTx-----END---->");
		
		
	}



	@Override
	public void insertExceptionSpTx() {
		System.out.println("-----insertExceptionSpTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertExceptionSpTx-----END---->");
		throwException();
	}



	@Override
	public void insertExceptionRdTx() {
		System.out.println("-----insertExceptionRdTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertExceptionRdTx-----END---->");
		throwException();
	}



	@Override
	public void insertExceptionRnTx() {
		System.out.println("-----insertExceptionRnTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertExceptionRnTx-----END---->");
		throwException();
	}



	@Override
	public void insertExceptionNsTx() {
		System.out.println("-----insertExceptionNsTx-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insertExceptionNsTx-----END---->");
		throwException();
	}
	
	
	private int throwException(){
		System.out.println("throw exctpion ----->");
		int j=0;
		int p = 10/j;
		return p;
	}



	@Override
	public void insert() {
		System.out.println("-----insert-----BEGIN---->");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 userMapper.insertByName(random());
		 System.out.println("-----insert-----END---->");
	}
	

}
