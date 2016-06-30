package dataStructures.linkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.Node;

public class SinglyUnsortedLinkedListTest {
	
	
	private SinglyUnsortedLinkedList<Integer, String> list1;
	private SinglyUnsortedLinkedList<Integer, String> list2;
	
	@Before
	public void setUp() {
		this.list1 = new SinglyUnsortedLinkedList<Integer, String>();
		this.list2 = new SinglyUnsortedLinkedList<Integer, String>();
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
		assertEquals(new Integer(18), this.list1.getHead().getKey());
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
	
	@Test
	public void itShouldReverseCorrectly(){
		loadList1();
		this.list1.reverse();
		assertArrayEquals(new Integer[]{1, 9, 5, 2, 32, 100, 85, 91, 23, 18}, this.list1.getKeys());
	}
	
	@Test
	public void itShouldSearchCorrectly(){
		loadList1();
		Node< Integer, String> node = this.list1.search(85);
		assertEquals(new Integer(85), node.getKey());
	}
	
	@Test
	public void itShouldDeleteCorrectly(){
		loadList1();
		Node< Integer, String> node = this.list1.search(85);
		this.list1.delete(node);
		assertEquals(null, this.list1.search(85));
	}
	
	@Test
	public void itShouldReturnPredecessorCorrectly(){
		loadList1();
		Node< Integer, String> node = this.list1.search(85);
		assertEquals(new Integer(91), this.list1.predecessor(node).getKey());
	}
	
	@Test
	public void itShouldReturnSuccessorCorrectly(){
		loadList1();
		Node< Integer, String> node = this.list1.search(85);
		assertEquals(new Integer(100), this.list1.successor(node).getKey());
	}
	
	@Test
	public void itShouldReturnTheKeysCorrectly(){
		loadList2();
		assertArrayEquals(new Integer[]{39, 61, 10}, list2.getKeys());
	}
	
	@Test
	public void linkedListShouldUnionCorrectly(){
		loadList1();
		loadList2();
		
		assertEquals("SinglyUnsortedLinkedList [18, 23, 91, 85, 100, 32, 2, 5, 9, 1]", list1.toString());
		assertEquals("SinglyUnsortedLinkedList [39, 61, 10]", list2.toString());
		list1.union(list2);
		assertEquals("SinglyUnsortedLinkedList [18, 23, 91, 85, 100, 32, 2, 5, 9, 1, 39, 61, 10]", list1.toString());
		
	}
	
	private void loadList1() {
		list1.insert(new DoublyNode<Integer, String>(1, "AA"));
		list1.insert(new DoublyNode<Integer, String>(9, "BA"));
		list1.insert(new DoublyNode<Integer, String>(5, "KL"));
		list1.insert(new DoublyNode<Integer, String>(2, "KH"));
		list1.insert(new DoublyNode<Integer, String>(32, "TU"));
		list1.insert(new DoublyNode<Integer, String>(100, "VW"));
		list1.insert(new DoublyNode<Integer, String>(85, "OO"));
		list1.insert(new DoublyNode<Integer, String>(91, "SH"));
		list1.insert(new DoublyNode<Integer, String>(23, "AW"));
		list1.insert(new DoublyNode<Integer, String>(18, "PP"));
	}
	
	private void loadList2() {
		list2.insert(new DoublyNode<Integer, String>(10, "BB II"));
		list2.insert(new DoublyNode<Integer, String>(61, "UH"));
		list2.insert(new DoublyNode<Integer, String>(39, "CI"));
	}
}
