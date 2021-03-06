package dataStructures.linkedList;

/*
 * Data Structure: Doubly Node 
 * Description: It is a Node's implementation for the Doubly Linked List. 
 * Each Node has a key, a piece of Data, a pointer to its previous Node and a 
 * pointer to its next node.
 */

public class DoublyNode<T extends Comparable<T>, U> implements LinkedListNode<T,U> {
	
	private T key;
	private U data;
	private LinkedListNode<T,U> next;
	private LinkedListNode<T,U> prev;
		
	public DoublyNode(T key, U data){
		super();
		
		this.key = key;
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	@Override
	public T getKey(){
		return this.key; 
	}
	
	@Override
	public void setKey(T key){
		this.key = key; 
	}
	
	@Override
	public U getData(){
		return this.data; 
	}
	
	@Override
	public void setData(U data){
		this.data = data; 
	}
	
	@Override
	public LinkedListNode<T,U> getNext() {
		return next;
	}
	
	@Override
	public void setNext(LinkedListNode<T,U> next) {
		this.next = next;
	}
	
	public LinkedListNode<T,U> getPrev() {
		return prev;
	}
	
	public void setPrev(LinkedListNode<T,U> prev) {
		this.prev = prev;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		DoublyNode other = (DoublyNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}
