package exercises;

public class CountSmallerElements {
	
	public static Integer[] countSmallerElements(Integer [] array){
		CustomBST tree = new CustomBST();
		Integer counter[] = new Integer[array.length];
		for(int i = array.length-1 ; i >= 0 ; i--){
			tree.insert(array[i],"", counter, i);
		}
		return counter;
	}
	
	public static class CustomBST{
		private CustomBSTNode root;
		private Integer amountOfNodes;
		
		public CustomBST(){
			super();
			this.root = null;
			this.amountOfNodes = 0;
		}
		
		/*
		 * Method: insert
		 * It insert a new element iteratively.
		 */
		public void insert(Integer key, String data, Integer[] counter, Integer index){
			
			CustomBSTNode parent  = null;
			CustomBSTNode node    = this.root;
			CustomBSTNode newNode = new CustomBSTNode(key);
			Integer auxCounter = 0;
			this.amountOfNodes++;
			
			while(node != null){
				parent = node;
				if(newNode.getKey().compareTo(node.getKey()) > 0){				
					Integer leftSize = node.getLeft() != null ? node.getLeft().getSize() : 0;
					auxCounter += (leftSize+1);
					node = node.getRight();
				}else{
					node = node.getLeft();
				}
			}
			counter[index] = auxCounter;
			newNode.setParent(parent);
			
			if(parent == null){ //It is the first element of the tree.
				this.root = newNode;
			}else if(newNode.getKey().compareTo(parent.getKey()) < 0){
				parent.setLeft(newNode);
			}else{
				parent.setRight(newNode);
			}
			
			newNode.setHeight(1);
			newNode.setSize(1);
			node = newNode.getParent();
			
			while(node != null){
				node.setSize(node.getSize()+1);
				Integer newHeight = 0;
				Integer leftHeight  = node.getLeft() != null? node.getLeft().getHeight() : 0; 
				Integer rightHeight = node.getRight() != null? node.getRight().getHeight() : 0;
				newHeight = leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
				node.setHeight(newHeight);
				node = node.getParent();
			}
		}
	}
	
	public static class CustomBSTNode{
		private Integer key;
		private Integer height;
		private Integer size;
		private CustomBSTNode parent;
		private CustomBSTNode left;
		private CustomBSTNode right;
		
		public CustomBSTNode(Integer key) {
			super();
			this.key    = key;
			this.parent = null;
			this.left   = null;
			this.right  = null;
			this.height = 0;
		}
		
		public Integer getKey() {
			return key;
		}
		
		public void setKey(Integer key) {
			this.key = key;
		}
		
		public CustomBSTNode getParent() {
			return parent;
		}
	
		public void setParent(CustomBSTNode parent) {
			this.parent = parent;
		}
	
		public CustomBSTNode getLeft() {
			return left;
		}
		
		public void setLeft(CustomBSTNode left) {
			this.left = left;
		}
		
		public CustomBSTNode getRight() {
			return right;
		}
		
		public void setRight(CustomBSTNode right) {
			this.right = right;
		}
		
		public Integer getHeight(){
			return this.height;
		}
		
		public void setHeight(Integer height){
			this.height = height;
		}
		
		public Integer getSize(){
			return this.size;
		}
		
		public void setSize(Integer size){
			this.size = size;
		}
	}
}
