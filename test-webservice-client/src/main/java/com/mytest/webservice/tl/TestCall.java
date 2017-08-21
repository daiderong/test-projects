package com.mytest.webservice.tl;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axiom.om.OMElement;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TestCall {


    public static void main(String[] args) throws Exception {
        WebserviceTonglu s = new WebserviceTonglu();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROWSET><ROW num=\"1\"><identityNo>330122196210201124</identityNo><name>王金花</name></ROW></ROWSET>";
        OMElement retOME = s.sendAndResult(ActionEm.BASE_INFO, xml);
        Iterator<OMElement> iter = retOME.getChildElements();
        Map<String, String> map = new HashMap();
        while (iter.hasNext()) {
            OMElement node = iter.next();
            map.put(node.getLocalName(), node.getText());
        }
        ResultXml resultXml = new ResultXml();
        resultXml.setOutErrXml(map.get("outErrXml"));
        resultXml.setOutXml(map.get("outXml"));
        resultXml.setResult(Integer.parseInt(map.get("LabourTech001Result")));

        resultXml.setOutMap(new HashMap<String, String>());
        resultXml.setOutErrMap(new HashMap<String, String>());
        set(resultXml.getOutMap(), resultXml.getOutXml());
        set(resultXml.getOutErrMap(),resultXml.getOutErrXml());
    }

    public static void set(Map<String,String> map,String xml) throws Exception{

        //解析outXml
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(is);
        NodeList nolist = doc.getElementsByTagName("ROWSET");
        System.out.println(nolist.getLength());

        if(nolist.getLength() > 0 && nolist.item(0).hasChildNodes()){
            Node row = nolist.item(0).getFirstChild();
            NodeList rowChildren = row.getChildNodes();
            for (int i = 0; rowChildren != null && i < rowChildren.getLength(); i++) {
                Node rowChild = rowChildren.item(i);
                map.put(rowChild.getNodeName(), rowChild.getTextContent());
            }
        }
        
        
    }
}
