package sorting;

public class MergeTwoSortedArrays {
	
	public static void print(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] merge(int arr1[], int arr2[]) {
	    int i = 0, j = 0, k = 0;
	    int size1 = arr1.length;
	    int size2 = arr2.length;
	    int ans[] = new int[size1 + size2];
	    while(i < size1 && j < size2) {
	        if(arr1[i] < arr2[j]) {
	            ans[k++] = arr1[i++];
	        } else {
	            ans[k++] = arr2[j++];
	        }
	    }
	    if(i < size1) {
	        while(i < size1) {
	            ans[k++] = arr1[i++];
	        }
	    }
	    if(j < size2) {
	        while(j < size2) {
	            ans[k++] = arr2[j++];
	        }
	    }
	    return ans;
	    
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 2, 3, 4, 6};
		int arr2[] = {5, 7, 8, 9};
		int arr[] = merge(arr1, arr2);
		print(arr);
	}

}
