package com.auth888.happyprime.models;

import lombok.Getter;
import lombok.Setter;

public class CheckingNumber {

	@Getter @Setter
	private int theNumber;
	@Getter @Setter
	private boolean isHappy = false;
	@Getter @Setter
	private boolean isPrime = false;
	
	public CheckingNumber(int theNumber) {
		this.theNumber = theNumber;
		
	}
}
