package dataStructures.stack;

import static org.junit.Assert.*;

import java.nio.BufferUnderflowException;

import org.junit.*;

import dataStructures.stack.ArrayStack;

public class ArrayStackTest {
	
	private ArrayStack<Integer, String> s = null;
			
	@Before
	public void setUp() {
		s = new ArrayStack<Integer, String>(15);
	}

	@Test
	public void stackShouldStartEmpty() {
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferUnderflowException.class)  
	public void popingEmptyStackShouldRaiseAnException(){
		s.pop();
	}
}
