package sorting;

import utils.UtilsFunctions;

/*
 * Problem: Sort the input array
 * Algorithm: Selection Sort
 * Best case running time:  O(n^2)
 * Average Case Running Time: O(n^2)
 * Worst case running time: О(n^2)
 * Extra Space Complexity: O(1)
 * Stable: Yes 
 * In-Place: Yes
 * Source: CLRS page 29
 * Extra notes: It is a terrible algorithm because always has a running time of O(n^2)  
 */

public class SelectionSort {
	
	public static<T extends Comparable<T>> void sort(T[] array){
		
		for(int i = 0 ; i < array.length -1 ; i++){
			int smallestIndex = i;
			
			for(int j = i+1 ; j < array.length ; j++){
				if(array[j].compareTo(array[smallestIndex]) < 0){
					smallestIndex = j;
				}
			}
			if(i != smallestIndex){
				UtilsFunctions.swap(array,i, smallestIndex);
			}
		}
		return;
	}
}
