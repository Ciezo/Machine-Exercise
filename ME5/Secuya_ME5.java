import javax.swing.*;
import java.awt.Color;
// import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit; 
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Secuya_ME5 extends WindowAdapter implements MouseListener, ActionListener {
    
    static JPopupMenu contentPane = new JPopupMenu(); 
    // static JFrame container_Content = new JFrame(); 
    static JFrame frame = new JFrame("Secuya_BM5 Application");
    static MessagePanel msgP = new MessagePanel();

    // I remember that we should put attributes as a class member 
    // rather than have them inside and declared a private method
    static JCheckBoxMenuItem setVisibility_msg1; 
    static JCheckBoxMenuItem setVisibility_msg2; 
    static JRadioButtonMenuItem colorOpt1; 
    static JRadioButtonMenuItem colorOpt2; 

    
    private static void createAndShowGUI() {

        // Initializing basic set up 
        frame.getContentPane().setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().add(new MessagePanel());
        
        // Add this window listener which is self 
        frame.addWindowListener(new Secuya_ME5());  

        // Add mouse listener 
        frame.addMouseListener(new Secuya_ME5());

        // Create these menu items upon running instance 
            /** For contentPane */
            JMenu colorSet = new JMenu("Change text color");
            colorOpt1 = new JRadioButtonMenuItem("Change to black");
            colorOpt2 = new JRadioButtonMenuItem("Change to red"); 
            setVisibility_msg1 = new JCheckBoxMenuItem("Set Visible Message 1");
            setVisibility_msg2 = new JCheckBoxMenuItem("Set Visible Message 2");

                // Set the checkboxes to check by default 
                setVisibility_msg1.setSelected(true);
                setVisibility_msg2.setSelected(true);
            
                // Set the colorOpt1, "Change to black", by default on runtim 
                colorOpt1.setSelected(true); 
            
            
            // Add these items to the color set
            colorSet.add(colorOpt1); 
            colorSet.add(colorOpt2); 

            // Add the initialized components to the contentPane 
            contentPane.add(colorSet); 
            contentPane.add(setVisibility_msg1); 
            contentPane.add(setVisibility_msg2); 

        // Add listeners to the objects, "setVisibility_msg1" and "setVisibility_msg2"
        setVisibility_msg1.addActionListener(new Secuya_ME5());   
        setVisibility_msg2.addActionListener(new Secuya_ME5());

        // Add listeners to the objects of colorOpt1 and colorOpt2 
        colorOpt1.addActionListener(new Secuya_ME5());
        colorOpt2.addActionListener(new Secuya_ME5());
        
        // Try synonymous inner class
        colorOpt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorOpt1.isSelected()) {
                    msgP.setColor(Color.black); 
                }
            }

        }); 

        colorOpt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorOpt2.isSelected()) {
                    msgP.setColor(Color.red); 
                }
            }

        }); 

        // Set Action commands 
        setVisibility_msg1.setActionCommand("visible_msg1");
        setVisibility_msg2.setActionCommand("visible_msg2");
        colorOpt1.setActionCommand("black");
        colorOpt2.setActionCommand("red");

        // Pack the Frame, prep it, and KILL when exit
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Pack container_Content and show it
        // container_Content.pack();
        // container_Content.setVisible(true);
    }

    // Since it is encapsulated, let us do some getter methods 

    public JCheckBoxMenuItem getMsg1() {
        return setVisibility_msg1; 
    }
    
    public JCheckBoxMenuItem getMsg2() {
        return setVisibility_msg2; 
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // FOR SOME REASON WHEN I MOVE THESE METHODS DOWN THE MAIN METHOD
    // IT PREVENTS AN ERROR TO THE MESSAGE PANEL?
    // THE ERROR STATES THAT 'MESSAGE PANEL IS ALREADY DEFINED'

    @Override
    public void windowClosing(WindowEvent e) {
        // Log to console 
        System.out.println("Attempting to close window"); 

        // Beep 
        Toolkit.getDefaultToolkit().beep();

        //Pop-dialog and store the decision
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit Secuya_BM5 Application?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE); 

        
        // Store the decision 
        // int opt = JOptionPane.YES_NO_OPTION; 
        
        switch (opt) {
            case JOptionPane.YES_OPTION:
                System.out.println("Exiting Application");
                System.exit(0); 
                break; 

            case JOptionPane.NO_OPTION:
                /** WHY WHY WHY DOES IT CLOSE THE WHOLE APP?! 
                 *  IT JUST PRINTS A LINE! 
                 * */
                System.out.println("Returning to application");
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                break;
            
            default:
                System.out.println("");
                break; 
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        e.getSource(); 
        /** NOTE:
         *  Well, I removed the container_Content because as we run at launch
         *  and it creates a new instance as declared on top, but this shows
         *  another frame with no use at all 
         * 
         *  So, instead of doing that I must just use the main frame, make it 
         *  static so we can definitely reference the invoke it on show() 
         */

        // container_Content = new JFrame(); 
        // container_Content.setVisible(true); 
        int rC = e.getButton();
        if (rC == 3) {
            System.out.println("Right click" + "\n"
            + "Mouse clicked");
            // contentPane.show(container_Content, e.getX(), e.getY());
            contentPane.show(frame, e.getX(), e.getY());
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int rC = e.getButton();
        if (rC == 3) {
            System.out.println("Right click" + "\n"
            + "Mouse released");
            // contentPane.show(container_Content, e.getX(), e.getY());
            contentPane.show(frame, e.getX(), e.getY());
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Fetch actions commands 
        String commander = e.getActionCommand(); 

        // Switch
        switch(commander) {
            case "visible_msg1":
                getMsg1();  
                if (setVisibility_msg1.isSelected()) {
                    msgP.isMessage1Visible = true; 
                    System.out.println("Text 1, message1, is visible"); 
                }

                else if ((setVisibility_msg1.isSelected() == false)) {
                    System.out.println("Text 1, message1, not visible");
                    msgP.isMessage1Visible = false; 
                    msgP.setMessage1Visible(false); 


                    /** NOTE TO SELF: 
                     *  THEY SEEMS TO BE RESPONDING BASED ON HOW 
                     *  THE CONSOLE LOGS OUR PRINTLN 
                     *  
                     *  SOMEHOW I CAN'T OVERWRITE THE STRING VALUES 
                     *  AS AN EMPTY STRING 
                     */
                }

                break;  
            case "visible_msg2":
                break;
                
            case "black":
                /** WHY THIS IS NOT WORKING SOMEONE PLEASE TELL ME I WANNA LEARN 
                 *  THAT IS WHY I REALLY TOOK MY TIME EVEN RISKING SUBMITTING THIS LATE
                 */
                if (colorOpt1.isSelected()) {
                    System.out.println("Black selected");
                    msgP.setColor(Color.black); 
                    System.out.println("Changing text to black");
                    msgP.repaint(); 
                    colorOpt2.setSelected(false); 
                }    
                    
                break; 
            
                case "red":  
                /** WHY THIS IS NOT WORKING SOMEONE PLEASE TELL ME I WANNA LEARN 
                 *  THAT IS WHY I REALLY TOOK MY TIME EVEN RISKING SUBMITTING THIS LATE
                 */  
                if (colorOpt2.isSelected()) {
                    System.out.println("Red selected");
                    msgP.setColor(Color.red);
                    System.out.println("Changing text to red");
                    msgP.repaint();  
                    colorOpt1.setSelected(false);
                }
                     
                break; 
        }

    }

}

class MessagePanel extends JPanel{
    String message1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    String message2 = "Nibh praesent tristique magna sit. Fringilla est ullamcorper eget nulla facilisi";
    String message = new String(message1);
    Color textColor = Color.black; 
    boolean isMessage1Visible = true;
    boolean isMessage2Visible = true;

    public void setColor(Color textColor) {
        this.textColor = textColor;
    }

    public void setMessage1Visible(boolean isTextVisible) {
        isMessage1Visible = isTextVisible;
    }

    public void setMessage2Visible(boolean isTextVisible) {
        isMessage2Visible = isTextVisible;
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(textColor);
        if(isMessage1Visible) {
            g.drawString(message, 150, 150);
        }
        if(isMessage2Visible) {
            g.drawString(message2, 100, 250);
        }

        else if ((isMessage1Visible == false)) {
            message1 = ""; 
            repaint();
            g.drawString(message1, 150, 150);
        }
        
        else if ((isMessage2Visible == false)) {
            message2 = ""; 
            repaint();
            g.drawString(message2, 150, 150);
        }
    }
}