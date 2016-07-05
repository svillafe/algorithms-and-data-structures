package dataStructures.deque;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

/*
 * Data Structure: Deque (Double ended queue)
 * Implementation of a Deque using an array as the underlying data structure
 * Source: CLRS page 236 
 */
public class ArrayDeque<T> implements Deque<T> {
	
	private Integer tail =  0;
	private Integer head = -1;
	private T [] array;
	
	@SuppressWarnings("unchecked")
	public ArrayDeque(Integer size){
		super();
		this.array = (T[])new Object[size];
	}
	
	public Boolean isEmpty(){
		return this.head == -1;
	}
	
	public Boolean isFull(){
		return this.tail == this.head;
	}
	
	public void pushBack(T x){
		if(this.isFull()){
			throw new BufferOverflowException();
		}
		
		if(this.head == -1){
			this.head = this.tail;
		}
		
		this.array[this.tail] = x;
		this.tail = (this.tail + 1) % this.array.length;
		return;
	}
	
	public void pushFront(T x){
		if(this.isFull()){
			throw new BufferOverflowException();
		}
		
		if(this.head == -1){
			this.head = this.tail;
		}
		
		this.head = (this.head - 1 + this.array.length) % this.array.length;
		
		this.array[this.head] = x;
		
		return;
	}
			
	public T popFront(){
		
		if(this.isEmpty()){
			throw new BufferUnderflowException();
		}
		
		T x = this.array[this.head];
		
		this.head = (this.head + 1) % this.array.length;
		
		if(this.head == this.tail){
			this.head = -1;
		}
		
		return x;
	}
	
	public T popBack(){
		
		if(this.isEmpty()){
			throw new BufferUnderflowException();
		}
		
		this.tail = (this.tail + this.array.length - 1) % this.array.length;
		
		T x = this.array[this.tail];
				
		if(this.head == this.tail){
			this.head = -1;
		}
		
		return x;
	}
	
	public String toString(){
		return "( " + Arrays.toString(this.array) + " Head: " + this.head + " Tail: " + this.tail + " )";
	}		
}
