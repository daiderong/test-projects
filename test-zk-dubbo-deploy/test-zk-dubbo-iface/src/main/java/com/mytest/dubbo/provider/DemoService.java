package com.mytest.dubbo.provider;
  
import java.util.List;

import com.mytest.dubbo.model.User;  
  
public interface DemoService {  
  
    String sayHello(String name);  
  
    public List<User> getUsers();  
  
}  