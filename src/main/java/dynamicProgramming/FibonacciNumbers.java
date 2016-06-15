package dynamicProgramming;

/*
 * This class shows different approaches on solving the Fibonacci Numbers problem.
 * Input: Integer number between 0 - n
 * Output: Fibonacci Number N
 * 	F(N) = F(N - 1) + F(N - 2)
 *  F(0) = 0
 *  F(1) = 1
 *  
 *  Source: Skiena page 275
 */
public class FibonacciNumbers {
	
	

	/*
	 * The following implementation follows the recursive definition of Fibonacci.
	 * If we examine the recursion tree of the argument n = 8, we realize that there
	 * are arguments that are computed over and over again. For example F(4) is 
	 * computed two times and F(2) is computed no less than five times.
	 */
	public static Integer recursiveFibonacci(Integer n){
		Integer resp = 0;
		
		if(n == 0){
			resp = 0;
		}else if(n == 1){
			resp = 1;
		}else{
			resp = recursiveFibonacci(n-1) + recursiveFibonacci(n-2); 
		}
		return resp;
	}
	
	/*
	 * The following implementation follows the recursive definition of Fibonacci.
	 * Since we compute many times the same n, we cache or store the results of each
	 * Fibonacci computation in a table data structure indexed by parameter K.
	 */
	private static int MAXN = 100;
	private static Integer UNKNOWN = -1;
	
	public static Integer cachingFibonacci(Integer n){
		Integer table[] =  new Integer[MAXN+1];
		
		table[0] = 0;
		table[1] = 1;
		
		for(int i = 2 ; i <= n ; i ++){
			table[i] = UNKNOWN ;
		}
		
		return computeFibCaching(n, table);
	}

	private static Integer computeFibCaching(Integer n, Integer[] table) {
		if(table[n] == UNKNOWN ){
			table[n] = computeFibCaching(n - 1, table) + computeFibCaching(n - 2, table); 
		}	
		return table[n];
	}
	
	/*
	 * We can implement Fibonacci in linear time more easily by explicitly specifying
	 * the order of evaluation of the recurrence.
	 */
	
	public static Integer dpFibonacci(Integer n){
		Integer table[] =  new Integer[MAXN];
		
		table[0] = 0;
		table[1] = 1;
		
		for(int i = 2 ; i <= n ; i ++){
			table[i] = table[i-1] + table[i-2] ;
		}
		
		return table[n];
	}

	/*
	 * We can, even improve the space complexity of the previous algorithm by deleting 
	 * the table and saving only the two last elements.
	 */
	
	public static Integer dpFibonacciImp(Integer n){
		Integer last2 = 0;
		Integer last1 = 1;
		Integer current = 0;
		
		if(n == 1){
			current = 1;
		}
		
		for(int i = 2 ; i <= n ; i ++){
			current = last1 + last2 ;
			last2 = last1;
			last1 = current;
		}
		return current;
	}
	
	
	
}
