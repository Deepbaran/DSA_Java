package subSequences;

import java.util.Scanner;

public class SubSequences {

	public static String[] findSubsequences(String str) {
		if(str.isEmpty()) { // str.length() == 0
			String ans[] = {""};
			return ans;
		}
		String smallAns[] = findSubsequences(str.substring(1));
		String ans[] = new String[2 * smallAns.length];
		for(int i = 0; i < 2 * smallAns.length; i++) {
			if(i < smallAns.length) {
				ans[i] = smallAns[i];
			} else {
				ans[i] = str.substring(0, 1) + smallAns[i - smallAns.length];
			}
		}
		return ans;
	}
	
	public static void printSubsequences(String s[]) {
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String s[] = findSubsequences(str);
		printSubsequences(s);
		sc.close();
	}

}
