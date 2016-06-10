package dataStructures.tree;

/*
 * Data Structure: Left-Child Right-Sibling Tree
 * Description: This representation allows us to build nodes with a variable amount of 
 * children (Not only 2 like Binary Tree). 
 * 
 * Source CLRS page 247
 */
public class LCRSTree<T extends Comparable<T> ,U> {
	
	private LCRSNode<T, U> root;
	private Integer amountOfNodes;
	
	public LCRSTree(){
		super();
		this.root = null;
		this.amountOfNodes = 0;
	}
	
	public Boolean isEmpty() {
		return this.amountOfNodes == 0;
	}
	
	public void insert(T key, U data, T parent){
		this.amountOfNodes++;
		if(this.root == null){
			this.root = new LCRSNode<T, U>(key, data);
		}else{
			insertInto(this.root, key, data, parent);
		}
	}
	
	private Boolean insertInto(LCRSNode<T, U> node, T key, U data, T parent) {
		if(node == null){
			return false;
		}
		
		if(node.getKey() == parent){
			
			LCRSNode<T, U> newNode = new LCRSNode<T, U>(key, data);
			newNode.setParent(node);
			
			LCRSNode<T, U> toInsert = node.getLeftChild();
			if(toInsert == null){
				node.setLeftChild(newNode);
			}else{
				while(toInsert.getRightSibbling() != null){
					toInsert = toInsert.getRightSibbling();
				}
				toInsert.setRightSibbling(newNode);
			}
			return true;
		}else{
			LCRSNode<T, U> iterator = node.getLeftChild();
			Boolean exit = false;
			while(iterator != null && !exit){
				exit = insertInto(iterator, key, data, parent);
				iterator = iterator.getRightSibbling();
			}
			return exit;
		}
	}

	public void printRecursivly(){
		printRecursivly(this.root);
	}

	private void printRecursivly(LCRSNode<T, U> node) {
		if(node == null){
			return;
		}
		
		System.out.println(node.getKey());
		printRecursivly(node.getRightSibbling());
		printRecursivly(node.getLeftChild());
	}
	
}
