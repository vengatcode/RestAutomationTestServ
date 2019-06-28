/**
 * 
 */
package com.restapi.autotest.springbootstarter.pojo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


/**
 * @author LENOVO
 *
 */
@Component
public class RestAutoTestResponseBody {
	
	List<TestResult> testResult;
	
	RestAutoTestResponseBody(){
		testResult = new ArrayList();
	}

	public List<TestResult> getTestResult() {
		return testResult;
	}

	public void setTestResult(List<TestResult> testResult) {
		this.testResult = testResult;
	}

	

}
