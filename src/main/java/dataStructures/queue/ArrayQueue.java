package dataStructures.queue;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

import dataStructures.Node;

/*
 * Data Structure: Queue
 * It implements a first-in, first-out (FIFO) policy
 * Source: CLRS page 235 
 */
public class ArrayQueue<T extends Comparable<T>, U> implements Queue<T, U> {
	
	private Integer tail =  0;
	private Integer head = -1;
	
	private Node<T, U>[] array;
	
	public Boolean isEmpty(){
		return this.head == -1;
	}
	
	public Boolean isFull(){
		return this.tail == this.head;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(Integer size){
		super();
		this.array = new Node[size];
	}
	
	public void enqueue(Node<T, U> x){
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
		
	public Node<T, U> dequeue(){
		
		if(this.isEmpty()){
			throw new BufferUnderflowException();
		}
		
		Node<T, U> x = this.array[this.head];
		
		this.head = (this.head + 1) % this.array.length;
		
		if(this.head == this.tail){
			this.head = -1;
		}
		
		return x;
	}
	
	public String toString(){
		return Arrays.toString(this.array) + " Head: " + this.head + " Tail: " + this.tail;
	}	
}
