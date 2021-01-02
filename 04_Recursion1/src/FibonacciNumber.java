
public class FibonacciNumber {

	public static int fib(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println(fib(n)); // 0 1 1 2 3 5 8
	}

}
