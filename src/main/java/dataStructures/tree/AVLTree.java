package dataStructures.tree;

/*
 * Data Structure: AVL Tree
 * Description: It is a binary search tree (BST) which is height is balanced. 
 * In other words, for each node x, the heights of the left and right subtrees 
 * of x differ by at most 1.
 * 
 * Space:	O(n)[Average]	O(n)[Worst case]
 * Search	O(log n)[Average]	O(log n)[Worst case]
 * Insert	O(log n)[Average]	O(log n)[Worst case]
 * Delete	O(log n)[Average]	O(log n)[Worst case]
 * 
 * Source: CLRS page 333
 */
public class AVLTree<T extends Comparable<T>, U> {

	private AVLNode<T, U> root;
	private Integer amountOfNodes;
		
	public AVLTree(){
		super();
		this.root = null;
		this.amountOfNodes = 0;
	}
	
	public AVLNode<T, U> getRoot() {
		return this.root;
	}
		
	/*
	 * Method: insert
	 * It insert a new element iteratively.
	 */
	public void insert(T key, U data){
		
		AVLNode<T, U> parent  = null;
		AVLNode<T, U> node    = this.root;
		AVLNode<T, U> newNode = new AVLNode<T, U>(key, data);
		
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
		computeHeights(newNode);
		this.balanceTree(parent);
	}

	private void computeHeightsToRoot(AVLNode<T, U> node) {
		while(node != null){
			computeHeightNode(node);
			node = node.getParent();
		}
	}
	
	private void computeHeightsToLeaves(AVLNode<T, U> node) {
		if(node == null){
			return;
		}
		computeHeightsToLeaves(node.getLeft());
		computeHeightsToLeaves(node.getRight());
		computeHeightNode(node);
	}
	
	private void computeHeights(AVLNode<T, U> node){
		computeHeightsToLeaves(node);
		computeHeightsToRoot(node);
	}

	private void balanceTree(AVLNode<T, U> node) {
		
		while(node != null){
			
			Integer rightHeight = node.getRight() == null? 0 : node.getRight().getHeight();
			Integer leftHeight  = node.getLeft() == null? 0 : node.getLeft().getHeight();
			int balance = rightHeight - leftHeight;

			if(balance == -2){ //The current node is unbalanced, the left subtree is height is greater 
							  //than the right subtree height.
				if(node.getLeft().getLeft().getHeight() >= node.getLeft().getRight().getHeight()){
					node = rotateRight(node);
				}else{
					node = doubleRotateLeftRight(node);
				}
			}else if(balance == 2){
				if(node.getRight().getRight().getHeight() >= node.getRight().getLeft().getHeight()){
					node = rotateLeft(node);
				}else{
					node = doubleRotateRightLeft(node);
				}
			}
			if(node.getParent() == null){
				this.root = node;
			}
			node = node.getParent();
		}
	}

	//              oldRoot 		         newRoot
	//		/   \                           /       \
        //             A    newRoot      ==>         oldRoot     C       
	//		     /   \                   /     \    /  \
	// 		     B     C                A       B  D    E
	//                        / \
	//                       D   E
	private AVLNode<T, U> rotateLeft(AVLNode<T, U> oldRoot) {
		AVLNode<T, U> newRoot = oldRoot.getRight();
		
		newRoot.setParent(oldRoot.getParent());
		oldRoot.setRight(newRoot.getLeft());
			  
		if(oldRoot.getRight() != null) {
			oldRoot.getRight().setParent(oldRoot);
		}
		
		newRoot.setLeft(oldRoot);
		oldRoot.setParent(newRoot);
		
		if(newRoot.getParent() != null){
			if(newRoot.getParent().getRight() == oldRoot){
				newRoot.getParent().setRight(newRoot);
			}else if(newRoot.getParent().getLeft() == oldRoot){
				newRoot.getParent().setLeft(newRoot);
			}
		}
		
		computeHeightsToRoot(oldRoot);
		return newRoot;
	}
	
	private void computeHeightNode(AVLNode<T, U> node){
		Integer rightHeight = node.getRight() != null? node.getRight().getHeight() : 0;
		Integer leftHeight = node.getLeft() != null? node.getLeft().getHeight() : 0;
		Integer height = (rightHeight > leftHeight ? rightHeight : leftHeight) + 1;
		node.setHeight(height);
		return;
	}
	
	//		oldRoot							newRoot
	//		/	\                           /     \
	//	newRoot	 A      ==>               B      oldRoot       
	//	 /   \                   	     / \    /  \
	//	B	 C							D  E   C    A
	//		/ \
	//		D	E
	private AVLNode<T, U> rotateRight(AVLNode<T, U> oldRoot) {
		AVLNode<T, U> newRoot = oldRoot.getLeft();
		
		newRoot.setParent(oldRoot.getParent());
		oldRoot.setLeft(newRoot.getRight());
			  
		if(oldRoot.getLeft() != null) {
			oldRoot.getLeft().setParent(oldRoot);
		}
		
		newRoot.setRight(oldRoot);
		oldRoot.setParent(newRoot);
		
		if(newRoot.getParent() != null){
			if(newRoot.getParent().getRight() == oldRoot){
				newRoot.getParent().setRight(newRoot);
			}else if(newRoot.getParent().getLeft() == oldRoot){
				newRoot.getParent().setLeft(newRoot);
			}
		}
		
		computeHeightsToRoot(oldRoot);
		return newRoot;
	}
	
	//        A 	          A		        D
	//	/   \            /  \                 /   \
        //     B     C      ==> B    D        ==>    A      C        
	//	    / \             /  \            / \    / \
	//         D    E          F     C          B  F  G   E 
	//        / \ 	                / \			   
	//       F   G	               G   E
	private AVLNode<T, U> doubleRotateRightLeft(AVLNode<T, U> node) {
		  node.setRight(rotateRight(node.getRight()));
		  return rotateLeft(node);
	}
	
	//		  A                     A               E
	//		/   \                 /  \             /  \
	//	   B     C      ==>      E     C  ==>     B     A       
	//	      / \                   /  \             / \   / \
	//  	     D   E                 B    G           D   F  G  C
	//              / \              /  \         
	//             F   G            D    F
	private AVLNode<T, U> doubleRotateLeftRight(AVLNode<T, U> node) {
		node.setLeft(rotateLeft(node.getLeft()));
		return rotateRight(node);
	}

	
	public AVLNode<T, U> search(T key){
		
		AVLNode<T, U> node = this.root;
		
		while(node != null && node.getKey() != key){
			if(key.compareTo(node.getKey()) < 0){
				node = node.getLeft();
			}else{
				node = node.getRight();
			}
		}
		
		return node;
	}
	


	/*
	 * Remove
	 */
	public void remove(T key){
		AVLNode<T, U> node = this.root;
		Boolean found = false;
		
		while(node != null && !found){
			if(key.compareTo(node.getKey()) < 0){
				node = node.getLeft();
			}else if(key.compareTo(node.getKey()) > 0){
				node = node.getRight();
			}else{
				found = true;
				removeNode(node);
			}
		}
	}
	
	/*
	 * Method: removeNode
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
	private void removeNode(AVLNode<T, U> node){
		AVLNode<T, U> newNode = null;
		
		if(node.getLeft() == null && node.getRight() == null){
			//If the node is a leaf, I delete it and I recompute 
			//the heights and check the balance starting from its parent
			newNode = node.getParent();
			this.transplant(node, null);
		}else if(node.getLeft() == null){
			newNode = node.getRight();
			this.transplant(node, newNode);
		}else if(node.getRight() == null){
			newNode = node.getLeft();
			this.transplant(node, newNode);
		}else{
			newNode = getMinimum(node.getRight());
			if(newNode.getParent() != node){
				this.transplant(newNode, newNode.getRight());
				newNode.setRight(node.getRight());
				newNode.getRight().setParent(newNode);
			}
			this.transplant(node, newNode);
			newNode.setLeft(node.getLeft());
			newNode.getLeft().setParent(newNode);
		}
		computeHeights(newNode);
		balanceTree(newNode);
	}
	
	/*
	 * Method: Transplant
	 * Description: It helps to move subtrees around within the binary search tree by
	 * replacing one subtree as a child of its parent with another subtree.
	 * It replace the subtree rooted at node rootA with the subtree rooted at node 
	 * rootB.
	 *  
	 *  Source: CLRS page 296
	 */
	private void transplant(AVLNode<T, U> rootA, AVLNode<T, U> rootB){
		if(rootA.getParent() == null){
			//RootA is the root of the tree.
			this.root = rootB;
		}else if(rootA == rootA.getParent().getLeft()){
			//RootA is a Left Child.
			rootA.getParent().setLeft(rootB);
		}else{
			//RootA is a Left Child.
			rootA.getParent().setRight(rootB);
		}
		
		if(rootB != null){
			//Set the rootB's parent with 
			//rootA's parent
			rootB.setParent(rootA.getParent());
		}
		
		
	}
	
	private AVLNode<T, U> getMinimum(AVLNode<T, U> node) {
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}

	public AVLNode<T, U> findMaximum() {
		AVLNode<T, U> node = this.root;		
		if(node == null){
			return null;
		}
		
		while(node.getRight() != null){
			node = node.getRight();
		}
		return node;
	}
	
	public AVLNode<T, U> findMinimum() {
		AVLNode<T, U> node = this.root;		
		if(node == null){
			return null;
		}
		
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
}
