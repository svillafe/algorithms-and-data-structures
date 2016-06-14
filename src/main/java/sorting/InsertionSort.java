package sorting;

import java.util.Arrays;

import dataStructures.linkedList.DoublyUnsortedLinkedList;
import dataStructures.linkedList.LinkedListNode;

/*
 * Problem: Sort the input array
 * Algorithm: InsertionSort
 * Type: Comparison Sort
 * Best case running time:  O(n) [When the input array is already sorted]
 * Average Case Running Time: O(n log n)
 * Worst case running time: О(n^2) [When the input array is reversed]
 * Extra Space Complexity: O(1)
 * Stable: Yes
 * In-Place: Yes
 * Extra notes: It is a simple sorting algorithm that works well with small or mostly sorted data.
 * Source: CLRS page 18 
 */

public class InsertionSort {
	
	public static void main(String [] args){
		Integer array[] = new Integer[]{89, 74, 105, 43, 47, 52, 135, 125, 96, 41, 2, 150, 97, 92, 18, 3};
		sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static<T extends Comparable<T>> void sort(T[] array){
		
		for(int i = 1 ; i < array.length ; i++){
			T key = array[i];
			
			// Insert A[i] into the sorted sequence A[0..i-1] 
			int j = i - 1;
			
			while(j >= 0 && array[j].compareTo(key) > 0 ){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
		return;
	}

	public static<K extends Comparable<K>, D> void sort(DoublyUnsortedLinkedList<K, D> linkedList) {
		
		if(linkedList.isEmpty()){
			return;
		}
		
		LinkedListNode<K, D> node = linkedList.getHead();
		
		while(node != null){
			
			K key = node.getKey();
			
			LinkedListNode<K, D> nodeSort = node;
			
			while(nodeSort.getPrev() != null && nodeSort.getPrev().getKey().compareTo(key) > 0){
				nodeSort.setKey(nodeSort.getPrev().getKey());
				nodeSort = nodeSort.getPrev();
			}
			
			nodeSort.setKey(key);
			node = node.getNext();
		}
		
		return;
	}
	
}
