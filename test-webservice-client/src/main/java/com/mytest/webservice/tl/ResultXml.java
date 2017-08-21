package com.mytest.webservice.tl;

import java.util.Map;

public class ResultXml {

	Integer result;
	String outXml;
	String outErrXml;
	Map<String,String> outMap;
	Map<String,String>  outErrMap;
	
	
	
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getOutXml() {
		return outXml;
	}
	public void setOutXml(String outXml) {
		this.outXml = outXml;
	}
	public String getOutErrXml() {
		return outErrXml;
	}
	public void setOutErrXml(String outErrXml) {
		this.outErrXml = outErrXml;
	}
	public Map<String, String> getOutMap() {
		return outMap;
	}
	public void setOutMap(Map<String, String> outMap) {
		this.outMap = outMap;
	}
	public Map<String, String> getOutErrMap() {
		return outErrMap;
	}
	public void setOutErrMap(Map<String, String> outErrMap) {
		this.outErrMap = outErrMap;
	}
	
	
	
	
	
	
	
}
