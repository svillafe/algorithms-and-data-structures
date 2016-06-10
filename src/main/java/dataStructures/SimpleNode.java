package dataStructures;
/*
 * Data Structure: Simple Node
 * It is the simplest representation of a node. It only contains
 * a key which works as an identifier and a piece of data.
 */
public class SimpleNode<K extends Comparable<K>, D> implements Node<K, D> {
	
	private K key;
	private D data;
	
	public SimpleNode(K key, D data) {
		super();
		this.key = key;
		this.data = data;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}

	@Override
	public D getData() {
		return this.data;
	}

	@Override
	public void setData(D data) {
		this.data = data;
	}

}
