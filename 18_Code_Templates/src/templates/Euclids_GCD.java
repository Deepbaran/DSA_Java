package templates;

public class Euclids_GCD {
	int gcd(int a, int b){
		if(a==0) return b;
		return gcd(b%a,a);
	}
}
