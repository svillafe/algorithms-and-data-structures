package dataStructures.linkedList;

import dataStructures.Node;

/*
 * Data Structure: DoublyUnsortedLinkedList.
 * Implements: LinkedList
 * Description: It is a linked list where each node has a link to the next
 * and to the previous node. It makes use of DoublyNode in order to achieve
 * this behavior.
 * Source: CLRS chapter 10.2
 */
public class DoublyUnsortedLinkedList<T extends Comparable<T>, U> implements LinkedList<T,U> {
	
	private LinkedListNode<T,U> head;
	private Integer length;
	
	public DoublyUnsortedLinkedList(){
		super();
		this.head = null;
		this.length = 0;
	}
	
	@Override
	public LinkedListNode<T,U> getHead() {
		return head;
	}

	@Override
	public Integer getLength() {
		return length;
	}
	
	@Override
	public Boolean isEmpty(){
		return this.head == null;
	}
	
	@Override
	public Node<T,U> search(T key) {
		LinkedListNode<T,U> response = this.head;
		
		while(response != null && response.getKey() != key){
			response = response.getNext();
		}
		
		return response;
	}
	
	@Override
	public void insert(Node<T,U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>) nodeElement;
		this.length++;
		
		element.setNext(this.head);
		if(this.head != null){
			this.head.setPrev(element);
		}
		this.head = element;
		element.setPrev(null);
		
		return;
	}
	
	@Override
	public void delete(Node<T,U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>) nodeElement;
		this.length--;
		if(element.getPrev() != null){
			element.getPrev().setNext(element.getNext());
		}else{
			this.head = element.getNext();
		}
		if(element.getNext()!= null){
			element.getNext().setPrev(element.getPrev());
		}	
	}
	
	@Override
	public Node<T,U> minimum() {
		LinkedListNode<T, U> node = this.head;
		LinkedListNode<T, U> resp = node;
		
		while(node != null){
			if(node.getKey().compareTo(resp.getKey()) < 0){
				resp = node;
			}
			node = node.getNext();
			
		}
		
		return resp;
	}
	
	@Override
	public LinkedListNode<T, U> maximum() {
		LinkedListNode<T, U> node = this.head;
		LinkedListNode<T, U> resp = node;
		
		while(node != null){
			
			if(node.getKey().compareTo(resp.getKey()) > 0){
				resp = node;
			}
			
			node = node.getNext();
		}
		
		return resp;
	}
	
	@Override
	public Node<T, U> successor(Node<T,U> nodeElement) {
		LinkedListNode<T, U> node = (LinkedListNode<T, U>)nodeElement;
		return node.getNext();
	}

	@Override
	public Node<T, U> predecessor(Node<T, U> nodeElement) {
		LinkedListNode<T, U> node = (LinkedListNode<T, U>)nodeElement;
		return node.getPrev();
	}
	
	@SuppressWarnings({ "unchecked" })
	public T[] getKeys() {
		T[] resp = (T[]) new Comparable[this.length];
		LinkedListNode<T, U> node = this.head;
		
		for(int i = 0 ; i < this.length && node != null; i++){
			resp[i] = node.getKey();
			node = node.getNext();
		}
		
		return resp;
	}
	
	@Override
	public String toString() {
		String prefix = "DoublyUnsortedLinkedList [";
		String content = "";
		String suffix = "]";
		LinkedListNode<T, U> node = this.head;
		
		while(node != null){
			content += node.getKey();
			node = node.getNext();
			if(node!= null){
				content += ", "; 
			}
		}
		
		return prefix + content + suffix;
	}


	@Override
	public void reverse() {
		LinkedListNode<T, U> prev = null;
		LinkedListNode<T, U> node = this.head;
		LinkedListNode<T, U> next = null;
		
	    while (node != null) {
	        next = node.getNext();
	        
	        node.setNext(prev);
	        node.setPrev(next);
	        
	        prev = node;
	        node = next;
	    }
	    
		this.head = prev;
	}

	@Override
	public void union(DynamicSet<T, U> ds) {
		DoublyUnsortedLinkedList<T, U> ls = (DoublyUnsortedLinkedList<T, U>) ds;
		LinkedListNode<T, U> node = this.head;
		while(node.getNext() != null){
			node = node.getNext();
		}
		node.setNext(ls.getHead());
		this.length = this.length + ls.getLength();
	}
}
