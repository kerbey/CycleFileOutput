package cyclefileoutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass
{
	public static void main(String[]args)
	{
		double numberOfWheels=0, weight=0;
		Scanner input= new Scanner(System.in);
		String a;
		try
		{		
			System.out.println("enter a number of wheels");
			numberOfWheels= input.nextDouble();
			System.out.println("enter in the weight");
			weight = input.nextDouble();
			if(numberOfWheels>0||weight>0)
			{
				Cycle d= new Cycle(numberOfWheels, weight);
				a=d.ToString();
				System.out.println("\n"+a+".");
			}
			else 
			{//new throws exception for numbers less  than or equals to zero 
				//which prints out to the catch statement below
				throw new Exception();
			}	
		}
		catch(InputMismatchException e2)
		{
			System.out.println("You can't enter letters in");
		}
		catch(Exception e)
		{//catch for numbers less than or equal to zero 
			System.out.println("You can't enter in values that are less than or equal to zero.");	
		}
	}
}