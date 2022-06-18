/** DOCUMENTATION SECTION 
 * @author Cloyd Van S. Secuya
 * @StudentNo 2020101812
 * @Section BM5  
 */

 // PACKAGE SECTION 



 // IMPORT SECTION
 import javax.swing.*;
 import java.awt.*;
 import java.awt.BorderLayout;
 import java.awt.event.*; 
 import java.awt.Color.*;
 import java.awt.Dimension;



public class SecuyaSysInfo2 {

    // We can set some attributes here to be used by some methods as an object instance later on.
    static Color white = new Color(255, 255, 255);
    static Dimension dimension1 = new Dimension(200, 21);
    static Dimension dimension2 = new Dimension(800, 400);
                   
    
    // Creating a method to show a GUI 
    private static void instanceOfGUI() {
        // Create an instance and set up the window. KILL the process once closed.  
        JFrame frame = new JFrame("SECUYA System Info Look-Alike");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of a menu BAR with white background 
        /** We created a menu BAR through menubar object that acts as a main menu content layer to which we put the list of menus
         *  Next, we will create in the following block sections of this code the four required menu items: 
         *      File  Edit  View  Help   
         *              * these are the following Menu items required inside the menu bar
         * 
         * Another thing to note is that the File item Menu should only have the one with a subitems
         */
        JMenuBar menubar = new JMenuBar(); 
        menubar.setOpaque(true); 
        menubar.setBackground(white); 
        menubar.setPreferredSize(dimension1);

        // Create an instance of the first menu item: File 
        //  * This menu item shall only be the one to have a submenu in this program.
        //  * The rest are just empty!
        JMenu fileMenu = new JMenu("File"); 
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.getAccessibleContext().setAccessibleDescription("This is the File Menu which contains items");

        // Create an instance of the second menu item: Edit 
        JMenu editMenu = new JMenu("Edit"); 
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.getAccessibleContext().setAccessibleDescription("This is the Edit Menu which is empty"); 

        // Create an instance of the third menu item: View 
        JMenu viewMenu = new JMenu("View"); 
        viewMenu.setMnemonic(KeyEvent.VK_V); 
        viewMenu.getAccessibleContext().setAccessibleDescription("This is the View Menu which is empty");

        // Create an instance of the fourth menu item: Help 
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H); 
        helpMenu.getAccessibleContext().setAccessibleDescription("This is the Help Menu which is empty");


        // We are to create the submenu for the "File" menu item
        /** File 
         *   Open   Ctrl + o 
         *   Close 
         *   Save   Ctrl + S 
         *   ---------------------      (A separator)
         *   Export 
         *   Print  Ctrl + P 
         *   ---------------------      (A separator)
         *   Exit
        */
        JMenuItem fileSubMenuItem; 

        fileSubMenuItem = new JMenuItem("Open   Ctrl + O"); 
        fileSubMenuItem.getAccessibleContext().setAccessibleDescription("This is Open submenu item");
        fileMenu.add(fileSubMenuItem); 

        fileSubMenuItem = new JMenuItem("Close");  
        fileSubMenuItem.getAccessibleContext().setAccessibleDescription("This is Open submenu item");
        fileMenu.add(fileSubMenuItem);

        fileSubMenuItem = new JMenuItem("Save   Ctrl + S");  
        fileSubMenuItem.getAccessibleContext().setAccessibleDescription("This is Open submenu item");
        fileMenu.add(fileSubMenuItem);
        fileMenu.addSeparator();        // Separator 

        fileSubMenuItem = new JMenuItem("Export...");  
        fileSubMenuItem.getAccessibleContext().setAccessibleDescription("This is Open submenu item");
        fileMenu.add(fileSubMenuItem);
        fileMenu.addSeparator();        // Separator

        fileSubMenuItem = new JMenuItem("Print   Ctrl + P");  
        fileSubMenuItem.getAccessibleContext().setAccessibleDescription("This is Open submenu item");
        fileMenu.add(fileSubMenuItem);
        fileMenu.addSeparator();        // Separator

        fileSubMenuItem = new JMenuItem("Exit");  
        fileSubMenuItem.getAccessibleContext().setAccessibleDescription("This is Open submenu item");
        fileMenu.add(fileSubMenuItem);

        // Add the required menu items into the menu BAR 
        // File   Edit   View   Help
        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(viewMenu); 
        menubar.add(helpMenu); 

        // Add the required submenu items into the File Menu item 
        //  *NOTE: DON'T DO this because it overrides the previous initialization with the most recent one
        // fileMenu.add(fileSubMenuItem);
        // fileMenu.add(fileSubMenuItem);
        // fileMenu.add(fileSubMenuItem);
        // fileMenu.add(fileSubMenuItem);
        // fileMenu.add(fileSubMenuItem);
        // fileMenu.add(fileSubMenuItem); 


        // Set the initialized objects to the frame 
        frame.setJMenuBar(menubar);  
        frame.getContentPane().setPreferredSize(dimension2);
        
        Container pane; 

        
        // Fetch the instance of frame object
        frame.getContentPane();

        // Display and activate the window
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                instanceOfGUI();
            }
        });
    }
}
