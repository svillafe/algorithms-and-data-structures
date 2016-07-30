package dataStructures.tree;
import dataStructures.Node;

public class AVLNode< T extends Comparable<T>, U> implements Node<T, U> {
	
	private T key;
	private U data;
	private Integer height;
	private AVLNode<T, U> parent;
	private AVLNode<T, U> left;
	private AVLNode<T, U> right;
	
	public AVLNode(T key, U data) {
		super();
		this.key    = key;
		this.data   = data;
		this.parent = null;
		this.left   = null;
		this.right  = null;
		this.height = 1; 
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
		
	public AVLNode<T, U> getParent() {
		return parent;
	}

	public void setParent(AVLNode<T, U> parent) {
		this.parent = parent;
	}

	public AVLNode<T, U> getLeft() {
		return left;
	}
	
	public void setLeft(AVLNode<T, U> left) {
		this.left = left;
	}
	
	public AVLNode<T, U> getRight() {
		return right;
	}
	
	public void setRight(AVLNode<T, U> right) {
		this.right = right;
	}

	public Integer getHeight() {
		return height;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}
}

