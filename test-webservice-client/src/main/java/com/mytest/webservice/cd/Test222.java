package com.mytest.webservice.cd;


import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class Test222 {
	public static void main(String args[]) throws AxisFault{    
		  	RPCServiceClient serviceClient = new RPCServiceClient();   
		    Options options = serviceClient.getOptions();     
		    EndpointReference targetEPR = new EndpointReference(   
		            "http://193.168.2.3/cdcqhlxjk/services/CdcqhlxjkService");   
		    options.setTo(targetEPR);   
		    Object[] opAddEntryArgs = new Object[] {};   
//		    System.out.println(opAddEntryArgs.length);
		    Class[] classes = new Class[] {String.class}; 
//		    System.out.println(classes.length);
		    QName opAddEntry = new QName("http://www.ylzinfo.com/xsd", "personInsured");   
		    System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);   
		}   
}

