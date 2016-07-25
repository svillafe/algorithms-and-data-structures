package convertToBaseProblems;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import convertToBaseProblems.ConvertToHex;

public class ConvertToHexTest {
	
	@Test
	public void itShouldComputeCorrectly() {		
		assertTrue("0x12".equals(ConvertToHex.integerToHex(18)));
		assertTrue("-0x1".equals(ConvertToHex.integerToHex(-1)));
		assertTrue("0x1234BABE".equals(ConvertToHex.integerToHex(305445566)));
	}
}
