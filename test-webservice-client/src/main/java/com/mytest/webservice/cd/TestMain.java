package com.mytest.webservice.cd;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;  
  
public class TestMain  
{  
    private static EndpointReference targetEPR = new EndpointReference( "http://193.168.2.3/cdcqhlxjk/services/CdcqhlxjkService");  
  
    public void getResult() throws Exception  
    {  
        ServiceClient sender = new ServiceClient();  
        sender.setOptions(buildOptions());  
        OMElement result = sender.sendReceive(buildParam());  
        System.out.println(result);  
    }  
  
    private static OMElement buildParam()  
    {  
        OMFactory fac = OMAbstractFactory.getOMFactory();  
        OMNamespace omNs = fac.createOMNamespace("http://www.ylzinfo.com/xsd", "");  
        OMElement data = fac.createOMElement("CdcqhlxjkService", omNs); 
        OMElement inner = fac.createOMElement("AAC001", omNs); 
        inner.setText("132626196412050026");  
        data.addChild(inner);  
        return data;  
    }  
  
    private static Options buildOptions()  
    {  
        Options options = new Options();  
        options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);  
        options.setAction("urn:personInsured");  
        options.setTo(targetEPR);  
        options.setTransportInProtocol(Constants.TRANSPORT_HTTP);  
        return options;  
    }  
  
    /** 
     * 本机采用代理服务器上网时，需要设置代理 
     * @return 
     */  
//    public static ProxyProperties buildProxy()  
//    {  
//        ProxyProperties proxyProperties = new ProxyProperties();  
//        proxyProperties.setProxyName("代理名称");  
//        proxyProperties.setProxyPort(8080);  
//        return proxyProperties;  
//    }  
  
    public static void main(String[] args) throws Exception  
    {  
        TestMain s = new TestMain();  
        s.getResult();  
    }  
  
}  