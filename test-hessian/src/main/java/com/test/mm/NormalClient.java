package com.test.mm;
import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.test.hessain.Login;
import com.test.hessain.SayHello;


public class NormalClient {

    public static void main(String[] args) throws MalformedURLException {  
        //Spring Hessian代理Servelet  
        String url = "http://localhost:8080/test-hessian/sayHello.htm";  
        HessianProxyFactory factory = new HessianProxyFactory();  
        SayHello api = (SayHello) factory.create(SayHello.class, url);  
        System.out.println(api.sayHello("DDR"));  
        
        
        
        String loginUrl = "http://localhost:8080/test-hessian/login.htm";  
        Login login = (Login) factory.create(Login.class, loginUrl);  
        System.out.println(login.login("DDR","DDR"));
        
        System.out.println(login.login("DDR1","DDR"));
        
        
        
    }  

}