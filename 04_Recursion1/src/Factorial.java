
public class Factorial {
	
	/*
	 * Recursion in computer science is a method where the solution to a problem depends on solutions to smaller instances of the same problem
	 */

	public static int fact(int n) {
		// for recursion, stack overflow occurs if base case is not set properly
		// For every call of recursion(recurrence), previous recurrence pauses till the called new recurrence either returns result or terminates
		// till the new recurrence returns result or terminates, all the previous recurrences are stored in the call stack
		if(n == 1) { // Base case <- where recursion stops. The simplest problem that we have to solve.
			return 1;
		}
		
		int smallAns = fact(n -1);
		return n * smallAns;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int ans = fact(n);
		System.out.println(ans);
	}

}

/*
 * Recursion follows PMI(Principle of Mathematical Induction)
 * 
 * Recursion steps:
 * 1. Figure out the Base case
 * 2. Figure out the smaller problem(Hypothesis step)
 * 3. Once smaller problem is found, figure our how we can solve the bigger problem with it(induction)
 * 
 * 
 * n == 1 is our base case
 * For the factorial, fact(n - 1) is the smaller problem. Here, we will not analyze fact(n - 1) and assume that it gives us the desired result
 * n * fact(n - 1) is the way we will handle the bigger problem once smaller problem is found
 * 
 * 
 * Points to remember:
 * 1. Always assume that the smaller problem will be solved and give us the desired result. Recursion will do it for us according to PMI
 *    This is the most crucial step. Do not be curious while writing code.
 *    Do this after solving the problem and not the other way around. 
 *    Don't try to solve the problem by analysing all the steps.
 * 2. Never analyze the smaller problem
 * 3. Recursion follows a simple rule and that is, we will solve one small problem and the rest will be solved by recursion
 * 
 */
