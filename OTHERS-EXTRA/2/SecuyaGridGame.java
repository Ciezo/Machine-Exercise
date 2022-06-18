/** DOCUMENTATION SECTION 
 * @author Cloyd Van S. Secuya
 * @StudentNo 2020101812 
 * @Section BM5
 * 
 * @note I will write console print so that I can see if the actions respond well 
 * 
 */



 // PACKAGE SECTION 



 // IMPORT SECTION 
 import java.awt.*;
 import javax.swing.*;
 import javax.swing.JComboBox;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JOptionPane;
 import java.awt.Toolkit; 
 import java.awt.event.ActionListener; 
 import java.awt.event.ActionEvent; 
 

public class SecuyaGridGame extends JFrame implements ActionListener {

    public String commander;
    public JComboBox themeComboBox;  
    public int score = 0; 
    public static int progress = 10; 
    ME2 gui; 

    public SecuyaGridGame(ME2 gui) {
        // Initialize the GUI app through this constructor and create a new line for console space logging
        this.gui = gui; 
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" +"\n" + "\n" + "\n" + "\n");  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e.getSource(); 
        commander = e.getActionCommand(); 

        switch (commander) {

            case "startGame":
                System.out.println("Start Game! - GAMEEE!!!"); 
                handleStartGame(e); 
                break; 

            case "theme":
                handleTheme(e); 
                break; 

            case "exit": 
                handleExit(e); 
                break; 

            case "howTo":
                handleHowTo(e);
                break; 

            case "about":
                handleAbout(e);
                break;

            case "rightArr":
                RIGHTpressingArrowButons(e); 
                break; 

            case "leftArr":
                LEFTpressingArrowButons(e);
                break;

            case "upArr":
                UPpressingArrowButons(e);
                break;

            case "downArr":
                DOWNpressingArrowButons(e);
                break; 

            case "C3":
                gameWin(e); 
                break; 
        }
    }
    
    
    private void gameWin(ActionEvent e) {
        // Beep
        Toolkit.getDefaultToolkit().beep();

        //Show a pop-up dialog
        JOptionPane.showMessageDialog(null,"You win!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleStartGame(ActionEvent event) {        
        // Beep 
        Toolkit.getDefaultToolkit().beep();
        // Log to console
        System.out.println("A1 selected");
        
        // Set the theme to white as game start
        System.out.println("Setting button PANELS to white!" + "\t White Theme Setting Set!");
        gui.a1.setBackground(new Color(255,255,255));
        gui.a2.setBackground(new Color(255,255,255));
        gui.a3.setBackground(new Color(255,255,255));
        gui.b1.setBackground(new Color(255,255,255));
        gui.b2.setBackground(new Color(255,255,255));
        gui.b3.setBackground(new Color(255,255,255));
        gui.c1.setBackground(new Color(255,255,255));
        gui.c2.setBackground(new Color(255,255,255));
        gui.c3.setBackground(new Color(255,255,255));
        
        System.out.println("\n");
        
        System.out.println("Setting radio BUTTONS to white!" + "\t White Theme Setting Set!");
        gui.buttonA1.setBackground(new Color(255,255,255));
        gui.buttonA2.setBackground(new Color(255,255,255));
        gui.buttonA3.setBackground(new Color(255,255,255));
        gui.buttonB1.setBackground(new Color(255,255,255));
        gui.buttonB2.setBackground(new Color(255,255,255));
        gui.buttonB3.setBackground(new Color(255,255,255));
        gui.buttonC1.setBackground(new Color(255,255,255));
        gui.buttonC2.setBackground(new Color(255,255,255));
        gui.buttonC3.setBackground(new Color(255,255,255));
        
        // Reset buttons to original or default state, where buttons are visible(TRUE), and deselected
        System.out.println("Resetting all buttons"); 
        gui.buttonA1.setVisible(true);
        gui.buttonA2.setVisible(true);
        gui.buttonA3.setVisible(true);
        gui.buttonB1.setVisible(true);
        gui.buttonB2.setVisible(true);
        gui.buttonB3.setVisible(true);
        gui.buttonC1.setVisible(true);
        gui.buttonC2.setVisible(true);
        gui.buttonC3.setVisible(true);

        gui.buttonA1.setSelected(false);
        gui.buttonA2.setSelected(false);
        gui.buttonA3.setSelected(false);
        gui.buttonB1.setSelected(false);
        gui.buttonB2.setSelected(false);
        gui.buttonB3.setSelected(false);
        gui.buttonC1.setSelected(false);
        gui.buttonC2.setSelected(false);
        gui.buttonC3.setSelected(false);

        // Reselect the button at start, A1
        gui.buttonA1.setSelected(true);

        // Reset score to 0 
        score = 0; 
        gui.scoreValue.setText("0");
        System.out.println("Reset Score~");
        System.out.println(score);
        
        // Show message dialog for notifaction 
        JOptionPane.showMessageDialog(null, "Game Start!"); 
    }
    
    private void handleTheme(ActionEvent event) {
        // Create a list of options for the comobo box
        String[] opt = {"Light", "Dark"}; 

        // Create a combox 
        themeComboBox = new JComboBox(opt); 

        // Register combobox into an actionlistener 
        themeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                int colorOpt = themeComboBox.getSelectedIndex(); 
            // Create and perform action from combo box as source
                if (e.getSource() == themeComboBox) {
                    System.out.println(themeComboBox.getSelectedItem()); 

                    switch (colorOpt) {
                        case 0: 
                            System.out.println("\t" + "At index 0");
                            System.out.println("Light Theme!");

                            System.out.println("Setting button PANELS to light!" + "\t Light Theme Setting Set!");
                            gui.a1.setBackground(new Color(255,255,255));
                            gui.a2.setBackground(new Color(255,255,255));
                            gui.a3.setBackground(new Color(255,255,255));
                            gui.b1.setBackground(new Color(255,255,255));
                            gui.b2.setBackground(new Color(255,255,255));
                            gui.b3.setBackground(new Color(255,255,255));
                            gui.c1.setBackground(new Color(255,255,255));
                            gui.c2.setBackground(new Color(255,255,255));
                            gui.c3.setBackground(new Color(255,255,255));
                            
                            System.out.println("\n");

                            System.out.println("Setting radio BUTTONS to light!" + "\t Light Theme Setting Set!");
                            gui.buttonA1.setBackground(new Color(255,255,255));
                            gui.buttonA2.setBackground(new Color(255,255,255));
                            gui.buttonA3.setBackground(new Color(255,255,255));
                            gui.buttonB1.setBackground(new Color(255,255,255));
                            gui.buttonB2.setBackground(new Color(255,255,255));
                            gui.buttonB3.setBackground(new Color(255,255,255));
                            gui.buttonC1.setBackground(new Color(255,255,255));
                            gui.buttonC2.setBackground(new Color(255,255,255));
                            gui.buttonC3.setBackground(new Color(255,255,255));

                            break; 

                        case 1: 
                            System.out.println("\t " + "At index 1");
                            System.out.println("Dark Theme!");

                            System.out.println("Setting button PANELS to dark" + "\t Dark Theme Setting Set!");
                            gui.a1.setBackground(new Color(0,0,0));
                            gui.a2.setBackground(new Color(0,0,0));
                            gui.a3.setBackground(new Color(0,0,0));
                            gui.b1.setBackground(new Color(0,0,0));
                            gui.b2.setBackground(new Color(0,0,0));
                            gui.b3.setBackground(new Color(0,0,0));
                            gui.c1.setBackground(new Color(0,0,0));
                            gui.c2.setBackground(new Color(0,0,0));
                            gui.c3.setBackground(new Color(0,0,0));
                            
                            System.out.println("\n");

                            System.out.println("Setting radio BUTTONS to dark!" + "\t Dark Theme Setting Set!");
                            gui.buttonA1.setBackground(new Color(0,0,0));
                            gui.buttonA2.setBackground(new Color(0,0,0));
                            gui.buttonA3.setBackground(new Color(0,0,0));
                            gui.buttonB1.setBackground(new Color(0,0,0));
                            gui.buttonB2.setBackground(new Color(0,0,0));
                            gui.buttonB3.setBackground(new Color(0,0,0));
                            gui.buttonC1.setBackground(new Color(0,0,0));
                            gui.buttonC2.setBackground(new Color(0,0,0));
                            gui.buttonC3.setBackground(new Color(0,0,0));

                            break; 
                    }
                }
            }
         }); 


        // Create a new window for pop-up 
        JFrame frame = new JFrame("Theme"); 
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        JPanel themeContainer = new JPanel();
        themeContainer.setPreferredSize(new Dimension(200, 100)); 
        themeContainer.setOpaque(true);
        themeContainer.setBackground(Color.white); 
        themeContainer.add(themeComboBox, BorderLayout.CENTER); 

        // Add the contents to the frame 
        frame.add(themeContainer, BorderLayout.CENTER); 

        // Pack the frame and display it         
        frame.pack();
        frame.setVisible(true);
        
        // Log this action when invoked to the console
        System.out.println("Theme option selected");
    }

    private void handleExit(ActionEvent event) {
        
        // Log to console 
        System.out.println("Exiting Game.....");

        // Frame instance 
        JFrame exitFrame = new JFrame("Exit Game!"); 
        
        // Panel instance 
        JPanel panel = new JPanel(); 
        panel.setPreferredSize(new Dimension(200, 50));
        panel.setOpaque(true); 
        panel.setBackground(Color.white);
        
        // Create a button 
        JButton exitBtn = new JButton("Exit"); 
        
        // Create labels inside the panel 
        panel.add(new JLabel("Are you sure you want to exit?")); 
        panel.add(exitBtn);
        
        // Beep 
        Toolkit.getDefaultToolkit().beep();
        
        // Exit upon pressing a button inside the new pop-up window
        exitBtn.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exitBtn) {                    
                    gui.dispose();
                    exitFrame.dispose();
                    // exitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                }
            }
        });
        
        // Add contents 
        exitFrame.add(panel); 

        // Activate the window
        exitFrame.pack();
        exitFrame.setVisible(true);

    } 

    private void handleHowTo(ActionEvent event) {

        // Log to console 
        System.out.println("Game Instructions....");
        
        // Create the pop-up window 
        JFrame frame = new JFrame("Game Instructions");

        // Create a panel for the pop-up window 
        JPanel panel = new JPanel(); 
        
        // Create content for the panel and add it
        JLabel info = new JLabel("The user shall reach the end of the maze by using the arrow controls or mouse clicks!");
        panel.add(info, BorderLayout.CENTER); 

        // Customize the window and set properties and add it to frame 
        panel.setOpaque(true);
        // panel.setPreferredSize(new Dimension(200, 200));                 // no need to set Dimensions as we let it be automatically configured with the length of JLabel 
        panel.setBackground(Color.white);

        // frame.setPreferredSize(new Dimension(200, 200));                 // no need to set Dimensions as we let it be automatically configured with the length of JLabel 
        frame.add(panel);       

        // Pack and activate the window
        frame.pack();
        frame.setVisible(true);

    }

    private void handleAbout(ActionEvent event) {

        // Log to console 
        System.out.println("About....");
        
        // Create the pop-up window 
        JFrame frame = new JFrame("About");

        // Create a panel for the pop-up window 
        JPanel panel = new JPanel(); 
        
        // Create content for the panel and add it
        JLabel info = new JLabel("A simple game with Action and Item Listeners!");
        panel.add(info, BorderLayout.CENTER); 

        // Customize the window and set properties and add it to frame 
        panel.setOpaque(true);
        panel.setBackground(Color.white);
        frame.add(panel);       

        // Pack and activate the window
        frame.pack();
        frame.setVisible(true);

    }

    private void RIGHTpressingArrowButons(ActionEvent event) {
        // Right Arrow Button 
        gui.right.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == gui.right) {
                    score += progress; 
                    String scoreStat = String.valueOf(score); 

                    if (gui.buttonA1.isSelected()) {
                        gui.buttonA2.setSelected(true); 
                        gui.buttonA1.setSelected(false); 
                        gui.buttonA1.setVisible(false);
                        
                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonA2.isSelected()) {
                        gui.buttonA3.setSelected(true);
                        gui.buttonA2.setSelected(false);
                        gui.buttonA2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonA3.isSelected()) {
                        System.out.println("You have reached boundaries!");
                        gui.buttonA3.setVisible(false); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat); 
                    }

                    else if (gui.buttonB1.isSelected()) {
                        gui.buttonB2.setSelected(true); 
                        gui.buttonB1.setSelected(false);
                        gui.buttonB1.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat); 
                    }

                    else if (gui.buttonB2.isSelected()) {
                        gui.buttonB3.setSelected(true); 
                        gui.buttonB2.setSelected(false);
                        gui.buttonB2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB3.isSelected()) {
                        System.out.println("You have reached boundaries!"); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonC1.isSelected()) {
                        gui.buttonC2.setSelected(true);
                        gui.buttonC1.setSelected(false);
                        gui.buttonC1.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat); 
                    }

                    else if (gui.buttonC2.isSelected()) {
                        gui.buttonC3.setSelected(true);
                        gui.buttonC2.setSelected(false);
                        gui.buttonC2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonC3.isSelected()) {
                        System.out.println("You have reached boundaries!"); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);

                        gameWin(e);
                    }

                    else {
                        System.out.println("");
                    }
                }  
                
            }
        });

        
        
    }
    
    private void LEFTpressingArrowButons(ActionEvent event) {
        
        // Left Arrow Button 
        gui.left.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == gui.left) {
                    score += progress; 
                    String scoreStat = String.valueOf(score); 
                    if (gui.buttonA1.isSelected()) {
                        System.out.println("You have reached boundaries!");

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonA2.isSelected()) {
                        gui.buttonA1.setSelected(true);
                        gui.buttonA2.setSelected(false);
                        gui.buttonA2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonA3.isSelected()) {
                        gui.buttonA2.setSelected(true);
                        gui.buttonA3.setSelected(false);
                        gui.buttonA3.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB1.isSelected()) {
                        System.out.println("You have reached boundaries!");

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB2.isSelected()) {
                        gui.buttonB1.setSelected(true); 
                        gui.buttonB2.setSelected(false);
                        gui.buttonB2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB3.isSelected()) {
                        gui.buttonB2.setSelected(true); 
                        gui.buttonB3.setSelected(false);
                        gui.buttonB3.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonC1.isSelected()) {
                        System.out.println("You have reached boundaries!");

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    
                    else if (gui.buttonC2.isSelected()) {
                        gui.buttonC1.setSelected(true);
                        gui.buttonC2.setSelected(false);
                        gui.buttonC2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    
                    else if (gui.buttonC3.isSelected()) {
                        gui.buttonC2.setSelected(true); 
                        gui.buttonC3.setSelected(false);
                        gui.buttonC3.setVisible(false); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);

                        gameWin(e);
                    }
                    
                }    
            }
        });

    }
    
    private void DOWNpressingArrowButons(ActionEvent event) {
        
        // Down Arrow Button 
        gui.down.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == gui.down) {
                    score += progress; 
                    String scoreStat = String.valueOf(score); 
                    if (gui.buttonA1.isSelected()) {
                        gui.buttonB1.setSelected(true); 
                        gui.buttonA1.setSelected(false); 
                        gui.buttonA1.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB1.isSelected()) {
                        gui.buttonC1.setSelected(true); 
                        gui.buttonB1.setSelected(false);
                        gui.buttonB1.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonC1.isSelected()) {
                        System.out.println("You have reached boundaries!"); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonA2.isSelected()) {
                        gui.buttonB2.setSelected(true);
                        gui.buttonA2.setSelected(false);
                        gui.buttonA2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB2.isSelected()) {
                        gui.buttonC2.setSelected(true); 
                        gui.buttonB2.setSelected(false);
                        gui.buttonB2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonC2.isSelected()) {
                        System.out.println("You have reached boundaries!"); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonA3.isSelected()) {
                        gui.buttonB3.setSelected(true); 
                        gui.buttonA3.setSelected(false);
                        gui.buttonA3.setVisible(false);          
                        
                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB3.isSelected()) {
                        gui.buttonC3.setSelected(true); 
                        gui.buttonB3.setSelected(false);
                        gui.buttonB3.setVisible(false);     
                        
                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonC3.isSelected()) {
                        System.out.println("You have reached boundaries!"); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);

                        gameWin(e);
                    }

                }
            }
        });

    }
    
    private void UPpressingArrowButons(ActionEvent event) {
        
        // Up Arrow Button 
        gui.up.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == gui.up) {
                    score += progress; 
                    String scoreStat = String.valueOf(score); 
                    if (gui.buttonA1.isSelected()) {
                        System.out.println("You have reached boundaries!");

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB1.isSelected()) {
                        gui.buttonA1.setSelected(true); 
                        gui.buttonB1.setSelected(false);
                        gui.buttonB1.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonC1.isSelected()) {
                        gui.buttonB1.setSelected(true); 
                        gui.buttonC1.setSelected(false); 
                        gui.buttonC1.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonA2.isSelected()) {
                        System.out.println("You have reached boundaries!"); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB2.isSelected()) {
                        gui.buttonA2.setSelected(true); 
                        gui.buttonB2.setSelected(false);
                        gui.buttonB2.setVisible(false);

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonC2.isSelected()) {
                        gui.buttonB2.setSelected(true); 
                        gui.buttonC2.setSelected(false);
                        gui.buttonC2.setVisible(false);          
                        
                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonA3.isSelected()) {
                        System.out.println("You have reached boundaries!");      
                        
                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }

                    else if (gui.buttonB3.isSelected()) {
                        gui.buttonA3.setSelected(true); 
                        gui.buttonB3.setSelected(false);
                        gui.buttonB3.setVisible(false);                
                        
                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);
                    }
                    
                    else if (gui.buttonC3.isSelected()) {
                        gui.buttonB3.setSelected(true); 
                        gui.buttonC3.setSelected(false);
                        gui.buttonC3.setVisible(false); 

                        gui.scoreValue.getText(); 
                        gui.scoreValue.setText(scoreStat); 
                        System.out.println("Score: " + " " + scoreStat);

                        gameWin(e);
                    }

                }
            }
        });

    }     
}