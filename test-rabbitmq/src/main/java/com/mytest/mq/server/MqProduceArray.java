
package com.mytest.mq.server;

import org.apache.commons.lang.math.RandomUtils;

import com.mytest.mq.cfg.RabbitMqCfg;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MqProduceArray {  
  
  
    public static void main(String[] argv) throws Exception {  
        // 创建连接工厂  
        ConnectionFactory factory = new ConnectionFactory();  
//      设置RabbitMQ地址  
        factory.setHost("localhost");  
//      创建一个新的连接  
        Connection connection = factory.newConnection();  
//      创建一个频道  
        Channel channel = connection.createChannel();  

//      发送消息到队列中  
//        Scanner sc = new Scanner(System.in);
//        message = null;
//        while((message = sc.nextLine())!=null){
//        	
//        	if(message.equalsIgnoreCase("Q")){
//        		break;
//        	}
//        	
//        	 channel.basicPublish("", RabbitMqCfg.DEFAULT_TOPIC_QUEUE, null, message.getBytes("UTF-8"));  
//        	 System.out.println("P [x] Sent '" + message + "'");  
//             
//        }
        int i = 0;
        int len = RabbitMqCfg.DEFAULT_TOPIC_QUEUE_ARRAY.length;
        while(i ++ < 100000){
//          声明一个队列 -- 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。   
            channel.queueDeclare(RabbitMqCfg.DEFAULT_TOPIC_QUEUE_ARRAY[i%len], false, false, false, null);  
            String message = "Hello World!"+RandomUtils.nextInt(10000);  
        	if(message.equalsIgnoreCase("Q")){
        		break;
        	}
        	 channel.basicPublish("", RabbitMqCfg.DEFAULT_TOPIC_QUEUE_ARRAY[i%len], null, message.getBytes("UTF-8"));  
        	 System.out.println("P [x] Sent '" + message + "'");  
             
        }
        System.out.println("P is  Exit");  
//      关闭频道和连接  
        channel.close();  
        connection.close();  
    }  
}  