package dataStructures.linkedList;

import dataStructures.Node;

/*
 * LinkedList Node Interface
 * It represents the node of the linked lists. It adds to the plain node structure
 * the logic of previous nodes and next nodes. 
 */
public interface LinkedListNode<T extends Comparable<T>,U> extends Node<T,U>{
	
	public LinkedListNode<T, U> getNext();
	
	public void setNext(LinkedListNode<T,U> next);
	
	public LinkedListNode<T,U> getPrev();
	
	public void setPrev(LinkedListNode<T,U> prev);
}
