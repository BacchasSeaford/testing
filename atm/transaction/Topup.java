package atm.transaction;

import atm.ATM;
import atm.Session;
import atm.physical.*;
import banking.AccountInformation;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Receipt;
import simulation.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Mobile Topup credit
 *
 * @author (Seaford Bacchas)
 * 
 */
public class Topup extends Transaction
{
    /**
     * Constructor for objects of class Topup
     */
    public Topup(ATM atm, Session session, Card card, int pin)
    {
        super(atm, session, card, pin);
    }
    
    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled
    {
        from = atm.getCustomerConsole().readMenuChoice(
            "Account to pay for credit",
            AccountInformation.ACCOUNT_NAMES);

        String [] amountOptions = { "1", "2", "5", "10", "15" };
        Money [] amountValues = { 
                                  new Money(135), new Money(235), new Money(535),
                                  new Money(1035), new Money(1535)
                                };
        String amountMessage = "";
        String [] credit ={""};
        amount = amountValues [ 
                atm.getCustomerConsole().readMenuChoice(
                    amountMessage + "Enter number of credit \n credit cost equal number * 100 + 35", amountOptions) ];
        phoneNum = atm.getCustomerConsole().readPhonenum(
                    "Please enter the phone number");

        
      //  Simulation.getInstance().display("Please enter your Phone number\n");
        return new Message(Message.Topup, card, pin, serialNumber, from, 5, amount);

    }
        protected Receipt completeTransaction()
    {
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[1];
                detailsPortion[0] = "Topup paid for by: " + 
                                    AccountInformation.ACCOUNT_ABBREVIATIONS[from];
              
            }
        };
    }
   
      /** Accounts to charge
     */
    private int from;
    
    /** phone to transfer credit to
     */
    private int to;
    
    /** money to pay for phone card 
     */
    private Money amount;
    /** Phone number
     */
    private int phoneNum;  
}
