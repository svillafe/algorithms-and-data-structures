package dataStructures.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	private BinarySearchTree<Integer, String> tree = null;
	
	@Before
	public void setUp() {
		this.tree = new BinarySearchTree<Integer, String>();
		loadTree();
	}
	
	
	@Test
	public void itShouldWalkInOrderCorrectly(){
		assertArrayEquals(new Integer[]{1,2,5,6,7,8}, this.tree.inOrderTreeWalkRecursively());
	}
	
	@Test
	public void itShouldWalkPreOrderCorrectly(){
		assertArrayEquals(new Integer[]{6,2,1,5,7,8}, this.tree.preOrderTreeWalkRecursively());
	}
	
	@Test
	public void itShouldWalkPostOrderCorrectly(){
		assertArrayEquals(new Integer[]{1,5,2,8,7,6}, this.tree.postOrderTreeWalkRecursively());
	}
	
	@Test
	public void itShouldSearchIteratively(){
		assertEquals("AD", this.tree.searchIteratively(8).getData());
		assertEquals(null, this.tree.searchIteratively(15));
	}
	
	@Test
	public void itShouldSearchRecursively(){
		assertEquals("AD", this.tree.searchRecursively(8).getData());
		assertEquals(null, this.tree.searchRecursively(15));
	}
	
	@Test
	public void itShouldFindMinimumIteratively(){
		assertEquals("AE", this.tree.findMinimumIteratively().getData());
	}
	
	@Test
	public void itShouldFindMinimumRecursively(){
		assertEquals("AE", this.tree.findMinimumRecursively().getData());
	}
	
	@Test
	public void itShouldFindMaximumIteratively(){
		assertEquals("AD", this.tree.findMaximumIteratively().getData());
	}
	
	@Test
	public void itShouldFindMaximumRecursively(){
		assertEquals("AD", this.tree.findMaximumRecursively().getData());
	}
		
	private void loadTree() {
		tree.insert(6, "AA");
		tree.insert(2, "AB");
		tree.insert(7, "AC");
		tree.insert(8, "AD");
		tree.insert(1, "AE");
		tree.insert(5, "AF");
	}
}
