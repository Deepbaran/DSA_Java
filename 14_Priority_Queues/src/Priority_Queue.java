import java.util.ArrayList;

// min-heap:

public class Priority_Queue {
	private ArrayList<Integer> heap;
	
	public Priority_Queue() {
		heap = new ArrayList<>();
	}
	
	boolean isEmpty() {
		return heap.size() == 0;
	}
	
	int size() {
		return heap.size();
	}
	
	int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			// Throw an Exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	void insert(int element) {
		heap.add(element);
		// We need to do up heapify to maintain the heap order property
		// up heapify in case of min-heap makes sure that the root node is less than all of it's child nodes.
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		
		while(childIndex > 0) { // Keep up-heapifying the heap till the heap is in order.
			// Continue the loop till we reach root.
			if(heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}
		
	int removeMin() throws PriorityQueueException {
		if(isEmpty()){
			// Throw an exception
			throw new PriorityQueueException();
		}
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int index = 0;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while(leftChildIndex < heap.size()){

			if(heap.get(leftChildIndex) < heap.get(minIndex)){
				minIndex = leftChildIndex;
			}
			if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)){
				minIndex = rightChildIndex;
			}
			if(minIndex == index){
				break;
			}else{
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		return temp;
	}
	
}


/*
Best way to implement a priority queue is by using heap.
There are two types of heap(one type of BT),
1. minHeap --> root is less than it's children
2. maxHeap --> root is greater than it's children
A priority queue must satisfy the CBT(Complete Binary Tree) property and Heap property
Priority Queue (Heap) might be defined as a array but always visualize it as a "Heap Sorted CBT"
*/

/*
PriorityQueue -> 1 2 3 4 5 6 7 8
Positon of children in array of node at ith position in array --> ((2 * i) + 1) and ((2 * i) - 1)
Position parent in array for ith element in array --> (int)((i - 1) / 2)
*/

/*
* It's called HEAP SORT
* decreasing order --> min heap
* increasing order --> max heap
* 
* Time Complexity of inserting all elements in Heap Sort: O(nlogn)
* Time Complexity of removing all elements from Heap Sort: O(nlogn)
* Overall Time Complexity: O(nlogn)
* 
* Space Complexity: O(n) <-- we are using a extra vector of n length other than the data that was provided
*/