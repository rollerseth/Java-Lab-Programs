// File: CDAccount.java
// Author: Seth Roller
// Date: 4/11/18
// Purpose: To create a new CD Account

package AccountKinds;

public class CDAccount extends ProtectedAccount
{
    static public double INTEREST_RATE = 0.15;
    public int MONTHS_GONE_BY = 0;
    
    /**
     * CDAccount constructor
     *
     * Input: name of account holder, and PIN, and initial balance
     **/
    public CDAccount( String name, String pin, double initial) 
    {
	super(name, pin);
	deposit(initial);
	setRate(INTEREST_RATE);
	
    }

    public void withdraw( double amount, String pin)
    {
	if (super.getMonthsPassed < 12)
	{
	    super.withdraw(amount + (super.getBalance * 0.20),pin);		
	}

	else
	{
	    super.withdraw(amount, pin);
	}    
    }

    public void deposit( double amount, String pin)
    {
	super.deposit(amount, pin);
    }

    public double computeFees()
    {
	

    }

}
