import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

public class Tabios_ME5 extends WindowAdapter{
    private static void createAndShowGUI() {
        MessagePanel messagePanel = new MessagePanel();
        Color black = Color.black;
        Color red = Color.red;

        JFrame frame = new JFrame("Tabios_BM5 Application");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                int diabox = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit Tabios_BM5 Application?", "Exit", JOptionPane.YES_NO_OPTION);

                if (diabox == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } 
                else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        frame.getContentPane().setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().add(messagePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JMenu menu;
        JMenuItem menuItem;   
        JMenuBar MenuBar = new JMenuBar();

        menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_O);
        MenuBar.add(menu);
        
        menuItem = new JMenuItem("Exit", KeyEvent.VK_E);
        menuItem.setMnemonic(KeyEvent.VK_E);
        menu.add(menuItem);
        
        JPopupMenu popup ;
        JMenu submenu;
        JCheckBoxMenuItem text1, text2;
        JRadioButtonMenuItem textblack, textred;
        

        popup = new JPopupMenu();
        submenu = new JMenu("Change text color");

        textblack = new JRadioButtonMenuItem("Change to Black");
        textblack.setSelected(true);
        textred = new JRadioButtonMenuItem("Change to Red");

        textblack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (textblack.isSelected()){
                     messagePanel.setColor(black);
                }
            }
        });

        textred.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (textred.isSelected()){
                    messagePanel.setColor(red);
                }
            }
        });


        ButtonGroup color = new ButtonGroup();

        color.add(textblack);
        color.add(textred);
        submenu.add(textblack);
        submenu.add(textred);
        popup.add(submenu);
        
         
        text1 = new JCheckBoxMenuItem("Set visible Message1");
        text1.setSelected(true);


        text2 = new JCheckBoxMenuItem("Set visible Message2");
        text2.setSelected(true);


        popup.add(text1);
        popup.add(text2);

    
        text1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (text1.isSelected()){
                    messagePanel.setMessage1Visible(true);
                }
                else{
                    messagePanel.setMessage1Visible(false);
                }  
            }
        });
        text2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (text2.isSelected()){
                    messagePanel.setMessage2Visible(true);
                }
                else{
                    messagePanel.setMessage2Visible(false);
                }  
            }
        });


        text1.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {                 
            }    
         }); 
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
        frame.setJMenuBar(MenuBar);
        frame.pack();
        frame.setVisible(true);
        }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}




class MessagePanel extends JPanel{
    static String message1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
    static String message2 = "Nibh praesent tristique magna sit. Fringilla est ullamcorper eget nulla facilisi";
    String message = new String(message1);
    Color textColor = Color.black;
    boolean isMessage1Visible = true;
    boolean isMessage2Visible = true;

   
    public void setColor(Color textColor) {
        this.textColor = textColor;
        this.repaint();

    }
    public void setMessage1Visible(boolean isTextVisible) {
        isMessage1Visible = isTextVisible;
        this.repaint();
        
    }

    public void setMessage2Visible(boolean isTextVisible) {
        isMessage2Visible = isTextVisible;
        this.repaint();
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
        
    }
}
