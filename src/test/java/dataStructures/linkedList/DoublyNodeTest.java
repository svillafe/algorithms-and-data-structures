package dataStructures.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.linkedList.DoublyNode;

public class DoublyNodeTest {
	
	private DoublyNode<Integer, String> doublyNode = null;
	
	@Before
	public void setUp() {
		this.doublyNode = new DoublyNode<Integer, String>(5, "Hello World");
	}
	
	@Test
	public void itShouldStoreTheKeyCorrectly(){
		assertEquals(new Integer(5), this.doublyNode.getKey());
	}
	
	@Test
	public void itShouldStoreTheDataCorrectly(){
		assertEquals("Hello World", this.doublyNode.getData());
	}
	
	@Test
	public void itShouldInitializeThePointerWithNull(){
		assertEquals(null, this.doublyNode.getPrev());
		assertEquals(null, this.doublyNode.getNext());
	}
	
	@Test
	public void itShouldBeEqualsToAnotherNodesWithSameValues(){
		DoublyNode<Integer, String> doublyNode2 = new DoublyNode<Integer, String>(5, "Hello World");
		assertEquals(true, doublyNode2.equals(this.doublyNode));
		assertEquals(false, doublyNode2 == this.doublyNode);
	}
}
