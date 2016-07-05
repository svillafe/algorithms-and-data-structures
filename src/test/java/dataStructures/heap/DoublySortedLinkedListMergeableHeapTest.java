package dataStructures.heap;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dataStructures.SimpleNode;

public class DoublySortedLinkedListMergeableHeapTest {
		
		private DoublySortedLinkedListMergeableHeap<String> heap1 = null;
		private DoublySortedLinkedListMergeableHeap<String> heap2 = null;
		private DoublySortedLinkedListMergeableHeap<String> heap3 = null;
		
		@Before
		public void setUp() {
			heap1 = new DoublySortedLinkedListMergeableHeap<String>();
			heap2 = new DoublySortedLinkedListMergeableHeap<String>();
			heap3 = new DoublySortedLinkedListMergeableHeap<String>();
			
			heap1.insert(new SimpleNode<Integer, String>(1, "AR"));
			heap1.insert(new SimpleNode<Integer, String>(2, "BR"));
			heap1.insert(new SimpleNode<Integer, String>(5, "CL"));
			heap1.insert(new SimpleNode<Integer, String>(9, "EU"));
			heap1.insert(new SimpleNode<Integer, String>(32, "TV"));
			heap1.insert(new SimpleNode<Integer, String>(100, "UY"));
			heap1.insert(new SimpleNode<Integer, String>(85, "VE"));
			heap1.insert(new SimpleNode<Integer, String>(72, "NG"));
			heap1.insert(new SimpleNode<Integer, String>(23, "AQ"));
			heap1.insert(new SimpleNode<Integer, String>(18, "FR"));
			
			heap2.insert(new SimpleNode<Integer, String>(10, "EU"));
			heap2.insert(new SimpleNode<Integer, String>(20, "TV"));
			heap2.insert(new SimpleNode<Integer, String>(15, "UY"));
			heap2.insert(new SimpleNode<Integer, String>(90, "VE"));
			heap2.insert(new SimpleNode<Integer, String>(62, "NG"));
			heap2.insert(new SimpleNode<Integer, String>(78, "AQ"));
			heap2.insert(new SimpleNode<Integer, String>(64, "FR"));
		}

		
		@Test
		public void minimumShouldReturnTheMinimum(){
			assertEquals(heap1.minimum().getKey(), new Integer(1));
		}
		
		@Test
		public void itShouldStoredValuesInSortedOrder(){
			assertEquals(heap1.toString(), "DoublySortedLinkedListMergeableHeap [1, 2, 5, 9, 18, 23, 32, 72, 85, 100]");
		}
		
		@Test
		public void itShouldMergeAnotherHeapWithElementsCorrectly(){
			heap1.union(heap2);
			assertEquals(heap1.toString(), "DoublySortedLinkedListMergeableHeap [1, 2, 5, 9, 10, 15, 18, 20, 23, 32, 62, 64, 72, 78, 85, 90, 100]");
			
		}
		
		@Test
		public void itShouldMergeAnEmptyHeapCorrectly(){
			
			assertEquals(heap1.amountOfElements(), new Integer(10));
			assertEquals(heap3.amountOfElements(), new Integer(0));
			assertEquals(heap2.amountOfElements(), new Integer(7));
			
			heap1.union(heap3);
			assertEquals(heap1.toString(), "DoublySortedLinkedListMergeableHeap [1, 2, 5, 9, 18, 23, 32, 72, 85, 100]");
			assertEquals(heap1.amountOfElements(), new Integer(10));
			
			heap1.union(heap2);
			assertEquals(heap1.toString(), "DoublySortedLinkedListMergeableHeap [1, 2, 5, 9, 10, 15, 18, 20, 23, 32, 62, 64, 72, 78, 85, 90, 100]");
			assertEquals(heap1.amountOfElements(), new Integer(17));
			
			heap1.union(heap3);
			assertEquals(heap1.toString(), "DoublySortedLinkedListMergeableHeap [1, 2, 5, 9, 10, 15, 18, 20, 23, 32, 62, 64, 72, 78, 85, 90, 100]");
			assertEquals(heap1.amountOfElements(), new Integer(17));
		}
}
