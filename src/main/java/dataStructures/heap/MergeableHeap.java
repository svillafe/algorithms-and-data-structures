package dataStructures.heap;

import dataStructures.Node;

/*
 * Data Structure: MergeableHeap
 * It can be view as a Heap that supports Merge Operations. This is a MinHeap,
 * therefore every parent is smaller than its children.
 */
public interface MergeableHeap<U> {
	
	public void insert(Node<Integer, U> element);
	
	public Node<Integer, U> minimum();
	
	public Node<Integer, U> extractMin();
	
	public void union(MergeableHeap<U> mheap);
}
