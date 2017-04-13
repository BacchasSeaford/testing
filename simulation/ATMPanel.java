/*
 * ATM Example system - file ATMPanel.java  
 *
 * copyright (c) 2001 - Russell C. Bjork
 *
 */
 
package simulation;

import atm.ATM;

import java.awt.*;
import java.awt.event.*;

/** The GUI panel that simulates the ATM itself
 */
class ATMPanel extends Panel
{
    /** Constructor
     *
     *  @param gui the the overall GUI
     *  @param operatorPanel the simulation of the card reader
     *  @param cardReader the simulation of the card reader
     *  @param display the simulation of the display
     *  @param keyboard the simulation of the keyboard
     *  @param cashDispenser the simulation of the cash dispenser
     *  @param receiptPrinter the simulation of the receipt printer
     */
    ATMPanel(final GUI gui,
             SimOperatorPanel operatorPanel,
             SimCardReader cardReader,
             SimDisplay display,
             SimKeyboard keyboard,
             SimCashDispenser cashDispenser,
             SimEnvelopeAcceptor envelopeAcceptor,
             SimReceiptPrinter receiptPrinter)
    {
        GridBagLayout atmLayout = new GridBagLayout();
        setLayout(atmLayout);
        
        // Add the operator panel
        
        add(operatorPanel);
        atmLayout.setConstraints(operatorPanel,
                GUI.makeConstraints(OPERATOR_ROW, OPERATOR_COL,
                                OPERATOR_WIDTH, OPERATOR_HEIGHT,
                                OPERATOR_FILL));
                                
        // Put cardReader in a Panel with GridLayout to ensure it gets space
        // even when invisible, then add it
        
        Panel cardReaderPanel = new Panel();
        cardReaderPanel.setLayout(new GridLayout(1,1));
        cardReaderPanel.add(cardReader);
        add(cardReaderPanel);
        atmLayout.setConstraints(cardReaderPanel, 
                GUI.makeConstraints(READER_ROW, READER_COL,
                                READER_WIDTH, READER_HEIGHT, 
                                READER_FILL));
                                
        // The customer console consists of two components (display and keyboard)
        // that must be added individually in different places in the GUI
        
        add(display);
        atmLayout.setConstraints(display, 
                GUI.makeConstraints(DISPLAY_ROW, DISPLAY_COL,
                                DISPLAY_WIDTH, DISPLAY_HEIGHT,
                                DISPLAY_FILL));
                                
        add(keyboard);
        atmLayout.setConstraints(keyboard,
                GUI.makeConstraints(KEYBOARD_ROW, KEYBOARD_COL,
                                KEYBOARD_WIDTH, KEYBOARD_HEIGHT,
                                KEYBOARD_FILL));
                                
        // Add the cash dispenser
        
        add(cashDispenser);
        atmLayout.setConstraints(cashDispenser,
                GUI.makeConstraints(DISPENSER_ROW, DISPENSER_COL,
                                DISPENSER_WIDTH, DISPENSER_HEIGHT,
                                DISPENSER_FILL));                                
                                
        // Put envelope acceptor in a Panel with GridLayout to ensure it gets space
        // even when invisible, then add it
        
        Panel envelopeAcceptorPanel = new Panel();
        envelopeAcceptorPanel.setLayout(new GridLayout(1,1));
        envelopeAcceptorPanel.add(envelopeAcceptor);
        add(envelopeAcceptorPanel);
        atmLayout.setConstraints(envelopeAcceptorPanel,
                GUI.makeConstraints(ENVELOPE_ROW, ENVELOPE_COL, 
                                ENVELOPE_WIDTH, ENVELOPE_HEIGHT,
                                ENVELOPE_FILL));
        envelopeAcceptor.setVisible(false);
        
        // Add the receipt printer
        
        add(receiptPrinter);
        atmLayout.setConstraints(receiptPrinter,
                GUI.makeConstraints(PRINTER_ROW, PRINTER_COL,
                                PRINTER_WIDTH, PRINTER_HEIGHT,
                                PRINTER_FILL));
                                
        // Add a button for showing the log
        
        Panel showLogButtonPanel = new Panel();
        showLogButtonPanel.setBackground(operatorPanel.getBackground());
        Button showLogButton = new Button("Show Log");
        showLogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                gui.showCard("LOG");
            }
        });
        showLogButtonPanel.add(showLogButton);
        add(showLogButtonPanel);
        atmLayout.setConstraints(showLogButtonPanel,
                GUI.makeConstraints(SHOW_LOG_BUTTON_ROW, SHOW_LOG_BUTTON_COL,
                                SHOW_LOG_BUTTON_WIDTH, SHOW_LOG_BUTTON_HEIGHT,
                                SHOW_LOG_BUTTON_FILL));
    }

    // The GUI representing the ATM is laid out using a GridBagLayout.  
    // The following constants determine the positioning of the various
    // components within the grid bag.  Each component has a row and column
    // coordinate for its upper left hand corner, plus a height in rows and
    // a width in columns.  The following is the arrangement:
    
    // ----------------------------------------------------------------------
    // |       DISPLAY                                     |     RECEIPT    |
    // |                                                   |     PRINTER    |
    // |                                                   |                |
    // |                                                   |                |
    // |                                                   |                |
    // |                                                   |                |
    // |                                                   |                |
    // |                                                   |                |
    // |--------------------------------------------------------------------|
    // |  ENVELOPE       |    CASH        |    CARD        |   KEYBOARD     |
    // |  ACCEPTOR       |    DISPENSER   |    READER      |                |
    // |                 |                |                |                |
    // |                 |                |                |                |
    // |                 |                |                |                |
    // |                 |                |                |                |
    // ----------------------------------------------------------------------
    // | SHOW LOG BUTTON | OPERATOR PANEL                                   |
    // |                 |                                                  |
    // ----------------------------------------------------------------------
    
    // The following constants govern the size of various components, and
    // need to be used by the component
    
    public static final int DISPLAYABLE_LINES =     9;
    public static final String BLANK_DISPLAY_LINE = 
        "                                             ";
    public static final int PRINTABLE_LINES =       9;
    public static final int PRINTABLE_CHARS =      30;
    
    // The following are used only for doing the layout

    private static final int DISPLAY_ROW =          0;
    private static final int DISPLAY_COL =          0;
    private static final int DISPLAY_WIDTH =        3;
    private static final int DISPLAY_HEIGHT =       1;
    private static final int DISPLAY_FILL =         GridBagConstraints.BOTH;
    
    private static final int PRINTER_ROW =          0;
    private static final int PRINTER_COL =          DISPLAY_COL + DISPLAY_WIDTH;
    private static final int PRINTER_WIDTH =        1;
    private static final int PRINTER_HEIGHT =       1;
    private static final int PRINTER_FILL =         GridBagConstraints.NONE;
    
    private static final int ENVELOPE_ROW =         DISPLAY_ROW + DISPLAY_HEIGHT;
    private static final int ENVELOPE_COL =         0;
    private static final int ENVELOPE_WIDTH =       1;
    private static final int ENVELOPE_HEIGHT =      1;
    private static final int ENVELOPE_FILL =        GridBagConstraints.NONE;
        
    private static final int DISPENSER_ROW =        ENVELOPE_ROW;
    private static final int DISPENSER_COL =        ENVELOPE_COL + ENVELOPE_WIDTH;
    private static final int DISPENSER_WIDTH =      1;
    private static final int DISPENSER_HEIGHT =     1;
    private static final int DISPENSER_FILL =       GridBagConstraints.NONE;

    private static final int READER_ROW =           ENVELOPE_ROW;
    private static final int READER_COL =           DISPENSER_COL + DISPENSER_WIDTH;
    private static final int READER_WIDTH =         1;
    private static final int READER_HEIGHT =        1;
    private static final int READER_FILL =          GridBagConstraints.NONE;
    
    private static final int KEYBOARD_ROW =         ENVELOPE_ROW;
    private static final int KEYBOARD_COL =         READER_COL + READER_WIDTH;
    private static final int KEYBOARD_WIDTH =       1;
    private static final int KEYBOARD_HEIGHT =      1;
    private static final int KEYBOARD_FILL =        GridBagConstraints.NONE;
    
    private static final int SHOW_LOG_BUTTON_ROW =  ENVELOPE_ROW + ENVELOPE_HEIGHT;
    private static final int SHOW_LOG_BUTTON_COL =  0;
    private static final int SHOW_LOG_BUTTON_WIDTH= 1;
    private static final int SHOW_LOG_BUTTON_HEIGHT=1;
    private static final int SHOW_LOG_BUTTON_FILL = GridBagConstraints.BOTH;
    
    private static final int OPERATOR_ROW =         SHOW_LOG_BUTTON_ROW;
    private static final int OPERATOR_COL =         SHOW_LOG_BUTTON_COL + SHOW_LOG_BUTTON_WIDTH;
    private static final int OPERATOR_WIDTH =       3;
    private static final int OPERATOR_HEIGHT =      1;
    private static final int OPERATOR_FILL =        GridBagConstraints.BOTH;
    
    private static final int TOTAL_ROWS = 3;
    private static final int TOTAL_COLS = 3;
}
                                     