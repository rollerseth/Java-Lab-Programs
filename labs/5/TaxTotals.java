//TaxTotals.java 
// Author: Seth Roller
// Date: 2/13/18
// Purpose: To display taxtotals of a prodcut

import java.util.*;

public class TaxTotals 
{
    public static void main(String args[]) 
    {
	Scanner sc = new Scanner(System.in);

	double pay = 0;
	
	System.out.println();
	
	System.out.print("This program computes total ");
	System.out.println("costs interactively.");
	System.out.println("Written by Seth Roller.");
	
	System.out.println();

	System.out.print("To begin, enter the number of items: ");
	int  numItems = sc.nextInt();

	System.out.println();
	System.out.println();
	// for turnin

	for(int itemNum = 1; itemNum <= numItems; itemNum++)
	    {

		System.out.print("Enter the item name, cost and tax "
				 + "rate for " + itemNum + ": ");

		String item = sc.next();
		double cost = sc.nextDouble();
		double rate = sc.nextDouble();

		System.out.println();
	       

		double amount = Tax.computeTotalCost(rate, cost);
		
		pay = pay + amount;
		
		System.out.print(item + " cost with tax is ");
		System.out.printf("$%2.2f", amount);
		System.out.println();
		System.out.println();
	    }


	System.out.print("The total cost of your " + numItems + " items");
	System.out.printf(" is $%1.2f", pay);
	System.out.println();
	System.out.println();

	
    }

}
