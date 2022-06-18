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
           
                if (changeFlags == true) {
                    // Create a reader 
                    try {
                        File readerHandler = new File("./test.txt");
                        Scanner read = new Scanner(readerHandler);
                        
                        while (read.hasNextLine()) {
                            EXTRACT_data = new String (read.nextLine());
                            
                            // Call the dedicated function to store the string for later comparison 
                                // getMined_EXTRACTED_DATA(); 
                             
                            fileText.setText(EXTRACT_data);
                            fileText.repaint();

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
            errValue.setText("");
            frame.repaint();
            // cancel(true); 
        }
    }

    
    public ErrorNumber getNumErrors() {
        // TODO: ITEM 3
            
            int errNum = 0; 

            editable = typingArea.getText();                        // This is where we type below the JEditorPane
            ch_FROM_editable = editable.toCharArray(); 
            length2 = ch_FROM_editable.length; 
            
            String text_FROM_EditorPane = fileText.getText();       // This is the uneditable JEditorPane where contents are updated from text file
            ch_WAS_String_FROM_file = text_FROM_EditorPane.toCharArray(); 
            length = ch_WAS_String_FROM_file.length;
            
            System.out.println("\n" + "Typing....: " + editable);
            
            for (int i = 0; i < length; i++) {
                if (i >= editable.length()) {
                    errNum++;
                    continue;
                }
                
                else if (ch_FROM_editable[i] != ch_WAS_String_FROM_file[i]) {
                    errNum++;  
                }
            }

            System.out.println("Errors: " + errNum);
        
        // errNum = errNum - 1;            
        errValue.setText("" + errNum);
        return new ErrorNumber(errNum);
    }
}