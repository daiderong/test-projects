package com.test.hessain;

public class SayHelloImpl implements SayHello,Login {

	@Override
	public String sayHello(String name) {
		System.out.println("服务端方法被调用！");
		return "Hello," + name + "!";
	}

	
	
	@Override
	public String login(String name, String pwd) {
		
		if(name.equals(pwd)){
			return "Welcome "+name;
		}
		return "Password not correct!";
	}
}