package sorting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.linkedList.DoublyNode;
import dataStructures.linkedList.DoublyUnsortedLinkedList;

public class InsertionSortTest {
	private DoublyUnsortedLinkedList<Integer, String> list;
	
	@Test
	public void itShouldSortCorrectlyAnUnsortedArray() {
		Integer [] array = new Integer[]{89, 28, 34, 71, 21, 84, 64, 61, 46, 7, 27, 87, 57, 54, 18, 90, 53, 12, 6, 95, 99, 100, 65, 37, 31, 67, 52,  1, 98, 79, 11, 68, 72, 86, 38};
		Integer [] sorted = new Integer[]{1, 6, 7, 11, 12, 18, 21, 27, 28, 31, 34, 37, 38, 46, 52, 53, 54, 57, 61, 64, 65, 67, 68, 71, 72, 79, 84, 86, 87, 89, 90, 95, 98, 99, 100};
		InsertionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void itShouldSortCorrectlyASortedArray() {
		Integer [] array = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		Integer [] sorted = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		InsertionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void itShouldSortCorrectlyAnEmptyArray() {
		Integer [] array = new Integer[]{};
		Integer [] sorted = new Integer[]{};
		InsertionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	@Test
	public void itShouldSortCorrectlyAReversedArray() {
		Integer [] array = new Integer[]{20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		Integer [] sorted = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		InsertionSort.sort(array);
		assertArrayEquals(sorted, array);
	}
	
	
	
	
	
	@Before
	public void setUp() {
		this.list = new DoublyUnsortedLinkedList<Integer, String>();
		this.list.insert(new DoublyNode<Integer, String>(1, "AA"));
		this.list.insert(new DoublyNode<Integer, String>(9, "BA"));
		this.list.insert(new DoublyNode<Integer, String>(5, "KL"));
		this.list.insert(new DoublyNode<Integer, String>(2, "KH"));
		this.list.insert(new DoublyNode<Integer, String>(32, "TU"));
		this.list.insert(new DoublyNode<Integer, String>(100, "VW"));
		this.list.insert(new DoublyNode<Integer, String>(85, "OO"));
		this.list.insert(new DoublyNode<Integer, String>(91, "SH"));
		this.list.insert(new DoublyNode<Integer, String>(23, "AW"));
		this.list.insert(new DoublyNode<Integer, String>(18, "PP"));
	}
	
	
	
	@Test
	public void itShouldSortALinkedList(){
		InsertionSort.sort(this.list);
		assertEquals("DoublyUnsortedLinkedList [1, 2, 5, 9, 18, 23, 32, 85, 91, 100]",this.list.toString());	
	}
}
