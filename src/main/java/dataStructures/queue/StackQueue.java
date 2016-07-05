package dataStructures.queue;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import dataStructures.Node;
import dataStructures.stack.ArrayStack;
import dataStructures.stack.Stack;

/*
 * Problem: Build a Queue using two stacks
 * It implements a first-in, first-out (FIFO) policy
 * Source: CLRS page 236 
 */
public class StackQueue<T extends Comparable<T>, U> implements Queue<T, U> {
	
	private ArrayStack<T, U> s1;
	private ArrayStack<T, U> s2;	
	private Integer size;
	
	public StackQueue(int size){
		super();
		this.size = size;
		this.s1 = new ArrayStack<T, U>(size);
		this.s2 = new ArrayStack<T, U>(size);
	}
	
	@Override
	public void enqueue(Node<T, U> x){
		if(this.isFull()){
			throw new BufferOverflowException();
		}
		this.s1.push(x);
	}
	
	@Override
	public Node<T, U> dequeue(){
		if(this.isEmpty()){
			throw new BufferUnderflowException();
		}
		
		if(this.s2.isEmpty()){
			passElements(this.s1, this.s2);
		}
		
		return this.s2.pop();
	}

	@Override
	public Boolean isEmpty() {
		return this.s1.isEmpty() && this.s2.isEmpty();
	}

	@Override
	public Boolean isFull() {
		return (this.s1.amountOfElements() + this.s2.amountOfElements()) == this.size; 
	}
	
	public String toString(){
		return this.s1.toString() + this.s2.toString();
	}
	
	private void passElements(Stack<T, U> src, Stack<T, U> dest) {
		while(!src.isEmpty()){
			dest.push(src.pop());
		}
	}
}
