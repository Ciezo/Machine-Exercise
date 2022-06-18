/** DOCUMENTATION SECTION 
 * @author Cloyd Van S. Secuya
 * @section BM5
 * @student no.: 2020101812
 * @note 
 *      *  BUTTON1 == LEFT CLICK 
 *      *  BUTTON2 == SCROLL WHEEL CLICK 
 *      *  BUTTON3 == RIGHT CLICK 
 */



//PACKAGE SECTION 
package ME4; 



// IMPORT SECTION
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Frame;



public class ME4 extends Frame implements MouseListener, MouseMotionListener{

    // Graphics graphic = getGraphics();
    Color [] colors = new Color[] {  
        Color.black,
        Color.red,
        Color.blue,
        Color.green
    };

    Color [] colorArr = new Color [] {
        new Color(0, 0, 0),
        new Color(255, 0, 0), 
        new Color(0, 0, 255), 
        new Color(0, 255, 0)
       };  

    boolean blkFlag;
    boolean rdFlag;
    boolean bluFlag;
    boolean grnFlag; 

    public ME4() {
        addMouseListener(this);
        addMouseMotionListener(this);
        setTitle("Secuya_BM5 Simple Paint Application");
        add(new JLabel("Right Click to change colors"), BorderLayout.PAGE_START); 
        add(new JLabel("Left Click to summon rectangles"), BorderLayout.SOUTH); 
        setSize(400, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent we)
                 {
                 dispose();
                 System.exit(0);
             }
         });
    }

    public static void main(String[] args) {
        new ME4();
    }

    
    public void mouseClicked(MouseEvent e){
        Graphics graphic = getGraphics();

        // System.out.println("Mouse is clicked!"); 
        
        /** IMPORTANT NOTES 
         *  BUTTON1 == LEFT CLICK 
         *  BUTTON2 == SCROLL WHEEL CLICK 
         *  BUTTON3 == RIGHT CLICK 
         */

        int clicker = e.getButton(); 

        switch (clicker) {
            case MouseEvent.BUTTON1: 
                System.out.println("Left click!");
                graphic.setColor(colors[0]);
                graphic.fillRect(e.getX(), e.getY(), 100, 100); 
                
                break;
            
            case MouseEvent.BUTTON2:
                System.out.println("Scroll wheel click");
                break; 

            case MouseEvent.BUTTON3:
                System.out.println("Right click");
                int picker = e.getClickCount(); 
                System.out.println(picker);
                
                
                switch (picker) {
                    case 1:
                    graphic.setColor(colors[0]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    break; 
                    
                    case 2:
                    graphic.setColor(colors[1]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    break; 
                    
                    case 3:
                    graphic.setColor(colors[2]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    break; 
                    
                    case 4: 
                    graphic.setColor(colors[3]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    break; 
                }
                
                // for (int i = 0; i < 4; i++) {
                //     if (i == 0)
                //         graphic.setColor(colors[0]);
                    
                //     else if (i == 1)
                //         graphic.setColor(colors[1]);
                    
                //     else if (i == 2)
                //         graphic.setColor(colors[2]);    
        
                //     else if (i == 3)
                //         graphic.setColor(colors[3]);
        
                //     graphic.fillRect(150, 150, 100, 100); 
                // }
                
                break; 
            }
            
        }
        
    public void mousePressed(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
        System.out.println("Mouse entered");
        setBackground(Color.white);
        repaint();
    }

    public void mouseExited(MouseEvent e){
        System.out.println("Mouse exited");
        setBackground(Color.gray);
    }

    
    public void mouseDragged(MouseEvent e) {  
        Graphics graphic = getGraphics();
        Color officialColor = colorSetter(e); 
        graphic.setColor(officialColor);
        graphic.fillOval(e.getX(), e.getY(), 10, 10);

        if (blkFlag == true) {
            graphic.setColor(colorArr[0]);
            graphic.fillOval(e.getX(), e.getY(), 10, 10);
            System.out.println(blkFlag);
        }

        else if (rdFlag == true) {
            graphic.setColor(colorArr[1]);
            graphic.fillOval(e.getX(), e.getY(), 10, 10);
            System.out.println(rdFlag);
        }

        else if (bluFlag == true) {
            graphic.setColor(colorArr[2]);
            graphic.fillOval(e.getX(), e.getY(), 10, 10);
            System.out.println(blkFlag);
            System.out.println(bluFlag);
        }

        else if (grnFlag == true) {
            graphic.setColor(colorArr[3]);
            graphic.fillOval(e.getX(), e.getY(), 10, 10);
            System.out.println(grnFlag);
        }
    }     
        
    public void mouseMoved(MouseEvent e){
    }

    Color colorSetter(MouseEvent e) {

        Graphics graphic = getGraphics();
        int picker = e.getClickCount(); 
                System.out.println(picker);
               
                switch (picker) {
                    case 1:
                    graphic.setColor(colors[0]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    blkFlag = true; 
                    System.out.println("Black true");

                    if (blkFlag == true) {
                        return colorArr[0]; 
                    }

                    break; 
                    
                    case 2:
                    graphic.setColor(colors[1]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    rdFlag = true; 
                    System.out.println("Red true");

                    if (rdFlag == true) {
                        return colorArr[1];   
                    }  

                    break; 
                    
                    case 3:
                    graphic.setColor(colors[2]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    bluFlag = true; 
                    System.out.println("Blue true");
                    
                    if (bluFlag == true) {
                        return colorArr[2]; 
                    }

                    break; 
                    
                    case 4: 
                    graphic.setColor(colors[3]);
                    graphic.fillOval(e.getX(), e.getY(), 10, 10);
                    picker++;
                    grnFlag = true;
                    System.out.println("Green true");
                    
                    if (grnFlag == true) {
                        return colorArr[3];  
                    }

                    break; 

                    default:
                        return colorArr[0]; 
                }
                
        return colorArr[0]; 
    }
    
    // public void paint(Graphics g) {
    //     g.setColor(colors[0]);
    //     g.fillRect(150, 150, 100, 100);
    // }
}