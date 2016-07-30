package dataStructures.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BSTNodeTest {
	
	private BSTNode<Integer, String> binaryTreeNode = null;
	
	@Before
	public void setUp() {
		this.binaryTreeNode = new BSTNode<Integer, String>(5, "Hello World");
	}
	
	@Test
	public void itShouldStoreTheKeyCorrectly(){
		assertEquals(this.binaryTreeNode.getKey(), new Integer(5));
	}
	
	@Test
	public void itShouldStoreTheDataCorrectly(){
		assertEquals(this.binaryTreeNode.getData(), "Hello World");
	}
	
	@Test
	public void itShouldInitializeThePointersWithNull(){
		assertEquals(this.binaryTreeNode.getParent(), null);
		assertEquals(this.binaryTreeNode.getLeft(), null);
		assertEquals(this.binaryTreeNode.getRight(), null);
	}
}
