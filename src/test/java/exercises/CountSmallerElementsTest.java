package exercises;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CountSmallerElementsTest {
	@Test
	public void itShouldComputeCorrectly(){
		assertArrayEquals(new Integer[]{6,1,1,1,0,1,0}, CountSmallerElements.countSmallerElements(new Integer[]{12,1,2,3,0,11,4}));		
	}
}
