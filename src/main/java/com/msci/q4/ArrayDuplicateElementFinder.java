package com.msci.q4;

public class ArrayDuplicateElementFinder {

	public static int findDuplicate(final int[] input) {
		/*
		 * Since the array with length n+1, for any element i are in {1...n}, Math.abs(input[i]) 
		 * as an index are always valid
		 */
		
		for (int i=0; i <input.length; i++) {
			if (Math.abs(input[i])>=input.length) {
				return -1;
			} else if (input[Math.abs(input[i])]>0) {
				input[Math.abs(input[i])]=-input[Math.abs(input[i])];
		    } else {
				return Math.abs(input[i]);
		    }
		}
		return -1;
	}
}
