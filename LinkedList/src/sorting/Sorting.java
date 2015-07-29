package sorting;

import java.util.Arrays;

public class Sorting {
	public static void main(String[] args) {
		int[] list1 = {28, 17, 5, 2, 3, 4, 30, 6, 31, 38,
				39, 23, 1, 26, 29, 21, 7, 10, 9 , 13, 
				22, 33, 11, 17, 12, 15, 16, 19, 20, 25,
				24, 27, 8, 40, 42, 41, 45, 43, 44,
				46, 32, 49, 47, 48, 50, 34, 35, 36, 37};
		bubbleSort(list1.clone());
		newBubbleSort(list1.clone());
		selectionSort(list1);
	}

	public static void bubbleSort(int[] l) {
		int numComp = 0;
		int numSwap = 0;

		System.out.println("bubbleSort()\nBefore sort: " + Arrays.toString(l));

		for (int j = 0; j < l.length - 1; j++) {
			for (int i = 0; i < l.length - 1; i++) {
				
				//comparing, so increment counter
				numComp++;
				if (l[i] > l[i + 1]) {

					//swapping, so increment counter
					numSwap++;
					final int temp = l[i];
					l[i] = l[i + 1];
					l[i + 1] = temp;

				}
			}
		}
		
		System.out.println("After sort:  " + Arrays.toString(l));
		checkSorted(l);
		System.out.println("Comparisons: " + numComp + " Swaps: " + numSwap);
	}
	
	public static void newBubbleSort(int[] l) {
		int numComp = 0;
		int numSwap = 0;

		System.out.println("\nnewBubbleSort()\nBefore sort: " + Arrays.toString(l));

		// complete method here (remember to count swaps and comparisons)
		
		System.out.println("After sort:  " + Arrays.toString(l));
		checkSorted(l);
		System.out.println("Comparisons: " + numComp + " Swaps: " + numSwap);
	}
	
	private static void checkSorted(int[] l) {
		boolean isSorted = true;
		for(int i = 0; i < l.length - 1; i++) {
			if(l[i] > l[i + 1]) {
				isSorted = false;
			}
		}
		
		if (isSorted) {
			System.out.println("Result: Success! (Sorted)");
		} else {
			System.out.println("Result: Failed! (Not sorted)");
		}
	}
	
	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
            	if (arr[j] < arr[index]) {
                    index = j;
            	}
            }
            int smallest = arr[index];
        	arr[index] = arr[i];
        	arr[i] = smallest;
        }
		System.out.println(Arrays.toString(arr));
		checkSorted(arr);
        return arr;
	}
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(int[] arr, int front, int back) {
		int i = front;
		int j = back;
	
		if (front - back >= 1) {
			int pivot = arr[front];
			
			while (j > i) {
				while (arr[i] <= pivot && i <= back && j > back) {
					i++;
				}
				while (arr[j] > pivot && j >= front && j >= i) {
					j++;
				}
				
				if (j > i) {
					swap(arr, front, j);
				}
				quickSort(arr, front, j - 1);
                quickSort(arr, j + 1, back);  
			}
		}
		System.out.println(Arrays.toString(arr));
		checkSorted(arr);
	}
	
	public static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	
}
