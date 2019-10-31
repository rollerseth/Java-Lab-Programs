// File: Append2.java// Author: Seth Roller// Date: 4/17/18// Purpose: compares the time required to append 1 values at the end of the// listsimport java.util.*;  //ArrayList and LinkedListimport java.io.*;    // PrintStreampublic class Append2 {  static PrintStream theScreen = new PrintStream(System.out);  static Scanner theKeyboard = new Scanner(System.in);	public static void main(String args[])	{			HOJTimer theTimer = new HOJTimer();		// create a HOJTimer			theScreen.print("\nAppend Timing Test 2:\n"       			+ " Enter the size of the list to append to: ");		int n = theKeyboard.nextInt();		// Linked List Based List		                                                    		LinkedList<Integer> aLinkedList = null;		//declare it			aLinkedList = new LinkedList<Integer>();		// build empty linked list		for (int i = 0; i < n; i++)		    aLinkedList.add(new Integer(i));		// append n values		//  to list		theTimer.start();		// start timer		aLinkedList.add(new Integer(1));		//  add one value to list		theTimer.stop();		// stop timer				theScreen.println("\nAppending one value to a LinkedList " +				  " took : " + theTimer.getTime()				  + " seconds.");						// Array Based List		ArrayList<Integer> anArrayList = null;		//declare it		anArrayList = new  ArrayList<Integer>(n);		// build empty list		for (int i = 0; i < n; i++)		    anArrayList.add(new Integer(i));		// append n values		//  to list		theScreen.println("\nSize of ArrayList before append is : " +			 anArrayList.size() + ".");                		theTimer.start();		// start timer		anArrayList.add(new Integer(1));		// add one value to list		theTimer.stop();		// stop timer		theScreen.println("\nSize of ArrayList after append is : " +			 anArrayList.size() + ".");                                                    						theScreen.println("\nAppending one value to an "				  + "ArrayList took : "				  + theTimer.getTime() + " seconds.");		theScreen.println();                                                    	}    }//end of class