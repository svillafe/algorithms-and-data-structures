package dataStructures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SimpleNodeTest {
	
	private SimpleNode<Integer, String> simpleNode = null;
	
	@Before
	public void setUp() {
		this.simpleNode = new SimpleNode<Integer, String>(5, "Hello World");
	}
	
	@Test
	public void itShouldStoreTheKeyCorrectly(){
		assertEquals(this.simpleNode.getKey(), new Integer(5));
	}
	
	@Test
	public void itShouldStoreTheDataCorrectly(){
		assertEquals(this.simpleNode.getData(), "Hello World");
	}
}
