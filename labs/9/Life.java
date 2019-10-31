// File: Life.java 
// Author: Seth Roller
// Date: 3/20/18
// Purpose: To play the game of life
 
import java.util.*;  // Scanner
import java.io.*;    // PrintStream
 
 
public class Life {
 
    static PrintStream theScreen = new PrintStream(System.out);
    static Scanner theKeyboard = new Scanner(System.in);
 
    public static void main( String args[])
    {
 	
	theScreen.print("\nEnter the name of "
			+ "the initial configuration file: ");
		
	String inFile, str;
	inFile = theKeyboard.nextLine();
 
	// initialize the game
	LifeGame theGame = new LifeGame(inFile);
 
 
	int count = 0;
	while(true)
	{
	    // display current configuration
	    theScreen.println(theGame);
	    theScreen.println("\nGeneration " + count
			      + " - press 'Enter' for the next "
			      + "generation or type 'done' to finish");
	    str = theKeyboard.nextLine();
	    
	    if (str.equals("done")) break;
 
	    // generate next configuration
	    theGame.nextGeneration();
	    count++;
	}
    }
}
