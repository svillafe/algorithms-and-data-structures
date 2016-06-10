package utils;

import java.util.Arrays;

/*
 * Utility functions that are used along the different implementations.
 */

public class UtilsFunctions {
	
	public static void swap(int[] array, int i, int j){
		int  aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	public static<T> void swap(T[] array, int i, int j){
		T  aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	public static <T extends Comparable<T>> T[] concat(T[] first, T[] second) {
	  T[] result = Arrays.copyOf(first, first.length + second.length);
	  System.arraycopy(second, 0, result, first.length, second.length);
	  return result;
	}
	
	public static Double[] ComparableToDoubleArray(Comparable[] array){
		Double[] resp = new Double[array.length];
		for(int i = 0 ; i < array.length ; i++){
			resp[i] = (Double) array[i];
		}
		return resp;
	}
	
}
