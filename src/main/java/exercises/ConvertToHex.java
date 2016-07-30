package exercises;

import java.util.Arrays;

/*
 * Input  : an integer number.
 * Output : an String containing the Hexadecimal (base 16) representation of the number.
 */
public class ConvertToHex {
	
	public static String  integerToHex(int number){
		//0 -> 0	//8 -> 8
		//1 -> 1	//9  -> 9
		//2 -> 2	//10 -> A
		//3 -> 3	//11 -> B
		//4 -> 4	//12 -> C
		//5 -> 5	//13 -> D
		//6 -> 6	//14 -> E
		//7 -> 7	//15 -> F
		String sign;
		
		if(number < 0){
			sign = "-";
			number *= -1;
		}else{
			sign ="";
		}
		char [] hex = new char[]{'0', '1' ,'2', '3' ,'4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D' ,'E', 'F'};
		char mask = 0xF;
		int i = 7; 
		char[] characters = new char[8];//Assumed Integer of 4 bytes/32bits.
		for(int j = 0 ; j < 8 ; j ++){
			characters[j] = 0;
		}
		while(number > 0){
			Integer toConvert = number & mask;
			characters[i] = hex[toConvert]; 
			number = number >> 4;
			i--;
		}
		
		String response = sign + "0x" + new String(Arrays.copyOfRange(characters, i+1, 8));
		return response;
	}
}
