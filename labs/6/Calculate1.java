// File: Calculate.java
// Date: 2/20/18
// Author: Seth Roller
// Purpose: 


import java.util.*;  // Scanner
import java.io.*;    // PrintStream

class Calculate1 extends Object
{
  static PrintStream theScreen = new PrintStream(System.out);
  static Scanner theKeyboard = new Scanner(System.in);

  static final String MENU = "\nPlease enter:\n" +
                      	"\t+, to perform addition;\n" +
	              		"\t-, to perform subtraction;\n" +
                      	"\t*, to perform multiplication;\n" +
                      	"\t/, to perform division;\n" +
                      	"--> ";

  public static void main(String args[])
  {

        theScreen.println();
  	theScreen.println("Welcome to the 4-function calculator!");
	theScreen.print(" " + MENU);
  	char operation;

	operation = theKeyboard.nextLine().charAt(0);
	theScreen.println();
  	if (operation != '+' && operation != '-' &&
          		operation != '*' && operation != '/')
       {
       		theScreen.println("ERROR: invalid operation. Must be "
       			+ "+, -, *, or /, not " + operation);
       		System.exit(1);
       
       }
	theScreen.println();
	theScreen.print("Now enter your operands: ");

	double op1, op2;
	op1 = theKeyboard.nextDouble();
	op2 = theKeyboard.nextDouble();
	theScreen.println();
	if (operation == '/' && op2 == 0)
       {
       		theScreen.println("ERROR: division by 0.");
       		System.exit(1);
       
       }

	double result = apply(operation, op1, op2);

	theScreen.println();
	theScreen.println(op1 + " " + operation + " " + op2
       + " = " + result);
	theScreen.println();
  }

    public static double apply(char operation, double op1, double op2)
    {

	if (operation == '+')
	    {
		return (op1 + op2);

	    }

	else if (operation == '-')
	    {
		return (op1 - op2);
		
	    }

	else if (operation == '*')
	    {

		return (op1 * op2);

	    }

	else if (operation == '/')
	    {

		return (op1 / op2);
	    }

	else
	{ 
	    	theScreen.println("ERROR: invalid operation. Must be "
       			+ "+, -, *, or /, not " + operation);
       		System.exit(1);


	
	}

	return 0;
}

}
