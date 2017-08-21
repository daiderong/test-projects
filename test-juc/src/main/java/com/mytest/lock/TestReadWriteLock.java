/**   
* @Title: TestReadWriteLock.java 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong  
* @date 2017年8月3日 下午12:47:52 
* @version V1.0   
*/
package com.mytest.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/** 
* @ClassName: TestReadWriteLock 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong
* @date 2017年8月3日 下午12:47:52 
*  
*/
public class TestReadWriteLock {

	private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock () ;
	
	private static int count = 0;
	
	private static int getCount(){
		return count;
	}
	
	private static int addCount(){
		 count++;
		 return count;
	}
	
	
	public static void main(String[] args) {
		
		
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					WriteLock writeLock = rwLock.writeLock();
					writeLock.lock();
					try {
						int v = addCount();
						System.out.println(Thread.currentThread()+"写入:"+v);
					} finally {
						writeLock.unlock();
					}
					try {
						System.out.println("--> QueueLength:"+rwLock.getQueueLength());
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		for(int i=0;i<100;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					ReadLock readLock = rwLock.readLock();
					readLock.lock();
					try {
						System.out.println(Thread.currentThread()+"读取："+getCount());
					} finally {
						readLock.unlock();
						System.out.println("--> QueueLength:"+rwLock.getQueueLength());
					}
				}
			}).start();
		}
		
		
	}
	
	
	
	
	
}
