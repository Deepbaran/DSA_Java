package sorting;

import java.util.Scanner;

public class QuickSort {

	public static int partition(int arr[], int start, int end) {
		// Find Pivot (the first element)
		// Place Pivot at it's pos
		// Ensure <= pivot towards left and > pivot towards right
		// return pivot position
		int lessThanEqaulToPivot = 0;
		for(int i = start + 1; i <= end; i++) {
			if(arr[i] <= arr[start]) {
				lessThanEqaulToPivot++;				
			}
		}
		int position = lessThanEqaulToPivot + start;
		int temp = arr[position];
		arr[position] = arr[start];
		arr[start] = temp;
		int i = start;
		int j = end;
		while(i < position && j > position) {
			if(arr[i] > arr[position]) {
				if(arr[j] <= arr[position]) {
					int temp1 = arr[i];
					arr[i] = arr[j];
					arr[j] = temp1;
					j--;
					i++;
				} else {
					j--;
				}
			} else { // ith element is less than equal to pivot
				i++;
			}
		}
		return position;		
	}
	
	public static void quick_sort(int arr[], int start, int end) {
		if(start >= end) { // Base case
			// as a single element is always sorted so no need to do anything for start == end
			return;			
		}
		int pivotPos = partition(arr, start, end);
		quick_sort(arr, start, pivotPos - 1);
		quick_sort(arr, pivotPos + 1, end);
	}
	
	public static void printArray(int arr[]) {
		for(int  i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		quick_sort(arr, 0, n - 1);
		printArray(arr);
		sc.close();
	}

}
