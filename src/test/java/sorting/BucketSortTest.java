package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BucketSortTest {
	@Test
	public void shouldSortCorrectlyAnUnsortedArray() {
		Double [] array  = new Double[]{0.89, 0.28, 0.34, 0.71, 0.21, 0.84, 0.64, 0.61, 0.46, 0.7, 0.27, 0.87, 0.57, 0.54, 0.18, 0.90, 0.53, 0.12, 0.6, 0.95, 0.99, 0.65, 0.37, 0.31, 0.67, 0.52,  0.01, 0.98, 0.79, 0.11, 0.68, 0.72, 0.86, 0.38};
		Double [] sorted = new Double[]{0.01, 0.11, 0.12, 0.18, 0.21, 0.27, 0.28, 0.31, 0.34, 0.37, 0.38, 0.46, 0.52, 0.53, 0.54, 0.57, 0.6,  0.61, 0.64, 0.65, 0.67, 0.68, 0.70, 0.71, 0.72, 0.79, 0.84, 0.86, 0.87, 0.89, 0.90, 0.95, 0.98, 0.99};		
		array = BucketSort.sort(array);

		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void shouldSortCorrectlyASortedArray() {
		Double [] array  = new Double[]{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9};
		Double [] sorted = new Double[]{0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9};
		array = BucketSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void shouldSortCorrectlyAnEmptyArray() {
		Double [] array  = new Double[]{};
		Double [] sorted = new Double[]{};
		array = BucketSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void shouldSortCorrectlyAReversedArray() {
		Double [] array   = new Double[]{0.99, 0.90, 0.89, 0.80, 0.79, 0.70, 0.69, 0.6 , 0.59, 0.50, 0.49, 0.40, 0.39, 0.30, 0.29, 0.20, 0.19, 0.10, 0.09, 0.01, 0.0};
		Double [] sorted  = new Double[]{0.0, 0.01, 0.09, 0.10, 0.19, 0.20, 0.29, 0.30, 0.39, 0.40, 0.49, 0.50, 0.59, 0.60, 0.69, 0.70, 0.79, 0.80, 0.89, 0.90, 0.99};
		array = BucketSort.sort(array);
		
		assertArrayEquals(sorted, array);
	}
}
