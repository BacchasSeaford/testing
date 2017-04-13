/*
 * ATM Example system - file Balances.java
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
 
package banking;

/** Representation for customer's current account balances as returned by the 
 *  bank.  An empty object of this class is created and sent along with the
 *  transaction message; the bank fills it in with values.
 */

public class Balances
{
    /** Constructor.  Create an object whose values will be filled in later, when
     *  returning a value to the creator.
     */
    public Balances()
    {
    }
    
    /** Mutator.  Fill in values
     *
     *  @param total the total balance in the account
     *  @param available the available balance
     */
    public void setBalances(Money total, Money available)
    {
        this.total = total;
        this.available = available;
    }
    
    /** Accessor for total balance
     *
     *  @return total balance in the account
     */
    public Money getTotal()
    {
        return total;
    }
    
    /** Accessor for available balance
     *
     *  @return available balance
     */
    public Money getAvailable()
    {
        return available;
    }
    
    // Instance variables
    
    /** Current total balance in the account 
    */
    private Money total;
    
    /** Current available balance in the account
     */
    private Money available;
}