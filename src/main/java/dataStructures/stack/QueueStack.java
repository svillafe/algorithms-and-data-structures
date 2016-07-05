package dataStructures.stack;

import java.nio.BufferUnderflowException;

import dataStructures.Node;
import dataStructures.queue.ArrayQueue;
import dataStructures.queue.Queue;

/*
 * Problem: Build a Stack using two queues
 * It implements a last-in, first-out (LIFO) policy
 * Source: CLRS page 236 
 */
public class QueueStack<T extends Comparable<T>, U> implements Stack<T, U> {
	
	@SuppressWarnings("unchecked")
	private Queue<T, U> [] queues = new Queue[2];
	
	private int active;
	
	public QueueStack(int size){
		super();
		
		this.queues[0] = new ArrayQueue<T, U>(size);
		this.queues[1] = new ArrayQueue<T, U>(size);
		this.active = 0;
	}
	
	@Override
	public Boolean isFull() {
		return this.queues[this.active].isFull();
	}
	
	@Override
	public Boolean isEmpty() {
		return this.queues[this.active].isEmpty();
	}

	@Override
	public Node<T, U> pop() {
		
		Node<T, U> resp = null;
		
		if(this.queues[this.active].isEmpty()){
			throw new BufferUnderflowException();
		}
		
		while(!this.queues[this.active].isEmpty()){
			resp = this.queues[this.active].dequeue();
			if(!this.queues[this.active].isEmpty()){
				this.queues[1-this.active].enqueue(resp);
			}
		}
		
		this.active = 1 - this.active;
		return resp;
	}

	@Override
	public void push(Node<T, U> element) {
		this.queues[this.active].enqueue(element);
	}
	
	public String toString(){
		return this.queues[0].toString() + " " + this.queues[1].toString();
	}
}
