package sorting;

import java.util.Scanner;

public class MergeSort {

	public static void merge(int arr1[], int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		int arr[] = new int[end - start + 1];
		while(i <= mid && j <= end) {
			if(arr1[i] < arr1[j]) {
				arr[k++] = arr1[i++];
			} else {
				arr[k++] = arr1[j++];
			}
		}
		while(i <= mid) {
			arr[k++] = arr1[i++];
		}
		while(j <= end) {
			arr[k++] = arr1[j++];
		}
		for(int l = start; l <= end; l++) {
			arr1[l] = arr[l - start];
		}
	}
	
	public static void merge_sort(int arr[], int start, int end) {
		if(start >= end) { // Base case
			return;
		}
		int mid = (start + end) / 2;
		merge_sort(arr, start, mid);
		merge_sort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}
	
	public static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();	
		}
		merge_sort(arr, 0, arr.length - 1);
		printArray(arr);
		sc.close();
	}

}
