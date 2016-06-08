package dataStructures.hashTable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.Node;
import dataStructures.SimpleNode;

public class DirectAddressHashTableTest {
	
	private DirectAddressHashTable<String> hashTable = null;
	
	@Before
	public void setUp() {
		this.hashTable = new DirectAddressHashTable<String>();
		
		this.hashTable.insert(new SimpleNode<Integer, String>(6, "AA"));
		this.hashTable.insert(new SimpleNode<Integer, String>(17, "AB"));
		this.hashTable.insert(new SimpleNode<Integer, String>(28, "AC"));
		this.hashTable.insert(new SimpleNode<Integer, String>(39, "AD"));
	}
	
	@Test
	public void itShouldInsertElementCorrectly() {
		assertEquals(this.hashTable.search(39).getData() , "AD");
	}

	@Test
	public void itShouldReturnNullWhenAnElementIsNotInTheTable() {
		assertEquals(this.hashTable.search(89), null);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)  
	public void itShouldThrowExceptionForAnInvalidKey() {
		this.hashTable.insert(new SimpleNode<Integer, String>(100, "Bye"));
	}
	
	@Test
	public void itShouldDeleteTheElementsCorrectly() {
		Node<Integer, String> element = this.hashTable.search(39);
		this.hashTable.delete(element);
		assertEquals(this.hashTable.search(89), null);
	}
}
