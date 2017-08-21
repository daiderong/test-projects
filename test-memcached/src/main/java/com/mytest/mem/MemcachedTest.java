package com.mytest.mem;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

public class MemcachedTest {

	
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException, MemcachedException {
		XMemcachedClient xc = new XMemcachedClient("localhost",11211);
		
		long t = System.currentTimeMillis();
		 for(int i=0;i<10000;i++){
			 xc.add(i+"", 10, i+"");
		 }
		 System.out.println(System.currentTimeMillis() - t);
		 for(int i=0;i<10000;i++){
			 xc.get(i+"");
		 }
		 System.out.println(System.currentTimeMillis() - t);
		 xc.shutdown();
	}
}
