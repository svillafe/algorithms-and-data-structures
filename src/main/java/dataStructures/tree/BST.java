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
 * Source: CLRS page 287
 */
public class BST<T extends Comparable<T>, U> {
	
	private BSTNode<T, U> root;
	private Integer amountOfNodes;
	
	public BST(){
		super();
		this.root = null;
		this.amountOfNodes = 0;
	}
	
	/*
	 * Method: insert
	 * It insert a new element iteratively.
	 */
	public void insert(T key, U data){
		
		BSTNode<T, U> parent  = null;
		BSTNode<T, U> node    = this.root;
		BSTNode<T, U> newNode = new BSTNode<T, U>(key, data);
		
		this.amountOfNodes++;
		
		while(node != null){
			parent = node;
			if(newNode.getKey().compareTo(node.getKey()) < 0){
				node = node.getLeft();
			}else{
				node = node.getRight();
			}
		}
		
		newNode.setParent(parent);
		
		if(parent == null){ //It is the first element of the tree.
			this.root = newNode;
		}else if(newNode.getKey().compareTo(parent.getKey()) < 0){
			parent.setLeft(newNode);
		}else{
			parent.setRight(newNode);
		}
	}

	public void insertRecursively(T key, U data){
		if(this.root == null){
			this.root = new BSTNode<T, U>(key, data);
		}else{
			insertIntoTree(this.root, new BSTNode<T,U>(key, data));
		}
	}
	
	private void insertIntoTree(BSTNode<T, U> node, BSTNode<T, U> newNode) {
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
	

	public BSTNode<T, U> searchRecursively(T key){
		BSTNode<T, U> resp = searchRecursively(this.root, key);
		return resp;
	}
	
	private BSTNode<T, U> searchRecursively(BSTNode<T, U> node, T key){
		if(node == null || node.getKey() == key){
			return node;
		}
		
		if(key.compareTo(node.getKey()) < 0){
			return this.searchRecursively(node.getLeft(), key);
		}else{
			return this.searchRecursively(node.getRight(), key);
		}
	}
	
	public BSTNode<T, U> searchIteratively(T key){
		
		BSTNode<T, U> node = this.root;
		
		while(node != null && node.getKey() != key){
			if(key.compareTo(node.getKey()) < 0){
				node = node.getLeft();
			}else{
				node = node.getRight();
			}
		}
		
		return node;
	}
	
	public BSTNode<T, U> findMaximumRecursively() {
		if(this.root == null){
			return null;
		}
		
		return findMaximumRecursively(this.root);
	}
	
	
	private BSTNode<T, U> findMaximumRecursively(BSTNode<T, U> node) {
		if(node.getRight() == null){
			return node;
		}else{
			return findMaximumRecursively(node.getRight());
		}
	}
	
	public BSTNode<T, U> findMaximumIteratively() {
		BSTNode<T, U> node = this.root;		
		if(node == null){
			return null;
		}
		
		while(node.getRight() != null){
			node = node.getRight();
		}
		return node;
	}
	
	
	public BSTNode<T, U> findMinimumRecursively() {
		if(this.root == null){
			return null;
		}
		
		return findMinimumRecursively(this.root);
	}
	
	
	private BSTNode<T, U> findMinimumRecursively(BSTNode<T, U> node) {
		if(node.getLeft() == null){
			return node;
		}else{
			return findMinimumRecursively(node.getLeft());
		}
	}
	
	public BSTNode<T, U> findMinimumIteratively() {
		BSTNode<T, U> node = this.root;		
		if(node == null){
			return null;
		}
		
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}

	public void printIterable(){
		Stack<T, U> s = new ArrayStack<T,U>(this.amountOfNodes);
		
		s.push(this.root);
		
		while(!s.isEmpty()){
			BSTNode<T, U> node = (BSTNode<T, U>) s.pop();
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

	private Integer doInOrderRecursively(BSTNode<T, U> node,T[] resp, Integer index) {
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

	private Integer doPreOrderRecursively(BSTNode<T, U> node, T[] resp, Integer index) {
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

	private Integer  doPostOrderRecursively(BSTNode<T, U> node, T[] resp, Integer index) {
		if(node == null){
			return index;
		}
		
		index = doPostOrderRecursively(node.getLeft(), resp, index);
		index = doPostOrderRecursively(node.getRight(), resp, index);
		index++;
		resp[index] = node.getKey();
		return index;
	}
	
	/*
	 * Method: successor
	 * Description: If the right subtree of a node x in T is empty and x has a successor 
	 * y, then y is the lowest ancestor of x whose left child is also an ancestor of x. 
	 * Every node is its own ancestor.
	 * 
	 */
	public BSTNode<T, U> successor(BSTNode<T, U> node){
		BSTNode<T, U> parent = null;
		
		if(node.getRight() != null){
			return this.findMinimumRecursively(node.getRight());
		}
		
		parent = node.getParent();
		
		while(parent != null && node.getKey() == parent.getRight().getKey()){
			node = parent;
			parent = node.getParent();
		}
		
		return parent;
	}
	
	/* 
	 * Method: predecessor
	 * Description : If the left subtree of a node x in T is empty and x has a predecessor y, 
	 * then y is the lowest ancestor of x whose right child is also an ancestor of x. Every
	 * node is its own ancestor. 
	 * 
	 */
	public BSTNode<T, U> predecessor(BSTNode<T, U> node){
		BSTNode<T, U> parent = null;
		
		if(node.getLeft() != null){
			return this.findMaximumRecursively(node.getLeft());
		}
		
		parent = node.getParent();
		
		while(parent != null && node.getKey() == parent.getLeft().getKey()){
			node = parent;
			parent = node.getParent();
		}
		
		return parent;
	}
	
	/*
	 * Method: Transplant
	 * Description: It helps to move subtrees around within the binary search tree by
	 * replacing one subtree as a child of its parent with another subtree.
	 *  It replace the subtree rooted at node rootA with the subtree rooted at node 
	 *  rootB.
	 *  
	 *  Source: CLRS page 296
	 */
	private void transplant(BSTNode<T, U> rootA, BSTNode<T, U> rootB){
		if(rootA.getParent() == null){
			this.root = rootB;
		}else if(rootA == rootA.getParent().getLeft()){
			rootA.getParent().setLeft(rootB);
		}else{
			rootA.getParent().setRight(rootB);
		}
		
		if(rootB != null){
			rootB.setParent(rootA.getParent());
		}
	}
	
	/*
	 * Method: Delete
	 * Description: In order to delete a node there are several cases to bear
	 * in mind: 
	 * 		* If z (node to be deleted) has no left child, then we replace z by
	 * 		its right child.
	 * 		* If z has just one child, which is its left child, then we replace
	 * 		z by its left child.
	 * 		* Otherwise, z has both a left and right child. We find z's successor
	 * 		which lies in z's right subtree and has no left child.
	 * 			- If the minimum is z's right child, then we replace z by the minimum
	 * 			leaving minimum's right child alone.
	 * 			- Otherwise, the minimum lies within the z's right subtree but is not
	 * 			z's right child. Thus, we first replace the minimum by its own right 
	 * 			child, and then we replace z by the minimum.
	 * 
	 * Source: CLRS page 296.
	 */
	public void delete(BSTNode<T, U> node){
		if(node.getLeft() == null){
			this.transplant(node, node.getRight());
		}else if(node.getRight() == null){
			this.transplant(node, node.getLeft());
		}else{
			BSTNode<T, U> minimum = this.findMinimumRecursively(node.getRight());
			if(minimum.getParent() != node){
				this.transplant(minimum, minimum.getRight());
				minimum.setRight(node.getRight());
				minimum.getRight().setParent(minimum);
			}
			this.transplant(node, minimum);
			minimum.setLeft(node.getLeft());
			minimum.getLeft().setParent(minimum);
		}
	}

}
