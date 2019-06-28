package com.restapi.autotest.springbootstarter.pojo;

/**
 * @author VR5037542 ***Vengatesan Rathinavel***
 *
 */
public class TestObject {
	
	String testcaseid;
	String methodtype;
	String endpoint;
	String headerparamkey; //set in future enhancement
	String headerparamvalue; //set in future enhancement
	String requestbody;
	String expectedstatus;
	String expectedresponse;
	
	public String getTestcaseid() {
		return testcaseid;
	}
	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}
	public String getMethodtype() {
		return methodtype;
	}
	public void setMethodtype(String methodtype) {
		this.methodtype = methodtype;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getHeaderparamkey() {
		return headerparamkey;
	}
	public void setHeaderparamkey(String headerparamkey) {
		this.headerparamkey = headerparamkey;
	}
	public String getHeaderparamvalue() {
		return headerparamvalue;
	}
	public void setHeaderparamvalue(String headerparamvalue) {
		this.headerparamvalue = headerparamvalue;
	}
	public String getRequestbody() {
		return requestbody;
	}
	public void setRequestbody(String requestbody) {
		this.requestbody = requestbody;
	}
	public String getExpectedstatus() {
		return expectedstatus;
	}
	public void setExpectedstatus(String expectedstatus) {
		this.expectedstatus = expectedstatus;
	}
	public String getExpectedresponse() {
		return expectedresponse;
	}
	public void setExpectedresponse(String expectedresponse) {
		this.expectedresponse = expectedresponse;
	}
	
	public TestObject() {
		
	}
	
	public TestObject(String testcaseid, String methodtype, String endpoint, String headerparamkey,
			String headerparamvalue, String requestbody, String expectedstatus, String expectedresponse) {
		super();
		this.testcaseid = testcaseid;
		this.methodtype = methodtype;
		this.endpoint = endpoint;
		this.headerparamkey = headerparamkey;
		this.headerparamvalue = headerparamvalue;
		this.requestbody = requestbody;
		this.expectedstatus = expectedstatus;
		this.expectedresponse = expectedresponse;
	}
	
	

}
