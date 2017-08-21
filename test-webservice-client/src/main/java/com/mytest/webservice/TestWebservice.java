package com.mytest.webservice;
  
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
  
public class TestWebservice {  
  
    public void Test(){  
        //testClient();  
        //testRPC();  
        testOMElement();  
    }  
      
//    /** 
//     * 第一种 
//     * MyEclipse 生成客户端方式 
//     */  
//    public void testClient(){  
//        HelloWebService service = new HelloWebService();  
//        HelloWebServicePortType portType = service.getHelloWebServiceHttpSoap11Endpoint();  
//        String result = portType.sayHello("jack");  
//        System.out.println(result);  
//    }  
      
    /** 
     *  第二种 
     *  使用axis2 RPC调用webservice 需要导入相应的jar包 
     */  
    public void testRPC(){  
        try{  
            RPCServiceClient client = new RPCServiceClient();  
            Options options = client.getOptions();  
            String url = "http://localhost:8080/axis2/services/HelloWebService?wsdl";  
            EndpointReference end = new EndpointReference(url);  
            options.setTo(end);  
              
            Object[] obj = new Object[]{"tom"};  
             Class<?>[] classes = new Class[] { String.class };    
              
            QName qname = new QName("http://testClick", "sayHello");    
            String result = (String) client.invokeBlocking(qname, obj,classes)[0];  
            System.out.println(result);  
        }catch(AxisFault e){  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     *  第三种 
     * @throws AxisFault  
     */  
    public void testOMElement(){  
        try{  
            ServiceClient sc = new ServiceClient();  
            Options opts = new Options();   
            String url = "http://124.160.76.183:20443/service.asmx?op=LabourTech001";  
            EndpointReference end = new EndpointReference(url);  
            opts.setTo(end);  
            opts.setAction("http://www.labourtech.com/LabourTech001");  
            sc.setOptions(opts);  
              
            OMFactory fac = OMAbstractFactory.getOMFactory();    
            OMNamespace omNs = fac.createOMNamespace("http://testClick", "");    
            OMElement method = fac.createOMElement("sayHello",omNs);    
            OMElement value = fac.createOMElement("name",omNs);  
            value.setText("admin");  
            method.addChild(value);   
            OMElement res = sc.sendReceive(method);  
            res.getFirstElement().getText();    
            System.out.println(res.getFirstElement().getText());  
        }catch(AxisFault e){  
            e.printStackTrace();  
        }  
    }  
}  