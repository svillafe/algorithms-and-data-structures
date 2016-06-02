package sorting;

import utils.UtilsFunctions;

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
