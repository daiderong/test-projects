package com.tgb.klx.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tgb.klx.dubbo.server.HelloWorld;

public class ConsumerThd implements Runnable {
	public void run() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationConsumer.xml" });
		context.start();
		HelloWorld helloWorld = (HelloWorld) context.getBean("demoService");
		String hello = helloWorld.hello("小康");
		System.out.println(hello);
	}

	public static void main(String[] args) {
		new Thread(new ConsumerThd()).start();
	}
}
