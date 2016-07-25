package convertToBaseProblems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import convertToBaseProblems.ConvertToNegabinary;

public class ConvertToNegabinaryTest {
	
	@Test
	public void itShouldComputeCorrectly() {		
		assertEquals("110001",ConvertToNegabinary.integerTom2(-15));
	}
}
