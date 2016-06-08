package dataStructures.hashTable;

import dataStructures.Node;

/*
 * Data Structure: HashTable
 * Hash Strategy: Direct address, each position correspond to a key in the 
 * Universe U. It works only when the universe U of keys is small and two
 * elements do not have the same key.
 * 
 * Source CLRS page 254. 
 */
public class DirectAddressHashTable<U> implements Dictionary<Integer, U> {
	
	//Let's suppose that the size of universe U of key is 100
	private static final int MAX_TABLE = 100;
	
	private Node<Integer,U>[] table = null;
	
	@SuppressWarnings("unchecked")
	public DirectAddressHashTable() {
		super();
		this.table = new Node[MAX_TABLE];
	}
	
	@Override
	public void insert(Node<Integer, U> element) {
		this.table[element.getKey()] = element;
	}

	@Override
	public Node<Integer, U> search(Integer key) {
		return this.table[key];
	}

	@Override
	public void delete(Node<Integer, U> element) {
		this.table[element.getKey()] = null;
	}
}
