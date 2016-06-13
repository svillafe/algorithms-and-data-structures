package sorting;

/*
 * Problem: Sort the input array
 * Algorithm: Radix Sort
 * Best case running time:  O(n)
 * Average Case Running Time: O(n)
 * Worst case running time: О(n)
 * Extra Space Complexity: O(k)
 * Stable: Yes (It depends on the algorithm we choose)
 * In-Place: No (It depends on the algorithm we choose)
 * Source: CLRS page 197
 * Extra notes: It assumes that the input are Integer, and it sorts them by sorting first
 * by the least significant digit first. 
 */

public class RadixSort {
	
	public static Integer[] sort(Integer[] array, Integer digits){
		for(int i = 1 ; i <= digits ; i++){
			CountingSort.sort(array, 9, i );
		}
		return array;
	}
}
