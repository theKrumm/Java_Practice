package heap;

import java.util.*;

@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>> {
	private static final int CAPACITY = 2;

	private int size; // Number of elements in heap
	private AnyType[] heap; // The heap array

	public Heap() {
		size = 0;
		heap = (AnyType[]) new Comparable[CAPACITY];
	}

	/**
	 * Inserts a new item
	 */
	public void insert(AnyType x) {
		if (x == null) {
			throw new NullPointerException("Null insertion.");
		}

		if (size == heap.length - 1) {
			doubleSize();
		}

		// Insert a new item to the end of the array
		
		int position;
		// Percolate up
		for (position = ++size; position > 1 &&
				x.compareTo(heap[position / 2]) < 0; position = position / 2) {
			heap[position] = heap[position / 2];
		}
		heap[position] = x;

	}

	/**
	 * Deletes the top item
	 */
	public AnyType removeMin() throws RuntimeException {
		if (size == 0) {
			throw new RuntimeException();
		}
		AnyType min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min;
	}

	private void doubleSize() {
		AnyType[] old = heap;
		heap = (AnyType[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public String toString() {
		String out = "";
		for (int k = 1; k <= size; k++)
			out += heap[k] + " ";
		return out;
	}

	/**
	 * Construct the binary heap given an array of items.
	 */
	public void buildHeap(AnyType[] array) {
		size = array.length;
		heap = (AnyType[]) new Comparable[size + 1];
		System.arraycopy(array, 0, heap, 1, size);
		buildHeap();
	}

	/**
	 * runs at O(size)
	 */
	private void buildHeap() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		AnyType tmp = heap[k];
		int child;

		for (; 2 * k <= size; k = child) {
			child = 2 * k;

			if (child != size && heap[child].compareTo(heap[child + 1]) > 0)
				child++;

			if (tmp.compareTo(heap[child]) > 0)
				heap[k] = heap[child];
			else
				break;
		}
		heap[k] = tmp;
	}

	public static void main(String[] args) {

		Heap<Integer> h = new Heap<Integer>();
		Integer[] a = { 2, 5, 3, 9, 6, 11, 4, 17, 10, 8 };
		h.buildHeap(a); // build a heap from a given array
		h.insert(2);
		h.insert(2);
		h.insert(2);
		h.insert(2);
		//h.removeMin();
		
		System.out.println(h);

	}
}