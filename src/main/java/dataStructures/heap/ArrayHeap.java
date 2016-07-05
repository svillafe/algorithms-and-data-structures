package dataStructures.heap;

import java.nio.BufferUnderflowException;

import dataStructures.Node;
import dataStructures.SimpleNode;
import utils.UtilsFunctions;

public class ArrayHeap<K extends Comparable<K>, D> implements Heap<K, D> {
	
	//CLRS page 151. 
	//This class exemplify a Max-Heap. i.e Array[Parent(i)] > Array[i].
	private Node<K, D>[] array;
	private Integer size = 0;
	
	public ArrayHeap() {
		super();	
	}
	
	@SuppressWarnings("unchecked")
	public ArrayHeap(K[] array){
		super();
		
		this.size = array.length;
		this.array = new Node[this.size];
		for(int i = 0 ; i < array.length ; i++){
			this.array[i] = new SimpleNode<K, D>(array[i], null);
		}
		
		for(int i = (int)Math.floor((this.size)/2) ; i >= 0 ; i--){
			maxHeapify(i);
		}
		
	}
	
	public ArrayHeap(Node<K, D>[] array){
		super();
		
		this.size = array.length;
		this.array = array.clone();
		
		for(int i = (int)Math.floor((this.size)/2) ; i >= 0 ; i--){
			maxHeapify(i);
		}
	}
	
	public Node<K, D>[] getArray(){
		return this.array.clone();
	}
	
	public Node<K, D> extractMaximum(){
		Node<K, D> max = null;
		
		if(this.size < 1){
			throw new BufferUnderflowException();
		}
		
		max = this.array[0];
		UtilsFunctions.swap(this.array, 0, this.size-1);
		this.size--;
		maxHeapify(0);
		
		return max;
	}
	
	public Node<K, D> maximum(){
		return this.array[0];
	}
	
	public Integer parentIndex(Integer i){
		return i/2;
	}
	
	public Integer leftIndex(Integer i){
		return 2*i + 1;
	}
	
	public Integer rightIndex(Integer i){
		return 2*i + 2;
	}
	
	private void maxHeapify(Integer i){
		
		Integer leftIndex  = leftIndex(i);
		Integer rightIndex = rightIndex(i);
		Integer largest = 0;
		
		if(leftIndex < this.size && (this.array[leftIndex].getKey().compareTo(this.array[i].getKey()) > 0)){
			largest = leftIndex;
		}else{
			largest = i;
		}
		
		if(rightIndex < this.size && (this.array[rightIndex].getKey().compareTo(this.array[largest].getKey()) >0)){
			largest = rightIndex;
		}
		
		if(largest != i){
			UtilsFunctions.swap(this.array, i , largest);
			maxHeapify(largest);
		}
	}
}
