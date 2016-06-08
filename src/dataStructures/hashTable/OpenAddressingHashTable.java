package dataStructures.hashTable;

import java.nio.BufferOverflowException;
import java.util.Random;

import dataStructures.Node;

/*
 * Data Structure: HashTable
 * Hash Strategy: Open Addressing, each position contains either an element of the 
 * dynamic set or null. When we are Searching for an element, we systematically examine 
 * table's slots until either we find the desired element or we have ascertained that 
 * the element is not in the table. When we are Deleting an element from the hash table 
 * we mark it as a logical erase. Thus, when we are searching for an element and we 
 * encounter a logical erase, we continue probing, but if we encounter null we stop. 
 * When inserting and we encounter a logical erase position we insert the element in 
 * that position.
 * 
 * Source CLRS page 271. 
 */

public class OpenAddressingHashTable<U> implements Dictionary<Integer, U> {
	
	private static final int AMOUNT_SLOTS = 9;
	private static final int DELETED = -1;
	
	private Integer c1 = 0, c2 = 0;
	
	private Node<Integer, U> hashTable[] = null;
	
	@SuppressWarnings("unchecked")
	public OpenAddressingHashTable() {
		super();
		Random randomGenerator = new Random();
		
		c1 = randomGenerator.nextInt();
		c2 = randomGenerator.nextInt();
		
		this.hashTable = new Node[AMOUNT_SLOTS];
	}
	
	@Override
	public void insert(Node<Integer, U> element) {
		int i = 0;
		int j = 0;
		
		do{
			j = hashFunctionLinearProbing(element.getKey(), i);
			if(this.hashTable [j] == null || this.hashTable [j].getKey() == DELETED){
				this.hashTable[j] = element;
				return;
			}else{
				i++;
			}
		}while(i != AMOUNT_SLOTS);
		throw new BufferOverflowException();
	}

	@Override
	public Node<Integer, U> search(Integer key) {
		Integer i = 0;
		Integer j = 0;
		Node<Integer, U> resp = null;
		
		while(this.hashTable [j] != null && i < AMOUNT_SLOTS && resp == null){
			
			j = hashFunctionLinearProbing(key, i);
			
			if(this.hashTable [j].getKey() == key){
				resp = this.hashTable[j];
			}
			
			i++;
		}
		
		return resp;
	}

	@Override
	public void delete(Node<Integer, U> element) {
		
		Integer i = 0;
		Integer j = 0;
		Boolean exit = false;
		
		while(this.hashTable [j] != null && i != AMOUNT_SLOTS && !exit){
			j = hashFunctionLinearProbing(element.getKey(), i);
		
			if(this.hashTable [j].getKey() == element.getKey()){
				this.hashTable[j].setKey(DELETED);
				exit = true;
			}else{
				i++;
			}
		}
		
		return;
	}
	
	public Node<Integer,U>[] getHashTable(){
		return this.hashTable;
		
	}
	
	//CLRS page 272
	//Linear probing: it is easy to implement but it suffers from a problem
	//called primary clustering. 
	private Integer hashFunctionLinearProbing(Integer key, Integer index){
		return (hashFunction(key) + index) % AMOUNT_SLOTS;
	}
	
	//CLRS page 272
	//Quadratic probing: it suffers from a problem called secondary clustering.
	@SuppressWarnings("unused")
	private Integer hashFunctionQuadraticProbing(Integer key, Integer index){
		return (hashFunction(key) + c1 * index + c2 * index * index) % AMOUNT_SLOTS;
	}
	
	//CLRS page 272
	//Double hashing: it is one of the best methods available for open addressing
	//because the permutations produced have many of the characteristics of randomly
	//chose permutations.
	@SuppressWarnings("unused")
	private Integer hashFunctionDoubleHashing(Integer key, Integer index){
		return (hashFunction(key) + index * hashFunction2(key)) % AMOUNT_SLOTS;
	}
	
	private Integer hashFunction(Integer key){
		return key % AMOUNT_SLOTS;
	}
	
	private Integer hashFunction2(Integer key){
		return 1 + (key % AMOUNT_SLOTS-1);
	}
}
