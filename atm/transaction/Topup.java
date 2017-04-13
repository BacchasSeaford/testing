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
import java.util.Scanner;
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
        Simulation.getInstance().display("Please enter your Phone number\n");
//        phoneNum1 = new TextField(10);
//        phoneNum1.setText("");
//        from = Integer.parseInt(phoneNum1.getText());
        return new Message(Message.Topup, card, pin, serialNumber, from, 5, new Money(100));
    }
  
        protected Receipt completeTransaction()
    {
        return new Receipt(this.atm, this.card, this, this.balances) {
            {
                detailsPortion = new String[1];
                detailsPortion[0] = "Topup to: " + 
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
    private TextField phoneNum1;
    
}
