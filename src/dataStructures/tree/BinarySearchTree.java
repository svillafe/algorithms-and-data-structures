package dataStructures.tree;

import java.util.Arrays;

import dataStructures.stack.ArrayStack;
import dataStructures.stack.Stack;

/*
 * Data Structure: Binary Search Tree
 * Description: It fulfills the Binary Search Tree Property, which claims: Let x be the node 
 * in a binary search tree. If y is a node in the left subtree of x, the y .key <= x.key. 
 * If y is a node in the right subtree of x, then y.key >= x.key.
 * 
 * Source CLRS page 287
 */
public class BinarySearchTree<T extends Comparable<T>, U> {
	
	private BinaryTreeNode<T, U> root;
	private Integer amountOfNodes;
	
	public BinarySearchTree(){
		super();
		this.root = null;
		this.amountOfNodes = 0;
	}
	
	public void insert(T key, U data){
		this.amountOfNodes++;
		
		if(this.root == null){
			this.root = new BinaryTreeNode<T, U>(key, data);
		}else{
			insertIntoTree(this.root, new BinaryTreeNode<T,U>(key, data));
		}
	}

	private void insertIntoTree(BinaryTreeNode<T, U> node, BinaryTreeNode<T, U> newNode) {
		if(newNode.getKey().compareTo(node.getKey()) < 0){
			if(node.getLeft() == null){
				newNode.setParent(node);
				node.setLeft(newNode);
			}else{
				insertIntoTree(node.getLeft(), newNode);
			}
		}else{
			if(node.getRight() == null){
				newNode.setParent(node);
				node.setRight(newNode);
			}else{
				insertIntoTree(node.getRight(), newNode);
			}
		}
	}
	

	public BinaryTreeNode<T, U> searchRecursively(T key){
		BinaryTreeNode<T, U> resp = searchRecursively(this.root, key);
		return resp;
	}
	
	private BinaryTreeNode<T, U> searchRecursively(BinaryTreeNode<T, U> node, T key){
		if(node == null || node.getKey() == key){
			return node;
		}
		
		if(key.compareTo(node.getKey()) < 0){
			return this.searchRecursively(node.getLeft(), key);
		}else{
			return this.searchRecursively(node.getRight(), key);
		}
	}
	
	public BinaryTreeNode<T, U> searchIteratively(T key){
		
		BinaryTreeNode<T, U> node = this.root;
		
		while(node != null && node.getKey() != key){
			if(key.compareTo(node.getKey()) < 0){
				node = node.getLeft();
			}else{
				node = node.getRight();
			}
		}
		
		return node;
	}
	
	public BinaryTreeNode<T, U> findMaximumIteratively() {
		BinaryTreeNode<T, U> node = this.root;		
		if(node == null){
			return null;
		}
		
		while(node.getRight() != null){
			node = node.getRight();
		}
		return node;
	}
	
	public BinaryTreeNode<T, U> findMaximumRecursively() {
		if(this.root == null){
			return null;
		}
		
		return findMaximumRecursively(this.root);
	}
	
	
	private BinaryTreeNode<T, U> findMaximumRecursively(BinaryTreeNode<T, U> node) {
		if(node.getRight() == null){
			return node;
		}else{
			return findMaximumRecursively(node.getRight());
		}
	}
	
	public BinaryTreeNode<T, U> findMinimumIteratively() {
		BinaryTreeNode<T, U> node = this.root;		
		if(node == null){
			return null;
		}
		
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
	
	public BinaryTreeNode<T, U> findMinimumRecursively() {
		if(this.root == null){
			return null;
		}
		
		return findMinimumRecursively(this.root);
	}
	
	
	private BinaryTreeNode<T, U> findMinimumRecursively(BinaryTreeNode<T, U> node) {
		if(node.getLeft() == null){
			return node;
		}else{
			return findMinimumRecursively(node.getLeft());
		}
	}

	public void printIterable(){
		Stack<T, U> s = new ArrayStack<T,U>(this.amountOfNodes);
		
		s.push(this.root);
		
		while(!s.isEmpty()){
			BinaryTreeNode<T, U> node = (BinaryTreeNode<T, U>) s.pop();
			System.out.println(node.getKey());
			if(node.getLeft() != null){
				s.push(node.getLeft());
			}
			if(node.getRight() != null){
				s.push(node.getRight());
			}
		}
		return;
	}
	
	public void printInOrderTreeWalk(){
		T[] array = this.inOrderTreeWalkRecursively();
		System.out.println(Arrays.toString(array));
	}
	
	public void printPreOrderTreeWalk(){
		T[] array = this.preOrderTreeWalkRecursively();
		System.out.println(Arrays.toString(array));
	}
	
	public void printPostOrderTreeWalk(){
		T[] array = this.postOrderTreeWalkRecursively();
		System.out.println(Arrays.toString(array));
	}
	
	@SuppressWarnings("unchecked")
	public T[] inOrderTreeWalkRecursively(){
		T[] resp = (T[]) new Comparable[this.amountOfNodes];
		doInOrderRecursively(this.root, resp, -1);
		return resp;
	}

	private Integer doInOrderRecursively(BinaryTreeNode<T, U> node,T[] resp, Integer index) {
		if(node == null){
			return index;
		}
		index = doInOrderRecursively(node.getLeft(), resp, index);
		index++;
		resp[index] = node.getKey(); 
		index = doInOrderRecursively(node.getRight(), resp, index);
		return index;
	}
	
	@SuppressWarnings("unchecked")
	public T[] preOrderTreeWalkRecursively(){
		T[] resp = (T[]) new Comparable[this.amountOfNodes];
		doPreOrderRecursively(this.root, resp, -1);
		return resp;
	}

	private Integer doPreOrderRecursively(BinaryTreeNode<T, U> node, T[] resp, Integer index) {
		if(node == null){
			return index;
		}
		
		index++;
		resp[index] = node.getKey();
		index = doPreOrderRecursively(node.getLeft(), resp, index);
		index = doPreOrderRecursively(node.getRight(), resp, index);
		
		return index;
	}
	
	@SuppressWarnings("unchecked")
	public T[] postOrderTreeWalkRecursively(){
		T[] resp = (T[]) new Comparable[this.amountOfNodes];
		doPostOrderRecursively(this.root, resp, -1);
		return resp;
	}

	private Integer  doPostOrderRecursively(BinaryTreeNode<T, U> node, T[] resp, Integer index) {
		if(node == null){
			return index;
		}
		
		index = doPostOrderRecursively(node.getLeft(), resp, index);
		index = doPostOrderRecursively(node.getRight(), resp, index);
		index++;
		resp[index] = node.getKey();
		return index;
	}

}
