package dataStructures.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LCRSNodeTest {
	private LCRSNode<Integer, String> lcrsNode = null;
	
	@Before
	public void setUp() {
		this.lcrsNode = new LCRSNode<Integer, String>(5, "Hello World");
	}
	
	@Test
	public void itShouldStoreTheKeyCorrectly(){
		assertEquals(this.lcrsNode.getKey(), new Integer(5));
	}
	
	@Test
	public void itShouldStoreTheDataCorrectly(){
		assertEquals(this.lcrsNode.getData(), "Hello World");
	}
	
	@Test
	public void itShouldInitializeThePointersWithNull(){
		assertEquals(this.lcrsNode.getParent(), null);
		assertEquals(this.lcrsNode.getLeftChild(), null);
		assertEquals(this.lcrsNode.getRightSibbling(), null);
	}
}
