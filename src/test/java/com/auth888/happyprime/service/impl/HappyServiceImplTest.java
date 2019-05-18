package com.auth888.happyprime.service.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.auth888.happyprime.models.CheckingNumber;

public class HappyServiceImplTest {

    private HappyServiceImpl happyServiceImpl;

    @Before
    public void setUp( ) {
        this.happyServiceImpl = new HappyServiceImpl();
    }

    private void internalTestHappyServiceImpl(int inputNum, boolean isPrime, boolean isHappy) {
        CheckingNumber cn = happyServiceImpl.testHappyPrimeNumber(inputNum);
        assertEquals(isPrime, cn.isPrime());
        assertEquals(isHappy, cn.isHappy());
    }

    @Test
    public void testIsHappyOrPrime() {
		internalTestHappyServiceImpl(-1, false, false);
		internalTestHappyServiceImpl(0, false, false);
		internalTestHappyServiceImpl(1, false, true);
		internalTestHappyServiceImpl(2, true, false);
		internalTestHappyServiceImpl(19, true, true);
		internalTestHappyServiceImpl(167, true, true);
		internalTestHappyServiceImpl(487, true, true);
		internalTestHappyServiceImpl(500, false, false);
    }
}
