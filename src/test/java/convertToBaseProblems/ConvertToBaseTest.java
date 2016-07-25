package convertToBaseProblems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import convertToBaseProblems.ConvertToBase;

public class ConvertToBaseTest {
	
	@Test
	public void itShouldComputeCorrectly() {		
		assertEquals("12", ConvertToBase.integerToBase(18, 16));
		assertEquals("-1", ConvertToBase.integerToBase(-1, 16));
		assertEquals("1234BABE", ConvertToBase.integerToBase(305445566, 16));
		assertEquals("10", ConvertToBase.integerToBase(10, 10));
		assertEquals("-5", ConvertToBase.integerToBase(-5, 10));
		assertEquals("10", ConvertToBase.integerToBase(2, 2));
		assertEquals("110001", ConvertToBase.integerToBase(-15, -2));
		assertEquals("CASA", ConvertToBase.integerToBase(301900, 29));

	}
}
