package sorting.quicksort;

import java.util.Arrays;
import java.util.Random;

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
 * Extra notes: One way to improve the RANDOMIZED-QUICKSORT procedure is to partition 
 * around a pivot that is chosen more carefully than by picking a random element from 
 * the subarray. One common approach is the median-of-3 method: choose the pivot as the 
 * median (middle element) of a set of 3 elements randomly selected from the subarray. 
 * 
 * Source: CLRS page 188 
 */
public class Median3QuickSort {
	
	public static void sort(Integer[] array, Integer start,Integer end){
		if(start < end){
			int pivotPosition = median3Partition(array, start, end);
			sort(array, start, pivotPosition-1);
			sort(array, pivotPosition+1, end);
			
		}
		return;
	}
	
	//CLRS page 176.
	private static int median3Partition(Integer[] array, Integer start, Integer end){
		int pivotIndex = selectMedian3Pivot(array, start, end);
		UtilsFunctions.swap(array, pivotIndex, end);
		return partition(array, start, end);
	}
	
	private static int selectMedian3Pivot(Integer [] array, Integer start, Integer end){
		Random randomGenerator = new Random();
		int selected = -1;
		int indexes [] = new int[]{-1,-1,-1};
		
		if(end - start <= 3){
			return randomGenerator.nextInt(end-start+1)+start;
		}
		
		for(int i = 0 ; i < 3 ; i++){
			int p = -1;
			do{
				p = randomGenerator.nextInt(end-start+1) + start;
			}while(Arrays.asList(indexes).contains(p));
			indexes[i] = p;
		}
		
		if((array[indexes[0]] > array[indexes[1]] && array[indexes[0]] < array[indexes[2]]) || 
		   (array[indexes[0]] < array[indexes[1]] && array[indexes[0]] > array[indexes[2]])){
			selected =indexes[0];
		}else if((array[indexes[1]] > array[indexes[0]] && array[indexes[1]] < array[indexes[2]]) || 
				 (array[indexes[1]] < array[indexes[0]] && array[indexes[1]] > array[indexes[2]])){
			selected =indexes[1];
		}else{
			selected = indexes[2];
		}
		return selected;
	}
		
	//CLRS page 171.
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
