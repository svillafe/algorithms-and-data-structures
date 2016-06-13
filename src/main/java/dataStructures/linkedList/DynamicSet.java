package dataStructures.linkedList;

import dataStructures.Node;
/*
 * DynamicSet Interface
 * It define the basic operations that must be supported by dynamic data structures.
 * 
 * Source: CLRS page 231
 */
public interface DynamicSet<T extends Comparable<T>, U> {
	
	public void insert(Node<T,U> element);
	
	public Node<T,U> search(T key);
	
	public void delete(Node<T,U> element);
	
	public Node<T,U> minimum();
	
	public Node<T,U> maximum();
	
	public Node<T,U> successor(Node<T,U> element);
	
	public Node<T,U> predecessor(Node<T,U> element);
	
	public void union(DynamicSet<T,U> ds);
	
}
