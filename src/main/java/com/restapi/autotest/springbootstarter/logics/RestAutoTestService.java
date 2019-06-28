/**
 * 
 */
package com.restapi.autotest.springbootstarter.logics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.autotest.springbootstarter.pojo.RestAutoTestRequestBody;
import com.restapi.autotest.springbootstarter.pojo.RestAutoTestResponseBody;
import com.restapi.autotest.springbootstarter.pojo.TestObject;
import com.restapi.autotest.springbootstarter.pojo.TestResult;


/**
 * @author VR5037542  ***Vengatesan Rathinavel***
 *
 */
@Service
public class RestAutoTestService {
	
	static Logger LOGGER = Logger.getLogger(RestAutoTestService.class);
	public static int responsestatus;
	
	@Autowired
	RestAutoTestResponseBody restAutoTestResponseBody;

	public RestAutoTestResponseBody getRestAutoTestResponse(RestAutoTestRequestBody restAutoTestRequestBody) {

		List<TestResult> testResults = new ArrayList<TestResult>();
		
		ArrayList<TestObject> testObjects = (ArrayList<TestObject>) restAutoTestRequestBody.getTestobjects();
		Iterator<TestObject> iteratorObject = testObjects.iterator();
		while(iteratorObject.hasNext()) {
			TestResult testResult = new TestResult();
			TestObject testObject = iteratorObject.next();
			LOGGER.info(testObject.getTestcaseid());
			testResult.setTestcaseid(testObject.getTestcaseid());
			testResult.setTestmethod(testObject.getMethodtype());
			String response = invokeHTTPConnection(testObject);
			testResult.setResponsebody(response);
			testResult.setResponsestatus(responsestatus);
			LOGGER.info(testObject.getMethodtype());
			LOGGER.info(responsestatus);
			if(testObject.getExpectedresponse().trim().isEmpty()) {
				testResult.setTeststatus("No expected response to check!!!");
			}else {
				LOGGER.info("Expected Response : " + testObject.getExpectedresponse());
				boolean testStatus = testObject.getExpectedresponse().trim().equalsIgnoreCase(response);
				if(testStatus) {
					testResult.setTeststatus("PASS");
				}else {
					testResult.setTeststatus("FAIL");
				}
			}						
			testResults.add(testResult);
		}	
		restAutoTestResponseBody.setTestResult(testResults);				
		return restAutoTestResponseBody;
	}
	
	private static String invokeHTTPConnection(TestObject testObject) {
		LOGGER.debug("Method [invokeHTTPConnection] start");
		URL serviceURL = null;
		HttpURLConnection httpConnection = null;
		BufferedReader responseBuffer = null;
		OutputStream outputStream = null;
		String response = "";
		try {
			serviceURL = new URL(testObject.getEndpoint());

			httpConnection = (HttpURLConnection) serviceURL.openConnection();
			httpConnection.setRequestMethod(testObject.getMethodtype());
			if ((testObject.getHeaderparamkey() != null)
					&& (testObject.getHeaderparamvalue() != null)) {
				String[] key = testObject.getHeaderparamkey().split(",");
				String[] value = testObject.getHeaderparamvalue()
						.split(",");
				for (int i = 0; i < key.length; i++) {
					httpConnection.setRequestProperty(key[i], value[i]);
					//System.out.println(key[i] + value[i]);
				}
			}
			if (!testObject.getMethodtype().equals("GET")) {
				httpConnection.setDoOutput(true);
				outputStream = httpConnection.getOutputStream();
				outputStream.write(testObject.getRequestbody().getBytes());
				outputStream.flush();
				responsestatus = httpConnection.getResponseCode();
			}
			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ httpConnection.getResponseCode());
			}
			responseBuffer = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			String output;
			while ((output = responseBuffer.readLine()) != null) {
				LOGGER.info("Actual Response : " + output);
				response = response + output;
			}
			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			LOGGER.error(e.getStackTrace());
			response = e.getMessage();
			try {
				if (outputStream != null) {
					outputStream.close();
				}
				if (responseBuffer != null) {
					responseBuffer.close();
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getStackTrace());
			}
		} catch (IOException e) {
			LOGGER.error(e.getStackTrace());
			response = e.getMessage();
			try {
				if (outputStream != null) {
					outputStream.close();
				}
				if (responseBuffer != null) {
					responseBuffer.close();
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getStackTrace());
			}
		} catch (Exception e) {
			LOGGER.error(e.getStackTrace());
			response = e.getMessage();
			try {
				if (outputStream != null) {
					outputStream.close();
				}
				if (responseBuffer != null) {
					responseBuffer.close();
				}
			} catch (Exception ex) {
				LOGGER.error(e.getStackTrace());
			}
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
				if (responseBuffer != null) {
					responseBuffer.close();
				}
			} catch (Exception ex) {
				LOGGER.error(ex.getStackTrace());
			}
		}
		LOGGER.debug("Method [invokeHTTPConnection] end");
		return response;
	}


}
