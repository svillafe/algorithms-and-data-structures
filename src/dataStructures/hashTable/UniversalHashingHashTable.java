package dataStructures.hashTable;

import java.util.Random;

import dataStructures.Node;

/*
 * Data Structure: HashTable
 * Hash Strategy: In universal hashing, at the beginning of execution we select the
 * hash function at random from a carefully designed class of functions. We do this
 * by selecting randomly the parameter a and b of the hash function when we instantiate
 * a new hash table. 
 * 
 * Sorce CLRS 265
 */
public class UniversalHashingHashTable<U> implements Dictionary<Integer, U> {
	private static final int AMOUNT_SLOTS = 50;
	
	private Integer a = 0, b = 0;
	private Integer p = 0;
	
	private Node<Integer, U> hashTable[] = null;
	
	//p is a prime number large enough so that every possible key k
	//is in the range 0 to p-1
	@SuppressWarnings("unchecked")
	public UniversalHashingHashTable(Integer p) {
		super();
		this.p = p;
		Random randomGenerator = new Random();
		
		a = randomGenerator.nextInt(1000);
		b = randomGenerator.nextInt(1000);
		
		this.hashTable = new Node[AMOUNT_SLOTS];
	}
	
	@Override
	public void insert(Node<Integer, U> element) {
		this.hashTable[this.hashFunction(element.getKey())] = element;
	}

	@Override
	public Node<Integer, U> search(Integer key) {
		return this.hashTable[this.hashFunction(key)];
	}

	@Override
	public void delete(Node<Integer, U> element) {
		this.hashTable[this.hashFunction(element.getKey())] = null;
		return;
	}
	
	private Integer hashFunction(Integer key){
		return (((this.a * key) + this.b) % this.p) % AMOUNT_SLOTS;
	}
}
