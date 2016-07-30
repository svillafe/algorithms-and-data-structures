package dataStructures.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AVLNodeTest {
		
	private AVLNode<Integer, String> AVLNode = null;
	
	@Before
	public void setUp() {
		this.AVLNode = new AVLNode<Integer, String>(5, "Hello World");
	}
	
	@Test
	public void itShouldStoreTheKeyCorrectly(){
		assertEquals(this.AVLNode.getKey(), new Integer(5));
	}
	
	@Test
	public void itShouldStoreTheDataCorrectly(){
		assertEquals(this.AVLNode.getData(), "Hello World");
	}
	
	@Test
	public void itShouldInitializeThePointersWithNull(){
		assertEquals(this.AVLNode.getParent(), null);
		assertEquals(this.AVLNode.getLeft(), null);
		assertEquals(this.AVLNode.getRight(), null);
		assertEquals(this.AVLNode.getHeight(), new Integer(1));
	}
}


