import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

public class ME2 extends JFrame {
    //Menus
    JMenuBar menuBar = new JMenuBar();
    JMenu optionsMenu = new JMenu("Options");
    JMenuItem startGame = new JMenuItem("Start Game");
    JMenuItem theme = new JMenuItem("Theme");
    JMenuItem exitGame = new JMenuItem("Exit");
    JMenu helpMenu = new JMenu("Help");
    JMenuItem howToPlay = new JMenuItem("How to play");
    JMenuItem about = new JMenuItem("About this game");

    //Main sections
    JPanel matrix = new JPanel();
    JPanel controlsAndScore = new JPanel();
    JPanel controls = new JPanel(new GridLayout(1,4));
    JPanel score = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    //Radio button group and radio buttons
    ButtonGroup group = new ButtonGroup();
    JRadioButton buttonA1 = new JRadioButton();
    JRadioButton buttonA2 = new JRadioButton();
    JRadioButton buttonA3 = new JRadioButton();
    JRadioButton buttonB1 = new JRadioButton();
    JRadioButton buttonB2 = new JRadioButton();
    JRadioButton buttonB3 = new JRadioButton();
    JRadioButton buttonC1 = new JRadioButton();
    JRadioButton buttonC2 = new JRadioButton();
    JRadioButton buttonC3 = new JRadioButton();

    //Radio button containers
    JPanel a1 = new JPanel(new GridBagLayout());
    JPanel a2 = new JPanel(new GridBagLayout());
    JPanel a3 = new JPanel(new GridBagLayout());
    JPanel b1 = new JPanel(new GridBagLayout());
    JPanel b2 = new JPanel(new GridBagLayout());
    JPanel b3 = new JPanel(new GridBagLayout());
    JPanel c1 = new JPanel(new GridBagLayout());
    JPanel c2 = new JPanel(new GridBagLayout());
    JPanel c3 = new JPanel(new GridBagLayout());

    //Border
    Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

    //Arrow buttons
    BasicArrowButton left = new BasicArrowButton(BasicArrowButton.WEST);
    BasicArrowButton right = new BasicArrowButton(BasicArrowButton.EAST);
    BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH);
    BasicArrowButton down = new BasicArrowButton(BasicArrowButton.SOUTH);

    //Score label
    JLabel scoreLabel = new JLabel("Score: ");
    JLabel scoreValue = new JLabel("0");

    // SecuyaGridGame game = new SecuyaGridGame(); 

    public ME2(String name) {
        super(name);
        setResizable(false);

        initAllNames(); //to be used by remoteswinglibrary
        initButtonPanels();
        initButtons();
        initPanels();
        addListeners(); 
    }

    // private void addListeners() {
    //     left.addActionListener(); 
    // }

    private void initAllNames() {
        //Frame
        this.setName("mainWindow");

        //Menus
        menuBar.setName("menuBar");
        optionsMenu.setName("menuBar");
        startGame.setName("startGame");
        theme.setName("theme");
        exitGame.setName("exitGame");
        helpMenu.setName("helpMenu");
        howToPlay.setName("howToPlay");
        about.setName("about");

        //Main sections
        matrix.setName("matrix");
        controlsAndScore.setName("controlsAndScore");
        controls.setName("controls");
        score.setName("score");

        //Radio button group and radio buttons
        buttonA1.setName("buttonA1");
        buttonA2.setName("buttonA2");
        buttonA3.setName("buttonA3");
        buttonB1.setName("buttonB1");
        buttonB2.setName("buttonB2");
        buttonB3.setName("buttonB3");
        buttonC1.setName("buttonC1");
        buttonC2.setName("buttonC2");
        buttonC3.setName("buttonC3");
        
        //Radio button containers
        a1.setName("a1");
        a2.setName("a2");
        a3.setName("a3");
        b1.setName("b1");
        b2.setName("b2");
        b3.setName("b3");
        c1.setName("c1");
        c2.setName("c2");
        c3.setName("c3");



        //Arrow buttons
        left.setName("left");
        up.setName("up");
        down.setName("down");
        right.setName("right");

        //Score label
        scoreLabel.setName("scoreLabel");
        scoreValue.setName("scoreValue");    
    }

    private void initPanels() {
        matrix.setLayout(new GridLayout(3,3));        
        matrix.setPreferredSize(new Dimension(200, 200));

        //Add radio buttons to matrix
        matrix.add(a1);
        matrix.add(a2);
        matrix.add(a3);
        matrix.add(b1);
        matrix.add(b2);
        matrix.add(b3);
        matrix.add(c1);
        matrix.add(c2);
        matrix.add(c3);


        controlsAndScore.setLayout(new GridLayout(2,1));

        //Add subsections
        controlsAndScore.add(controls);
        controlsAndScore.add(score);

        controls.setPreferredSize(new Dimension(200, 40));

        //Add arrow buttons to controls
        controls.add(left);
        controls.add(up);
        controls.add(down);
        controls.add(right);

        score.setPreferredSize(new Dimension(200, 5));

        //Add labels to score
        score.add(scoreLabel);
        score.add(scoreValue);
        
    }

    private void initButtonPanels() {
        a1.setBorder(raisedEtched);
        a1.setBackground(new Color(255, 255, 255));
        a1.add(buttonA1);

        a2.setBorder(raisedEtched);
        a2.setBackground(new Color(255, 255, 255));
        a2.add(buttonA2);

        a3.setBorder(raisedEtched);
        a3.setBackground(new Color(255, 255, 255));
        a3.add(buttonA3);

        b1.setBorder(raisedEtched);
        b1.setBackground(new Color(255, 255, 255));
        b1.add(buttonB1);

        b2.setBorder(raisedEtched);
        b2.setBackground(new Color(255, 255, 255));
        b2.add(buttonB2);

        b3.setBorder(raisedEtched);
        b3.setBackground(new Color(255, 255, 255));
        b3.add(buttonB3);

        c1.setBorder(raisedEtched);
        c1.setBackground(new Color(255, 255, 255));
        c1.add(buttonC1);

        c2.setBorder(raisedEtched);
        c2.setBackground(new Color(255, 255, 255));
        c2.add(buttonC2);

        c3.setBorder(raisedEtched);
        c3.setBackground(new Color(255, 255, 255));
        c3.add(buttonC3);
    }
    
    private void initButtons() {
        buttonA1.setBackground(new Color(255, 255, 255));
        buttonA2.setBackground(new Color(255, 255, 255));
        buttonA3.setBackground(new Color(255, 255, 255));
        buttonB1.setBackground(new Color(255, 255, 255));
        buttonB2.setBackground(new Color(255, 255, 255));
        buttonB3.setBackground(new Color(255, 255, 255));
        buttonC1.setBackground(new Color(255, 255, 255));
        buttonC2.setBackground(new Color(255, 255, 255));
        buttonC3.setBackground(new Color(255, 255, 255));

        group.add(buttonA1);
        group.add(buttonA2);
        group.add(buttonA3);
        group.add(buttonB1);
        group.add(buttonB2);
        group.add(buttonB3);
        group.add(buttonC1);
        group.add(buttonC2);
        group.add(buttonC3);
    }

    public void addComponentsToPane(final Container pane) {
        pane.add(matrix, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controlsAndScore, BorderLayout.SOUTH);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        ME2 frame = new ME2("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set up the menu
        frame.initMenu();
        frame.setJMenuBar(frame.menuBar);

        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private void initMenu() {
        menuBar.setPreferredSize(new Dimension(200,20));
        
        optionsMenu.add(startGame);
        optionsMenu.add(theme);
        optionsMenu.add(exitGame);
        menuBar.add(optionsMenu);

        helpMenu.add(howToPlay);
        helpMenu.add(about);
        menuBar.add(helpMenu);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
