package com.tgb.klx.dubbo.server;  
  
public class HelloWorldImpl implements HelloWorld{  
  
    public String hello(String name) {  
        name=name+"小康测试";  
        return name;  
    }  
  
} 