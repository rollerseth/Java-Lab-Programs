// File: Tax.java 
// Author: Seth Roller
// Date: 2/13/18
// Purpose: Compute tax information through cost and taxrate

public class Tax
{

    
    public static double computeTotalCost(double rate, double cost)
    {
	final double MIN_LUXURY = 100.0;
	final double LUXURY_RATE = 10.0;
	double regularCost, luxuryBase, luxurySurcharge, totalCost;

	if ((cost < 0) || (rate < 0))
	{
	    String message = ("in computerTotalCost, ");
	    message = message + "the values of cost and rate ";
	    message = message + "must be > 0, not ";
	    message = message + cost + " " + rate;
	    throw new IllegalArgumentException(message);
	
	
	
	}

	if (cost <= MIN_LUXURY)
	    return cost + cost * rate / 100.0;

	regularCost = cost + cost * rate / 100.0;
	luxuryBase = cost - MIN_LUXURY;
	luxurySurcharge = luxuryBase * LUXURY_RATE / 100.0;
	totalCost = regularCost + luxurySurcharge; 
	
	return totalCost;
    }



}
