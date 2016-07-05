package sorting;

import dataStructures.linkedList.DoublyNode;
import dataStructures.linkedList.DoublyUnsortedLinkedList;
import utils.UtilsFunctions;

/*
 * Problem: Sort the input array
 * Algorithm: Bucket Sort
 * Type: Comparison Sort
 * Best case running time:  O(n + k) 
 * Average Case Running Time: O(n + k)
 * Worst case running time: О(n^2) 
 * Extra Space Complexity: O(n)
 * Stable: Yes
 * In-Place: No
 * Extra notes: It assumes that the input is generated by a random process that 
 * distributes elements uniformly and independently over the interval [0,1).
 * 
 * Source: CLRS page 200 
 */

public class BucketSort {
	
	private static final int AMOUNT_INTERVALS = 10;
	
	public static Double [] sort(Double [] array){
		
		@SuppressWarnings("unchecked")
		DoublyUnsortedLinkedList<Double, Object> [] B = new DoublyUnsortedLinkedList[AMOUNT_INTERVALS];
		
		Double [] resp = new Double[0];
		
		for(int i = 0 ; i < AMOUNT_INTERVALS ; i++){
			B[i] = new DoublyUnsortedLinkedList<Double, Object>();
		}
		
		for(int i = 0 ; i < array.length ; i++){
			B[(int)Math.floor(AMOUNT_INTERVALS*array[i])].insert(new DoublyNode<Double, Object>(array[i], null));
		}
		
		for(int i = 0 ; i < AMOUNT_INTERVALS ; i++){
			InsertionSort.sort(B[i]);
		}
		
		for(int i = 0 ; i < AMOUNT_INTERVALS ; i++){
			resp = UtilsFunctions.<Double>concat(resp, UtilsFunctions.ComparableToDoubleArray(B[i].getKeys())); 
		}
		
		return resp;
	}
}
