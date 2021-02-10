package collections;
import java.util.*;
public class ComparatorClass {

	public static void main(String[] args) {
		int[][] array= {
				{1, 5},
				{13, 1},
				{12, 100},
				{12, 85} };
		
//		Arrays.sort(array, new Checker());
		
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]); // a[0]<=b[0] -> Don't Swap. a[0]>b[0] -> Swap
			}
		});
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}

class Checker implements Comparator<int[]> {
	@Override
	public int compare(int[] a, int[] b) {
		return a[0]-b[0];
		// -1/0 -> Don't Swap
		// 1 -> Swap
	}
}