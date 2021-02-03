package templates;

public class nPr {
	long npr(long n, long r) 
	{ 
	    long P = 1; 
	  
	    // Compute n*(n-1)*(n-2)....(n-k+1) 
	    for (long i = 0; i < r; i++) 
	        P *= (n-i) ; 
	  
	    return P; 
	}
}
