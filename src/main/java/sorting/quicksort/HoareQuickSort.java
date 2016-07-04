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
 * Extra notes: The original partition method which is due to C.A.R. Hoare. 
 * 
 * Source: CLRS page 185 
 */
public class HoareQuickSort {
	
	public static void sort(Integer[] array, Integer start, Integer end){
		if(start < end){
			int pivotPosition = hoarePartition(array, start, end);
			sort(array, start, pivotPosition-1);
			sort(array, pivotPosition+1, end);
			
		}
		return;
	}
	
	//CLRS page 185.
	private static int hoarePartition(Integer[] array, Integer start, Integer end){
		int pivot = array[start];
		int i = start - 1;
		int j = end   + 1;
			
		while(true){
			do{
				j = j - 1;
			}while(array[j] > pivot );
				
			do{
				i = i + 1;
			}while(array[i] < pivot);
			
			
			if(i < j){
				UtilsFunctions.swap(array, i , j);
				i--;
				j++;
			}else{
				return j;
			}
		}
	}
}
