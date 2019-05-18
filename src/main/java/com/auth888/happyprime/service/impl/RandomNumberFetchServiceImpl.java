package com.auth888.happyprime.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.auth888.happyprime.constant.HappyConstants;
import com.auth888.happyprime.service.RandomNumberFetchService;

@Service
public class RandomNumberFetchServiceImpl implements RandomNumberFetchService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RandomNumberFetchServiceImpl.class);

    @Value("${app.fetch.random.number.api}")
    private String fetchRandomNumberApi;

    @Autowired
    private RestTemplate restTemplate;

	@Override
	public Integer fetchRandomNumber() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(fetchRandomNumberApi, String.class);
            String result = response.getBody();
            if (!StringUtils.isEmpty(result)) {
                return Integer.parseUnsignedInt(result.trim());
            } else {
                LOGGER.error(HappyConstants.ERROR_FAILED_FETCHING_RANDOM);
                return null;
            }
        } catch (Exception ex) {
            LOGGER.error(HappyConstants.ERROR_FAILED_FETCHING_RANDOM, ex);
            return null;
        }
	}

}
