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
		this.balanceTree(parent, key);
	}

	private void computeHeights(AVLNode<T, U> node) {
		while(node != null){
			computeHeightNode(node);
			node = node.getParent();
		}
	}

	private void balanceTree(AVLNode<T, U> node, T key) {
		
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
		
		computeHeights(oldRoot);
		return newRoot;
	}
	
	private void computeHeightNode(AVLNode<T, U> node){
		Integer rightHeight = node.getRight() != null? node.getRight().getHeight() : 0;
		Integer leftHeight = node.getLeft() != null? node.getLeft().getHeight() : 0;
		Integer height = (rightHeight > leftHeight ? rightHeight : leftHeight) + 1;
		node.setHeight(height);
		return;
	}
	
	//              oldRoot 		       newRoot
	//	       /   \                           /     \
        //       newRoot     A      ==>               B      oldRoot       
	//	 /   \                   	     / \    /  \
	//       B     C                            D  E   C    A
	//      / \
	//     D   E
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
		
		computeHeights(oldRoot);
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
	
	//                A                     A               E
	//		/   \                 /  \             /  \
        //             B     C      ==>      E     C  ==>     B     A       
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
