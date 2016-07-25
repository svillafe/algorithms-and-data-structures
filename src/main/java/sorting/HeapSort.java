package sorting;

import dataStructures.Node;
import dataStructures.heap.ArrayHeap;
import dataStructures.heap.Heap;

/*
 * Problem: Sort the input array
 * Algorithm: HeapSort
 * Type: Comparison Sort
 * Best case running time: O(n log n) 
 * Average Case Running Time: O(n log n)
 * Worst case running time: O(n log n) 
 * Extra Space Complexity: O(1)
 * Stable: No
 * In-Place: Yes
 * 
 * Source: CLRS page 159
 */
public class HeapSort {
	
	@SuppressWarnings("unchecked")
	public static<K extends Comparable<K>, D> Node<K, D>[] sort(Node<K, D>[] array){
		
		Heap<K, D> auxHeap = new ArrayHeap<K,D>(array);
		Node<K, D>[] resp = new Node[array.length];
		
		for(int i = array.length-1 ; i >= 0 ; i--){
			Node<K,D> maximum = auxHeap.extractMaximum();
			resp[i] = maximum;
		}
		
		return resp;
	}
	
	public static Integer[] sort(Integer[] array){
		
		Heap<Integer, String> auxHeap = new ArrayHeap<Integer,String>(array);
		Integer[] resp = new Integer[array.length];
		
		for(int i = array.length-1 ; i >= 0 ; i--){
			Integer maximum = auxHeap.extractMaximum().getKey();
			resp[i] = maximum;
		}
		
		return resp;
	}
}
