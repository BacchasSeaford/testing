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
        from = 1;
        int i = 0;
        String x = "9999999999";
        while (i != 6){
            if (i == 0){
            if (phoneNum <1000000000 || phoneNum > Long.parseLong(x)){
                phoneNum = atm.getCustomerConsole().readPhonenum(
                    "Please enter the phone number");
                i = 66; 
            }
         }
            else {            
                if (phoneNum <1000000000 || phoneNum > Long.parseLong(x)){
                phoneNum = atm.getCustomerConsole().readPhonenum(
                    "Phone number Invalid \nPlease enter a valid phone number");
                i = 66; 
            }
            else{
            i = 6;}} }
        String [] amountOptions = { "1", "2", "5", "10", "15" };
        Money [] amountValues = { 
                                  new Money(135), new Money(235), new Money(535),
                                  new Money(1035), new Money(1535)
                                };
        String amountMessage = "";
        String [] credit ={""};
        amount = amountValues [ 
                atm.getCustomerConsole().readMenuChoice(
                    amountMessage + "Enter number of credit \nCredit cost equal number * 100 + 35 \nAll top up is paid for by savings account", amountOptions) ];
 
        String [] confirmOption = { "Confirm","Select cancel button" };
        int [] Values = { 
                                  1,2
                                };
          to = Values [ 
                atm.getCustomerConsole().readMenuChoice(
                     "Hit 1 or 2 number to confirm \nor \ncancel button to cancel", confirmOption) ];
 
        
        return new Message(Message.Topup, card, pin, serialNumber, from, 5, amount, phoneNum);

    }
        protected Receipt completeTransaction()
    {
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[3];
                detailsPortion[0] = "Topup paid for by: " + 
                                    AccountInformation.ACCOUNT_NAMES[from]+" Account";
                detailsPortion[1] = "Topup was sent to: " + phoneNum;
                detailsPortion[2] = "Total cost for top up is: " + amount;
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
    private long phoneNum;  
}
