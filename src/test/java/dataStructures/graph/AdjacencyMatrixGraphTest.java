package dataStructures.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AdjacencyMatrixGraphTest {

	private AdjacencyMatrixGraph graph = null;
	
	@Before
	public void setUp() {
		this.graph = new AdjacencyMatrixGraph(6);
		this.graph.insertEdge(0, 1);
		this.graph.insertEdge(1, 2);
		this.graph.insertEdge(0, 2);
		this.graph.insertEdge(3, 5);
		this.graph.insertEdge(4, 5);
	}
	
	
	@Test
	public void insertEdge(){
		this.graph.insertEdge(3, 4);
		assertEquals(true, this.graph.areTheseVerticesConnected(3, 4));
	}
	
	@Test
	public void deleteEdge(){
		this.graph.deleteEdge(1, 2);
		assertEquals(false, this.graph.areTheseVerticesConnected(1, 2));
	}
	
	@Test
	public void itShouldCheckIfVerticesAreConnected(){
		assertEquals(true, this.graph.areTheseVerticesConnected(3, 5));
	}
}
