package dataStructures.deque;

/*
 * Data Structure: Deque (Double ended queue)
 * Deque allows insertion and deletion at both ends.
 * Source: CLRS page 236 
 */
public interface Deque<T> {
	
	//Check if the Deque is empty
	public Boolean isEmpty();
	
	//Check if the Deque is full
	public Boolean isFull();
	
	//Push a new element at the end of the deque
	public void pushBack(T x);
	
	//Push a new element at the front of the deque
	public void pushFront(T x);
	
	//Pop the first element of the deque
	public T popFront();
	
	//Pop the last element of the deque
	public T popBack();
	
}	
