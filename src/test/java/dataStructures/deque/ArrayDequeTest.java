package dataStructures.deque;

import static org.junit.Assert.assertEquals;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import org.junit.Before;
import org.junit.Test;

public class ArrayDequeTest {
	

	private ArrayDeque<Integer> s = null;
			
	@Before
	public void setUp() {
		s = new ArrayDeque<Integer>(6);
	}

	@Test
	public void queueShouldStartEmpty() {
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferUnderflowException.class)  
	public void popingBackEmptyQueueShouldRaiseAnException(){
		s.popBack();
	}
	
	@Test(expected = BufferUnderflowException.class)  
	public void popingFrontEmptyQueueShouldRaiseAnException(){
		s.popFront();
	}
	
	@Test
	public void dequeueShouldReturnCorrectValues() {
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushFront(8);
		
		assertEquals(new Integer(4), s.popBack());
		assertEquals(new Integer(8), s.popFront());
		
		s.pushFront(10);
		
		assertEquals(new Integer(10), s.popFront());
		assertEquals(new Integer(3), s.popBack());
		assertEquals(new Integer(1), s.popFront());
		assertEquals(new Integer(2), s.popBack());
		
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferOverflowException.class)
	public void queueShouldReturnWhenItIsFull() {
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(5);
		s.pushBack(6);	
		assertEquals(true, s.isFull());
		s.pushFront(7);
	}
}
