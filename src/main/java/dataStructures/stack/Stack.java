package dataStructures.stack;

import dataStructures.Node;

/*
 * Data Structure: Stack
 * It implements a last-in, first-out (LIFO) policy
 * Source: CLRS page 232 
 */
public interface Stack<K extends Comparable<K>, D> {
	
	public Boolean isFull();
	
	public Boolean isEmpty();
	
	public Node<K, D> pop();
	
	public void push(Node<K, D> element);
}
