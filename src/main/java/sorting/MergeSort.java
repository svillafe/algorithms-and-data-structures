package sorting;

import java.util.Arrays;

/*
 * Problem: Sort the input array
 * Algorithm: Merge Sort
 * Type: Comparison Sort
 * Best Case Running Time: O(n log n)
 * Average Case Running Time: O(n log n)
 * Worst Case Running Time: O(n log n)
 * Extra Space Complexity: O(n)
 * Stable: Yes 
 * In-Place: No
 * Source: CLRS page 31 and 34 
 */

public class MergeSort {
	
	public static void main(String [] args){
		Integer array[] = new Integer[]{89, 74, 105, 43, 47, 52, 135, 125, 96, 41, 2, 150, 97, 92, 18};
		sort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static<T extends Comparable<T>> void sort(T[] array, int start, int end){
		
		if(start < end){
			int middlePoint = (int)Math.floor((start+end)/2);
			
			MergeSort.sort(array, start, middlePoint);
			MergeSort.sort(array, middlePoint + 1, end);
			
			merge(array, start, middlePoint, end);
		}
		return;
	}
	
	//start, middle and end are positions. 
	//In a 15 positions array, end is equal to 14.
	@SuppressWarnings({"rawtypes", "unchecked"})
	private static<T extends Comparable<T>> void merge(T[] array, int start, int middle, int end) {
		
		//Plus one because the middle item remains in the left array.
		int leftSize  = middle - start + 1; 
		int rightSize = end - middle;
		
		Comparable[] leftArray = new Comparable[leftSize + 1];
		Comparable[] rightArray = new Comparable[rightSize + 1];
		
		for(int i = 0 ; i < leftSize ; i++){
			leftArray[i] = array[start + i];
		}
		leftArray[leftSize] = Integer.MAX_VALUE;
		
		for(int j = 0 ; j < rightSize ; j++){
			rightArray[j] = array[middle + j + 1];
		}
		rightArray[rightSize] = Integer.MAX_VALUE;
		
		int leftIndex = 0;
		int rightIndex = 0;
		for(int k  = start ; k <= end ; k++ ){
			
			if((leftIndex < leftSize) && (leftArray[leftIndex].compareTo((T) rightArray[rightIndex]) <= 0)){
				array[k] = (T) leftArray[leftIndex];
				leftIndex++;
			}else if((rightIndex < rightSize) && (rightArray[rightIndex].compareTo((T) leftArray[leftIndex]) < 0)){
				array[k] = (T) rightArray[rightIndex];
				rightIndex++;
			}
		}
		
	}
}
