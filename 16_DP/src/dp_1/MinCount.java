package dp_1;

/*
Given an integer N, find and return the count of minimum numbers, sum of whose squares is equal to N.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
Output will be 1, as 1 is the minimum count of numbers required.
*/

import java.util.Scanner;

public class MinCount {

	private static int minCountHelper(int[] ans,int n){
	    if(n-(int)(Math.pow((int)(Math.sqrt(n)),2))==0){
	        ans[n]=1;
	        return ans[n];
	    }
	    if(ans[n]!=Integer.MAX_VALUE){
	        return ans[n];
	    }
	    for(int i=1;i<=(int)(Math.sqrt(n));i++){
	        int val=minCountHelper(ans,n-(int)(Math.pow(i,2)))+1;
	        ans[n]=Math.min(val,ans[n]);
	    }
	    return ans[n];
	}

	private static int minCount(int n){
	    int[] ans=new int[n+1];
	    for(int i=0;i<=n;i++)
	        ans[i]=Integer.MAX_VALUE;
	    return minCountHelper(ans,n);    
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minCount(n));
	}

}
