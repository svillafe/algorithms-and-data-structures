package dataStructures.graph;
/*
 * Data Structure: Graph
 * Implementation of a graph G(V,E) using a matrix as an underlying data structure. 
 * It may use excessive space for graphs with many vertices and relatively few edges.
 * Unless it is an dense graph, the adjacency matrix it is not the best choice to
 * represent a graph.
 * 
 * Source: TADM Skiena page 151. 
 */
public class AdjacencyMatrixGraph {
	
	Boolean [][] matrix;
	
	public AdjacencyMatrixGraph(int amountOfVertices){
		super();
		this.matrix = new Boolean[amountOfVertices][amountOfVertices];
	}
	
	public void insertEdge(Integer x , Integer y){
		this.matrix[x][y] = true;
	}
	
	public void deleteEdge(Integer x , Integer y){
		this.matrix[x][y] = false;
	}
	
	public Boolean areTheseVerticesConnected(Integer x, Integer y){
		return this.matrix[x][y] == true;
	}
}
