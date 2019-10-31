// File: Calculate2.java
// Date: 3/13/18
// Author: Seth Roller
// Purpose: To perform basic arithmetic


import java.util.*;  // Scanner
import java.io.*;    // PrintStream

class Calculate2 extends Object
{

    public static void main(String args[])
    {
	
	PrintStream theScreen = new PrintStream(System.out);
	Scanner theKeyboard = new Scanner(System.in);
	

	final String MENU = "\nPlease enter:\n" +
	    "\ta, to perform addition;\n" +
	    "\tb, to perform subtraction;\n" +
	    "\tc, to perform multiplication;\n" +
	    "\td, to perform division;\n" +
	    "\te, to perform exponentiation;\n" +
	    "\tf, to exit the program;\n" +
	    "--> ";
                      	
	double op1 = 0.0, op2 = 0.0;
	
	theScreen.println("\nWelcome to the 5-function calculator!\n");

	while (true)
	{
	char operation = getMenuChoice(MENU, theKeyboard, 'a', 'f');

	if (operation == 'f') break;

	while (true)
	{
	    
	theScreen.print("\nNow enter your operands: ");

	try
	{
	    
	op1 = theKeyboard.nextDouble();
	op2 = theKeyboard.nextDouble();
	String junk = theKeyboard.nextLine();
	break;
	}
	catch (InputMismatchException ex)
	{
	    System.out.println();
	    System.out.println("\nERROR: entered a non-number!");
	    System.out.println("\nPlease try again!");
	    String junk = theKeyboard.nextLine();


	}
		
	}// end of inner while
	
	if (operation == 'd' && op2 == 0.0)
	    {
		theScreen.println("ERROR: division by 0.");
		System.exit(1);		   
	    }
	
	double result = apply(operation, op1, op2);

	theScreen.println();
	theScreen.println("\nThe result is " + result);

	} //end of while
    }
	
    private static char getMenuChoice(String MENU, Scanner theKeyboard,
				      char first, char last)
    {
	char choice;
	do
	    {
		System.out.print(MENU);
		choice = theKeyboard.nextLine().charAt(0);
	    } while ((choice < first) || (choice > last));
	    return choice;
    }

    private static double apply(char operation, double op1, double op2)
    {
	switch (operation)
	    {
	    case 'a':
		return op1 + op2;
	    case 'b':
		return op1 - op2;
	    case 'c':
		return op1 * op2;
	    case 'd':
		return op1 / op2;
	    case 'e':
	      	return power(op1, (int) op2);
	    default:
		System.out.println("\nInvalid operation " + operation
				   + " received by calculator!\n");
	    }
	return 0.0;
    }

    public static double power(double op1, int op2)
    {

	double product = 1;
	for (int i = 1; i <= op2; i++)
	    {
		product = product * op1;
		
	    }
	return product;
    }

    
} // end of class
