package subSequences;

import java.util.Scanner;

public class ReturnKeypad {

	private static String[] keypad(int n) {
		if(n == 0) {
			String str[] = {""};
			return str;
		}
		String smallAns[] = keypad(n / 10);
		String str[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		int n1 = (n % 10) - 2;
		String s = str[n1];
		String ans[] = new String[s.length() * smallAns.length];
		int k = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < smallAns.length; j++) {
				ans[k++] = smallAns[j] + s.substring(i, i + 1);
			}
		}
		return ans;
	}
	
	private static void printKeypad(String str[]) {
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str[] = keypad(n);
		printKeypad(str);
		sc.close();
	}

}
