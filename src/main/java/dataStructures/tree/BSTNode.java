package dataStructures.tree;

import dataStructures.Node;

public class BSTNode< T extends Comparable<T>, U> implements Node<T, U> {
	
	private T key;
	private U data;
	private BSTNode<T, U> parent;
	private BSTNode<T, U> left;
	private BSTNode<T, U> right;
	
	public BSTNode(T key, U data) {
		super();
		this.key    = key;
		this.data   = data;
		this.parent = null;
		this.left   = null;
		this.right  = null;
	}
	
	@Override
	public T getKey() {
		return key;
	}
	
	@Override
	public void setKey(T key) {
		this.key = key;
	}
	
	@Override
	public U getData() {
		return data;
	}
	
	@Override
	public void setData(U data) {
		this.data = data;
	}
	
	
	public BSTNode<T, U> getParent() {
		return parent;
	}

	public void setParent(BSTNode<T, U> parent) {
		this.parent = parent;
	}

	

	public BSTNode<T, U> getLeft() {
		return left;
	}
	
	public void setLeft(BSTNode<T, U> left) {
		this.left = left;
	}
	
	public BSTNode<T, U> getRight() {
		return right;
	}
	
	public void setRight(BSTNode<T, U> right) {
		this.right = right;
	}
}
