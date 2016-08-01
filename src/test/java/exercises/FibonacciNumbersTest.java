package exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciNumbersTest {
	
	@Test
	public void itShouldCorrectlyComputeBaseCases() {
		assertEquals(new Integer(0), FibonacciNumbers.recursiveFibonacci(0));
		assertEquals(new Integer(1), FibonacciNumbers.recursiveFibonacci(1));
		
		assertEquals(new Integer(0), FibonacciNumbers.cachingFibonacci(0));
		assertEquals(new Integer(1), FibonacciNumbers.cachingFibonacci(1));
		
		assertEquals(new Integer(0), FibonacciNumbers.dpFibonacci(0));
		assertEquals(new Integer(1), FibonacciNumbers.dpFibonacci(1));
		
		assertEquals(new Integer(0), FibonacciNumbers.dpFibonacciImp(0));
		assertEquals(new Integer(1), FibonacciNumbers.dpFibonacciImp(1));
	}
	
	@Test
	public void itShouldComputeCorrectly() {
		assertEquals(new Integer(55), FibonacciNumbers.recursiveFibonacci(10));
		assertEquals(new Integer(55), FibonacciNumbers.cachingFibonacci(10));
		assertEquals(new Integer(55), FibonacciNumbers.dpFibonacci(10));
		assertEquals(new Integer(55), FibonacciNumbers.dpFibonacciImp(10));
	}
}
