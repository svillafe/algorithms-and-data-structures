package dynamicProgramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NearestKnapsackTest {
	@Test
	public void itShouldComputeCorrectly() {
		assertEquals(new Integer(5), NearestKnapsack.compute(new Integer[]{5}, 6));
		assertEquals(new Integer(6), NearestKnapsack.compute(new Integer[]{3, 3, 3, 3, 3, 3}, 8));
		assertEquals(new Integer(9), NearestKnapsack.compute(new Integer[]{9, 4, 4, 9, 4, 9, 9, 9, 9}, 10));
		assertEquals(new Integer(9), NearestKnapsack.compute(new Integer[]{3, 2, 4}, 9));
		assertEquals(new Integer(12), NearestKnapsack.compute(new Integer[]{3, 10, 4}, 12));
		assertEquals(new Integer(13), NearestKnapsack.compute(new Integer[]{3, 10, 4}, 13));
	}
}
