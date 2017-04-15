/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Seaford Bacchas 
 */
public class phone extends Panel {
    public void CardPanel()
    {
        setLayout(new GridLayout(0, 1, 0, 0));
        setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        add(new Label("Phone number should be area code and your phone number ",
                      Label.CENTER));
        add(new Label("(999)999-9999",
                      Label.CENTER));
      
        cardNumberField = new TextField(30);
//        cardNumberField.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e)
//            {
//                synchronized(CardPanel.this)
//                {
//                    CardPanel.this.notify();
//                }
//            }
//        });
        Panel cardNumberPanel = new Panel();
        cardNumberPanel.add(cardNumberField);
        add(cardNumberPanel);
    }
    
    /** Ask the customer to enter the number on the card
     *
     *  @return the number entered
     */
    public synchronized int readCardNumber()
    {
        cardNumberField.setText("");
        
        cardNumberField.requestFocus();
        try
        {
            wait();
        }
        catch(InterruptedException e)
        { }
                
        int cardNumber;
        try
        {
            cardNumber = Integer.parseInt(cardNumberField.getText());
            if (cardNumber <= 0)
                cardNumber = -1;
        }
        catch(NumberFormatException e)
        {
            cardNumber = -1;
        }
        
        return cardNumber;
    }

    /** The field into which the card number is to be entered
     */
    private TextField cardNumberField;
    
}
