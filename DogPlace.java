/*
Author: slothsenpai

This challenge pertains to a dog show, so your dog has placed at a dog show and you need a program
which lists all the places your dog did not place in plain english (1st, 2nd, 3rd, etc)
The program is to list all the places between 1st and 100th excluding the placement of your dog
A bonus stipulation is to allow for placements greater than 100 which I have included

Coding Start: 5/21/16 6:10pm
Coding Complete: 5/21/16 8:21pm 
*/

import java.util.*;


public class DogPlace
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);		//Scanner which will be used to ask for the number of possible placements
		Random rand = new Random();		//Random to generate your dog's placement
		int ctr = 1;		//counter int which will cycle through all the remaining places
		int possPlaces = -1;	//int which will store the number of possible placements
		int yourPlace = -1;		//int which will store the placement of your dog
		String strPlace = "";	//String which will hold the string version of the yourPlace variable	
		String holder = "";		//String which will temporarily store user input in case it isn't an int
		boolean clear = false;  //boolean which will help which input validation below
		System.out.println("How many possible placements were there in the dog show?");		//Prompt asking the user how many places were possible in the dog show
		while(clear != true)	//while loop which will run until the user has input an int greater than zero
		{
			holder = input.nextLine();	//Stores user input as a string
			try
			{
				possPlaces = Integer.parseInt(holder);		//tries to parse an int from the string variable holder 
				if(possPlaces > 0)		//if a positive int was parsed from holder, the boolean controlling the while loop is set to true. thus the loop is exited
				{
					clear = true;	
				}
				else
				{
					System.out.println("Please enter a positive integer");	//If a negative int was parsed, a prompt asks the user for a positive int
				}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Please enter an integer");	//If something which was not an int was parsed, a prompt is displayed asking the user to input an int
			}
		}
		
		yourPlace = rand.nextInt(possPlaces) + 1;		//Random int is selected from 1 to the int chosen for possPlaces, this represents the placement of your dog
		strPlace = Integer.toString(yourPlace);
		
		System.out.print("\nCongratulations! Your dog placed ");
		placePrinter(strPlace);
		System.out.println(" place!");
		//The three lines above display your dog's placement by calling the placePrinter method and passing strPlace as an argument
		
		System.out.println("\nThe remaining places are: \n");
		while(ctr < possPlaces)
		{
			
			for(int i = 0; i < 10; i++)
			{
				if(ctr == yourPlace)
				{
					ctr++;
					i--;
				}
				else if(ctr == possPlaces)
				{
					holder = Integer.toString(ctr);
					placePrinter(holder);
					i = 10;
				}
				else
				{
					holder = Integer.toString(ctr);
					placePrinter(holder);
					System.out.print(", ");
					ctr++;
				}
			}
			System.out.println("");
			
		}
		
		//The while loop above will cycle through the remaining places until the last one has been reached
		//Each place is passed into the placePrinter method as an argument
		//the ctr variable is used as a counter for the current place while the string variable holder gets 
		//reused as a string version of whatever int ctr is on
		//The for loop simply formats the printing into chunks of ten numbers so the numbers don't
		//run off to the right indefinitely
		//The empty println is also used for formatting, it serves to add a newline after ten numbers have been printed
		
		
		
	}
	
	public static void placePrinter(String place)
	{
		if(place.length() > 1)
		{
			if(place.charAt(place.length() - 2) == '1')
			{
				System.out.print(place + "th");
			}
			else if(place.charAt(place.length() - 1) == '1')
			{
				System.out.print(place + "st");
			}
			else if(place.charAt(place.length() - 1) == '2')
			{
				System.out.print(place + "nd");
			}
			else if(place.charAt(place.length() - 1) == '3')
			{
				System.out.print(place + "rd");
			}
			else
			{
				System.out.print(place + "th");
			}
		}
		else if(place.charAt(place.length() - 1) == '1')
		{
			System.out.print(place + "st");
		}
		else if(place.charAt(place.length() - 1) == '2')
		{
			System.out.print(place + "nd");
		}
		else if(place.charAt(place.length() - 1) == '3')
		{
			System.out.print(place + "rd");
		}
		else
		{
			System.out.print(place + "th");
		}
	}
	/*
		The placePrinter method is a void returning method which takes a string as its only argument
		placePrinter first checks to see if the length of the string argument is greater than one
		if so, placePrinter then checks to see if the second character is '1' in which case
		every number should have a "th" after it and the number is printed as such
		
		If the second character is not '1', placePrinter checks to see if the last character in the string
		is '1', '2', or '3' and prints "st", "nd", or "rd" after that number, respectively
		
		If the string argument is not greater than one character, the same check for '1', '2', and '3' is performed
		and the correct suffix is printed
		
		If '1', '2', or '3' is not the character found, the "th" suffix is printed
	*/
}