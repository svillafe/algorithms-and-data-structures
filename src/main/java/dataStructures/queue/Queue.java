package dataStructures.queue;

import dataStructures.Node;

/*
 * Data Structure: Queue
 * It implements a first-in, first-out (FIFO) policy.
 * Source: CLRS page 234
 */
public interface Queue<T extends Comparable<T>, U> {

	public Boolean isEmpty();
	
	public Boolean isFull();
	
	public void enqueue(Node<T, U> x);
	
	public Node<T, U> dequeue();
	
}
