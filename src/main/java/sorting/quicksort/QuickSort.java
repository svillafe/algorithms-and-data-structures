package sorting.quicksort;

import utils.UtilsFunctions;

/*
 * Problem: Sort the input array
 * Algorithm: QuickSort
 * Type: Comparison Sort
 * Best case running time:  O(n log n)
 * Average Case Running Time: O(n log n)
 * Worst case running time: О(n^2)
 * Extra Space Complexity: O(1)
 * Stable: Yes
 * In-Place: Yes
 * Extra notes: The worst case occurs when the partitioning routine produces one 
 * subproblem with n - 1 elements an one with 0 elements. 
 * 
 * Source: CLRS page 170 
 */

public class QuickSort {
	
	public static void sort(Integer[] array, Integer start,Integer end){
		if(start < end){
			int pivotPosition = partition(array, start, end);
			sort(array, start, pivotPosition-1);
			sort(array, pivotPosition+1, end);
			
		}
		return;
	}
		
	private static int partition(Integer[] array, Integer start, Integer end){
		int pivot = array[end];
		int i = start-1;
		int pivotPosition = 0;
		for(int j = start ; j < end ; j++){
			if(array[j]<= pivot){
				i++;
				UtilsFunctions.swap(array, i, j);
			}
		}
		pivotPosition = i+1;
		UtilsFunctions.swap(array, pivotPosition, end);
		return i+1;
	}
}
