package com.mytest.juc;

import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThread2 {

	
	private  static  AtomicInteger aiInteger = new AtomicInteger(0);
	
	private static volatile  CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					while(aiInteger.get()< 400){
						Integer iv = aiInteger.incrementAndGet();
						//System.out.println(Thread.currentThread().getName()+":"+iv);
						list.add(iv);
					}
				}
			});
			t.start();
		}
		Thread.sleep(2000);
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2){
					return 1;
				}
				if(o1 < o2){
					return -1;
				}
				return 0;
			}
		});
		System.out.println(list);
	}
	
	
	
}



