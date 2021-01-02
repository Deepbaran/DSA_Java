package subSequences;

import java.util.Scanner;

public class PrintKeypad {

	private static void printKeypad(int n, String str) {
		if(n == 0) {
			System.out.println(str);
			return;
		}
		String s1[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int n1 = (n % 10) - 2;
		String s = s1[n1];
		for(int i = 0; i < s.length(); i++) {
			printKeypad(n / 10, s.substring(i, i + 1) + str); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printKeypad(n, "");
		sc.close();
	}

}
