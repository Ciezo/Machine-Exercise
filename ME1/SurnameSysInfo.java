import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author 
 */
public class SurnameSysInfo {
    private static void createAndShowGUI(){ 
        JFrame frame = new JFrame("SURNAME System Info Look-Alike");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //MenuBar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(200, 30));
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem item = new JMenuItem("Open...");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        menu.add(item);
        item = new JMenuItem("Close");
        item.setEnabled(false);
        menu.add(item);
        item = new JMenuItem("Save...");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("Export...");
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("Print...");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("Exit");
        menu.add(item);
        menu = new JMenu("Edit");
        menuBar.add(menu);
        menu = new JMenu("View");
        menuBar.add(menu);
        menu = new JMenu("Help");
        menuBar.add(menu);
        
        //Content
        JPanel maincon = new JPanel(new GridLayout(0, 1));
        maincon.setBackground(new Color(255, 255, 255));
        maincon.add(new JLabel("Item                                                            Value"));
        maincon.add(new JLabel("OS Name                                                   Microsoft Windows 10 Home"));
        maincon.add(new JLabel("Version                                                      10.0.19043 Build 19043"));
        maincon.add(new JLabel("Other OS Description                             Not Available"));
        maincon.add(new JLabel("OS Manufacturer                                     Microsoft Corporation"));
        
        //SideBar
        DefaultMutableTreeNode System = new DefaultMutableTreeNode("System Summary");
        DefaultMutableTreeNode Hardware = new DefaultMutableTreeNode("Hardware Resources");
        DefaultMutableTreeNode Components = new DefaultMutableTreeNode("Components");
        DefaultMutableTreeNode Software = new DefaultMutableTreeNode("Software Environment");
        System.add(Hardware);
        System.add(Components);
        System.add(Software);
        JTree tree = new JTree(System);
        
        //Finder
        JLabel name = new JLabel();
        name.setText("Find what:");
        JTextField finder = new JTextField();
        finder.setPreferredSize(new Dimension(500,23));
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        button1.setSize(new Dimension(300,150));
        button2.setSize(new Dimension(300,150));
        button1.setBackground(new Color(234, 235, 241));
        button2.setBackground(new Color(234, 235, 241));
        button1.setText("Find");
        button2.setText("Close Find");
        button1.setEnabled(false);
        JCheckBox box1 = new JCheckBox();
        JCheckBox box2 = new JCheckBox();
        box1.setText("Search selected category only");
        box2.setText("Search category names only");
        
        //Panels
        JPanel sidebar = new JPanel();
        JPanel content = new JPanel();
        JPanel find = new JPanel();
        
        sidebar.setBackground(new Color(255, 255, 255));
        sidebar.setPreferredSize(new Dimension(200,10));
        sidebar.setBorder(BorderFactory.createLineBorder(Color.gray));
        content.setBackground(new Color(255, 255, 255));
        content.setPreferredSize(new Dimension(600,100));
        content.setBorder(BorderFactory.createLineBorder(Color.gray));
        find.setBackground(new Color(234, 235, 241));
        find.setPreferredSize(new Dimension(50,100));
        find.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        //Adding Components
        sidebar.add(tree);
        
        content.add(maincon, BorderLayout.WEST);
        
        find.add(name, BorderLayout.WEST);
        find.add(finder, BorderLayout.CENTER);
        find.add(button1, BorderLayout.EAST);
        find.add(button2, BorderLayout.EAST);
        find.add(box1, BorderLayout.SOUTH);
        find.add(box2, BorderLayout.SOUTH);
        
        //Setting Frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(content, BorderLayout.CENTER);
        frame.add(find, BorderLayout.SOUTH);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800,400);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private javax.swing.JPopupMenu jPopupMenul;
}
