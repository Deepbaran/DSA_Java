package subSequences;

import java.util.Scanner;

public class PrintSubsequences {

	private static void printSubsequences(String str, String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		// first character of str is not part of the answer
		printSubsequences(str.substring(1), ans);
		// first character of str is part of answer
		printSubsequences(str.substring(1), ans + str.substring(0, 1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		printSubsequences(str, "");
		sc.close();
	}

}
