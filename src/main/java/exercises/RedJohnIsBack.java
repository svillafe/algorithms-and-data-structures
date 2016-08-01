package exercises;

import java.util.Arrays;

/*
 * Red John has committed another murder. But this time, he doesn't leave a red smiley behind. 
 * What he leaves behind is a puzzle for Patrick Jane to solve. He also texts Teresa Lisbon 
 * that if Patrick is successful, he will turn himself in. The puzzle begins as follows.
 * There is a wall of size 4xN in the victim's house. The victim also has an infinite supply 
 * of bricks of size 4x1 and 1x4 in her house. There is a hidden safe which can only be opened 
 * by a particular configuration of bricks in the wall. In every configuration, the wall has to 
 * be completely covered using the bricks. There is a phone number written on a note in the safe 
 * which is of utmost importance in the murder case. Gale Bertram wants to know the total number 
 * of ways in which the bricks can be arranged on the wall so that a new configuration arises 
 * every time. He calls it M. Since Red John is back after a long time, he has also gained a masters 
 * degree in Mathematics from a reputed university. So, he wants Patrick to calculate the number of 
 * prime numbers (say P) up to M (i.e. <= M). If Patrick calculates P, Teresa should call Red John 
 * on the phone number from the safe and he will surrender if Patrick tells him the correct answer. 
 * Otherwise, Teresa will get another murder call after a week.
 * 
 * You are required to help Patrick correctly solve the puzzle.
 * 
 * Source: HackerRank
 */
public class RedJohnIsBack {
	public static Integer compute(Integer n){
		Integer [] memory;
		
        if(n < 3){
            memory= new Integer[4];            
        }else{
            memory= new Integer[n+1];
        }
	        
		memory[0] = 1;
		memory[1] = 1;
		memory[2] = 1;
		memory[3] = 1;
		
		for(int i = 4 ; i <= n ; i++){
			memory[i] = memory[i-1] + memory[i-4];
		}
		
		return countPrimeNumbers(memory[n]);
	}
	
	private static Integer countPrimeNumbers(Integer upperBound){
		if(upperBound < 2){
			return 0;
		}
		
		Boolean[] isPrime=new Boolean[upperBound+1];
		
		for(int i=2;i<=upperBound;i++){
			isPrime[i]=true;
        }

        for(int i=2;i*i<=upperBound;i++){
           if(!isPrime[i]){
               continue;
           }
            for(int j=i*i;j<=upperBound;j+=i){
                isPrime[j]=false;
            }
        }

        int counter=0;
        
        for(int i=2;i<=upperBound;i++){
            if(isPrime[i]){
                counter++;
            }
        }

        return counter;
    }
}
