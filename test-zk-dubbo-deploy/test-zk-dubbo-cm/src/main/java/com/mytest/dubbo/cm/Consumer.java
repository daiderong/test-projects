package com.mytest.dubbo.cm;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mytest.dubbo.model.User;
import com.mytest.dubbo.provider.DemoService;  
  
public class Consumer {  
  
    public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] { "dubbo-cm.xml" });  
        context.start();  
  
        DemoService demoService = (DemoService) context.getBean("demoService");  
        String hello = demoService.sayHello("daiderong");  
        System.out.println(hello);  
  
        long star = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
        	 List<User> list = demoService.getUsers(); 
//        	 System.out.println(list);
        }
       
        long end = System.currentTimeMillis();
        System.out.println("used time:"+(end-star));
        		
//        if (list != null && list.size() > 0) {  
//            for (int i = 0; i < list.size(); i++) {  
//                System.out.println(list.get(i));  
//            }  
//        }  
        
//        System.in.read();  
    }  
  
}  