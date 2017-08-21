package com.mytest.mq;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private String uid;
	private String name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserInfo(String uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}
	public UserInfo() {
		super();
	}
	
	@Override
	public String toString() {
		return uid+","+name;
	}
	
	
}
