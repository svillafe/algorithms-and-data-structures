package dataStructures.tree;

import dataStructures.Node;

public class BinaryTreeNode< T extends Comparable<T>, U> implements Node<T, U> {
	
	private T key;
	private U data;
	private BinaryTreeNode<T, U> parent;
	private BinaryTreeNode<T, U> left;
	private BinaryTreeNode<T, U> right;
	
	public BinaryTreeNode(T key, U data) {
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
	
	
	public BinaryTreeNode<T, U> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode<T, U> parent) {
		this.parent = parent;
	}

	

	public BinaryTreeNode<T, U> getLeft() {
		return left;
	}
	
	public void setLeft(BinaryTreeNode<T, U> left) {
		this.left = left;
	}
	
	public BinaryTreeNode<T, U> getRight() {
		return right;
	}
	
	public void setRight(BinaryTreeNode<T, U> right) {
		this.right = right;
	}
}
