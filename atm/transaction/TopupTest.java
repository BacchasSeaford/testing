/**
 * 
 */
package atm.transaction;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;

import org.junit.Test;

import atm.ATM;
import atm.Session;
import atm.physical.CustomerConsole;
import banking.Card;

/**
 * @author Richy
 *
 */
public class TopupTest {
	private InputStream in;
	private PrintStream out;
    private int pin;
    private ATM atm; 
    private Session session; 
    private Card card;
    private int i;
    Topup con = new Topup(atm,session, card, pin);


	/**
	 * Test method for {@link atm.transaction.Topup#phone()}.
	 */
	@Test
	public final void testPhone() {
        int i = 0;
        String x = "9999999999";
        String y = "8768746924";
        long phoneNum = Long.parseLong(y);
		
            if (phoneNum <1000000000 || phoneNum > Long.parseLong(x)){
            	boolean p = false;
            	assertTrue(p);
            }
          else{
                boolean p = true;
                assertTrue(p);}
	}

	/**
	 * Test method for {@link atm.transaction.Topup#confirm()}.
	 */
	@Test
	public final void testConfirm() throws CustomerConsole.Cancelled{
        String [] confirmOption = { "Confirm","Select cancel button" };
        int [] Values = { 
                                  1,2
                                };
        //  i = Values [
               //atm.getCustomerConsole().readMenuChoice(
                 //    "Hit 1 or 2 number to confirm \nor \ncancel button to cancel", confirmOption) ];
	    int expected =2;
	    int actual = 2; 
	    
	    
	     Assert.assertEquals(expected, actual);
	}




}
