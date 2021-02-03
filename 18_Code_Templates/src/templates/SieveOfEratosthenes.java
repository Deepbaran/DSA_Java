package templates;

public class SieveOfEratosthenes {
	void sieveOfEratosthenes(int[] sieve, int n){
	    for(int i=0;i<=n;i++)
	            sieve[i]=1; // Initially assume all are Prime
	    sieve[0]=0;
	    sieve[1]=0;
	    for(int i=2;i*i<=n;i++){
	        if(sieve[i]==1) // Proceed if prime
		        for(int j=i*i;j<=n;j+=i)
		            sieve[j]=0; // Not a Prime
	    }
	}
}
