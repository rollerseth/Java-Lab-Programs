// File: DoubleArrayOps.java 
// Date: 2/27/18
// Author: Seth Roller
// Purpose: Defines common operations for double[].


import java.io.*;    // PrintStream

public class DoubleArrayOps
{

	// *****************************************************
	// subArray returns a sub sequence from an array       *
	//                                                     *
	// Receive: data, an array of doubles,                 *
	//          start, an integer, and                     *
	//          stop, an integer.                          *
	// Preconditions: stop >= start                        *
	//                start >= 0                           *
	//                stop < data.length                   *
	// Output: a sub sequence of the original array.       *
	//******************************************************
	public static double[] subArray(double data[], int start, int stop) 
	{
		double newData[] = new double[stop-start+1];
		
		int storeAt = 0;
		for (int i = start; i<= stop; i++)
			newData[storeAt++] = data[i];
			
		return newData;
	}
	
	
	//**********************************************************
	//  output values in the array                             *
	// Receive: out, a PrintStream                                  *
	//           data, the double[] to be displayed.           *
	// PRE: data.size() == the number of values .              *
	//**********************************************************
	public static void printArray(PrintStream out, double data[]) 
	{
		for (int i = 0; i< data.length; i++)
			out.print(data[i] + " ");
	}	
	
	
	//****************************************
	// Compute the mean of a list of numbers.*
	// Receive: data, the list of numbers.   *
	// PRE: data.size() > 0.                 *
	// Return: the mean value.               *
	//****************************************

    public static double average(double[] scoreArr)
    {
	int num = scoreArr.length;
	double sum = 0.0;
	if (num <= 0)
	{
	    System.err.println("ERROR in function average.");
	    System.err.println("No data values in array.");
	    return 0.0;

	}

	for (int i = 0; i < num; i++)
	    sum = sum + scoreArr[i];

	return sum / num;
	   

    }
	
	//***************************************************
	// Compute standard deviation of a list of numbers. *
	// Receive: data, the list of numbers.              *
	// PRE: data.size() > 0.                            *
	// Return: the standard deviation of the list.      *
	//***************************************************

    public static double standardDev(double[] data)
    {
	double avg;
	double sumSqrTerms = 0.0;
	double term;

	avg = average(data);
	
	int numValues = data.length;

	for (int i = 0; i < numValues; i++)
	{
	    term = data[i] - avg;
	    sumSqrTerms += term * term;
	    
	}
	return Math.sqrt(sumSqrTerms / numValues);

    }
    

}
