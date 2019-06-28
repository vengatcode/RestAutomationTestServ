package com.restapi.autotest.springbootstarter.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author VR5037542 ***Vengatesan Rathinavel***
 *
 */
@Component
public class RestAutoTestRequestBody {
	
	List<TestObject> testobjects; 
	
	/*
	 * public RestAutoTestRequestBody(){ testobjects = new ArrayList<TestObject>();
	 * }
	 * 
	 * public RestAutoTestRequestBody(List<TestObject> testobjects) { super();
	 * this.testobjects = testobjects; }
	 */

	public List<TestObject> getTestobjects() {
		return testobjects;
	}

	public void setTestobjects(List<TestObject> testobjects) {
		this.testobjects = testobjects;
	}
	
	

}
