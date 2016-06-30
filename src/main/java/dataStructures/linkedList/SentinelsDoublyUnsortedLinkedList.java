package dataStructures.linkedList;

import dataStructures.Node;

public class SentinelsDoublyUnsortedLinkedList<T extends Comparable<T>, U> implements LinkedList<T, U> {
	
	private DoublyNode<T, U> sentinel;
	private Integer length;
		
	public SentinelsDoublyUnsortedLinkedList(){
		super();
		
		this.sentinel = new DoublyNode<T, U>(null, null);
		this.sentinel.setNext(this.sentinel);
		this.sentinel.setPrev(this.sentinel);
		
		this.length = 0;
	}
	
	public LinkedListNode<T, U> getSentinel() {
		return sentinel;
	}
	
	@Override
	public LinkedListNode<T, U> getHead() {
		return this.sentinel.getNext();
	}
	
	@Override
	public Integer getLength() {
		return length;
	}
			
	public Boolean isEmpty(){
		return this.length == 0;
	}
		
	@Override
	public LinkedListNode<T, U> search(T key) {
		LinkedListNode<T, U> response = this.sentinel.getNext();
		
		while(response.getKey() != null && response.getKey() != key){
			response = response.getNext();
		}
		
		return response;
	}
		
	@Override
	public void insert(Node<T, U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>)nodeElement;
		this.length++;
		element.setNext(this.sentinel.getNext());
		this.sentinel.getNext().setPrev(element);
		this.sentinel.setNext(element);
	}
	
	@Override
	public void delete(Node<T, U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>)nodeElement;
		element.getPrev().setNext(element.getNext());
		element.getNext().setPrev(element.getPrev());
	}
	
	@Override
	public Node<T, U> minimum() {
		LinkedListNode<T, U> node = this.sentinel.getNext();
		LinkedListNode<T, U> minimum = node;
		
		while(node.getKey() != null){
			if(node.getKey().compareTo(minimum.getKey()) < 0 ){
				minimum = node;
			}
			node = node.getNext();
		}
		
		return minimum;
	}
	
	@Override
	public Node<T, U> maximum() {
		LinkedListNode<T, U> node = this.sentinel.getNext();
		LinkedListNode<T, U> maximum = node;
		
		while(node.getKey() != null){
			if(node.getKey().compareTo(maximum.getKey()) > 0 ){
				maximum = node;
			}
			node = node.getNext();
		}
		
		return maximum;
	}
	
	@Override
	public Node<T, U> successor(Node<T, U> aNode) {
		return ((LinkedListNode<T, U>) aNode).getNext();
	}

	@Override
	public Node<T, U> predecessor(Node<T, U> aNode) {
		return ((LinkedListNode<T, U>)aNode).getPrev();
	}
	
	@SuppressWarnings({ "unchecked" })
	public T[] toArray() {
		T[] resp = (T[]) new Comparable[this.length];
		LinkedListNode<T, U> node = this.sentinel;
		
		for(int i = 0 ; i < this.length ; i++, node = node.getNext()){
			resp[i] = node.getKey();
		}
		return resp;
	}
	
	@Override
	public String toString() {
		String prefix = "SentinelsDoublyLinkedList [";
		String content = "";
		String suffix = "]";
		LinkedListNode<T, U> node = this.sentinel.getNext();
		
		while(node.getKey() != null){
			content += node.getKey();
			node = node.getNext();
			if(node.getKey()!= null){
				content += ", "; 
			}
		}
		
		return prefix + content + suffix;
	}
	
	@Override
	public void reverse() {
		LinkedListNode<T, U> prev = null;
		LinkedListNode<T, U> node = this.sentinel.getNext();
		LinkedListNode<T, U> next = null;
		
		this.sentinel.setPrev(node);
		
	    while (node.getKey() != null) {
	        next = node.getNext();
	        
	        node.setNext(prev);
	        node.setPrev(next);
	        
	        prev = node;
	        node = next;
	    }

		this.sentinel.setNext(prev);
	}
	
	@SuppressWarnings({ "unchecked" })
	public T[] getKeys() {
		T[] resp = (T[]) new Comparable[this.length];
		LinkedListNode<T, U> node = this.sentinel.getNext();
		
		for(int i = 0 ; i < this.length && node.getData() != null; i++){
			resp[i] = node.getKey();
			node = node.getNext();
		}
		
		return resp;
	}

	@Override
	public void union(DynamicSet<T, U> ds) {
		SentinelsDoublyUnsortedLinkedList<T, U> ls = (SentinelsDoublyUnsortedLinkedList<T, U>) ds;
		LinkedListNode<T, U> node = this.sentinel.getNext();
		while(node.getNext().getKey() != null){
			node = node.getNext();
		}
		node.setNext(ls.getHead());
		this.length = this.length + ls.getLength();
	}
}

