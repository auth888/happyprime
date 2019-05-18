package com.auth888.happyprime.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth888.happyprime.models.CheckingNumber;
import com.auth888.happyprime.service.HappyService;
import com.auth888.happyprime.service.RandomNumberFetchService;
import com.auth888.happyprime.util.HappyUtils;

import com.auth888.happyprime.constant.HappyConstants;

@Service
public class HappyServiceImpl implements HappyService {
    private final static Logger LOGGER = LoggerFactory.getLogger(HappyServiceImpl.class);

	@Autowired
	private RandomNumberFetchService randomNumberFetchService;
	
	@Override
	public CheckingNumber testHappyPrimeNumber(Integer aNumber) {
        if (aNumber == null) {
            LOGGER.warn(HappyConstants.WARNING_SWITCHING_TO_RANDOM_NUMBER);
			aNumber = randomNumberFetchService.fetchRandomNumber();
            if (aNumber == null) {
                LOGGER.error(HappyConstants.ERROR_FAILED_FETCHING_RANDOM);
                return null;
            }
        }
        
        CheckingNumber checkingNumber = new CheckingNumber(aNumber);

        checkingNumber.setHappy(HappyUtils.isHappyNumber(aNumber));
        checkingNumber.setPrime(HappyUtils.isPrimeNumber(aNumber));
        
        return checkingNumber;
	}

}
