package com.mytest.sjjg;

import java.util.LinkedList;

import com.mytest.tmodel.Person;

public class LinkedListTest {

	public static void main(String[] args) throws InterruptedException {

		final int max =  50000;

		Runnable rm = () -> {
			final LinkedList1<Person> lk = new LinkedList1();
			long t1 = System.currentTimeMillis();
			for (int i = 0; i < max; i++) {
				lk.add(new Person(i, "测试" + i, i % 2 + ""));
			}
			long t2 = System.currentTimeMillis();
			for (int i = 0; i < max/2; i++) {
				lk.remove(i);
			}
			long t3 = System.currentTimeMillis();
			for (int i = 0; i < max/4; i++) {
				lk.add(i,new Person(i+10000, "rm"+i,  i % 2 + ""));
			}
			long t4 = System.currentTimeMillis();
			int ind = max/3;
			Person p =  lk.get(ind);
			long t5 = System.currentTimeMillis();
			System.out.println("rm person:"+p);
			System.out.println(String.format("rm 添加：%d,删除：%d,插入：%d,查询：%d，一共:%d", (t2 - t1),(t3 - t2),(t4 - t3),(t5 - t4),(t5 - t1)));
		};
		
		Runnable rc = () -> {
			final LinkedList<Person> lk = new LinkedList();
			long t1 = System.currentTimeMillis();
			for (int i = 0; i < max; i++) {
				lk.add(new Person(i, "测试" + i, i % 2 + ""));
			}
			long t2 = System.currentTimeMillis();
			for (int i = 0; i < max/2; i++) {
				lk.remove(i);
			}
			long t3 = System.currentTimeMillis();
			for (int i = 0; i < max/4; i++) {
				lk.add(i,new Person(i+10000, "rm"+i,  i % 2 + ""));
			}
			long t4 = System.currentTimeMillis();
			int ind = max/3;
			Person p =  lk.get(ind);
			long t5 = System.currentTimeMillis();
			System.out.println("rc person:"+p);
			System.out.println(String.format("rc 添加：%d,删除：%d,插入：%d,查询：%d，一共:%d", (t2 - t1),(t3 - t2),(t4 - t3),(t5 - t4),(t5 - t1)));
		};
		
//		new Thread(rm).start();
//		new Thread(rc).start();
		new Thread(rm).start();
		new Thread(rc).start();
		
		
		
//		new Thread(rm).start();
//		new Thread(rm).start();
//		new Thread(rm).start();
//		new Thread(rm).start();
//		new Thread(rm).start();
		
//		new Thread(rc).start();
//		new Thread(rc).start();
//		new Thread(rc).start();
//		new Thread(rc).start();
//		new Thread(rc).start();
//		new Thread(rc).start();

	}
}
