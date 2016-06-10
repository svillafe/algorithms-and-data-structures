package dataStructures.hashTable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.SimpleNode;

public class UniversalHashingHashTableTest {
private UniversalHashingHashTable<String> hashTable = null;
	
	@Before
	public void setUp() {
		hashTable = new UniversalHashingHashTable<String>(101);
	
		hashTable.insert(new SimpleNode<Integer, String>(1,  "AR"));
		hashTable.insert(new SimpleNode<Integer, String>(2,  "BR"));
		hashTable.insert(new SimpleNode<Integer, String>(5,  "CL"));
		hashTable.insert(new SimpleNode<Integer, String>(9,  "EU"));
		hashTable.insert(new SimpleNode<Integer, String>(32, "TV"));
		hashTable.insert(new SimpleNode<Integer, String>(100,"UY"));
		hashTable.insert(new SimpleNode<Integer, String>(85, "VE"));
		hashTable.insert(new SimpleNode<Integer, String>(72, "NG"));
		hashTable.insert(new SimpleNode<Integer, String>(23, "AQ"));		
	}

	
	@Test
	public void searchShouldReturnCorrectValue(){
		assertEquals(hashTable.search(23).getData(), "AQ");
	}
}
