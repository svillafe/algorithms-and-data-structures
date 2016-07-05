package dataStructures.heap;

import java.util.Arrays;

import dataStructures.Node;
import dataStructures.linkedList.DoublyNode;
import dataStructures.linkedList.DoublySortedLinkedList;

public class DoublySortedLinkedListMergeableHeap<U> implements MergeableHeap<U> {
	
	private DoublySortedLinkedList<Integer, U> list = null;
		
	public DoublySortedLinkedListMergeableHeap() {
		this.list = new DoublySortedLinkedList<Integer,U>();
	}
	
	@Override
	public void insert(Node<Integer, U> element) {
		DoublyNode<Integer, U> newElement = new DoublyNode<Integer, U>(element.getKey(), element.getData());
		this.list.insert(newElement);
	}
	
	public Integer amountOfElements(){
		return this.list.getLength();
	}
	
	@Override
	public Node<Integer, U> minimum() {
		Node<Integer, U> resp = this.list.getHead();
		return resp == null ? null : resp;
	}
	
	@Override
	public Node<Integer, U> extractMin() {
		Node<Integer, U> resp = this.list.getHead();
		this.list.delete(this.list.getHead());
		return resp;
	}
	
	@Override
	public void union(MergeableHeap<U> mheap) {
		DoublySortedLinkedList<Integer, U> list2 = generateList(mheap);
		this.list.union(list2);
	}

	private DoublySortedLinkedList<Integer, U> generateList(MergeableHeap<U> mheap) {
		
		DoublySortedLinkedList<Integer, U> resp = new DoublySortedLinkedList<Integer, U>();
		while(mheap.minimum() != null){
			resp.insert(mheap.extractMin());
		}
		
		return resp;
	}
	
	public String toString(){
		Object [] keys = this.list.getKeys();
		Integer [] array = Arrays.copyOf(keys, keys.length, Integer[].class);
		
		String prefix = "DoublySortedLinkedListMergeableHeap ";
		String content = Arrays.toString(array);
		
		return prefix + content;
	}
}