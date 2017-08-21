/**
 * 
 */
package com.mytest.redies;

import redis.clients.jedis.Jedis;

/**
 * @author ddr
 *
 */
public class TestJdis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Jedis jedis = new Jedis("127.0.0.1");
		
		 long t = System.currentTimeMillis();
		 for(int i=0;i<10000;i++){
			 jedis.set(i+"", i+"");
		 }
		 System.out.println(System.currentTimeMillis() - t);
		 long t2 = System.currentTimeMillis();
		 for(int i=0;i<10000;i++){
			 jedis.get(i+"");
		 }
		 System.out.println(System.currentTimeMillis() - t2);
	
		 jedis.close();
		// jedis.shutdown();
		 
	}

}
