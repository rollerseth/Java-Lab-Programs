// File: Grades.java 
// Date: 2/27/18
// Author: Seth Roller
// Purpose: Computes letter grades using the "curve" method.
	     
import java.util.*;  // Scanner
import java.io.*;    // PrintStream


class Grades extends Object
{
  static PrintStream theScreen = new PrintStream(System.out);
  static Scanner theKeyboard = new Scanner(System.in);

  public static void main(String args[])
      	throws FileNotFoundException

  {

//	define nameArr as an array of String objects
      String[] nameArr;
      
//	define scoreArr as an array of double objects
      double[] scoreArr;
      final int MAX_SCORES = 1000;

      nameArr = new String[MAX_SCORES];
      scoreArr = new double[MAX_SCORES];
      
      
      int scores = fillArraysFile(nameArr, scoreArr);

	//convert the array into one that just contains valid scores
      
	scoreArr = DoubleArrayOps.subArray(scoreArr, 0, scores-1);

	theScreen.print( "\nMean score: "
			 + DoubleArrayOps.average(scoreArr)
			 + "\n"
			 + "Std. Dev: "
			 + DoubleArrayOps.standardDev(scoreArr)
			 +"\n");
	theScreen.println();
	
//	define gradeArr as an array of character objects
	char[] gradeArr = new char[scores];

	gradeArr = computeLetterGrades(scoreArr);

	displayArrays( nameArr, scoreArr, gradeArr);
  }

// **********************************************************
// fillArrays fills nameArr and scoreArr from keyboard.     *
//                                                          *
// Receive: nameArr, an array of strings,                   *
//          scoreArr, an array of doubles.                  *
// Input: a sequence of names and scores,                   *
// Return: the number of scores read                        *
// Passback: the sequence of names in nameArr,              *
//           the sequence of scores in scoreArr.            *
// *********************************************************

    public static int fillArrays(String[] nameArr, double[] scoreArr)
    {

	theScreen.println();
	theScreen.println("Welcome to the grade calculator.");
	theScreen.println("Written by Seth Roller.");

	int numscores = 0;
	String name;
	double score;

	while (true)
	{
	    
	    theScreen.print("Enter a name (or 'done'): ");
	    name = theKeyboard.next();
	    theScreen.println();
	    
	    if (name.equals("done"))
		break;
	    theScreen.print("Now enter a score: ");
	    score = theKeyboard.nextDouble();
	    theScreen.println();
	    
	    nameArr[numscores] = name;
	    scoreArr[numscores] = score;

	    numscores++;


	}



	return numscores;


    }

    

// **************************************************** 
// Compute letter grades, using "curve" grading.      *
// Receive: scores, a list of scores.                 *
// Return: a list of the corresponding letter grades. *
// ***************************************************

    public static char[] computeLetterGrades(double[] scoreArr)
    {

	char[] gradeArr = new char[scoreArr.length];
	int numValues = scoreArr.length;

	if (numValues > 0)
	{
	    double avg = DoubleArrayOps.average(scoreArr);
	    double stnd = DoubleArrayOps.standardDev(scoreArr);
	    double F_CUT_OFF = avg - 1.5 * stnd;

	    double C_CUT_OFF = avg + 0.5 * stnd;
	    double D_CUT_OFF = avg - 0.5 * stnd;
	    double B_CUT_OFF = avg + 1.5 * stnd;

	    for (int i = 0; i < numValues; i++)
		if (scoreArr[i] < F_CUT_OFF)
		    gradeArr[i] = 'F';
	        else if (scoreArr[i] < D_CUT_OFF)
		    gradeArr[i] = 'D';
		else if (scoreArr[i] < C_CUT_OFF)
		    gradeArr[i] = 'C';
		else if (scoreArr[i] < B_CUT_OFF)
		    gradeArr[i] = 'B';
		else
		    gradeArr[i] = 'A';

	    return gradeArr;
	        
	}

	return gradeArr;
    }
    

// *****************************************************
// displayArrays displays the various arrays.          *
//                                                     *
// Receive: names, an array of strings,                *
//          scores, an array of doubles, and           *
//          grades, an array of chars.                 *
// Output: a sequence of names, scores and grades.     *
// ****************************************************

    public static void displayArrays(String[] nameArr,
				     double[] scoreArr,
				     char[] gradeArr)
    {

	int num = scoreArr.length;
	theScreen.println("Name     Score    Grade");
	theScreen.println();

	for (int i = 0; i < num; i++)
	    theScreen.printf("%-9s%4.2f      %c\n",
			     nameArr[i],
			     scoreArr[i],
			     gradeArr[i]);
	theScreen.println();

		

    }

// **********************************************************
// fillArrays fills nameArr and scoreArr from keyboard.     *
//                                                          *
// Receive: nameArr, an array of strings,                   *
//          scoreArr, an array of doubles.                  *
// Input: a sequence of names and scores,                   *
// Return: the number of scores read                        *
// Passback: the sequence of names in nameArr,              *
//           the sequence of scores in scoreArr.            *
// *********************************************************

    public static int fillArraysFile(String[] nameArr, double[] scoreArr)

	throws FileNotFoundException
	
    {

	theScreen.println();
	theScreen.println("Welcome to the grade calculator.");
	theScreen.println("Written by Seth Roller.");
	theScreen.println();
	theScreen.print("Enter the name of the file: ");
	theScreen.println();
	
	String fileName = theKeyboard.next();

	Scanner theFile = new Scanner(new File(fileName));
	
	int numscores = 0;
	String name;
	double score;

	while (true)
	{
	    
	    //theScreen.print("Enter a name (or 'done'): ");
	    name = theFile.next();
	    //theScreen.println();
	    
	    if (name.equals("done"))
		break;
	    //theScreen.print("Now enter a score: ");
	    score = theFile.nextDouble();
	    //theScreen.println();
	    
	    nameArr[numscores] = name;
	    scoreArr[numscores] = score;

	    numscores++;


	}

	return numscores;


    }

    

}
