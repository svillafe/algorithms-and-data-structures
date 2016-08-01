package exercises;
/*
 * Given a list of  integers, {a1, a2, a3, ... an}, and another integer, k representing 
 * the expected sum. Select zero or more numbers from such that the sum of these numbers 
 * is as near as possible, but not exceeding, to the expected sum(k).
 * 
 * Notes:
 * - Each element of the array can be selected multiple times.
 * - If no element is selected then the sum is 0. 
 */

public class NearestKnapsack {
	
	public static Integer compute(Integer [] numbers, Integer k){
		return compute(numbers, k, 0, 0);
	}
	
	public static Integer compute(Integer[] numbers, Integer number, Integer index, Integer sum){
		if(number < 0){ 
			return 0;
		}else if(number == 0 || (index >= numbers.length && number >0)){
			return sum;
		}
		
		return max(compute(numbers, number - numbers[index], index, sum+numbers[index]),
				   compute(numbers, number, index+1, sum));
	}
	
	public static Integer max(Integer a , Integer b){
		if(a > b){
			return a;
		}else{
			return b;
		}
	}
}
