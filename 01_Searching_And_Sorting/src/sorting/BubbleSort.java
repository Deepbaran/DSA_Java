package sorting;

import java.util.Scanner;

public class BubbleSort {

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
	
	public static void bubbleSort(int arr[]) {
		for(int i = 0; i < arr.length - 1; i++) {
	        for(int j = 1; j < arr.length - i; j++) {
	            if(arr[j] < arr[j - 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j - 1];
	                arr[j - 1] = temp;
	            } 
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size];
		takeInput(arr);
		bubbleSort(arr);
		print(arr);
	}

}
