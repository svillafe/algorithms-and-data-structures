package dataStructures.heap;

import dataStructures.Node;

/*
 * Data Structure: Heap
 * It can be view as a nearly complete binary tree. This is a MaxHeap,
 * therefore every parent is greater than its children.
 * 
 * Source CLRS page 151
 */
public interface Heap<K extends Comparable<K>, D> {
			
	public Node<K, D> extractMaximum();
	
	public Node<K, D> maximum();
		
	public Integer parentIndex(Integer index);
		
	public Integer leftIndex(Integer index);
		
	public Integer rightIndex(Integer index);
	
}
