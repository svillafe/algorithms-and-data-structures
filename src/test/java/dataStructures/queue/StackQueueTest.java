package dataStructures.queue;

import static org.junit.Assert.assertEquals;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import org.junit.Before;
import org.junit.Test;

import dataStructures.SimpleNode;
import dataStructures.queue.StackQueue;

public class StackQueueTest {
	
	private StackQueue<Integer, String> s = null;
			
	@Before
	public void setUp() {
		s = new StackQueue<Integer, String>(6);
	}

	@Test
	public void queueShouldStartEmpty() {
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferUnderflowException.class)  
	public void dequeingEmptyQueueShouldRaiseAnException(){
		s.dequeue();
	}
	
	@Test
	public void queueShouldReturnCorrectValues() {
		s.enqueue(new SimpleNode<Integer, String>(1, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(2, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(3, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(4, "AW"));
		
		assertEquals(new Integer(1), s.dequeue().getKey());
		s.enqueue(new SimpleNode<Integer, String>(5, "AW"));
		
		assertEquals(new Integer(2), s.dequeue().getKey());
		assertEquals(new Integer(3), s.dequeue().getKey());
		assertEquals(new Integer(4), s.dequeue().getKey());
		assertEquals(new Integer(5), s.dequeue().getKey());
		assertEquals(s.isEmpty(), true);
	}
	
	@Test(expected = BufferOverflowException.class)
	public void queueShouldReturnWhenItIsFull() {
		s.enqueue(new SimpleNode<Integer, String>(1, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(2, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(3, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(4, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(5, "AW"));
		s.enqueue(new SimpleNode<Integer, String>(6, "AW"));
		
		assertEquals(true, s.isFull());
		s.enqueue(new SimpleNode<Integer, String>(7, "AW"));
	}
}


