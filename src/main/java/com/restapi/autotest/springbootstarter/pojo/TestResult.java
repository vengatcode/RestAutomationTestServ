/**
 * 
 */
package com.restapi.autotest.springbootstarter.pojo;

/**
 * @author VR5037542 ***Vengatesan Rathinavel***
 *
 */
public class TestResult {
	
	String testcaseid;
	String testmethod;
	String responsebody;
	int responsestatus;
	String teststatus;
	
	public String getTestcaseid() {
		return testcaseid;
	}
	public void setTestcaseid(String testcaseid) {
		this.testcaseid = testcaseid;
	}
	public String getResponsebody() {
		return responsebody;
	}
	public void setResponsebody(String responsebody) {
		this.responsebody = responsebody;
	}
	public String getTeststatus() {
		return teststatus;
	}
	public void setTeststatus(String responsestatus) {
		this.teststatus = responsestatus;
	}
	public String getTestmethod() {
		return testmethod;
	}
	public void setTestmethod(String testmethod) {
		this.testmethod = testmethod;
	}
	public int getResponsestatus() {
		return responsestatus;
	}
	public void setResponsestatus(int responsestatus) {
		this.responsestatus = responsestatus;
	}
	

}
