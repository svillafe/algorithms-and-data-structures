package dataStructures.stack;

import static org.junit.Assert.*;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import org.junit.*;

import dataStructures.SimpleNode;
import dataStructures.stack.ArrayStack;

public class ArrayStackTest {
	
	private ArrayStack<Integer, String> s = null;
			
	@Before
	public void setUp() {
		s = new ArrayStack<Integer, String>(6);
	}

	@Test
	public void stackShouldStartEmpty() {
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferUnderflowException.class)  
	public void popingEmptyStackShouldRaiseAnException(){
		s.pop();
	}
	
	@Test
	public void stackShouldReturnCorrectValues() {
		s.push(new SimpleNode<Integer, String>(1, "AW"));
		s.push(new SimpleNode<Integer, String>(2, "AW"));
		s.push(new SimpleNode<Integer, String>(3, "AW"));
		s.push(new SimpleNode<Integer, String>(4, "AW"));
		
		assertEquals(new Integer(4), s.pop().getKey());
		s.push(new SimpleNode<Integer, String>(5, "AW"));
		
		assertEquals(new Integer(5), s.pop().getKey());
		assertEquals(new Integer(3), s.pop().getKey());
		assertEquals(new Integer(2), s.pop().getKey());
		assertEquals(new Integer(1), s.pop().getKey());
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferOverflowException.class)
	public void stackShouldReturnWhenItIsFull() {
		s.push(new SimpleNode<Integer, String>(1, "AW"));
		s.push(new SimpleNode<Integer, String>(2, "AW"));
		s.push(new SimpleNode<Integer, String>(3, "AW"));
		s.push(new SimpleNode<Integer, String>(4, "AW"));
		s.push(new SimpleNode<Integer, String>(5, "AW"));
		s.push(new SimpleNode<Integer, String>(6, "AW"));
		
		assertEquals(true, s.isFull());
		s.push(new SimpleNode<Integer, String>(7, "AW"));
	}
}
