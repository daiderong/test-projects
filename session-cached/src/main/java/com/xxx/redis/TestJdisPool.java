/**
 * 
 */
package com.xxx.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ddr
 *
 */
public class TestJdisPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(100);

        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(1000);

        // 设置空间连接
        config.setMaxIdle(10);

        // 创建连接池
        JedisPool  pool = new JedisPool(config, "127.0.0.1",6379);
        
        
        Jedis jedis1 = pool.getResource();
        Jedis jedis2 = pool.getResource();
        
        
		 long t = System.currentTimeMillis();
		 for(int i=0;i<10000;i++){
			 jedis1.set(i+"", i+"");
		 }
		 System.out.println(System.currentTimeMillis() - t);
		 for(int i=0;i<10000;i++){
			 jedis2.get(i+"");
		 }
		 System.out.println(System.currentTimeMillis() - t);
		 System.out.println(pool.getNumActive());
		 jedis1.close();
		 System.out.println(pool.getNumActive());
		 jedis2.close();
		 System.out.println(pool.getNumActive());
		 
		

	}

}
