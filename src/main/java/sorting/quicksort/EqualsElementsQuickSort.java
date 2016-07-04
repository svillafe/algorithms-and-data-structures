package sorting.quicksort;

import utils.UtilsFunctions;

public class EqualsElementsQuickSort {
	
	public static void sort(Integer[] array, Integer start,Integer end){
		
		if(start < end){
			int[] pivotsPositions = partition(array, start, end);
			sort(array, start, pivotsPositions[0]-1);
			sort(array, pivotsPositions[1]+1, end);			
		}
		return;
	}
	
	private static int [] partition(Integer [] array, Integer start, Integer end){
		
		int[] resp = new int[]{0,0};
		int pivot = array[end];
		int i = start - 1;
		
		for( int j = start ; j < end ; j++){
			
			if(array[j] < pivot){
				i++;
				UtilsFunctions.swap(array, i, j);
			}
		}
		UtilsFunctions.swap(array, i+1, end);		
		
		int pivotStart = i+1;
		int pivotEnd   = i+1;
		
		for(pivotEnd = pivotStart ; pivotEnd < end && array[pivotEnd] == pivot  ; pivotEnd++);
		
		pivotEnd--;
		
		for(i = pivotEnd+1 ; i <= end ; i++){
			if(array[i] == pivot){
				pivotEnd++;
				UtilsFunctions.swap(array, i , pivotEnd);
			}
		}
		
		resp[0] = pivotStart; 
		resp[1] = pivotEnd;

		return resp;
	}
}
