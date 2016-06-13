package dataStructures.linkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.Node;

public class DoublySortedLinkedListTest {
	
	private DoublySortedLinkedList<Integer, String> list1;
	private DoublySortedLinkedList<Integer, String> list2;
	
	@Before
	public void setUp() {
		this.list1 = new DoublySortedLinkedList<Integer, String>();
		this.list2 = new DoublySortedLinkedList<Integer, String>();
	}
	
	@Test
	public void itShouldStartsEmpty(){
		assertEquals(new Integer(0), this.list1.getLength());
		assertEquals(true, this.list1.isEmpty());
		loadList1();
		assertEquals(false, this.list1.isEmpty());
		assertEquals(new Integer(10), this.list1.getLength());
	}
	
	@Test
	public void itShouldReturnTheHeadCorrectly(){
		loadList1();
		assertEquals(new Integer(1), this.list1.getHead().getKey());
	}
	
	@Test
	public void itShouldReturnTheMinimumCorrectly(){
		loadList1();
		assertEquals(new Integer(1), this.list1.minimum().getKey());
	}
	
	@Test
	public void itShouldReturnTheMaximumCorrectly(){
		loadList1();
		assertEquals(new Integer(100), this.list1.maximum().getKey());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void itShouldNotBeAbleToReverse(){
		this.list1.reverse();
	}
	
	@Test
	public void itShouldSearchCorrectly(){
		loadList1();
		LinkedListNode< Integer, String> node = this.list1.search(85);
		assertEquals(new Integer(85), node.getKey());
	}
	
	@Test
	public void itShouldDeleteCorrectly(){
		loadList1();
		LinkedListNode< Integer, String> node = this.list1.search(85);
		this.list1.delete(node);
		assertEquals(null, this.list1.search(85));
	}
	
	@Test
	public void itShouldReturnPredecessorCorrectly(){
		loadList1();
		Node< Integer, String> node = this.list1.search(85);
		assertEquals(new Integer(72), this.list1.predecessor(node).getKey());
	}
	
	@Test
	public void itShouldReturnSuccessorCorrectly(){
		loadList1();
		LinkedListNode< Integer, String> node = this.list1.search(85);
		assertEquals(new Integer(100), this.list1.successor(node).getKey());
	}
	
	@Test
	public void itShouldReturnTheKeysCorrectly(){
		loadList2();
		assertArrayEquals(new Integer[]{10,39,61}, list2.getKeys());
	}
	
	@Test
	public void linkedListShouldUnionCorrectly(){
		loadList1();
		loadList2();
		
		assertEquals("DoublySortedLinkedList [1, 2, 5, 9, 18, 23, 32, 72, 85, 100]", list1.toString());
		assertEquals("DoublySortedLinkedList [10, 39, 61]", list2.toString());
		list1.union(list2);
		assertEquals("DoublySortedLinkedList [1, 2, 5, 9, 10, 18, 23, 32, 39, 61, 72, 85, 100]", list1.toString());
		
	}
	
	private void loadList1() {
		list1.insert(new DoublyNode<Integer, String>(1, "AA"));
		list1.insert(new DoublyNode<Integer, String>(9, "BA"));
		list1.insert(new DoublyNode<Integer, String>(5, "KL"));
		list1.insert(new DoublyNode<Integer, String>(2, "KH"));
		list1.insert(new DoublyNode<Integer, String>(32, "TU"));
		list1.insert(new DoublyNode<Integer, String>(100, "VW"));
		list1.insert(new DoublyNode<Integer, String>(85, "OO"));
		list1.insert(new DoublyNode<Integer, String>(72, "SH"));
		list1.insert(new DoublyNode<Integer, String>(23, "AW"));
		list1.insert(new DoublyNode<Integer, String>(18, "PP"));
	}
	
	private void loadList2() {
		list2.insert(new DoublyNode<Integer, String>(10, "Algorithms II"));
		list2.insert(new DoublyNode<Integer, String>(61, "Calculus I"));
		list2.insert(new DoublyNode<Integer, String>(39, "Calculus II"));
	}
}
