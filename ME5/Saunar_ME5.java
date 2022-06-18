import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;


public class Saunar_ME5 extends WindowAdapter{
    private static void createAndShowGUI() {
        
        MessagePanel message = new MessagePanel();

        JFrame frame;
        frame = new JFrame("Saunar_BM5 Application");
        frame.addWindowListener(new Saunar_ME5());
        System.out.println("Frame instantiated");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().add(new MessagePanel());
        
        JPopupMenu popUp = new JPopupMenu();
        
        //creating pop up menu items
        JMenu textClr = new JMenu("Change text color");
        JCheckBoxMenuItem visibleTxt1 = new JCheckBoxMenuItem("Set visible Message 1"); //checkbox1
        JCheckBoxMenuItem visibleTxt2 = new JCheckBoxMenuItem("Set visible Message 2"); //checkbox2
        visibleTxt1.setSelected(true);
        visibleTxt2.setSelected(true);
        
        //sub window for color change
        JRadioButtonMenuItem blck = new JRadioButtonMenuItem("Change to Black");
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Change to Red");
        
        blck.setMnemonic(KeyEvent.VK_B);
        red.setMnemonic(KeyEvent.VK_R);
        
        blck.setSelected(true);
        
        //to select only one button
        ButtonGroup setColors = new ButtonGroup();
        setColors.add(blck);
        setColors.add(red);

        popUp.add(textClr);
        popUp.add(visibleTxt1);
        popUp.add(visibleTxt2);
        textClr.add(blck);
        textClr.add(red);
        
        //menu bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.WHITE);
        menuBar.setPreferredSize(new Dimension(200, 20));
        
        //menu options
        JMenu options = new JMenu("Options");
        options.setMnemonic(KeyEvent.VK_O);
        
        //exit submenu from menu bar
        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_E);
                
        //adds
        options.add(exit);
        menuBar.add(options);
        frame.setJMenuBar(menuBar);

        frame.addMouseListener(new MouseAdapter() 
        {
            //right click for submenu (another window)
            @Override
            public void mouseClicked(MouseEvent me) {
                if(me.getButton() == MouseEvent.BUTTON3)
                {
                    //location of where submenu will display base on the click
                    popUp.show(frame, me.getX(), me.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}
        });
        
        
        //colors
        //red text
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(red.isSelected())
                {
                    //msg.textColor = Color.red;
                    //msg.paintComponent(g);
                    message.textColor = Color.red;
                    message.repaint();
                    System.out.println("Red");
                }
                message.repaint();
            }
        });
        
        //black text
        blck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(blck.isSelected())
                {
                    message.textColor = Color.black;
                    message.repaint();
                    System.out.println("Black");
                }
                message.repaint();
            }
        });
        
        
        visibleTxt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(visibleTxt1.isSelected())
                {
                    message.isText1Visible = true;
                    System.out.println("Text 1 visible");
                }
                if(visibleTxt1.isSelected() == false)
                {
                    message.isText1Visible = false;
                    System.out.println("Text 1 NOT visible");
                }
            }
        });
        
        visibleTxt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(visibleTxt2.isSelected())
                {
                    message.isText2Visible = true;
                    System.out.println("Text 2 visible");
                }
                if(visibleTxt2.isSelected() == false)
                {                  
                    message.isText2Visible = true;
                    System.out.println("Text 2 NOT visible");
                }
            }
        });  
        
        
        frame.getContentPane().add(message);
        frame.pack();
        frame.setVisible(true);

        System.out.println("Frame now visible"); 
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void windowOpened(WindowEvent e){
        System.out.println("Opened");
    }
    //pop up window 
    public void windowClosing(WindowEvent e){
        System.out.println("Closing");
        int windowPop;
        windowPop = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit Saunar_BM5 Application?", 
        "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if(windowPop == JOptionPane.YES_OPTION)
        {
            e.getWindow().dispose();
            System.out.println("Closed window");
        }
        else if(windowPop == JOptionPane.NO_OPTION)
        {
            System.out.println("Operation cancelled");
        }
    }
    public void windowClosed(WindowEvent e){
        System.out.println("Closed");
    }
    public void windowIconified(WindowEvent e){
        System.out.println("Iconified");
    }
    public void windowDeiconified(WindowEvent e){
        System.out.println("Deiconified");
    }
    public void windowActivated(WindowEvent e){
        System.out.println("Activated");
    }
    public void windowDeactivated(WindowEvent e){
        System.out.println("Deactivated");
    }
    public void windowGainedFocus(WindowEvent e){
        System.out.println("Focused");
    }
    public void windowLostFocus(WindowEvent e){
        System.out.println("Lost focus");
    }

}

class MessagePanel extends JPanel{
    
    String txt1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    String txt2 = "Nibh praesent tristique magna sit. Fringilla est ullamcorper eget nulla facilisi";
    String message = new String(txt1);
    Color textColor;
    boolean isText1Visible = true;
    boolean isText2Visible = true;

    public void setColor(Color textClr) {
        this.textColor = textColor;
    }

    public void setMessage1Visible(boolean isTextVisible) {
        isText1Visible = isTextVisible;
    }

    public void setMessage2Visible(boolean isTextVisible) {
        isText2Visible = isTextVisible;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(textColor);
        if(isText1Visible) {
            g.drawString(message, 150, 150);
        }
        if(isText2Visible) {
            g.drawString(txt2, 100, 250);
        }
    }
}

