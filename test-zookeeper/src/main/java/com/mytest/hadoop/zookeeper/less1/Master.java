package com.mytest.hadoop.zookeeper.less1;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class Master implements Watcher{
		
	ZooKeeper zk;
	String hostPort;
	
	
	public Master(String hostPort) {
		this.hostPort = hostPort;
	}

	
	void startZK(){
		try {
			zk = new ZooKeeper(hostPort, 15000,this );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(WatchedEvent event) {
		System.out.println(event);
	}
	
	public static void main(String[] args) throws Exception {
		String zkServer = "172.16.21.21:2181,172.16.21.21:2182,172.16.21.21:2183";
		Master m = new Master(zkServer);
		m.startZK();
		Thread.sleep(60000);
	}

}
