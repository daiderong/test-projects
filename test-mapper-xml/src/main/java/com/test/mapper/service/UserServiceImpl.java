package com.test.mapper.service;

import javax.annotation.Resource;

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
	
	
	
	@Override
	public User getByName(String name) {
		 System.out.println(">>>>>>>>>>>>>>>>getByName>>>>>>>>>>>>>>>>BEGIN");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class);  
		 User u = userMapper.getById(name);
		 System.out.println("<<<<<<<<<<<<<<<getByName<<<<<<<<<<<<<<<END");
		 return u;
	}


	@Override
	public void insertRdTx(String name, String pwd) {
		 System.out.println(">>>>>>>>>>>>>>>>insertRdTx>>>>>>>>>>>>>>>>BEGIN");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 User user = new User();
		 user.setPassword(pwd);
		 user.setUsername(name);
		 userMapper.insert(user);
//		 int i = 10/0;//会使事务回滚
		 System.out.println("<<<<<<<<<<<<<<<insertRdTx<<<<<<<<<<<<<<<END");
	}


	@Override
	public void insertRnTx(String name, String pwd) {
		 System.out.println(">>>>>>>>>>>>>>>>insertRnTx>>>>>>>>>>>>>>>>BEGIN");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 User user = new User();
		 user.setPassword(pwd);
		 user.setUsername(name);
		 userMapper.insert(user);
//		 int i = 10/0;//会使事务回滚，有可能仅影响本
		 System.out.println("<<<<<<<<<<<<<<<insertRnTx<<<<<<<<<<<<<<<END");
		
	}


	
	@Override
	public void insert(String name, String pwd)  {
		 System.out.println(">>>>>>>>>>>>>>>>insert>>>>>>>>>>>>>>>>BEGIN");
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 User user = new User();
		 user.setPassword(pwd);
		 user.setUsername(name);
		 userMapper.insert(user);
		 //int  i = 10/0; //如果外层没有事务将不会使事务回滚，如果外层有事务会使事务回滚
		 System.out.println("<<<<<<<<<<<<<<<insert<<<<<<<<<<<<<<<END");
	}
	
	public void  insertInner(String name, String pwd)  {
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 User user = new User();
		 user.setPassword(pwd);
		 user.setUsername(name);
		 userMapper.insert(user);
	}

	

	/*
	* Title: queryPage
	*Description:  
	* @see com.test.mapper.service.UserService#queryPage() 
	*/
	@Override
	public void queryPage() {
		 UserMapper userMapper = sessionTemplate.getMapper(UserMapper.class); 
		 User param = new User();
		 param.setOrderBy("username desc");
		 userMapper.queryPager(param );
	}
		
	

	@Override
	public void testRdTx() {
//		insertRdTx("rdtx", "rdtx");
//		insert("innner", "12345");
//		getByName("innner");
		queryPage();
	}


	@Override
	public void testRnTx() {
		insertRnTx("rntx", "rntx");
		insert("innner", "12345");
		
	}



}
