package exercises;

/*
 * Input  : an integer number and a base.
 * Output : an String containing the representation of the number in the base 
 * that we put in the input.
 */
public class ConvertToBase {
	
	/* 
	 * Negative-base systems can accommodate all the same numbers as standard
	 * place-value systems, but both positive and negative numbers are
	 * represented without the use of a minus sign. 
	 */
	public static String integerToBase(int number, int base){
		char [] digits = {'0', '1', '2','3','4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 
						  'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 
						  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		Integer remainder = 0;
		StringBuilder resp = new StringBuilder();
		String sign;
		
		if(base > 0 && number <0 ){
			sign ="-";
			number*=-1;
		}else{
			sign = "";
		}
		
		while(number != 0 ){
			remainder = number % base;
			number = number/base;
			
			if(remainder < 0){
				number +=1;
				remainder += Math.abs(base);
			}
			resp.insert(0, digits[remainder]);
		}
		
		resp.insert(0, sign);
		return resp.toString();
	}

}
