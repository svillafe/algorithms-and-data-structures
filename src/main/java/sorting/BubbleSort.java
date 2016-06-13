package sorting;

import utils.UtilsFunctions;

/*
 * Problem: Sort the input array
 * Algorithm: Bubble Sort
 * Type: Comparison Sort
 * Best case running time:  O(n) [When the input array is already sorted]
 * Average Case Running Time: O(n^2)
 * Worst case running time: О(n^2) [When the input array is reversed]
 * Extra Space Complexity: O(1)
 * Stable: Yes
 * In-Place: Yes
 * Source: CLRS page 40 
 */

public class BubbleSort {
	
	public static<T extends Comparable<T>> void sort(T[] array){
			
		for(int i = 0 ; i < array.length -1 ; i++){
			for(int j = array.length -1 ; j > i; j-- ){
				if(array[j].compareTo(array[j-1]) < 0){
					UtilsFunctions.swap(array, j-1 , j);
				}
			}
		}			
		return;
	}
}
