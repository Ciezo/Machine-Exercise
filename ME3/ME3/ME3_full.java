/** DOCUMENTATION SECTION 
 * @author Cloyd Van S. Secuya
 * @StudentNo 2020101812
 * @Section BM5  
 */

package ME3;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

public class ME3_full extends JFrame implements KeyListener {
    //Character
    ImageIcon characterIcon = new ImageIcon("ME3/assets/closed_mouth.png");
    ImageIcon charLightningIcon = new ImageIcon("ME3/assets/char_in_lightning.png"); 
    JLabel character = new JLabel();
    JLabel char_InLightning = new JLabel(); 
    JLabel characterEating = new JLabel();
    
    //Things in the board
    JLabel wall = new JLabel();
    JLabel star1 = new JLabel();
    JLabel star2 = new JLabel();
    JLabel star3 = new JLabel();
    JLabel lightning = new JLabel();
    JLabel bomb = new JLabel();
    JLabel goal = new JLabel();
    
    //Board
    JPanel board = new JPanel();
    JPanel a1 = new JPanel(new GridBagLayout());
    JPanel a2 = new JPanel(new GridBagLayout());
    JPanel a3 = new JPanel(new GridBagLayout());
    JPanel b1 = new JPanel(new GridBagLayout());
    JPanel b2 = new JPanel(new GridBagLayout());
    JPanel b3 = new JPanel(new GridBagLayout());
    JPanel c1 = new JPanel(new GridBagLayout());
    JPanel c2 = new JPanel(new GridBagLayout());
    JPanel c3 = new JPanel(new GridBagLayout());
    JPanel d1 = new JPanel(new GridBagLayout());
    JPanel d2 = new JPanel(new GridBagLayout());
    JPanel d3 = new JPanel(new GridBagLayout());
    
    //Border
    Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    
    // Declared variables
    int point = 7; 
    int recoverCnt = 0; 
    int starCounter = 3; 
    
    // If we set a star counter as an "on-looker" to the number of stars
    // We will have a problem because for every key event it may decrement by 1 
    // So, it has a very positive chance of being a negative integer. 

    // Thus, the condition if (starCounter != 0 ){gameWin();} is not going to be satisfied...
    // Therefore, it is much preferrable to have a boolean flag for each existing star
    // Unless...
    // We can set the condition to if (starCounter > 0) {gameWin();} and in this case. We somehow "cheated"
    // in a way for the program to know that all stars are gone if a negative integer exists!!! 
    
    // LMAO IT WORKED! 
    
     
    public ME3_full() {
        initAllNames();
        
        this.setTitle("Star Eater");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeContentPane(this.getContentPane());
        this.addKeyListener(this);
        
        this.pack();
        this.setVisible(true);
    }

    private void initializeContentPane(Container contentPane) {

        //Setup board        
        board.setLayout(new GridLayout(4,3));   
        board.setPreferredSize(new Dimension(300, 400));

        //Add borders to the panels
        a1.setBorder(raisedEtched);
        a2.setBorder(raisedEtched);
        a3.setBorder(raisedEtched);
        b1.setBorder(raisedEtched);
        b2.setBorder(raisedEtched);
        b3.setBorder(raisedEtched);
        c1.setBorder(raisedEtched);
        c2.setBorder(raisedEtched);
        c3.setBorder(raisedEtched);
        d1.setBorder(raisedEtched);
        d2.setBorder(raisedEtched);
        d3.setBorder(raisedEtched);

        //Set background color of panels
        a1.setBackground(Color.white);
        a2.setBackground(Color.white);
        a3.setBackground(Color.white);
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        c1.setBackground(Color.white);
        c2.setBackground(Color.white);
        c3.setBackground(Color.white);
        d1.setBackground(Color.white);
        d2.setBackground(Color.white);
        d3.setBackground(Color.white);

        //Add images to labels
        character.setIcon(new ImageIcon("ME3/assets/closed_mouth.png"));
        char_InLightning.setIcon(new ImageIcon("ME3/assets/char_in_lightning.png"));
        wall.setIcon(new ImageIcon("ME3/assets/wall.png"));
        lightning.setIcon(new ImageIcon("ME3/assets/lightning.png"));
        goal.setIcon(new ImageIcon("ME3/assets/goal.png"));
        bomb.setIcon(new ImageIcon("ME3/assets/bomb.png"));
        ImageIcon starIcon = new ImageIcon("ME3/assets/star.png");
        star1.setIcon(starIcon);
        star2.setIcon(starIcon);
        star3.setIcon(starIcon);

        //Add things in the board
        a1.add(star1);
        a3.add(lightning);
        b2.add(wall);
        b3.add(star3);
        c1.add(character);
        d1.add(star2);
        d2.add(bomb);
        d3.add(goal);
        
        //Add panels to the board
        board.add(a1);
        board.add(a2);
        board.add(a3);
        board.add(b1);
        board.add(b2);
        board.add(b3);
        board.add(c1);
        board.add(c2);
        board.add(c3);    
        board.add(d1);
        board.add(d2);
        board.add(d3);   

        //Add board to the content pane
        contentPane.add(board);
    }

    private void initAllNames() {
        this.setName("starEaterApp");

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // System.out.println("Key is typed: " + e.getKeyChar());
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int arrVal = e.getKeyCode(); 
        getAllComponents(); 

        character.setIcon(new ImageIcon("ME3/assets/open_mouth.png"));
        char_InLightning.setIcon(new ImageIcon("assets/char_in_lightning.png")); 
        System.out.println(point);
        
        // Delagate each arrow key task depending on each arrow key is pressed
        // Use keycodes then use switch cases to it
        switch (arrVal) {
            // RESET AND RESTART GAME
            case KeyEvent.VK_N: {
                System.out.println("Restarting Game!");
                resetGame(); 
                break; 
            }

            case 82: {
                // do { recoverCnt++; } while(recoverCnt != 2);                   
                recoverCnt++; 
                if (recoverCnt < 2) { 
                    System.out.println("Recovery left: " + recoverCnt); 
                }

                else {
                    System.out.println("Character recovered!"); 
                    repaint();
                }

                break; 
            }

            // CLOSE AND EXIT THE GAME 
            case 88: {
                System.out.println("Closing and leaving the game......");
                System.out.println("Shift + X"); 
                System.exit(0);
            }

            // ARROW UP
            case KeyEvent.VK_UP: {
                 // D, C, B, A ROW Section, points from 10, 7, 4, 1
                 if (point == 10) {
                    // Now, set and override up point to 7 
                    point = point - 3; 
                     
                    d1.remove(star2);
                    starCounter--; 
                    d1.remove(character);
                    d1.repaint(); 
                    c1.add(character); 
                    c1.repaint(); 
                }
                
                else if (point == 7) {
                    // Now, set and override up point to 4 
                    point = point - 3; 

                    c1.remove(character);
                    c1.repaint();
                    b1.add(character); 
                    b1.repaint();
                }

                else if (point == 4) {
                    // Now, set and override up point to 1 
                    point = point - 3; 
                    
                    b1.remove(character); 
                    b1.repaint();
                    a1.remove(star1); 
                    starCounter--; 
                    a1.repaint(); 
                    a1.add(character); 
                }
                
                else if (point == 1) {
                    System.out.println(""); 
                }
                

                // D, C ROW Sections points from 11, 8 
                else if (point == 11) {
                    // Now, set and override up point to 8 
                    point = point - 3; 

                    d2.remove(character);
                    d2.repaint();
                    c2.add(character); 
                    c2.repaint(); 
                }

                else if (point == 8) {
                    System.out.println("");
                }


                // C, B, A ROW Sections points from 9, 6, 3
                else if (point == 9) {
                    // Now, set and override up point to 6 
                    point = point - 3; 

                    c3.remove(character);
                    c3.repaint(); 
                    b3.remove(star3);
                    starCounter--; 
                    b3.repaint();
                    b3.add(character);
                } 

                else if (point == 6) {
                    // Now, set and override up point to 3
                    point = point - 3; 

                    b3.remove(character);
                    b3.repaint();
                    a3.remove(lightning);

                    if (recoverCnt < 2) {
                        character.setIcon(charLightningIcon); 
                        a3.add(character); 
                        a3.repaint();
                    }
                    
                    else {
                        System.out.println("Character recovered!"); 
                        a3.repaint();
                        a3.add(character); 
                    }
                }

                break; 
            }

            // ARROW LEFT
            case KeyEvent.VK_LEFT: {
                 // C ROW Section, points from 9 - 7
                 if (point == 9) {
                    // Now, set and override point to 8 
                    point--;
                     
                    c3.remove(character); 
                    c3.repaint();
                    c2.add(character);
                    c2.repaint();
                }
                
                else if (point == 8) {
                    // Now, set and override point to 7 
                    point--;
                    
                    c2.remove(character);
                    c2.repaint();
                    c1.add(character); 
                    c1.repaint(); 
                }

                else if (point == 7) {
                    System.out.println("");
                }


                 // D ROW Section, points from 12 - 10
                 if (point == 12) {
                    // Now, set and override point to 11
                    point--;

                    d3.remove(character); 
                    d3.repaint();
                    d2.remove(bomb);
                    d2.setBackground(Color.red);
                    d2.add(character);
                    d2.repaint();
                    
                    // Set a condition that meets if all stars are eaten then the player cannot finish the game 
                    // If all stars are eaten, then, they may get into the portal to finish it
                     
                    // Apply condtion here, 
                    /** To Do **/

                }
                
                else if (point == 11) {
                    // Now, set and override point to 10 
                    point--;
                    
                    d2.remove(character);
                    d2.repaint();
                    d1.add(character); 
                    d1.repaint();
                }

                else if (point == 10) {
                    System.out.println("");
                }


                 // A ROW Section, points from 3 - 1
                 if (point == 3) {
                    // Now, set and override point to 2 
                    point--;
                    
                    a3.remove(lightning);
                    a3.repaint();
                    // Set a condition that must satisfy when a character is in this panel it will change into char_in_lightning.png 
                    // Set it back into closed_mouth.png when "Ctrl + R" is pressed twice 
                    // if (recoverCnt != 2) {
                    //     character.setIcon(new ImageIcon("assets/char_in_lightning.png"));
                    //     a3.add(character);  
                    // }

                    // a3.add(character); 
                    a3.remove(character); 
                    a3.repaint(); 
                    a2.add(character); 
                    a2.repaint(); 
                }
                
                else if (point == 2) {
                    // Now, set and override point to 1 
                    point--;
                    
                    a2.remove(character);
                    a2.repaint(); 
                    a1.remove(star1);
                    starCounter--; 
                    a1.add(character); 
                    a1.repaint();
                }

                else if (point == 1) {
                    System.out.println(""); 
                }

                break; 
            }

            // ARROW RIGHT
            case KeyEvent.VK_RIGHT: {
                // Delegate each point to have their own spawn

                // Spawn point location at C1 
                // Set point relative to number of panels. Point AS 7

                // C ROW Section, points from 7 - 9
                if (point == 7) {
                    // Now, set and override point to 8 
                    point++;
                     
                    c1.remove(character); 
                    c1.repaint();
                    c2.add(character);
                    c2.repaint();
                }
                
                else if (point == 8) {
                    // Now, set and override point to 8 
                    point++;
                    
                    c2.remove(character);
                    c2.repaint();
                    c3.add(character); 
                    c3.repaint(); 
                }

                else if (point == 9) {
                    System.out.println("");
                }
                

                // D ROW Section, points from 10 - 12
                if (point == 10) {
                    // Now, set and override point to 11 
                    point++;
                     
                    d1.remove(character);
                    d1.remove(star2);
                    starCounter--; 
                    d1.repaint();
                    d2.remove(bomb);
                    d2.setBackground(Color.red);
                    d2.add(character);
                    d2.repaint();    
                }
                
                else if (point == 11) {
                    // Now, set and override point to 12 
                    point++;
                    
                    // Set a condition to meet that if all stars are not eaten, therefore, 
                    // the character cannot teleport and finish the game.
                    // Otherwise, if stars are eaten the player may win the game

                    // Apply condition here
                    /** To Do **/ 
                    if (starCounter > 0) {
                        System.out.println("You have not eaten all the stars yet!");
                    } 

                    else {
                        d2.remove(character);
                        d2.repaint();
                        gameWin();
                    }
                }

                else if (point == 12) {
                    System.out.println("");
                }


                // B ROW Section, in this case we cannot really go to right because there is a wall
                // So, it is advised that there is nothing to do when pressing right in here
                

                // A ROW Section, points from 1 - 3
                if (point == 1) {
                    // Now, set and override point to 2 
                    point++;
                    
                    a1.remove(star1);
                    starCounter--; 
                    a1.remove(character); 
                    a1.repaint();
                    a2.add(character);
                    a2.repaint();
                }
                
                else if (point == 2) {
                    // Now, set and override point to 3 
                    point++;
                    
                    a2.remove(character);
                    a2.repaint(); 
                    a3.remove(lightning); 
                    
                    // When the character is hit by lightning it should change to the char_in_lightning.png
                    // Then, player must press "Ctrl + R" twice to recover and the picture should change back to  
                    // closed_mouth.png
                    
                    // Declare a variable that should initialize 2 presses
                    // Apply condition here, 
                    /** To Do **/ 
                    if (recoverCnt < 2) {
                        character.setIcon(charLightningIcon); 
                        a3.add(character); 
                        a3.repaint();
                    }
                    
                    else {
                        System.out.println("Character recovered!"); 
                        a3.repaint();
                        a3.add(character); 
                    }
                }
                
                else if (point == 3) {
                   System.out.println("");
                }

                break; 
            }
            
            // ARROW DOWN 
            case KeyEvent.VK_DOWN: {
                 // A, B, C, D ROW Sections, points from 1, 4, 7, 10
                 if (point == 1) {
                     // Now, set and override point to 4 
                     point = point + 3; 
 
                     a1.remove(star1);
                     a1.remove(character);
                     a1.repaint(); 
                     b1.add(character); 
                     b1.repaint(); 
                }

                else if (point == 4) {
                    // Now, set and override point to 7 
                    point = point + 3; 
                    
                    b1.remove(character);
                    b1.repaint();
                    c1.add(character); 
                    c1.repaint(); 
                }

                else if (point == 7) {
                    // Now, set and override point to 10
                    point = point + 3; 

                    c1.remove(character);
                    c1.repaint();
                    d1.remove(star2);
                    d1.repaint();
                    d1.add(character); 
               }

                else if (point == 10) {
                    System.out.println("");
                }

                
                // C, D ROW Sections, points from 8, 11 
                else if (point == 8) {
                    // Now, set and override point to 11
                    point = point + 3; 

                    c2.remove(character);
                    c2.repaint();
                    d2.remove(bomb);
                    d2.setBackground(Color.red); 
                    d2.add(character); 
                }

                else if (point == 11) {
                    System.out.println("");
                }


                // A, B, C, D Row Sections, points from 3, 6, 9, 12
                else if (point == 3) {
                    point = point + 3; 
                    a3.remove(lightning);
                    a3.repaint(); 

                    // Set a condition to change the character into char_in_lighting.png 
                    // Change it back once "Ctrl + R" is hit twice 

                    // Apply condition here, 
                    /** To Do **/

                   
                    a3.remove(character);
                    b3.remove(star3);
                    starCounter--; 
                    b3.add(character); 
                    b3.repaint(); 
                }

                else if (point == 6) {
                    // Now, set and override downPoint to 9 
                    point = point + 3; 
                    b3.remove(character);
                    b3.repaint();
                    c3.add(character); 
                    c3.repaint(); 
                }

                else if (point == 9) {
                    // Set a condition for the portal and game win 
                    if (starCounter > 0) {
                        System.out.println("You have not eaten all the stars yet!"); 
                    }

                    else { 
                        c3.remove(character);
                        c3.repaint(); 
                        gameWin();
                    }
                }

                break;  
            }

            default: 
                break; 
        }

        System.out.println("\n");
        System.out.println("\t Stars left: " + starCounter); 

        // Logging and printing all the instances when an arrow key is pressed 
        // System.out.println("Key code is: " + e.getKeyCode()); 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        character.setIcon(new ImageIcon("ME3/assets/closed_mouth.png"));
    }

    public void getAllComponents() {
        // Fetch all components
        a1.getComponents(); 
        a2.getComponents();
        a3.getComponents();
        b1.getComponents();
        b2.getComponents();
        b3.getComponents();
        c1.getComponents();
        c2.getComponents();
        c3.getComponents();
        d1.getComponents();
        d2.getComponents();
        d3.getComponents();
    }
    
    public void resetGame() {
        getAllComponents(); 
        re_Paint(); 
        
        //Set background color of panels
        d2.setBackground(Color.white);
        
        //Add images to labels
        character.setIcon(new ImageIcon("ME3/assets/closed_mouth.png"));
        wall.setIcon(new ImageIcon("ME3/assets/wall.png"));
        lightning.setIcon(new ImageIcon("ME3/assets/lightning.png"));
        goal.setIcon(new ImageIcon("ME3/assets/goal.png"));
        bomb.setIcon(new ImageIcon("ME3/assets/bomb.png"));
        ImageIcon starIcon = new ImageIcon("ME3/assets/star.png");
        star1.setIcon(starIcon);
        star2.setIcon(starIcon);
        star3.setIcon(starIcon);

        //Add things in the board
        a1.add(star1);
        a3.add(lightning);
        b2.add(wall);
        b3.add(star3);
        c1.add(character);
        d1.add(star2);
        d2.add(bomb);
        d3.add(goal);
        
        // Spawn character 
        c1.add(character); 

        // Reset position 
        point = 7; 

        // Reset star value 
        starCounter = 3; 
    }

    public void re_Paint() {
        a1.repaint(); 
        a2.repaint();
        a3.repaint();
        b1.repaint();
        b2.repaint();
        b3.repaint();
        c1.repaint();
        c2.repaint();
        c3.repaint();
        d1.repaint();
        d2.repaint();
        d3.repaint();
    }

    public void gameWin() {
        System.out.println("You have eaten all the stars!!!"); 
        JOptionPane.showMessageDialog(null, "You did it!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE); 

        resetGame();
    }

    public static void main(String[] args) {
        ME3_full frame = new ME3_full();
    }
}