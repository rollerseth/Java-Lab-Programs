//Hypot.java computes the hypotenuse length of a right triangle,
//  given the lengths of its two legs.
//
// Author: Seth Roller
// Date: 1/23/18
// Purpose: To become accustomed to object-centered design 
//
// Specification:
//   input(keyboard): first and second leg
//   output(screen):  hypotenuse which is a double value

import java.util.*;

public class Hypot 
{
    public static void main(String args[])
    {
	Scanner theKeyboard = new Scanner(System.in);

        double leg1, leg2;

	
	System.out.println();

	System.out.println("Given two right triangle leg lengths,");
	System.out.println("this program computes the hypotenuse length.");
	System.out.println("Written by Seth Roller.");

	System.out.println();

	// getting two sides of triangle

	System.out.print("Enter the length of side 1: ");
	
	leg1 = theKeyboard.nextDouble();
	System.out.println(); //turnin
	
	System.out.print("Enter the length of side 2: ");
	
	leg2 = theKeyboard.nextDouble();
        System.out.println(); //turnin
	System.out.println();

	double hypotenuse; 
	hypotenuse = Math.sqrt(Math.pow(leg1, 2.0) + Math.pow(leg2, 2.0));

	//output
	String s1;
	s1 = "For a triangle with sides of " + leg1;
	s1 = s1 + " and " + leg2;
	System.out.println(s1);

	String s2 = "the hypotenuse is ";
	System.out.print(s2);
	System.out.printf("%.3f",hypotenuse);
	System.out.println();

	System.out.println();

    }

}
	
