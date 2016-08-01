package exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EightQueensTest {
	@Test
	public void itShouldComputeCorrectly() {
		assertEquals(new Integer(92), new Integer(EightQueens.compute().size()));
	}
}
