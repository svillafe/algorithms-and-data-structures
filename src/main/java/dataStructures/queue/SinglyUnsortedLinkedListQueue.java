package dataStructures.queue;

import java.nio.BufferUnderflowException;

import dataStructures.Node;
import dataStructures.linkedList.SinglyNode;
import dataStructures.linkedList.SinglyUnsortedLinkedList;

/*
 * Implementation of a Queue using LinkedList as an underlying data structure.
 */
public class SinglyUnsortedLinkedListQueue<T extends Comparable<T>, U> implements Queue<T, U> {
	
	SinglyUnsortedLinkedList<T, U> linkedList = new SinglyUnsortedLinkedList<T, U>();
	
	@Override
	public Boolean isEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public Boolean isFull() {
		return false;
	}

	@Override
	public void enqueue(Node<T, U> x) {
		SinglyNode<T, U> element = new SinglyNode<T, U>(x.getKey(), x.getData());
		linkedList.insert(element);
	}

	@Override
	public Node<T, U> dequeue() {
		if(linkedList.isEmpty()){
			throw new BufferUnderflowException();
		}
		Node<T, U> resp = linkedList.getTail();		
		linkedList.delete(resp);
		return resp;
	}
}
