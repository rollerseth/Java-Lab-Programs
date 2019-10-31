// File: Calculate.java
// Date: 2/20/18
// Author: Seth Roller
// Purpose: To perform simple arithmetic 


import java.util.*;  // Scanner
import java.io.*;    // PrintStream

class Calculate extends Object
{
  static PrintStream theScreen = new PrintStream(System.out);
  static Scanner theKeyboard = new Scanner(System.in);

  static final String MENU = "\nPlease enter:\n" +
                      	"\t+, to perform addition;\n" +
	              		"\t-, to perform subtraction;\n" +
                      	"\t*, to perform multiplication;\n" +
                      	"\t/, to perform division;\n" +
                        "\t^, to perform exponentiation; \n" +
                      	"--> ";

  public static void main(String args[])
  {

        theScreen.println();
  	theScreen.println("Welcome to the 5-function calculator!");
  	char operation;

	operation = getOp();
	
	theScreen.println();
  
	theScreen.println();

	double op1, op2;
	op1 = getDouble();
	theScreen.println();
	op2 = getDouble();
	
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
	else if (operation == '^')
	    {
		return power(op1, (int) op2);
	    }
	
	else
	{ 
	    	theScreen.println("ERROR: invalid operation. Must be "
       			+ "+, -, *, /, or ^ not " + operation);
       		System.exit(1);


	
	}

	return 0;
    }

    public static double getDouble()
    {
	String junk;
	
	while (true)
	    {
	        theScreen.print("Now enter your operand: ");

		if (theKeyboard.hasNextDouble())
		    {
			break;
		    }

		else
		    {
			junk = theKeyboard.nextLine();
			theScreen.println("ERROR, your input must be a "
					  + "double, not " + junk);
		    }

		
		
	    }

	double answer = theKeyboard.nextDouble();
	junk = theKeyboard.nextLine();
	return answer;



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
    
    public static char getOp()
    {
	while (true)
	    {
		theScreen.print(" " + MENU);

		char operation = theKeyboard.nextLine().charAt(0);

		if (operation != '+' && operation != '-' &&
		    operation != '*' && operation != '/'
		    && operation != '^')
		    {
			theScreen.println("ERROR: invalid operation. Must "
       			+ "be" + "+, -, *, /, or ^ not " + operation);
       
		    }
		else
		    {
			return operation;

		    }

	    }

	    
    }

    

}
