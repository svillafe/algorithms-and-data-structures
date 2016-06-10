package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SelectionSortTest {
	@Test
	public void shouldSortCorrectlyAnUnsortedArray() {
		Integer [] array = new Integer[]{89, 28, 34, 71, 21, 84, 64, 61, 46, 7, 27, 87, 57, 54, 18, 90, 53, 12, 6, 95, 99, 100, 65, 37, 31, 67, 52,  1, 98, 79, 11, 68, 72, 86, 38};
		Integer [] sorted = new Integer[]{1, 6, 7, 11, 12, 18, 21, 27, 28, 31, 34, 37, 38, 46, 52, 53, 54, 57, 61, 64, 65, 67, 68, 71, 72, 79, 84, 86, 87, 89, 90, 95, 98, 99, 100};
		SelectionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void shouldSortCorrectlyASortedArray() {
		Integer [] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer [] sorted = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		SelectionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void shouldSortCorrectlyAnEmptyArray() {
		Integer [] array = new Integer[]{};
		Integer [] sorted = new Integer[]{};
		SelectionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void shouldSortCorrectlyAReversedArray() {
		Integer [] array = new Integer[]{20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		Integer [] sorted = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		SelectionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
}
