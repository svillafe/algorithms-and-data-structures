package dataStructures.hashTable;

import dataStructures.Node;

public interface Dictionary<T extends Comparable<T>,U> {
	
	public void insert(Node<T,U> element);
	
	public Node<T,U> search(T key);
	
	public void delete(Node<T,U> key);

}
