// File: Driver.java 
// Author: Seth Roller
// Date: 2/6/18
// Purpose: Metric to English conversion 

import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a number to convert: ");
	
	double feet = sc.nextDouble();
	double meters = Metric.feetToMeters(feet);
	
	System.out.println();
	System.out.println();

	System.out.println(feet + " feet = " + meters + " meters");





    }



    
}
