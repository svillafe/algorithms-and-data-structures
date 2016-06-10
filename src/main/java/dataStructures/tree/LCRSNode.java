package dataStructures.tree;

import dataStructures.Node;

/*
 * Left Child Right Sibling Node
 * CLRS page 247
 */
public class LCRSNode< T extends Comparable<T>, U> implements Node<T, U> {
	
	private T key;
	private U data;
	private LCRSNode<T, U> parent;
	private LCRSNode<T, U> leftChild;
	private LCRSNode<T, U> rightSibbling;
	
	public LCRSNode(T key, U data){
		this.key = key;
		this.data = data;
		this.parent = null;
		this.leftChild = null;
		this.rightSibbling = null;
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
		return this.data;
	}

	@Override
	public void setData(U data) {
		this.data = data;
		
	}
	public LCRSNode<T, U> getParent() {
		return parent;
	}
	public void setParent(LCRSNode<T, U> parent) {
		this.parent = parent;
	}
	public LCRSNode<T, U> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(LCRSNode<T, U> leftChild) {
		this.leftChild = leftChild;
	}
	public LCRSNode<T, U> getRightSibbling() {
		return rightSibbling;
	}
	public void setRightSibbling(LCRSNode<T, U> rightSibbling) {
		this.rightSibbling = rightSibbling;
	}
}
