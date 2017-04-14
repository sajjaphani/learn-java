package org.learnjava;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This example class demonstrates how to use <code>PriorityQueue</code> as a max or min heap.
 * 
 * @author psajja
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Binary_heap">Binary Heap</a>
 *
 */
public class BinaryHeapExample {

	/**
	 * Create a min heap. By default priority queue is based on min heap.
	 * 
	 * @return
	 * 		min heap
	 */
	protected static PriorityQueue<Integer> getMinHeap() {
		return new PriorityQueue<>();
	}
	
	/**
	 * Creates a max heap. This method passes a comparator to the priority queue
	 * constructor, which allows reverse ordering and hence allows us to create
	 * a max heap. Alternatively We can use {@link Collections#reverseOrder()}
	 * 
	 * @return 
	 * 		max heap
	 */
	protected static PriorityQueue<Integer> getMaxHeap() {
	
		return new PriorityQueue<>( new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
	}
	
	/**
	 * Test client.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PriorityQueue<Integer> minHeap = getMinHeap();
		minHeap.add(10);
		minHeap.add(15);
		minHeap.add(20);
		
		System.out.println("Min Heap " + minHeap);
		
		System.out.println("Min Heap Top Element: " + minHeap.peek());
		System.out.println();

		PriorityQueue<Integer> maxHeap = getMaxHeap();
		maxHeap.add(10);
		maxHeap.add(15);
		maxHeap.add(20);
		
		System.out.println("Max Heap " + maxHeap);
		
		System.out.println("Max Heap Top Element: " + maxHeap.peek());
	}

}
