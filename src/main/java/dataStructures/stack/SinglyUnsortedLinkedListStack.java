package dataStructures.stack;

import java.nio.BufferUnderflowException;

import dataStructures.Node;
import dataStructures.linkedList.SinglyNode;
import dataStructures.linkedList.SinglyUnsortedLinkedList;

/*
 * Data Structure: Stack implemented using a linked list as an underlying structure.
 * It implements a last-in, first-out (LIFO) policy
 */
public class SinglyUnsortedLinkedListStack<T extends Comparable<T>, U> implements Stack<T, U> {
	
	SinglyUnsortedLinkedList<T, U> linkedList = new SinglyUnsortedLinkedList<T, U>();
	
	@Override
	public Boolean isFull() {
		return false;
	}

	@Override
	public Boolean isEmpty() {
		return this.linkedList.isEmpty();
	}

	@Override
	public Node<T, U> pop() {
		if(linkedList.isEmpty()){
			throw new BufferUnderflowException();
		}
		
		Node<T, U> resp = linkedList.getHead();		
		linkedList.delete(linkedList.getHead());
		return resp;
	}

	@Override
	public void push(Node<T, U> x) {
		SinglyNode<T, U> element = new SinglyNode<T,U>(x.getKey(), x.getData());
		linkedList.insert(element);
	}
}
