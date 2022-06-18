import javax.script.Invocable;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Secuya_ME6 {
    // My own attrib
    String EXTRACT_data = "";
    String editable = "";
    char[] ch_WAS_String_FROM_file;
    char[] ch_FROM_editable;
    int length;
    int length2;

    boolean chcksum = false;
    boolean chcksum2 = false; 

    String filename = "test.txt";   // filename for the dir 
    Path dir;                       // folder, we want to observe and watch this

    WatchService watcher;           // this is responsible for monitoring changes, creation, and deleltion of files 
    WatchKey key;                   // helps watcher to watch the registered objects
    boolean changeFlags = false;    // flag. just a boolean flag :)

    JFrame frame = new JFrame("Secuya_ME6");
    

    JEditorPane fileText = new JEditorPane();
    JScrollPane fileTextScrollPane = new JScrollPane(fileText);

    JTextArea typingArea = new JTextArea();
    JScrollPane typingAreaScrollPane = new JScrollPane(typingArea);

    JPanel infoPanel = new JPanel();
    JLabel errLabel = new JLabel("Errors: ");
    int errNum = 0;
    JLabel errValue = new JLabel("" + errNum);

    String fileContent = "";
    String editorContent = "";

    ErrorChecker errCheck;
    
    Timer timer;

    public Secuya_ME6 () {
        dir = Paths.get("."); // monitor current directory

        try {
            // Instantiate the WatchService
            watcher = FileSystems.getDefault().newWatchService();

            // Now, use the watchkey to monitor watch events
            // We try to do this to which the context is only modified content
            key = dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);

        } catch (IOException e) {
            System.err.println("Error " + e.getCause());
        }
    }

    public String getMined_EXTRACTED_DATA() { return EXTRACT_data; }

    public void processEvents() {
        while (true) {
            // TODO: ITEM 2
            for (WatchEvent<?> events: key.pollEvents()) {
                System.out.println("There was a change at: " + events.context());
                changeFlags = true; 
                System.out.println("Flags for changes is: " + changeFlags); 

                /** @NOTE TO SELF:  */
                    // Try and force extraction of data from the "test.txt" file 
                    // Therefore, we should read its entire contents through a Scanner?
                    // Just like what we did before...from the previous implementation 
                    //                      ==> (yung 2nd ATTEMPT pass to BlackBoard for this exercise) 
                    // where we try to read the entire contents of "test.txt" 

                    // Try and implement again that Cloyd! 
                    
                if (changeFlags == true) {
                    // Create a reader 
                    try {
                        File readerHandler = new File("./test.txt");
                        Scanner read = new Scanner(readerHandler);
                        
                        while (read.hasNextLine()) {
                            /** NOTE TO SELF:
                             *  THIS IS ALSO GOOD AS IT CAN UPDATE THE FILECONTENT!
                             *  HOWEVER, IT ONLY READS THEN APPENDS THE LATEST OR LAST LINE CHANGES FROM THE TEST.TXT FILE
                            */ // EXTRACT_data = read.nextLine() + "\n"; 
                            
                            /** NOTE TO SELF:                       , this long comment lol 
                             *  THIS IS MUCH PREFERRABLE IN TERMS OF UPDATING THE WHOLE STRING CONTENT WHICH SHOULD ALSO 
                             *  INLCUDE THE PREVIOUS LINES AS WELL AS THE NEW LINES WITH NEW CHANGES OR ADDITION OF STRING
                             *  HOWEVER, THE PROBLEM IS THAT IT ADDS "TWICE" TO THE FILE CONTENT 
                             *   
                             *  SO NAGIGING PROBLEMA AY GANITO: 
                             *     E.G.
                             *         {test.txt}  , no changes yet!    is NOT DIRTY
                             *         text 1
                             *         text 2
                             *         text 3 
                             *          
                             *         output to:   JEditor
                             *         text 1
                             *         text 2
                             *         text 3 
                             * 
                             *         ///////////
                             *         {test.txt}   , changes happened!!   is DIRTY then save so modified is true
                             *         text 1
                             *         text 2
                             *         text 3
                             *         text 4               // the new string addition on a new line 
                             *         
                             *    
                             *         output to:   JEditor         // after updating and repainting content
                             *         text 1
                             *         text 2
                             *         text 3
                             *         text 4                       // <== SUCCESSFULLY ADDED THE NEW LINE, HOWEVER,
                             *         text 1                       // IT ADDS "TWICE" AGAIN JUST LIKE FROM HERE..TO THE LAST LINE
                             *         text 2     
                             *         text 3
                             *         text 4
                             * 
                             */ EXTRACT_data = new String (EXTRACT_data + read.nextLine() + "\n");
                            
                            // Call the dedicated function to store the string for later comparison 
                                getMined_EXTRACTED_DATA(); 
                                
                            System.out.println(EXTRACT_data);
                            
                            fileText.setText(EXTRACT_data + "\n");
                            fileText.repaint();
                            ch_WAS_String_FROM_file = EXTRACT_data.toCharArray(); 
                            length = ch_WAS_String_FROM_file.length;
                        }
                    } 
                    
                    catch (FileNotFoundException e) { e.printStackTrace(); }  
                }

                else if (changeFlags) {
                    System.out.println("No changes");
                }
            }

            key.reset();
        }
    }

    public void createAndShowGui() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setFileContent();

        System.out.println(fileContent);
        frame.pack();
        frame.setVisible(true);

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        fileText.setText(fileContent);
        fileText.setEditable(false);
        fileTextScrollPane.setPreferredSize(new Dimension(400, 200));
        fileTextScrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("File text"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        typingArea.setLineWrap(true);
        // typingArea.setText("Type here");
        typingAreaScrollPane.setPreferredSize(new Dimension(400, 200));
        typingAreaScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Type text here"), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(errLabel);
        infoPanel.add(errValue);

        pane.add(fileTextScrollPane, BorderLayout.PAGE_START);
        pane.add(typingAreaScrollPane, BorderLayout.CENTER);
        pane.add(infoPanel, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);

        (errCheck = new ErrorChecker()).execute();
    }

    public void setFileContent() {
        fileContent = new String("");
        try {
            File txtFile = new File(filename);

            Scanner s = new Scanner(txtFile);
            while (s.hasNextLine()) {
                // System.out.println(s.nextLine());
                fileContent = new String(fileContent + s.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
        }
    }

    

    public static void main(String[] args) {
        Secuya_ME6 ME6 = new Secuya_ME6();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ME6.createAndShowGui();
            }
        });
        ME6.processEvents();
    }

    class ErrorNumber {
        int errNum = 0;

        public ErrorNumber(int errNum) {
            this.errNum = errNum;
        }

        public int getErrNum() {
            return errNum;
        }
    }

    class ErrorChecker extends SwingWorker<Void, ErrorNumber> {
        @Override
        protected Void doInBackground() {
            while (!isCancelled()) {
                publish(getNumErrors());
            }
            return null;
        }

        @Override
        protected void process(List<ErrorNumber> intList) {
            // TODO: ITEM 4
            errValue.setText("" + errNum);
            frame.repaint();
        }
    }

    public void checkAndTraverse() {
        // Check if this is really called by console logging
        System.out.println("Checking and traversing function called");
        // TODO: this 
        accessChar();

        /** NOTE TO SELF:
         *   IF YOU WANT TO CHECK IF THE CHAR ARRAYS ARE WORKING UNCOMMENT THE LINES WITH TAGS, TAG1 AND TAG2
         */

        // @note: TAG1
        // for (int i = 0; i < length; i++) {
        //     System.out.print(ch_WAS_String_FROM_file[i]);
        // }

        // @note: TAG2
        // for (int j = 0; j < length2; j++) {
        //     System.out.print(ch_FROM_editable[j]);
        // }
    }

    public void accessChar() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length2; j++) {
                if (ch_WAS_String_FROM_file[i] == ch_FROM_editable[j]) {
                    System.out.println("No changes to each character");
                }

                // THESE CODES ARE STILL LEAKING EVEN IF THE STRING FROM EDITABLE IS SAME ON THE TEST.TXT
                else { 
                    if (EXTRACT_data.charAt(i) != editable.charAt(j)) { 
                        if (ch_WAS_String_FROM_file[i] != ch_FROM_editable[j]) {
                            errNum += 0; 
                            System.out.println("Errors detected!!! Contents are unequal!");
                            System.out.println("Number of errors: " + errNum);
                        }
                    }    
                }
            }
        }
    }

    public ErrorNumber getNumErrors() {
        // TODO: ITEM 3
        
        // When CHANGED to true
        if (changeFlags == true) {
            editable = typingArea.getText(); 
            ch_FROM_editable = editable.toCharArray(); 
            length2 = ch_FROM_editable.length; 
            
            
            System.out.println("\n" + "Typing....: " + editable);

            // Call extracted String from test.txt
            getMined_EXTRACTED_DATA();
            System.out.println("Versus: " + "\n" + EXTRACT_data + "\n \t");
            
            // Try and call converter to char array
            checkAndTraverse();
        }
        
        
        return new ErrorNumber(0);
    }
}