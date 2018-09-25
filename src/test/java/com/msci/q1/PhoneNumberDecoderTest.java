package com.msci.q1;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.msci.q1.PhoneNumberDecoder;

public class  PhoneNumberDecoderTest {

	public static final String wordsFile="data/google-10000-english-usa.txt";
		
	@Test
	public void testLookup() throws Exception {
		PhoneNumberDecoder pnd=new PhoneNumberDecoder();
		pnd.setWordsFile(wordsFile);
		pnd.buildDictionary();	
		
		String num="56835282"; 
	    Set<String> set=pnd.lookup(num);
		assertTrue(set.contains("LOVEJAVA"));
		
        num="(568) 369-5282"; 
        set=pnd.lookup(num);
		assertTrue(set.contains("LOVEMYJAVA"));
		
		num="1010127753"; 
		set=pnd.lookup(num);
		assertTrue(set.contains("10101APPLE"));
		
		num="2"; 
	    set=pnd.lookup(num);
		assertTrue(set.contains("A"));
		
		num="999999999999999999999999999999999999999999"; 
	    set=pnd.lookup(num);
		assertTrue(set.isEmpty());
		 
        num=null;
        set=pnd.lookup(num);
		assertTrue(set.isEmpty());  
		
        num="";
        set=pnd.lookup(num);
		assertTrue(set.isEmpty());
	
        num="345x7789";
        set=pnd.lookup(num);
		assertTrue(set.isEmpty());
	}
	

	@Test
	public void testGetDictionary() throws Exception {
		Set<String> words = new HashSet<String>() {{
			add("ABC");
			add("JEX");
			add("LDW");
			add("KFY");
		}};
		PhoneNumberDecoder pnd=new PhoneNumberDecoder();
		Map<String, Set<String>> dict= pnd.getDictionary(words);
		assertTrue(dict.get("222").contains("ABC"));
		assertEquals(3, dict.get("539").size());
		assertTrue(dict.get("539").contains("JEX"));
		assertTrue(dict.get("539").contains("LDW"));
		assertTrue(dict.get("539").contains("KFY"));
	}	
}
