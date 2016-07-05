package dataStructures.heap;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrayHeapTest {

	private ArrayHeap<Integer, String> s = null;
			
	@Before
	public void setUp() {
		s = new ArrayHeap<Integer, String>(new Integer[]{61, 23, 3, 24, 5, 46, 57, 68, 9, 10});
	}

	@Test
	public void heapShouldReturnCorrectValues() {
		
		assertEquals(new Integer(68), s.maximum().getKey());
		assertEquals(new Integer(68), s.extractMaximum().getKey());
		assertEquals(new Integer(61), s.maximum().getKey());
	}
	
	@Test
	public void heapShouldComputeCorrectsIndices() {
		assertEquals(new Integer(1), s.parentIndex(2));
		assertEquals(new Integer(8), s.rightIndex(3));
		assertEquals(new Integer(5), s.leftIndex(2));
	}
}
