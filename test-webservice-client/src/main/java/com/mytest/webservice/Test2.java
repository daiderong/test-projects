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
  
public class Test2  
{  
    private static EndpointReference targetEPR = new EndpointReference( "http://124.160.76.183:20443/service.asmx");  
  
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
        OMNamespace omNs = fac.createOMNamespace("http://www.labourtech.com/", "");  
        OMElement data = fac.createOMElement("LabourTech001", omNs);  
        OMElement inner = fac.createOMElement("para1", omNs); 
        inner.setText("1");  
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROWSET><ROW num=\"1\"><identityNo>330122196210201124</identityNo><name>王金花</name></ROW></ROWSET>";
        OMElement inner2 = fac.createOMElement("para2", omNs);
        inner2.setText(xml);
        OMElement inner3 = fac.createOMElement("outXml", omNs);
        inner3.setText("");
        OMElement inner4 = fac.createOMElement("outErrXml", omNs);
        inner4.setText("");
        
        data.addChild(inner);  
        data.addChild(inner2);
        data.addChild(inner3);
        data.addChild(inner4);
        return data;  
    }  
  
    private static Options buildOptions()  
    {  
        Options options = new Options();  
        options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);  
        options.setAction("http://www.labourtech.com/LabourTech001");  
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
        Test2 s = new Test2();  
        s.getResult();  
    }  
  
}  