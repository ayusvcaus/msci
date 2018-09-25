package com.msci.q4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayDuplicateElementFinderTest {
	
	@Test
	public void testFindDuplicate() throws Exception {
		
		int[] input= {1,3,4,2,2};
		int expected=2;
		int actual=ArrayDuplicateElementFinder.findDuplicate(input);
		assertEquals(expected, actual);
		
		input= new int[]{3,1,3,4,2};
		expected=3;
		actual=ArrayDuplicateElementFinder.findDuplicate(input);
		assertEquals(expected, actual);
		
		input= new int[]{1,3,5,6,7,5,8,5,5};
		expected=5;
		actual=ArrayDuplicateElementFinder.findDuplicate(input);
		assertEquals(expected, actual);
		
		input= new int[]{1,3,5,6,7,9,8,5,5};
		expected=-1;
		actual=ArrayDuplicateElementFinder.findDuplicate(input);
		assertEquals(expected, actual);
	}
	

}
