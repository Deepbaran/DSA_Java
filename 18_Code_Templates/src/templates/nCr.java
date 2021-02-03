package templates;

public class nCr {
	long ncr(long n, long r){
		long C=1;
		for(long i=1;i<=r;i++){
			C*=(n-r+i);
			C/=i;
		}
		return C;
	}
}
