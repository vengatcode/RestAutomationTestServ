package com.restapi.autotest.springbootstarter.logics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.autotest.springbootstarter.pojo.RestAutoTestRequestBody;
import com.restapi.autotest.springbootstarter.pojo.RestAutoTestResponseBody;

/**
 * @author VR5037542 ***Vengatesan Rathinavel***
 *
 */
@RestController
public class RestAutoTestController {

	@Autowired
	RestAutoTestService restAutoTestService;

	@Autowired
	RestAutoTestResponseBody restAutoTestResponseBody;
	
	@RequestMapping(method = RequestMethod.POST, value = "/rest/autotest/trigger", consumes = "application/json")
	public RestAutoTestResponseBody getRestAutoTestResponse1(@RequestBody RestAutoTestRequestBody restAutoTestRequestBody) {	
		restAutoTestResponseBody = restAutoTestService.getRestAutoTestResponse(restAutoTestRequestBody);
		return restAutoTestResponseBody;		
	}

}
