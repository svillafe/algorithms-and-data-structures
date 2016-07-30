# Algorithms & Data Structures #

[![Build Status](https://travis-ci.org/svillafe/algorithms-and-data-structures.svg?branch=master)](https://travis-ci.org/svillafe/algorithms-and-data-structures) [![Coverage Status](https://coveralls.io/repos/github/svillafe/algorithms-and-data-structures/badge.svg?branch=master)](https://coveralls.io/github/svillafe/algorithms-and-data-structures?branch=master)

In this repository, you will find implementations of the most famous algorithms and data structures.
The majority of the code here is based in the pseudo-code that belongs to the CLRS Book. In code's comments, you will find the page of the book where the pseudo-code is located.

Below you will find the list of algorithms implemented from scratch:

### Sorting ###

| Algorithm                                           | Worst Case Running Time | Average Case Running Time | Stable | In-Place
|:---------------------------------------------------:|:-----------------------:|:-------------------------:|:------:|:-----------:|
|[Bubble Sort](/src/main/java/sorting/BubbleSort.java)| O(n^2)                  |O(n^2) | Yes | Yes
|[Bucket Sort](/src/main/java/sorting/BucketSort.java) | O(n^2)     |O(n + k)   | Yes | No 
|[Counting Sort](/src/main/java/sorting/CountingSort.java)| O(n) |O(n) |Yes | No 
|[Merge Sort](/src/main/java/sorting/MergeSort.java)| O(n log n)| O(n log n)| Yes | No |
|[Radix Sort](/src/main/java/sorting/RadixSort.java)|О(n)|О(n)| Yes | No
|[Selection Sort](/src/main/java/sorting/SelectionSort.java)| O(n^2) | O(n^2) | Yes |Yes 
|[Insertion Sort](/src/main/java/sorting/InsertionSort.java)|O(n log n) | О(n^2) | Yes | Yes
|[Heap Sort](/src/main/java/sorting/HeapSort.java)|O(n log n) | O(n log n)  | No | Yes
|[Quick Sort (Basic approach)](/src/main/java/sorting/quicksort/QuickSort.java)|О(n^2) | O(n log n) |Yes | Yes
|[Quick Sort (Hoare's method)](/src/main/java/sorting/quicksort/HoareQuickSort.java)|О(n^2) | O(n log n) |Yes | Yes
|[Quick Sort (Randomized version)](/src/main/java/sorting/quicksort/RandomQuickSort.java)|О(n^2) | O(n log n) |Yes | Yes
|[Quick Sort (Tail recursive)](/src/main/java/sorting/quicksort/TailRecursiveQuickSort.java)|О(n^2) | O(n log n) |Yes | Yes
|[Quick Sort (Median of three)](/src/main/java/sorting/quicksort/Median3QuickSort.java)|О(n^2) | O(n log n) |Yes | Yes

### Node ###

* [Node](/src/main/java/dataStructures/Node.java) (Interface)
* [Simple Node](/src/main/java/dataStructures/SimpleNode.java)
* [Singly Node](/src/main/java/dataStructures/linkedList/SinglyNode.java)
* [Doubly Node](/src/main/java/dataStructures/linkedList/DoublyNode.java)

### Stack ###

* [Stack](/src/main/java/dataStructures/stack/Stack.java) (Interface)

| Implementation | push | pop | isFull | isEmpty 
|:--------------:|:----:|:---:|:------:|:-------:|
|[Array Stack](/src/main/java/dataStructures/stack/ArrayStack.java) | O(1) |  O(1) |  O(1) |  O(1) 
|[Queue Stack](/src/main/java/dataStructures/stack/QueueStack.java) | O(1) | O(n)  | O(1)  | O(1)
|[Singly Unsorted Linked List Stack](/src/main/java/dataStructures/stack/SinglyUnsortedLinkedListStack.java)| O(1) | O(1)  | O(1)  | O(1)

### Queue ###

* [Queue](/src/main/java/dataStructures/queue/Queue.java) (Interface)
 
| Implementation | enqueue | dequeue | isFull | isEmpty 
|:--------------:|:-------:|:-------:|:------:|:-------:|
|[Array Queue](/src/main/java/dataStructures/queue/ArrayQueue.java) | O(1) |  O(1) |  O(1) |  O(1) 
|[Stack Queue](/src/main/java/dataStructures/queue/StackQueue.java) | O(1) | O(1)  | O(n)  | O(1)
|[Singly Unsorted Linked List Queue](/src/main/java/dataStructures/queue/SinglyUnsortedLinkedListQueue.java)| O(1) | O(n)  | O(1)  | O(1)

### Deque (Double ended queue) ###

* [Deque](/src/main/java/dataStructures/queue/Deque.java) (Interface)
* [Array Deque](/src/main/java/dataStructures/queue/ArrayDeque.java)

### Heap ###

* [Heap](/src/main/java/dataStructures/heap/Heap.java) (Interface)
* [Mergeable Heap](/src/main/java/dataStructures/heap/MergeableHeap.java) (Interface)
* [Array Heap](/src/main/java/dataStructures/heap/ArrayHeap.java)
* [Doubly Sorted Linked List Mergeable Heap](/src/main/java/dataStructures/heap/DoublySortedLinkedListMergeableHeap.java)

### Hash Tables ###

* [Direct Address Hash Table](/src/main/java/dataStructures/hashTable/DirectAddressHashTable.java)
* [Open Addressing Hash Table](/src/main/java/dataStructures/hashTable/OpenAddressingHashTable.java)
* [Universal Hashing Hash Table](/src/main/java/dataStructures/hashTable/UniversalHashingHashTable.java)

### Trees ###

* [Binary Search Tree (BST)](/src/main/java/dataStructures/tree/BST.java) 
* [BSTNode](/src/main/java/dataStructures/tree/BSTNode.java)
* [AVLTree](/src/main/java/dataStructures/tree/AVLTree.java) 
* [AVLNode](/src/main/java/dataStructures/tree/AVLNode.java)
* [LCRS Tree](/src/main/java/dataStructures/tree/LCRSTree.java) (Left Child Right Sibling)
* [LCRS Node](/src/main/java/dataStructures/tree/LCRSNode.java) (Left Child Right Sibling)

### Linked Lists ###

| Implementation | insert | delete | search | minimum | maximum
|:--------------:|:------:|:------:|:------:|:-------:|:------:|
| [Singly Sorted Linked List](/src/main/java/dataStructures/linkedList/SinglySortedLinkedList.java)| O(n) | O(n) | O(n) | O(1) | O(1)
| [Singly Unsorted Linked List](/src/main/java/dataStructures/linkedList/SinglyUnsortedLinkedList.java)| O(1) | O(n) | O(n) | O(n) | O(n)
| [Sentinels Doubly Unsorted Linked List](/src/main/java/dataStructures/linkedList/SentinelsDoublyUnsortedLinkedList.java)| O(1) | O(1) | O(n) | O(n) | O(n)
| [Doubly Sorted Linked List](/src/main/java/dataStructures/linkedList/DoublySortedLinkedList.java)| O(n) | O(1) | O(n) | O(1) | O(n)
| [Doubly Unsorted Linked List](/src/main/java/dataStructures/linkedList/DoublyUnsortedLinkedList.java)| O(1) | O(1) | O(n) | O(n) | O(n)

### Graphs ###

* [Adjacency Matrix Graph](/src/main/java/dataStructures/graph/AdjacencyMatrixGraph.java)

### Recursion & Dynamic Programming ###
* [Fibonacci Numbers](/src/main/java/dynamicProgramming/FibonacciNumbers.java)
* [Nearest Knapsack](/src/main/java/dynamicProgramming/NearestKnapsack.java)
* [Eight Queens](/src/main/java/dynamicProgramming/EightQueens.java)
* [Red John is back](/src/main/java/dynamicProgramming/RedJohnIsBack.java)




