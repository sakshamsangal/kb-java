package com.example.array;// Java implementation of the approach

public class TWR2Pointer {

	static int maxWater(int[] arr, int n)
	{

		// Indices to traverse the array
		int leftIndex = 0;
		int rightIndex = n - 1;

		// To store Left max and rightIndex max
		// for two pointers leftIndex and rightIndex
		int l_max = 0;

		int r_max = 0;

		// To store the total amount
		// of rain water trapped
		int result = 0;
		while (leftIndex <= rightIndex) {

			// We need check for minimum of leftIndex
			// and rightIndex max for each element
			if (l_max <= r_max) {
				// Add the difference between
				// current value and leftIndex max at index l
				result += Math.max(0, l_max - arr[leftIndex]);

				// Update leftIndex max
				l_max = Math.max(l_max, arr[leftIndex]);

				// Update leftIndex pointer
				leftIndex += 1;
			}
			else {

				// Add the difference between
				// current value and rightIndex max at index r
				result += Math.max(0, r_max - arr[rightIndex]);

				// Update rightIndex max
				r_max = Math.max(r_max, arr[rightIndex]);

				// Update rightIndex pointer
				rightIndex -= 1;

			}
		}
		return result;
	}

	// Driver code
	public static void main(String[] args)
	{
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int N = arr.length;
		System.out.print(maxWater(arr, N));
	}
}

// This code is contributed by rutvik_56.
