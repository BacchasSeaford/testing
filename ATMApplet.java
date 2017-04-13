/*
 * ATM Example system - file ATMApplet.java
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
 
import java.awt.*;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.*;
import java.applet.Applet;
import atm.ATM;
import simulation.Simulation;
import java.awt.event.*;
/** Applet class for the applet version of the ATM simulation.
 *  Create an instance of the ATM, display in the applet, and then let the GUI
 *  do the work.
 */
 
public class ATMApplet extends ATMMain
{
    public void init()
    {
        // Create the ATM software and the software that simulates it via a GUI
        
        ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                             null /* We're not really talking to a bank! */);
        Simulation theSimulation = new Simulation(theATM);
        
        // Start the Thread that runs the ATM
        
        new Thread(theATM).start();
        
        // Display the simulation's GUI in this applet
        
        Panel gui = theSimulation.getGUI();
        //setBackground(gui.getBackground());
        //add(gui);
    }
}
    