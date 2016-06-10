package dataStructures.stack;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.Arrays;

import dataStructures.Node;

/*
 * Data Structure: Stack implemented using an array as an underlying structure
 * It implements a last-in, first-out (LIFO) policy
 * Source: CLRS page 232 
 */
public class ArrayStack<T extends Comparable<T>, U> implements Stack<T, U> {
	
	private Node<T, U>[] array; 
	private Integer top = -1;
	
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Integer size){
		super();
		this.array = new Node[size];
	}
	
	public Boolean isEmpty(){
		return this.top == -1;
	}
	
	public Boolean isFull(){
		return this.top == this.array.length - 1;
	}
	
	public Integer amountOfElements(){
		return this.top+1;
	}
	
	public void push(Node<T, U> x){
		
		if(this.top == this.array.length - 1){
			throw new BufferOverflowException();
		}
		
		this.top++;
		this.array[this.top] = x;
		return;
	}
	
	public Node<T, U> pop(){
		
		if(this.isEmpty()){
			throw new BufferUnderflowException();
		}
		
		this.top--;
		return this.array[this.top + 1];
	}
	
	public String toString(){
		return Arrays.toString(this.array);
	}
}
