package com.auth888.happyprime.util;

import java.util.HashSet;
import java.util.Set;

public class HappyUtils {

	public static boolean isHappyNumber(int aNumber) {
		// use a HashSet to hold the numbers calculated:
		Set<Integer> calc_numbers = new HashSet<Integer>();

		while (calc_numbers.add(aNumber)) { // true if this set did not already contain the specified element
			int sum = 0;
			while (aNumber > 0) { // getting the value of power of 2 for each digits and add them together
				sum += Math.pow(aNumber % 10, 2);
				aNumber = aNumber / 10;
			}
			aNumber = sum;
		}
		if (aNumber == 1) {
			return true;
		}
		return false;

	}

	public static boolean isPrimeNumber(int aNumber) {
		if (aNumber <= 1)
			return false;
		if (aNumber == 2)
			return true;
		int range = aNumber;
		
		// starting from 2, and only need to check the odd numbers after:
		for (int i = 2; i <= range; i = (i % 2 == 0) ? (i + 1) : (i + 2)) { 
			// check the aNumber to see if it is a prime:
			if ((aNumber != i) && ((aNumber % i) == 0)) {
				// this number can be divided by a smaller number, not a prime.
				return false;
			} else {
				// reduce the range since any number bigger than that folder line wouldn't get a chance
				range = aNumber / i;
			}
		}
		return true;
	}

}
