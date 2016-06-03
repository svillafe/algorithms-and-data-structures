package sorting;

import java.util.Arrays;

/*
 * Problem: Sort the input array
 * Algorithm: Counting Sort
 * Type: Counting Sort
 * Best case running time:  O(n) 
 * Average Case Running Time: O(n)
 * Worst case running time: О(n)
 * Extra Space Complexity: O(k)
 * Stable: Yes
 * In-Place: No
 * Extra notes: It assumes that each of the n input is an integer in the range 0 to k.
 * Source: CLRS page 194 
 */

public class CountingSort {
	
	public static Integer[] sort(Integer[] array, int maximum){
		Integer [] sentinel = new Integer[maximum+1];
		Integer [] response = new Integer[array.length];
		
		Arrays.fill(sentinel, 0);
		
		for(int j = 0 ; j < array.length ; j++ ){
			sentinel[array[j]]++;
		}
		
		for(int i = 1 ; i <= maximum ; i++){
			sentinel[i] = sentinel[i] + sentinel[i-1];  
		}
		
		for(int j = array.length-1 ; j >= 0 ; j--){
			response[sentinel[array[j]]-1] = array[j];
			sentinel[array[j]] = sentinel[array[j]]-1;
		}
			
		return response;
		
	}

	public static void sort(Integer[] array, int maximum, int numberOfDigit) {
		int [] sentinel = new int[maximum+1];
		
		Integer [] response = new Integer[array.length];
		
		Arrays.fill(sentinel, 0);
		
		for(int j = 0 ; j < array.length ; j++ ){
			int index = (int)((array[j]%(Math.pow(10, numberOfDigit)))/Math.pow(10, numberOfDigit-1));
			sentinel[index]++;
		}
		
		for(int i = 1 ; i <= maximum ; i++){
			sentinel[i] = sentinel[i] + sentinel[i-1];  
		}
		
		for(int j = array.length-1 ; j >=0  ; j--){
			int index = (int)((array[j]%(Math.pow(10, numberOfDigit)))/Math.pow(10, numberOfDigit-1));
			response[sentinel[index]-1] = array[j];
			sentinel[index] = sentinel[index]-1;
		}
		
		System.arraycopy( response, 0, array, 0, response.length );
		return;
	}
}
