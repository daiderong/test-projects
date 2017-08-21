/**
 * 
 */
package com.mytest.rel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ddr
 *
 */
public class RedisClientHelps {
		
	
	
	private static RedisClientHelps redisClientHelps ;
	
	private static JedisPool pools = null;
	
	private  RedisClientHelps(){
		
	}
	
	
	public static RedisClientHelps get(){
		if(redisClientHelps == null){
			synchronized (redisClientHelps) {
				init(); 
			}
		}  
		return redisClientHelps;
	}
	
	
	
	
	public static void init(){
		// 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();

        // 设置最大连接数
        config.setMaxTotal(100);

        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(1000);

        // 设置空间连接
        config.setMaxIdle(10);

        // 创建连接池
        pools  = new JedisPool(config, "127.0.0.1",6379);
        
	}
	
	
	public void  put(String key,int seconds,String value){
		Jedis jc  =  pools.getResource();
		jc.setex(key, seconds, value);
		jc.close();
	}
	
	public String  get(String key){
		Jedis jc  =  pools.getResource();
		String value = jc.get(key);
		jc.close();
		return value;
	}
	
	
	
	public static void main(String[] args) {
		RedisClientHelps help = new RedisClientHelps();
		
		String key = "xaxa";
		
		System.out.println(help.get(key));
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(help.get(key));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(help.get(key));
		
	}
	
	
	
}
