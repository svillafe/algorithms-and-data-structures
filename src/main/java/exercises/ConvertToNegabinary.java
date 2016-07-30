package exercises;

/*
 * Input  : an integer number.
 * Output : an String containing the Negabinary (base -2) representation of the number.
 */
public class ConvertToNegabinary {
		
	public static String integerTom2(int number){
	
		StringBuilder aux = new StringBuilder();
				
		while(number != 0){
			
			Integer remainder = number % -2;
			number = number / -2;
			
			if(remainder < 0){
				remainder += 2;
				number += 1;
			}
			aux.insert(0, remainder.toString());
		}
		return aux.toString();
	}
	
}
