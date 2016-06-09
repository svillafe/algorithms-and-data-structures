package dataStructures.tree;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

public class LCRSTreeTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private LCRSTree<Integer, String> tree = null;
			
	@Before
	public void setUp() {
		tree = new LCRSTree<Integer, String>();
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void treeShouldStartEmpty() {
		assertEquals(tree.isEmpty(), true);
	}
	
	@Test  
	public void ShouldPrintInTheCorrectOrder(){
		loadTree();
		tree.printRecursivly();
	    assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n", outContent.toString());
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	private void loadTree() {
		tree.insert(1, "AA", null);
		tree.insert(2, "AB", 1);
		tree.insert(3, "AC", 1);
		tree.insert(4, "AD", 1);
		tree.insert(8, "AE", 2);
		tree.insert(9, "AF", 2);
		tree.insert(7, "AG", 3);
		tree.insert(5, "AH", 4);
		tree.insert(6, "AI", 4);
	}
	

}
