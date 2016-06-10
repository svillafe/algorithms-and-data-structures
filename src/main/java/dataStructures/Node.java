package dataStructures;

/*
 * Data Structure: Node.
 * Description: It represents an element of information. It is useful for data structures 
 * where there is an identifier (key) and auxiliary piece of information (data).
 */
public interface Node<T extends Comparable<T>, U> {
		
	public T getKey();
	
	public void setKey(T key);
	
	public U getData();
	
	public void setData(U data);

}
