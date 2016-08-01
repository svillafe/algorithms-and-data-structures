package exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RedJohnnIsBackTest {
	
	@Test
	public void itShouldWorkCorrectly(){
		assertEquals(new Integer(0), RedJohnIsBack.compute(1));
		assertEquals(new Integer(3), RedJohnIsBack.compute(7));
		assertEquals(new Integer(3385), RedJohnIsBack.compute(34));
		assertEquals(new Integer(10794), RedJohnIsBack.compute(38));
		assertEquals(new Integer(269), RedJohnIsBack.compute(25));
		assertEquals(new Integer(6), RedJohnIsBack.compute(10));
		assertEquals(new Integer(1432), RedJohnIsBack.compute(31));
	}
}
