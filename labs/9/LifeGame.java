// File: LifeGame.java 
// Author: Seth Roller
// Date: 3/20/18
// Purpose: Defines the non-trivial LifeGame operations.
 
import java.util.*; // Scanner
import java.io.*;   // File
 
public class LifeGame
{
 
    private int myRows;
    private int myCols;
    private int[][] myGrid;
 	
    // ++++++++++++++++++++++++++++++++++++++++++++++++++
    // * LifeGame constructor.                          *
    // * Receive: fileName, a string.                   *
    // * Precondition: fileName contains the name of    *
    // *   a file containing a Life configuration       *
    // *   (the number of rows, the number of columns,  *
    // *    and the values of each cell).               *
    // * Postcondition: myGrid has been initialized     *
    // *    to the configuration in fileName.           *
    // ++++++++++++++++++++++++++++++++++++++++++++++++++
	
    public LifeGame(String fileName)
    {
	Scanner theFile = null;
	try
	{
	    theFile = new Scanner(new File(fileName));
	}

	catch (FileNotFoundException e)
	{
	    System.out.println("File " + fileName + " not found.");
	    System.exit(1);
	}
	
	myRows = theFile.nextInt();
	myCols = theFile.nextInt();

	myGrid = new int[myRows + 2][myCols + 2];

	for (int r = 0; r < myRows + 2; r++)
	    for (int c = 0; c < myCols + 2; c++)
		myGrid[r][c] = 0;

	for (int r = 1; r < myRows + 1; r++)
	    for (int c = 1; c < myCols + 1; c++)
		myGrid[r][c] = theFile.nextInt();
    }
 
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // * LifeGame columns extractor.                        *
    // * Return: the number of columns in my configuration. *
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    public int columns()
    {
	return myRows;
    }
    
    // ++++++++++++++++++++++++++++++++++++++++++++++++++*
    // * LifeGame rows extractor.                        *
    // * Return: the number of rows in my configuration. *
    // ++++++++++++++++++++++++++++++++++++++++++++++++++*
    
    public int rows()
    {
	return myCols;
    }
    
    // ++++++++++++++++++++++++++++++++++++++++++++++++++*
    // * LifeGame cell Value extractor.                  *
    // * Return: the value in cell [row][col]            *
    // ++++++++++++++++++++++++++++++++++++++++++++++++++*
    
    public int cellValue(int row, int col)
    {
	return myGrid[row][col];
    }
    
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // * Mutator to generate next LifeGame generation.      *
    // * Postcondition: For each cell myGrid[r][c]:         *
    // *   if myGrid[r][c] had 3 living neighbors:          *
    // *     myGrid[r][c] contains a 1.                     *
    // *   if myGrid[r][c] had less than 2 neighbors OR     *
    // *       myGrid[r][c] had more than 3 neighbors:      *
    // *     myGrid[r][c] contains a 0.                     *
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    public void nextGeneration()
    {
	int[][] tempGrid = new int[myRows + 2][myCols + 2];
	
	for (int r = 1; r < myRows + 1; r++)
	    for (int c = 1; c < myCols + 1; c++)
	    {
		int cellCount = 0;
		cellCount = myGrid[r - 1][c - 1] + myGrid[r - 1][c] +
		    myGrid[r - 1][c + 1] + myGrid[r][c - 1] +
		    myGrid[r][c + 1] + myGrid[r + 1][c - 1] +
		    myGrid[r + 1][c] + myGrid[r + 1][c + 1];

		switch (cellCount)
		{
		    
		case 0:
		case 1:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		    tempGrid[r][c] = 0; //dies
		    break;
		case 2:
		    // no change
		    tempGrid[r][c] = myGrid[r][c];
		    break;
		case 3:
		    // cell birth
		    tempGrid[r][c] = 1;
		    break;
		default:
		    System.out.println("Bad count " + cellCount +
				       " for cell [" + r + "][" +
				       c + "]");
		   
		} // end of switch

	    } // end of for loop
	myGrid = tempGrid;
	
    } // end of nextGeneration
    
 
 
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // * LifeGame toString function member.                 *
    // * override the toString method to display the array  *
    // * Return: a String containing my configuration.      *
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String toString()
    {
	String value = "";
	for (int r = 1; r < myRows + 1; r++)
	{
	    for (int c = 1; c < myCols + 1; c++)
	    {
		if (myGrid[r][c] == 1)
		    value = value + "* ";
		else
		    value = value + "  ";	
	    }
	    
	    value = value + "\n"; 
	}
	return value; 
    }
    
} // end of the class
