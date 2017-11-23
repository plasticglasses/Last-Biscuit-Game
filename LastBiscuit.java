/*Level 3 attempted
Last biscuit is a game, 2 players take it in turns to take an amount of biscuits from one barrel
 or the same amount of biscuits from both barrels. You cannot take 0 biscuis from the barrel, 
 the winner is the player than takes the last biscuit.
*/
import java.util.Scanner;

public class LastBiscuit {
	public static void main(String args[]){

		final double EMPTY_BARREL = 0;	//used to check the number of biscuits in the barrel
		final double NO_BISCUITS = 0;	//used to check that a zero (or less) amount of biscuits has not been entered
		
		int barrelOne = 6;	
		int barrelTwo = 8;	
		int count = 0;		
		String winner = ("default");	//set string to "default" to satisfy the compiler
		
		Scanner input = new Scanner (System.in);
		
		while ((barrelOne != EMPTY_BARREL) || (barrelTwo != EMPTY_BARREL)){ 
			count++;
			
			int mostFullBarrel = (barrelTwo-barrelOne);	//barrel with the most biscuits in it
			int leastFullBarrel;	
			
			if (mostFullBarrel <= EMPTY_BARREL){ 	//check which barrel is bigger (for range check)
				mostFullBarrel=barrelOne;
				leastFullBarrel=barrelTwo;
			}else{
				mostFullBarrel=barrelTwo;
				leastFullBarrel=barrelOne;
			}
			
			System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
			System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);
			
			if ((count%2)!=0){ //if count is odd (checked by using modulus) then it is the turn of player 1
				System.out.print("Biscuits taken by player 1: ");
				winner=("player 1");//in case the game ends
			}else{
				System.out.print("Biscuits taken by player 2: ");
				winner=("player 2");
			}
			
			while(!input.hasNextInt()) {	//validates input is an integer, by checking input is an integer and looping if an invalid entry is made.
			    System.out.print("Please input a valid number of biscuits: ");
				input.next();
			}
			
			int numberOfBiscuits = input.nextInt();	
			
			if  ((!(numberOfBiscuits <= mostFullBarrel)) || (!(numberOfBiscuits > NO_BISCUITS))){ //range of number entered must be between 1 and the max number of biscuits possible in the barrel
				System.out.print("Please input a valid number of biscuits between 1 and " + mostFullBarrel);
				count--;
			}else{
				System.out.print("From barrel1 (one), barrel2 (two), or both (both)? ");
				input.nextLine(); //compiler displays an error if this is not here
				String whichBarrel = input.nextLine();
				
				if (!(whichBarrel.equals("both")) && (!(whichBarrel.equals("one")) && (!(whichBarrel.equals("two"))))){	//error checking, only allow "one", "two", "both"
					System.out.println("Invalid input, please enter one of the following: 'one', 'two', 'both'. ");
					count--;	//if input is wrong, it is still the same players turn, the count increments each loop to affect the player title, count-- used to counteract this increment.
				}else{
					
						if (whichBarrel.equals("both")){ 
							
							if (numberOfBiscuits > leastFullBarrel){	//if there are not enough biscuits in the barrel with the fewest biscuits
								System.out.println("There are not enough biscuits in each barrel"); 
								count--;	//see line 63
							}else{
								barrelOne = (barrelOne - numberOfBiscuits);	//if there are enough biscuits in both barrels
								barrelTwo = (barrelTwo - numberOfBiscuits);
								}
								
						}
						else if (whichBarrel.equals("one")){			 
							barrelOne = (barrelOne - numberOfBiscuits);	
							
							if (barrelOne < EMPTY_BARREL){	//if barrel one becomes less than empty (negative numbers) there are not enough biscuits
								barrelOne = (barrelOne + numberOfBiscuits);
								System.out.println("There are not enough biscuits in that barrel");
								count--;	//see line 63
							}
							
						}		
						else if (whichBarrel.equals("two")){
							barrelTwo = (barrelTwo - numberOfBiscuits);
							
							if (barrelTwo < EMPTY_BARREL){	//if barrel two becomes negative
								barrelTwo = (barrelTwo + numberOfBiscuits);
								System.out.println("There are not enough biscuits in that barrel");
								count--;	//see line 63
							}
						}
				}
			}
		}
		System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
		System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);
		System.out.println("Winner is " + winner);
	}

}

