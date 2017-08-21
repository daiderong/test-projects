package com.mytest.webservice.cd;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;


public class TestMain2  
{  
   public static void main(String[] args) throws AxisFault {
	   RPCServiceClient serviceClient = new RPCServiceClient();
	   Options options = serviceClient.getOptions();
	   EndpointReference targetEPR = new EndpointReference("http://193.168.2.3/cdcqhlxjk/services/CdcqhlxjkService");
	   options.setTo(targetEPR);
	   String idcard = "132626196412050026";
	   Object [] opAddEnt = new Object[]{idcard};
	   Class[] classes = new Class[]{String.class};
	   QName enty = new QName("http://www.ylzinfo.com/xsd", "personInsured");
	  System.out.println(); 	serviceClient.invokeBlocking(enty, opAddEnt,classes);
   }
  
}  