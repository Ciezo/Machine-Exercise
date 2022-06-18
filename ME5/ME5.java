import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;

public class ME5 extends WindowAdapter{
    private static void createAndShowGUI() {
        
        JFrame frame = new JFrame("Surname_Section Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().add(new MessagePanel());
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
        
    }
}