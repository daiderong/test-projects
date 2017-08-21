package com.mytest.mem;
import java.util.HashMap;  
import java.util.Map;  
//对接口进行测试  
public class TestMain {  
    private String url = "https://www.baidu.com";  
    private String charset = "utf-8";  
    private HttpClientUtil httpClientUtil = null;  
      
    public TestMain(){  
        httpClientUtil = new HttpClientUtil();  
    }  
      
    public void test(){  
        String httpOrgCreateTest = url;  
        Map<String,String> createMap = new HashMap<String,String>();  
        createMap.put("authuser","dai");  
        createMap.put("authpass","1234");  
        createMap.put("orgkey","1212");  
        createMap.put("orgname","1212");  
        String httpOrgCreateTestRtn = httpClientUtil.doPost(httpOrgCreateTest, createMap, httpOrgCreateTest); 
        System.out.println("result:"+httpOrgCreateTestRtn);  
    }  
      
    public static void main(String[] args){  
        TestMain main = new TestMain();  
        main.test();  
    }  
}  