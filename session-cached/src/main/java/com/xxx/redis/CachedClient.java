package com.xxx.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class CachedClient {

	 
//	// 建立连接池配置参数
//	private JedisPoolConfig config = new JedisPoolConfig();
//    // 设置最大连接数
//    config.setMaxTotal(100);
//
//    // 设置最大阻塞时间，记住是毫秒数milliseconds
//    config.setMaxWaitMillis(1000);
//
//    // 设置空间连接
//    config.setMaxIdle(10);
//
//    // 创建连接池
//    JedisPool  pool = new JedisPool(config, "127.0.0.1",6379);
	
	private JedisPoolConfig[] configs ;
	
	private HashMap<String, JedisPool>  poolMap = new HashMap<String, JedisPool>();
	
	private List<String>  nodes = new ArrayList<String>();
	
	private String[] hostAndPorts  = "127.0.0.1:6379:n1,127.0.0.1:6380:n2".split(",");
	
//	private String[] hosts ;
//	
//	private int[] ports  ;
	
	private HashMap<Integer, Integer> hostIndexErrorTimes = new HashMap<Integer, Integer>();
	
    
    public CachedClient(){
    	
    }
    
    
//    public void init(){
//    	
//    	int len = hostAndPorts.length;
//    	hosts = new String[len];
//		ports = new int[len];
//    	for(int i=0;i<hostAndPorts.length;i++){
//    		String[] hostPortArr = hostAndPorts[i].split(":");
//    		hosts [i] = hostPortArr[0];
//    		ports [i] = Integer.parseInt(hostPortArr[1]);
//    	}
//    	
//    	configs = new JedisPoolConfig[len];
//    	pools = new JedisPool[len];
//    	for(int i=0;i<hosts.length;i++){
//    		configs[i] = new JedisPoolConfig();
//    		configs[i].setMaxWaitMillis(1000);
//    		configs[i].setMaxIdle(10);
//    		configs[i].setMaxTotal(50);
//    		pools[i] = new JedisPool(configs[i],hosts[i],ports[i]);
//    		poolsLen++;
//    	}
//    }
    
	  public void init(){
	    	
	    	int len = hostAndPorts.length;
	    	String[] hosts = new String[len];
	    	int[]  ports = new int[len];
	    	String[]  nodeKey = new String[len];
	    	configs = new JedisPoolConfig[len];
	    	for(int i=0;i<hostAndPorts.length;i++){
	    		String[] hostPortArr = hostAndPorts[i].split(":");
	    		hosts [i] = hostPortArr[0];
	    		ports [i] = Integer.parseInt(hostPortArr[1]);
	    		nodeKey[i] = hostPortArr[2];
	    		configs[i] = new JedisPoolConfig();
	    		configs[i].setMaxWaitMillis(1000);
	    		configs[i].setMaxIdle(10);
	    		configs[i].setMaxTotal(50);
	    		poolMap.put(hostPortArr[2], new JedisPool(configs[i],hosts[i],ports[i])); 
	    		nodes.add(hostPortArr[2]);
	    	}
	    		
	    }
    
    
    public void put(String key,String value) {
    	String node  = getPoolNode(key);
    	Jedis jd = poolMap.get(node).getResource();
    	jd.set(key, value);
    	jd.close();
    }
    
    
    public String putReturnNewKey(String key,String value) {
    	String node  = getPoolNode(key);
    	String keyNew = key+"_"+node;
    	Jedis jd = null;
    	try{
    		jd = poolMap.get(node).getResource();
    	}catch(Exception e){
    		e.printStackTrace();
    		
    	}
    	
    	jd.set(keyNew, value);
    	jd.close();
    	return keyNew;
    }
    
    
    
    /**
     * 获取redis数据
     * @param key
     * @return 值
     */
    public String get(String key) {
    	String node = null;
    	int lastIndex = key.lastIndexOf("_");
    	if(lastIndex > 0){
    		node = key.substring(lastIndex);
    		 //如果比poolsLen
    	}
    	if(node == null)
    	{
    		node = getPoolNode(key);
    	}
    	
    	Jedis jd =  poolMap.get(node).getResource();
    	String value =   jd.get(key);
    	jd.close();
    	return value;
    }
    
    
    private String getPoolNode(String key){
    	return nodes.get(key.hashCode() % nodes.size());
    }
   
    
//    private int getPoolIndex(String key){
//    	return key.hashCode() % poolsLen;
//    }
//    
    
    /**
     * 取得error次数
     * @param poolIndex
     * @return
     */
    public int  getHostErrors(int poolIndex){
    	Integer error   = hostIndexErrorTimes.get(poolIndex);
    	if(error == null){
    		return 0;
    	}
    	return error;
    }
    
    
    /**
     * 取得error次数
     * @param poolIndex
     * @return
     */
    public int  addHostErrors(int poolIndex){
    	Integer error   = hostIndexErrorTimes.get(poolIndex);
    	if(error == null){
    		 hostIndexErrorTimes.put(poolIndex,1);
    		 return 1;
    	}else{
			error ++;
			hostIndexErrorTimes.put(poolIndex,error+1);
			return error;
    	}
    }
    
    /**
     * 取得error次数
     * @param poolIndex
     * @return
     */
    public void   removePool(int ind){
    	
    }
    
    
    
    
    
    public static void main(String[] args) {
    	CachedClient cc = new CachedClient();
    	cc.init();
    	long t1 = System.currentTimeMillis();
    	for(int i=0;i<10000;i++){
    		cc.put(i+"", i+"");
//    		System.out.println(cc.putReturnNewKey(i+"", i+""));
    	}
    	long t2 = System.currentTimeMillis();
    	
    	System.out.println(t2-t1);
    	for(int i=0;i<10000;i++){
    		cc.get(i+"");
//    		System.out.println(cc.get(i+""));
    	}
    	long t3 = System.currentTimeMillis();
    	
    	
    	String newKey = cc.putReturnNewKey("1234", "1212323131231231");
    	System.out.println(newKey);
    	System.out.println(cc.get(newKey));
    	
    	
    	System.out.println(t3-t2);
	}
    
    
    
}
