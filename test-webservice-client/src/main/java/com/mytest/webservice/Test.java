package com.mytest.webservice;

import org.apache.axiom.om.OMAbstractFactory;  
import org.apache.axiom.om.OMElement;  
import org.apache.axiom.om.OMFactory;  
import org.apache.axiom.om.OMNamespace;  
import org.apache.axiom.soap.SOAP11Constants;  
import org.apache.axis2.Constants;  
import org.apache.axis2.addressing.EndpointReference;  
import org.apache.axis2.client.Options;  
import org.apache.axis2.client.ServiceClient;  
import org.apache.axis2.transport.http.HTTPConstants;  
import org.apache.axis2.transport.http.HttpTransportProperties.ProxyProperties;  
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
  
public class Test  
{  
    private static EndpointReference targetEPR = new EndpointReference(  
            "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");  
  
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
        OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");  
        OMElement data = fac.createOMElement("getWeatherbyCityName", omNs);  
        OMElement inner = fac.createOMElement("theCityName", omNs);  
        inner.setText("北京");  
        inner.setText("上海");
        data.addChild(inner);  
        return data;  
    }  
  
    private static Options buildOptions()  
    {  
        Options options = new Options();  
        options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);  
        options.setAction("http://WebXml.com.cn/getWeatherbyCityName");  
        options.setTo(targetEPR);  
        //options.setProperty 如果不是通过代理上网，此句可省  
        //options.setProperty(HTTPConstants.PROXY, buildProxy());  
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
        Test s = new Test();  
        s.getResult();  
    }  
  
}  