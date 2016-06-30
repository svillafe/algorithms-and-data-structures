package dataStructures.linkedList;

import dataStructures.Node;

/* 
 * Data Structure: SinglySortedLinkedList.
 * Implements: LinkedList
 * Description: It is a linked list where each node has a link to the next node. 
 * It makes use of SinglyNode in order to achieve this behavior. In addition, in the 
 * insertion method, it insert the node in the correct order.
 * 
 * Source: CLRS page 237
 */
public class SinglySortedLinkedList<T extends Comparable<T>, U> implements LinkedList<T, U> {

	private LinkedListNode<T, U> head;
	private LinkedListNode<T, U> tail;
	private Integer length;
	
	public SinglySortedLinkedList(){
		super();
	
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	@Override
	public LinkedListNode<T, U> getHead() {
		return this.head;
	}
	
	public LinkedListNode<T, U> getTail() {
		return this.tail;
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
	public LinkedListNode<T, U> search(T key) {
		LinkedListNode<T, U> response = this.head;
		
		while(response != null && response.getKey() != key){
			response = response.getNext();
		}
		
		return response;
	}
	
	@Override
	public void insert(Node<T, U> nodeElement) {
		LinkedListNode<T, U> element = (LinkedListNode<T, U>)nodeElement;
		
		this.length++;
		LinkedListNode<T, U> node = this.head;
		LinkedListNode<T, U> previous = null;
		if(this.head == null){
			this.head = element;
			element.setNext(null);
			return;
		}
		
		while(node.getNext() != null && element.getKey().compareTo(node.getKey()) > 0){
			previous = node;
			node = node.getNext();
		}
		
		if(node.getNext() == null && node.getKey().compareTo(element.getKey()) < 0){
			node.setNext(element);
			this.tail = element;
		}else{
			element.setNext(node);
			previous.setNext(element);
		}
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
		return this.head;
	}
	
	@Override
	public Node<T, U> maximum() {
		return  this.tail;
	}
	
	@Override
	public Node<T, U> successor(Node<T, U> element) {
		return ((LinkedListNode<T, U>) element).getNext();
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
		String prefix = "SinglySortedLinkedList [";
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
		throw new UnsupportedOperationException();
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
	public void union(DynamicSet<T,U> dinamycSet2) {
		SinglySortedLinkedList<T,U> linkedList2 = (SinglySortedLinkedList<T,U>) dinamycSet2;
		LinkedListNode<T,U> node1   = this.head;
		LinkedListNode<T,U> node2 = linkedList2.getHead();
		while(node1.getNext() != null){
			node1 = node1.getNext();
		}
		
		while(node2!=null){
			LinkedListNode<T,U> aux = new SinglyNode<T,U>(node2.getKey(), node2.getData());
			insert(aux);
			node2 = node2.getNext();
		}
	}
	
	
}
