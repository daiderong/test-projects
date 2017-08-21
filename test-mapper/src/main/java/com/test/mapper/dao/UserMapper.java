package com.test.mapper.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.test.mapper.model.User;

public interface UserMapper {

	@Select("SELECT * from ${clasz} where username=#{username}")
	User getUser(String username);
	
	
	
	@Insert("INSERT INTO user values(#{username},#{password})")
	void insertUser(User user);
	
	
	@Insert("INSERT INTO user values(#{username},#{username})")
	void insertByName(String username);
	
}