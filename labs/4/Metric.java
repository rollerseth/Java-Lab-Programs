// File: Metric.java 
// Author: Seth Roller
// Date: 2/6/18
// Purpose: Utilizes Driver.java's functions 


public class Metric extends Object
{

//***********************************************************
// feetToMeters() converts feet into meters.                *
// Receive: feet, the (real) number of feet to be converted.*
// Precondition: feet >= 0.                                 *
// Return: The equivalent number of meters.                 *
//***********************************************************

    public static double feetToMeters(double feet)
    {

	double meters;

	if (feet >=0)
	    {
		meters = 0.3048 * feet;
		return meters;

	    }
	
	throw new IllegalArgumentException("In feetToMeters, feet must be" +
					   " be >0, not " + feet);




    }


}
