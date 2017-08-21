/**
 * 
 */
package com.mytest.redies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author ddr
 *
 */
public class TestJdisPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Jedis jedis = new Jedis("localhost");
		// 添加数据

		System.out.println("---------LIST---------");
		jedis.rpush("names", "唐僧");
		jedis.rpush("names", "悟空");
		jedis.rpush("names", "八戒");
		jedis.rpush("names", "悟净");

		List<String> list = jedis.lrange("names", 0L, -1L);
		System.out.println(list);

		System.out.println("---------SET---------");
		jedis.sadd("nameset", new String[] { "王", "王", "xxta" });

		Set<String> set = jedis.smembers("nameset");
		System.out.println(set);

		//

		System.out.println("---------MAP---------");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "xinxin");
		map.put("age", "22");
		map.put("qq", "123456");
		jedis.hmset("user1", map);
		// 取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
		// 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
		List<String> rsmap = jedis.hmget("user1", "name", "age", "qq");
		jedis.del("user1");//删除以后
		 rsmap = jedis.hmget("user1", "name", "age", "qq");
		System.out.println(rsmap);
		jedis.close();

//		jedis.shutdown();
	}

}
