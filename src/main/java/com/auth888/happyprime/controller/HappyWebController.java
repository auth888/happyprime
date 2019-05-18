package com.auth888.happyprime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.auth888.happyprime.constant.HappyConstants;
import com.auth888.happyprime.models.CheckingNumber;
import com.auth888.happyprime.models.HappyResponse;
import com.auth888.happyprime.service.HappyService;

@RestController
public class HappyWebController {
	
	@Autowired
	private HappyService happyService;

	@GetMapping(value = {"/testNumber", "/testNumber/{number}"})
	public HappyResponse testNumber(@PathVariable(name = "number", required = false) Integer number) {
		HappyResponse response = new HappyResponse();
		CheckingNumber checkingNumber = happyService.testHappyPrimeNumber(number);
		if (checkingNumber != null) {
			boolean isHappyPrime = checkingNumber.isHappy() && checkingNumber.isPrime();
			response.setTestNumber(checkingNumber.getTheNumber());
			response.setMessage(isHappyPrime ? HappyConstants.MESSAGE_INDEEDED_HAPPY_PRIME_NUMBER : HappyConstants.MESSAGE_NOT_HAPPY_PRIME_NUMBER);
		} else {
			response.setMessage(HappyConstants.ERROR_FAILED_FETCHING_RANDOM);
		}
		return response;
	}
	
}