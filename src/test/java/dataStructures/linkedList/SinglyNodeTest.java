package dataStructures.linkedList;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SinglyNodeTest {
	
	private SinglyNode<Integer, String> singlyNode = null;
	
	@Before
	public void setUp() {
		this.singlyNode = new SinglyNode<Integer, String>(5, "Hello World");
	}
	
	@Test
	public void itShouldStoreTheKeyCorrectly(){
		assertEquals(new Integer(5), this.singlyNode.getKey());
	}
	
	@Test
	public void itShouldStoreTheDataCorrectly(){
		assertEquals("Hello World", this.singlyNode.getData());
	}
	
	@Test
	public void itShouldInitializeThePointerWithNull(){
		assertEquals(null, this.singlyNode.getNext());
	}
	
	@Test(expected= java.lang.UnsupportedOperationException.class)
	public void itShouldNotSupportGetPrevOperation(){
		this.singlyNode.getPrev();
	}
	
	@Test
	public void itShouldBeEqualsToAnotherNodesWithSameValues(){
		SinglyNode<Integer, String> singlyNode2 = new SinglyNode<Integer, String>(5, "Hello World");
		assertEquals(true, singlyNode2.equals(this.singlyNode));
		assertEquals(false, singlyNode2 == this.singlyNode);
	}
}
