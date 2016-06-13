package dataStructures.linkedList;
/*
 * LinkedList Interface
 * It defines all the methods that are commons to all the different types of 
 * LinkedLists. 
 */
public interface LinkedList<T extends Comparable<T>, U> extends DynamicSet<T, U> {
	
	public LinkedListNode<T,U> getHead();
	
	public Integer getLength();
	
	public Boolean isEmpty();
	
	public void reverse();
	
}
