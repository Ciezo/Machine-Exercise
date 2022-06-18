package ME3;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class ME3 extends JFrame implements KeyListener {
    //Character
    ImageIcon characterIcon = new ImageIcon("closed_mouth.png");
    ImageIcon charLightningIcon = new ImageIcon("assets/char_in_lightning.png"); 
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
    
    public ME3() {
        initAllNames();

        this.setTitle("Star Eater");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initializeContentPane(this.getContentPane());
        //this.addKeyListener(this);

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
        character.setIcon(new ImageIcon("assets/closed_mouth.png"));
        char_InLightning.setIcon(charLightningIcon); 
        wall.setIcon(new ImageIcon("assets/wall.png"));
        lightning.setIcon(new ImageIcon("assets/lightning.png"));
        goal.setIcon(new ImageIcon("assets/goal.png"));
        bomb.setIcon(new ImageIcon("assets/bomb.png"));
        ImageIcon starIcon = new ImageIcon("assets/star.png");
        star1.setIcon(starIcon);
        star2.setIcon(starIcon);
        star3.setIcon(starIcon);

        //Add things in the board
        a1.add(star1);
        a3.add(lightning);
        b2.add(wall);
        b3.add(star3);
        c1.add(character);
        c2.add(char_InLightning);
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
        System.out.println("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("");
    }

    public static void main(String[] args) {
        ME3 frame = new ME3();
    }
}