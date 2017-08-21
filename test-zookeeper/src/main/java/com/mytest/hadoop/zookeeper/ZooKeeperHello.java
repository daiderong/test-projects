package com.mytest.hadoop.zookeeper;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
 
public class ZooKeeperHello {
 
	
	private static String zkServer = "172.16.21.21:2181,172.16.21.21:2182,172.16.21.21:2183";
	
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(zkServer, 300000, new DemoWatcher());//连接zk server
        String node = "/app1";
        Stat stat = zk.exists(node, false);//检测/app1是否存在
        if (stat == null) {
            //创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        //获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }
 
    static class DemoWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("----------->");
            System.out.println("path:" + event.getPath());
            System.out.println("type:" + event.getType());
            System.out.println("stat:" + event.getState());
            System.out.println("<-----------");
        }
    }
}
//2.3 与zk集群的连接
//
//zk的优点之一，就是高可用性，上面的代码连接的是单台zk server，如果这台server挂了，自然代码就会出错，事实上zk的API考虑到了这一点，把连接代码改成下面这样：
//
// ZooKeeper zk = new ZooKeeper("172.28.20.102:2181,172.28.20.102:2182,172.28.20.102:2183", 300000, new DemoWatcher());//连接zk server
// 
// 即：IP1:port1,IP2:port2,IP3:port3...  用这种方式连接集群就行了，只要有超过半数的zk server还活着，应用一般就没问题。但是也有一种极罕见的情况，比如这行代码执行时，刚初始化完成，正准备连接ip1时，因为网络故障ip1对应的server挂了，仍然会报错（此时，zk还来不及选出新leader），这个问题详见：http://segmentfault.com/q/1010000002506725/a-1020000002507402，参考该文的做法，改成：

//         ZooKeeper zk = new ZooKeeper("172.28.20.102:2181,172.28.20.102:2182,172.28.20.102:2183", 300000, new DemoWatcher());//连接zk server
//         if (!zk.getState().equals(ZooKeeper.States.CONNECTED)) {
//             while (true) {
//                 if (zk.getState().equals(ZooKeeper.States.CONNECTED)) {
//                     break;
//                 }
//                 try {
//                     TimeUnit.SECONDS.sleep(5);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }

