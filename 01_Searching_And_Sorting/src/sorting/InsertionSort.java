package sorting;

import java.util.Scanner;

public class InsertionSort {

	public static void takeInput(int arr[]) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
//		scan.close();
	}
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int arr[]) {
		for(int i = 1; i < arr.length; i++) {
	        int current = arr[i];
	        int j;
	        for(j = i - 1; j >= 0; j--) {
	            if(current < arr[j]) {
	                arr[j + 1] = arr[j]; 
	            } else {
	                break;
	            }
	        }
	        arr[j + 1] = current;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size];
		takeInput(arr);
		insertionSort(arr);
		print(arr);
	}

}
