package dataStructures.linkedList;

import dataStructures.Node;

public class SinglyUnsortedLinkedList<T extends Comparable<T>, U> implements LinkedList<T, U> {
	
	private LinkedListNode<T, U> head;
	private LinkedListNode<T, U> tail;
	private Integer length;
	
	 
	public SinglyUnsortedLinkedList(){
		super();
	
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public LinkedListNode<T, U> getHead() {
		return this.head;
	}
	
	public LinkedListNode<T, U> getTail() {
		return this.tail;
	}

	public Integer getLength() {
		return length;
	}
	
	public Boolean isEmpty(){
		return this.head == null;
	}
	
	@Override
	public LinkedListNode<T, U> search(T key) {
		LinkedListNode<T, U> response = this.head;
		
		while(response != null && response.getKey() != key){
			response = response.getNext();
		}
		
		return response;
	}
	
	@Override
	public void insert(Node<T, U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>) nodeElement;
		
		this.length++;
		if(this.isEmpty()){
			this.tail = element;
		}
		
		element.setNext(this.head);	
		this.head = element;
		
		return;
	}
	
	@Override
	public void delete(Node<T, U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>) nodeElement;
		this.length--;
		
		LinkedListNode<T, U> node = this.head;
		Boolean exit = false;

		if(this.head.getKey() == element.getKey()){
			this.head = element.getNext();
			//If the node to be deleted is the tail
			if(element.getNext() == null){
				this.tail = null;
			}
			
		}else{
			//You want to delete some node that is not the Head.
			while(node != null && !exit){
				if(node.getNext().getKey() == element.getKey()){
					node.setNext(element.getNext());
					exit = true;
				}
				node = node.getNext();
			}
			//If the node to be deleted is the tail
			if(element.getNext() == null){
				this.tail = node;
			}
		}
	}
	
	@Override
	public Node<T, U> minimum() {
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
	public Node<T, U> successor(Node<T, U> aNode) {
		return ((LinkedListNode<T, U>) aNode).getNext();
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
	public Node<T, U> predecessor(Node<T, U> aNode) {
		LinkedListNode<T, U> resp = this.head;
		
		while(resp.getNext().getKey() != aNode.getKey()){
			resp = resp.getNext();
		}
		
		return resp;
	}
	
	@SuppressWarnings({ "unchecked" })
	public T[] toArray() {
		T[] resp = (T[]) new Comparable[this.length];
		LinkedListNode<T, U> node = this.head;
		
		for(int i = 0 ; i < this.length ; i++, node = node.getNext()){
			resp[i] = node.getKey();
		}
		return resp;
	}
	
	@Override
	public String toString() {
		String prefix = "SinglyUnsortedLinkedList [";
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
	        
	        prev = node;
	        node = next;
	    }

		this.head = prev;
	}

	@Override
	public void union(DynamicSet<T, U> ds) {
		SinglyUnsortedLinkedList<T, U> ls = (SinglyUnsortedLinkedList<T, U>) ds;
		LinkedListNode<T, U> node = this.head;
		
		while(node.getNext() != null){
			node = node.getNext();
		}
		node.setNext(ls.getHead());
		this.length = this.length + ls.getLength();
	}
}
