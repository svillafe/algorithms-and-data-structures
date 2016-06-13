package dataStructures.linkedList;

import dataStructures.Node;

/* 
 * Data Structure: DoublySortedLinkedList.
 * Implements: LinkedList
 * Description: It is a linked list where each node has a link to the next
 * and to the previous node. It makes use of DoublyNode in order to achieve
 * this behavior. Moreover in the insertion method, it insert the node in the
 * correct order.
 * 
 * Source: CLRS page 237
 */
public class DoublySortedLinkedList<T extends Comparable<T>, U> implements LinkedList<T, U> {
	
	private LinkedListNode<T,U> head;
	private Integer length;
	
	public DoublySortedLinkedList(){
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
	public LinkedListNode<T,U> search(T key) {
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
		
		LinkedListNode<T, U> node = this.head;
		
		if(node == null || element.getKey().compareTo(node.getKey()) < 0){
			
			element.setNext(node);
			element.setPrev(null);
			
			if(node!=null){
				node.setPrev(element);
			}
			
			this.head = element;
			return;
		}
		
		while(node.getNext() != null && node.getNext().getKey().compareTo(element.getKey()) < 0){
			node = node.getNext();
		}
		
		element.setNext(node.getNext());
		if(node.getNext() != null){
			node.getNext().setPrev(element);
		}
		
		node.setNext(element);
		element.setPrev(node);
		
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
		return this.head;
	}
	
	@Override
	public Node<T,U> maximum() {
		
		LinkedListNode<T,U> node = this.head;
		LinkedListNode<T,U> prev = null;
		
		while(node != null){
			prev = node;
			node = node.getNext();
		}
		
		return prev;
	}
	
	@Override
	public Node<T,U> successor(Node<T,U> element) {
		LinkedListNode<T,U> node = (LinkedListNode<T, U>) element;
		return node.getNext();
	}


	public Node<T,U> predecessor(Node<T,U> element) {
		LinkedListNode<T,U> node = (LinkedListNode<T, U>) element;
		return node.getPrev();
	}
	
	@SuppressWarnings({ "unchecked" })
	public Object[] getKeys() {		
		T[] resp = (T[]) new Comparable[this.length];
		
		LinkedListNode<T,U> node = this.head;
		
		for(int i = 0 ; i < this.length && node != null; i++){
			
			resp[i] = node.getKey();
			
			node = node.getNext();
		}
		return resp;
	}
	
	@Override
	public String toString() {
		String prefix = "DoublySortedLinkedList [";
		String content = "";
		String suffix = "]";
		LinkedListNode<T,U> node = this.head;
		
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
		throw new UnsupportedOperationException();
	}

	@Override
	public void union(DynamicSet<T,U> dinamycSet2) {
		DoublySortedLinkedList<T,U> linkedList2 = (DoublySortedLinkedList<T,U>) dinamycSet2;
		LinkedListNode<T,U> node1   = this.head;
		LinkedListNode<T,U> node2 = linkedList2.getHead();
		while(node1.getNext() != null){
			node1 = node1.getNext();
		}
		
		while(node2!=null){
			LinkedListNode<T,U> aux = new DoublyNode<T,U>(node2.getKey(), node2.getData());
			insert(aux);
			node2 = node2.getNext();
		}
	}
}
