package stable;

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
 import javax.swing.tree.*;



public class SecuyaSysInfo {

    // We can set some attributes here to be used by some methods as an object instance later on.
    static Color white = new Color(255, 255, 255);
    static Dimension dimension1 = new Dimension(200, 30);
    static Dimension dimension2 = new Dimension(800, 400);
                   
    
    // Creating a method to show a GUI 
    public static void instanceOfGUI() {
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
        fileSubMenuItem.setEnabled(false);
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


        // Create a Jlist for the main content section
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Item");
        listModel.addElement("Value");
        listModel.addElement("OS Name");
        listModel.addElement("Microsoft Windows 10 Home");
        listModel.addElement("Version");
        listModel.addElement("10.19043 Build 19043");
        listModel.addElement("Other OS Description");
        listModel.addElement("Not Available");
        listModel.addElement("Os Manufacturer");
        listModel.addElement("Microsoft Corporation");

        JList list = new JList(listModel); 
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setSelectedIndex(-1);
        list.setVisibleRowCount(4);
        
        // Create panel for the main content and use the grid layout manager
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.add(list); 
        // mainPanel.add(new JLabel("Item                                                            Value"));
        // mainPanel.add(new JLabel("OS Name                                                   Microsoft Windows 10 Home"));
        // mainPanel.add(new JLabel("Version                                                      10.0.19043 Build 19043"));
        // mainPanel.add(new JLabel("Other OS Description                             Not Available"));
        // mainPanel.add(new JLabel("OS Manufacturer                                     Microsoft Corporation"));

        // Create the sidebar 
        // DefaultMutableTreeNode System = new DefaultMutableTreeNode("System Summary");
        // DefaultMutableTreeNode Hardware = new DefaultMutableTreeNode("Hardware Resources");
        // DefaultMutableTreeNode Components = new DefaultMutableTreeNode("Components");
        // DefaultMutableTreeNode Software = new DefaultMutableTreeNode("Software Environment");
        // System.add(Hardware);
        // System.add(Components);
        // System.add(Software);
        // JTree tree = new JTree(System);

        // Create buttons for the sidebar 
        JButton SysSum = new JButton("System Summary"); 
        JButton HardwRes = new JButton("Hardware Resources"); 
        JButton Comp = new JButton("Components"); 
        JButton SoftEnv = new JButton("Software Environments");  

        // Create the finder panel 
        JLabel label = new JLabel(); 
        label.setText("Find what:");
        JTextField textfield = new  JTextField(); 
        textfield.setPreferredSize(new Dimension(500, 25)); 
        JButton findButton = new JButton(); 
        findButton.setSize(new Dimension(300, 150));
        findButton.setText("Find");
        findButton.setEnabled(false);
        JButton closeButton = new JButton(); 
        closeButton.setSize(new Dimension(300, 150));
        closeButton.setText("Close Find");
        closeButton.setEnabled(true); 
        JCheckBox cbox1 = new JCheckBox(); 
        JCheckBox cbox2 = new JCheckBox(); 
        cbox1.setText("Search selected category only");
        cbox2.setText("Search category names only");

        // Panels instances
        JPanel Mcontent = new JPanel(); 
        JPanel sidebar = new JPanel(); 
        JPanel finder = new JPanel(); 

        Mcontent.setBackground(new Color(255, 255, 255));
        Mcontent.setPreferredSize(new Dimension(600, 100));
        Mcontent.setBorder(BorderFactory.createLineBorder(Color.gray)); 

        sidebar.setBackground(new Color(255, 255, 255));
        sidebar.setPreferredSize(new Dimension(200, 10)); 
        sidebar.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        finder.setBackground(new Color(234, 235, 241));
        finder.setPreferredSize(new Dimension(50, 100)); 
        finder.setBorder(BorderFactory.createLineBorder(Color.gray));

        Mcontent.add(mainPanel, BorderLayout.WEST);     
        // sidebar.add(tree); 
        sidebar.add(SysSum, BorderLayout.WEST); 
        sidebar.add(HardwRes, BorderLayout.WEST); 
        sidebar.add(Comp, BorderLayout.WEST); 
        sidebar.add(SoftEnv, BorderLayout.WEST);
        finder.add(label, BorderLayout.WEST);
        finder.add(textfield, BorderLayout.CENTER);
        finder.add(findButton, BorderLayout.EAST);
        finder.add(closeButton, BorderLayout.EAST);
        finder.add(cbox1, BorderLayout.SOUTH);
        finder.add(cbox2, BorderLayout.SOUTH);
        
        // Fetch the instance of frame object and set all given initialized components to it 
        frame.setSize(800,400);
        frame.getContentPane();
        frame.getContentPane().setPreferredSize(dimension2);
        frame.add(Mcontent, BorderLayout.CENTER);
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(finder, BorderLayout.SOUTH);
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setVisible(true);
   

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
