package com.mytest.hadoop.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

public class ZkClientTest {

	private static String zkServer = "172.16.21.21:2181,172.16.21.21:2182,172.16.21.21:2183";
	
	@Test
	 public void testZkClient() throws Exception {
		ZooKeeper zookeeper = new ZooKeeper(zkServer, 300000, null);
         
         if(zookeeper.exists("/test", false) == null)
         {
             zookeeper.create("/test", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
         }
         System.out.println("=============查看节点是否安装成功===============");
         System.out.println(new String(zookeeper.getData("/test", false, null)));
          
         System.out.println("=========修改节点的数据==========");
         String data = "zNode2";
         zookeeper.setData("/test", data.getBytes(), -1);
          
         System.out.println("========查看修改的节点是否成功=========");
         System.out.println(new String(zookeeper.getData("/test", false, null)));
          
         System.out.println("=======删除节点==========");
         zookeeper.delete("/test", -1);
          
         System.out.println("==========查看节点是否被删除============");
         System.out.println("节点状态：" + zookeeper.exists("/test", false));
          
//         if (!zkClient.exists(node)) {
//             zkClient.createPersistent(node, "hello zk");
//         }
//         System.out.println(zkClient.readData(node));
         
/***
         以上代码，看不懂，根本没有关系。
         懂了概念，知道了大致的API用法，后面就是深入学习。
         Zookeeper怎么设计，API怎么用，怎么实现“分布式锁”。
         有了良好的开端，上了道，就一步步提高了。
**/
         
     }

}
