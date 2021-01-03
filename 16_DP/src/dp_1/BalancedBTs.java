package dp_1;

import java.util.Scanner;

/*
Given an integer h, find the possible number of balanced binary trees of height h.
You just need to return the count of possible binary trees which are balanced.
This number can be huge, so return output modulus 10^9 + 7.

Time complexity should be O(h).
1 <= h <= 10^7
*/

public class BalancedBTs {

	final static int mod=(int)(Math.pow(10,9))+7;
	
	// Brute force
	private static int  balancedBTs(int h){
	    if(h<=1){
	        return 1;
	    }
	    int x=balancedBTs(h-1);
	    int y=balancedBTs(h-2);
	    int temp1=(int)(((long)(x)*x)%mod);
	    int temp2=(int)(((long)(y)*y)%mod);
	    int ans=(temp1+temp2)%mod;
	    return ans;
	}
	
	// DP: Memoization
	private static int binaryTreesOfHeightHHelper(int[] ans,int h) {
	    if(h<=1){
	        return 1;        
	    }else if(h==2){
	        return 3;
	    }
	    if(ans[h]!=0){
	        return ans[h];
	    }
	    if(h>2)
	        ans[h]=(
	        		(int)((2*(long)(binaryTreesOfHeightHHelper(ans,h-1))*(binaryTreesOfHeightHHelper(ans,h-2)))%mod)
	               	+(int)(((long)(binaryTreesOfHeightHHelper(ans,h-1))*(binaryTreesOfHeightHHelper(ans,h-1)))%mod)
	    			)%mod;
	    return ans[h];
	}

	private static int binaryTreesOfHeightH(int h){
	    int[] ans=new int[41];
	    return binaryTreesOfHeightHHelper(ans,h);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
	    int ans = balancedBTs(h);
	    System.out.println(ans);
	}

}
