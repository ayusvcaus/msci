package com.msci.q5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class PascalTriangleHandlerTest {
	private PascalTriangleHandler p;
	
	@Before
	public void setup() {
		p=new PascalTriangleHandler();
	}
	
	@Test 
	public void testGetValue() throws Exception {
		int expected=126;
		int actual=p.coordinatesToValue(9, 4);
		assertEquals(expected, actual);
		
		expected=-1;
		actual=p.coordinatesToValue(-1, 2);
		assertEquals(expected, actual);
		
		expected=-1;
		actual=p.coordinatesToValue(5, -2);
		assertEquals(expected, actual);
		
		expected=-1;
		actual=p.coordinatesToValue(5, 6);
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testBuidTriangle() throws Exception {
		int sizeExpected=10;
		List<List<Integer>> actual=p.buidTriangle(sizeExpected);
		assertEquals(sizeExpected, actual.size());
	
		int[] expectLayer={1, 9, 36, 84, 126, 126, 84, 36, 9, 1};
	    List<Integer> actualLayer=actual.get(actual.size()-1);
	    assertEquals(expectLayer.length, actualLayer.size());
	    for (int i=0; i<actualLayer.size(); i++) {
	    	 assertEquals(expectLayer[i], actualLayer.get(i).intValue());
	    }
	    
	    actual=p.buidTriangle(-1);
		assertEquals(0, actual.size());	    
	}
}
