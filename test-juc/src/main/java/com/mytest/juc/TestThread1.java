package com.mytest.juc;

import java.util.concurrent.TimeUnit;

public class TestThread1 {

	
	private static volatile boolean exeFlag = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(exeFlag){
					i++;
				}
				System.out.println(i);
			}
		});
		
		t.start();
		TimeUnit.SECONDS.sleep(1);
		exeFlag = false;
		
	}
	
	
	
}



