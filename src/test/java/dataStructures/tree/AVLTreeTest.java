package dataStructures.tree;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;


public class AVLTreeTest {
	
	private AVLTree<Integer, String> tree = null;
	
	@Before
	public void setUp() {
		this.tree = new AVLTree<Integer, String>();
	}
	
	@Test
	public void itShouldInsertCorrecltyRotateRight(){
		this.tree.insert(5, "A");
		this.tree.insert(3, "B");
		this.tree.insert(8, "C");
		this.tree.insert(1, "D");
		this.tree.insert(4, "E");
		
		assertEquals(new Integer(5), this.tree.getRoot().getKey());
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
		
		this.tree.insert(0, "F");
		
		assertEquals(new Integer(3), this.tree.getRoot().getKey());
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
		
		this.tree.insert(2, "G");
		
		assertEquals(new Integer(3), this.tree.getRoot().getKey());
		assertEquals(new Integer(8), this.tree.search(5).getRight().getKey());
		assertEquals(new Integer(4), this.tree.search(5).getLeft().getKey());
		assertEquals(new Integer(5), this.tree.search(3).getRight().getKey());
		assertEquals(new Integer(1), this.tree.search(3).getLeft().getKey());
		assertEquals(new Integer(0), this.tree.search(1).getLeft().getKey());
		assertEquals(new Integer(2), this.tree.search(1).getRight().getKey());
		assertEquals(null, this.tree.search(0).getRight());
		assertEquals(null, this.tree.search(0).getLeft());
		assertEquals(null, this.tree.search(2).getRight());
		assertEquals(null, this.tree.search(2).getLeft());
		assertEquals(null, this.tree.search(4).getRight());
		assertEquals(null, this.tree.search(4).getLeft());
		assertEquals(null, this.tree.search(8).getRight());
		assertEquals(null, this.tree.search(8).getLeft());
		
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
	}
	
	@Test
	public void itShouldInsertCorrecltyRotateLeft(){
		this.tree.insert(5, "A");
		this.tree.insert(2, "B");
		this.tree.insert(8, "C");
		this.tree.insert(7, "D");
		this.tree.insert(10, "E");
		assertEquals(new Integer(5), this.tree.getRoot().getKey());
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
		this.tree.insert(11, "F");
		assertEquals(new Integer(8), this.tree.getRoot().getKey());
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
		assertEquals(new Integer(7), this.tree.search(5).getRight().getKey());
		assertEquals(new Integer(2), this.tree.search(5).getLeft().getKey());
		assertEquals(new Integer(10), this.tree.search(8).getRight().getKey());
		assertEquals(new Integer(5), this.tree.search(8).getLeft().getKey());
		assertEquals(new Integer(11), this.tree.search(10).getRight().getKey());
		assertEquals(null, this.tree.search(10).getLeft());
		assertEquals(null, this.tree.search(11).getRight());
		assertEquals(null, this.tree.search(11).getLeft());
	}
	
	@Test
	public void itShouldInsertCorrecltyDoubleRotateRightLeft(){
		this.tree.insert(3, "A");
		this.tree.insert(1, "B");
		this.tree.insert(8, "C");
		this.tree.insert(5, "D");
		this.tree.insert(9, "E");
		
		assertEquals(new Integer(3), this.tree.getRoot().getKey());
		
		this.tree.insert(4, "F");
		this.tree.insert(6, "G");
		
		assertEquals(new Integer(5), this.tree.getRoot().getKey());
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
		assertEquals(new Integer(8), this.tree.search(5).getRight().getKey());
		assertEquals(new Integer(3), this.tree.search(5).getLeft().getKey());
		assertEquals(new Integer(4), this.tree.search(3).getRight().getKey());
		assertEquals(new Integer(1), this.tree.search(3).getLeft().getKey());
		assertEquals(new Integer(9), this.tree.search(8).getRight().getKey());
		assertEquals(new Integer(6), this.tree.search(8).getLeft().getKey());
		assertEquals(null, this.tree.search(1).getRight());
		assertEquals(null, this.tree.search(1).getLeft());
		assertEquals(null, this.tree.search(4).getRight());
		assertEquals(null, this.tree.search(4).getLeft());
		assertEquals(null, this.tree.search(6).getRight());
		assertEquals(null, this.tree.search(6).getLeft());
		assertEquals(null, this.tree.search(9).getRight());
		assertEquals(null, this.tree.search(9).getLeft());
	}
	
	
	@Test							  
	public void itShouldInsertCorrecltyDoubleRotateLeftRight(){
		this.tree.insert(8, "A");
		this.tree.insert(3, "B");
		this.tree.insert(9, "C");
		this.tree.insert(1, "D");
		this.tree.insert(5, "E");
		
		assertEquals(new Integer(8), this.tree.getRoot().getKey());
		
		this.tree.insert(4, "F");
		this.tree.insert(6, "G");
		
		assertEquals(new Integer(5), this.tree.getRoot().getKey());
		assertEquals(new Integer(3), this.tree.getRoot().getHeight());
		assertEquals(new Integer(8), this.tree.search(5).getRight().getKey());
		assertEquals(new Integer(3), this.tree.search(5).getLeft().getKey());
		assertEquals(new Integer(4), this.tree.search(3).getRight().getKey());
		assertEquals(new Integer(1), this.tree.search(3).getLeft().getKey());
		assertEquals(new Integer(9), this.tree.search(8).getRight().getKey());
		assertEquals(new Integer(6), this.tree.search(8).getLeft().getKey());
		assertEquals(null, this.tree.search(1).getRight());
		assertEquals(null, this.tree.search(1).getLeft());
		assertEquals(null, this.tree.search(4).getRight());
		assertEquals(null, this.tree.search(4).getLeft());
		assertEquals(null, this.tree.search(6).getRight());
		assertEquals(null, this.tree.search(6).getLeft());
		assertEquals(null, this.tree.search(9).getRight());
		assertEquals(null, this.tree.search(9).getLeft());
	}
	
	@Test
	public void itShouldFindMinimum(){
		this.tree.insert(8, "A");
		this.tree.insert(3, "B");
		this.tree.insert(9, "C");
		this.tree.insert(1, "D");
		this.tree.insert(5, "E");
		this.tree.insert(4, "F");
		this.tree.insert(6, "G");
		
		assertEquals("D", this.tree.findMinimum().getData());
	}

	@Test
	public void itShouldFindMaximum(){
		this.tree.insert(8, "A");
		this.tree.insert(3, "B");
		this.tree.insert(9, "C");
		this.tree.insert(1, "D");
		this.tree.insert(5, "E");
		this.tree.insert(4, "F");
		this.tree.insert(6, "G");
		
		assertEquals("C", this.tree.findMaximum().getData());
	}

}







	

	
	
	
	


