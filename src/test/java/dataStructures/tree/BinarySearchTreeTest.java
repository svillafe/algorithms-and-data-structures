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
	
	@Test
	public void itShouldFindTheSuccessor(){
		BinaryTreeNode<Integer, String> node1 = this.tree.searchIteratively(8);
		BinaryTreeNode<Integer, String> node2 = this.tree.searchIteratively(2);
		BinaryTreeNode<Integer, String> node3 = this.tree.searchIteratively(6);

		assertEquals(null, this.tree.successor(node1));
		assertEquals("AF", this.tree.successor(node2).getData());
		assertEquals("AC", this.tree.successor(node3).getData());
	}
	
	@Test
	public void itShouldFindThePredecessor(){
		BinaryTreeNode<Integer, String> node1 = this.tree.searchIteratively(1);
		BinaryTreeNode<Integer, String> node2 = this.tree.searchIteratively(2);
		BinaryTreeNode<Integer, String> node3 = this.tree.searchIteratively(6);

		assertEquals(null, this.tree.predecessor(node1));
		assertEquals("AE", this.tree.predecessor(node2).getData());
		assertEquals("AF", this.tree.predecessor(node3).getData());		
	}
	
	@Test
	public void itShouldDeleteNodesCorrectlyCase1(){
		BinaryTreeNode<Integer, String> node = this.tree.searchRecursively(7);		
		this.tree.delete(node);
		
		BinaryTreeNode<Integer, String> node1 = this.tree.searchRecursively(8);
		BinaryTreeNode<Integer, String> node2 = this.tree.searchRecursively(6);
		
		assertEquals(true, node1 == node2.getRight());
	}
	
	@Test
	public void itShouldDeleteNodesCorrectlyCase2(){
		this.tree.insert(4, "AW");
		BinaryTreeNode<Integer, String> node = this.tree.searchRecursively(5);		
		this.tree.delete(node);
		
		BinaryTreeNode<Integer, String> node1 = this.tree.searchRecursively(4);
		BinaryTreeNode<Integer, String> node2 = this.tree.searchRecursively(2);
		
		assertEquals(true, node1 == node2.getRight());
	}
	
	@Test
	public void itShouldDeleteNodesCorrectlyCase3(){
		BinaryTreeNode<Integer, String> node = this.tree.searchRecursively(6);		
		this.tree.delete(node);
		
		BinaryTreeNode<Integer, String> node1 = this.tree.searchRecursively(8);
		BinaryTreeNode<Integer, String> node2 = this.tree.searchRecursively(7);
		
		assertEquals(true, node1 == node2.getRight());
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
