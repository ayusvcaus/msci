package com.msci.q3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class  WordsReverserTest {
	
	@Test
	public void testReverseWordsByString() throws Exception {
		WordsReverser wr=new WordsReverser();
		String input="A group of engineer of MSCI work on Campus of US Berkeley";
		String actual=wr.reverseWords(input);
		String expected="Berkeley US of Campus on work MSCI of engineer of group A";
		assertEquals(expected, actual);
		
		input="A";
		actual=wr.reverseWords(input);
		expected="A";
		assertEquals(expected, actual);
		
		input=null;
		actual=wr.reverseWords(input);
		assertNull(actual);
		
		input="";
		actual=wr.reverseWords(input);
		expected="";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReverseWordsByCharArray() throws Exception {
		WordsReverser wr=new WordsReverser();
		char[] input= {'A', ' ', 'g', 'r', 'o', 'u', 'p', ' ', 'o', 'f', ' ', 'e', 'n', 'g', 'i', 'n', 'e', 'e', 'r' };
		wr.reverseWords(input);
		String actual=String.valueOf(input);
		String expected="engineer of group A";
		assertEquals(expected, actual);
		
		input= new char[]{'A'};
		wr.reverseWords(input);
		actual=String.valueOf(input);
		expected="A";
		assertEquals(expected, actual);
		
		input= new char[]{};
		wr.reverseWords(input);
		actual=String.valueOf(input);
		expected="";
		assertEquals(expected, actual);
		
		input=null;
		wr.reverseWords(input);
		assertNull(input);		
	}
}
