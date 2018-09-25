package com.msci.q2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class  HuffmanCoderTest {
	
	@Test
	public void testEncodeDecode() throws Exception {
		HuffmanCoder hc=new HuffmanCoder();
		String message="beep boop beer!";
		String expected="0011110111010001001001110100111110011000";
		String actual=hc.encode(message);
        assertEquals(expected, actual);
	
        actual=hc.decode(expected);
        assertEquals(message, actual);
        
		message="aaabcd";
        expected="11101001100";
        actual=hc.encode(message);
        assertEquals(expected, actual);
        
		message="AAAAAA";
        expected="000000";
        actual=hc.encode(message);
        assertEquals(expected, actual);        

        actual=hc.decode(expected);
        assertEquals(message, actual); 
        
		message="B";
        expected="0";
        actual=hc.encode(message);
        assertEquals(expected, actual);        

        actual=hc.decode(expected);
        assertEquals(message, actual); 
        
        assertEquals(hc.encode(null), "");
        assertEquals(hc.encode(""), "");
        
        assertEquals(hc.decode(null), "");
        assertEquals(hc.decode(""), "");
	}
}
