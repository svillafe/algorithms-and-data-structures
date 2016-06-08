package dataStructures.hashTable;

import static org.junit.Assert.assertEquals;

import java.nio.BufferOverflowException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dataStructures.Node;
import dataStructures.SimpleNode;

public class OpenAddressingHashTableTest {
	private OpenAddressingHashTable<String> hashTable = null;
	
	@Before
	public void setUp() {
		hashTable = new OpenAddressingHashTable<String>();
	
		hashTable.insert(new SimpleNode<Integer, String>(1,  "AR"));
		hashTable.insert(new SimpleNode<Integer, String>(2,  "BR"));
		hashTable.insert(new SimpleNode<Integer, String>(5,  "CL"));
		hashTable.insert(new SimpleNode<Integer, String>(9,  "EU"));
		hashTable.insert(new SimpleNode<Integer, String>(32, "TV"));
		hashTable.insert(new SimpleNode<Integer, String>(100,"UY"));
		hashTable.insert(new SimpleNode<Integer, String>(86, "VE"));
		hashTable.insert(new SimpleNode<Integer, String>(72, "NG"));
		hashTable.insert(new SimpleNode<Integer, String>(23, "AQ"));		
	}

	@Test
	public void linearProbingShouldWork(){
		
		OpenAddressingHashTable<String> myHashTable = null;
		
		@SuppressWarnings("unchecked")
		Node<Integer, String>[] myArray = new Node[9];
		
		myHashTable = new OpenAddressingHashTable<String>();
		SimpleNode<Integer, String> element1 = new SimpleNode<Integer, String>(1, "AR");
		SimpleNode<Integer, String> element2 = new SimpleNode<Integer, String>(1, "BR");
		SimpleNode<Integer, String> element3 = new SimpleNode<Integer, String>(1, "CL");
		SimpleNode<Integer, String> element4 = new SimpleNode<Integer, String>(1, "EU");
		
		myHashTable.insert(element1);
		myHashTable.insert(element2);
		myHashTable.insert(element3);
		myHashTable.insert(element4);
		
		
		myArray[1] = element1;
		myArray[2] = element2;
		myArray[3] = element3;
		myArray[4] = element4;
		
		Assert.assertArrayEquals(myArray, myHashTable.getHashTable());
	}
	
	@Test
	public void searchShouldReturnCorrectValue(){
		assertEquals(hashTable.search(9).getData(), "EU");
	}
	
	@Test
	public void itShouldReturnNullWhenAnElementIsNotInTheTable() {
		assertEquals(this.hashTable.search(89), null);
		assertEquals(this.hashTable.search(10), null);
	}
			
	@Test
	public void itShouldDeleteTheElementsCorrectly() {
		Node<Integer, String> element = this.hashTable.search(32);
		this.hashTable.delete(element);
		assertEquals(this.hashTable.search(32), null);	
		assertEquals(this.hashTable.search(86).getData(), "VE");
		this.hashTable.insert(new SimpleNode<Integer, String>(44, "LI"));
	}
	
	@Test(expected = BufferOverflowException.class)  
	public void itShouldThrowExceptionForOverflow() {
		this.hashTable.insert(new SimpleNode<Integer, String>(123, "TU"));
	}
}
